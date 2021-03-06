package com.study.kanapka.service;

import com.study.kanapka.dto.*;
import com.study.kanapka.exception.KanapkaResourceNotFoundException;
import com.study.kanapka.exception.KanapkaSortingException;
import com.study.kanapka.model.Dish;
import com.study.kanapka.model.DishOrder;
import com.study.kanapka.model.Order;
import com.study.kanapka.model.Reservation;
import com.study.kanapka.repository.DishOrderRepository;
import com.study.kanapka.repository.DishRepository;
import com.study.kanapka.repository.OrderRepository;
import com.study.kanapka.repository.ReservationRepository;
import com.study.kanapka.specification.GenericSpecificationsBuilder;
import com.study.kanapka.specification.OrderSpecification;
import com.study.kanapka.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final DishOrderRepository dishOrderRepository;
    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;
    private final ReservationRepository reservationRepository;
    private final OrderSpecification orderSpecification;

    @Autowired
    public OrderService(DishOrderRepository dishOrderRepository, OrderRepository orderRepository,
                        DishRepository dishRepository, ReservationRepository reservationRepository,
                        OrderSpecification orderSpecification) {
        this.dishOrderRepository = dishOrderRepository;
        this.orderRepository = orderRepository;
        this.dishRepository = dishRepository;
        this.reservationRepository = reservationRepository;
        this.orderSpecification = orderSpecification;
    }

    public List<OrderGetDTO> getAllOrders(){
        return orderRepository.findAll().stream().map(this::mapOrderToGetDto).collect(Collectors.toList());
    }

    public PageImpl<OrderGetDTO> getAllWithFiltering(FilterDTO filterDTO, Pageable pageable){

        GenericSpecificationsBuilder<Order> builder = new GenericSpecificationsBuilder<>();
        if (Objects.nonNull(filterDTO.getUrgent())) {
            builder.with(orderSpecification.isEqual("urgent", filterDTO.getUrgent()));
        }
        if (Objects.nonNull(filterDTO.getCancelled())) {
            builder.with(orderSpecification.isEqual("cancelled", filterDTO.getCancelled()));
        }
        if (Objects.nonNull(filterDTO.getConfirmed())) {
            builder.with(orderSpecification.isEqual("confirmed", filterDTO.getConfirmed()));
        }
        if (Objects.nonNull(filterDTO.getDone())) {
            builder.with(orderSpecification.isEqual("done", filterDTO.getDone()));
        }
        if(Objects.nonNull(filterDTO.getExpectedAtFrom())){
            builder.with(orderSpecification.isGreaterThan("expectedAt", filterDTO.getExpectedAtFrom()));
        }
        if(Objects.nonNull(filterDTO.getExpectedAtTo())){
            builder.with(orderSpecification.isLessThan("expectedAt", filterDTO.getExpectedAtTo()));
        }
        if(Objects.nonNull(filterDTO.getOrderedAtFrom())){
            builder.with(orderSpecification.isGreaterThan("orderedAt", filterDTO.getOrderedAtFrom()));
        }
        if(Objects.nonNull(filterDTO.getOrderedAtTo())){
            builder.with(orderSpecification.isLessThan("orderedAt", filterDTO.getOrderedAtTo()));
        }
        Pageable sorted = pageable;
        if(filterDTO.getSortBy() !=null && filterDTO.getSortOrder()!=null) {
            List<Sort.Order> sorting = createSortOrder(filterDTO.getSortBy(), filterDTO.getSortOrder());
            sorted = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sorting));
        }
        Page<Order> page = orderRepository.findAll(builder.build(), sorted);
        List<OrderGetDTO> orders = page.stream().map(this::mapOrderToGetDto).collect(Collectors.toList());

        return new PageImpl<>(orders, sorted, page.getTotalElements());

    }

    public List<OrderGetDTO> getOrdersByIds(Long[] ids){
        return orderRepository.findAllByIdIsIn(Arrays.asList(ids))
                .stream().map(this::mapOrderToGetDto)
                .collect(Collectors.toList());
    }

    public List<DishPopularityScaleDto> getAllDishesByOrder(long orderId){
        Optional<Order> optional = orderRepository.findById(orderId);
        if(optional.isEmpty()){
            throw new KanapkaResourceNotFoundException("There are no order by id " + orderId);
        }
        return dishOrderRepository.findAllByOrder(optional.get());
    }

    @Transactional
    public void persistOrder(OrderPostDTO orderPostDTO){
        List<Dish> dishes = dishRepository.findAllByIdIsIn(new ArrayList<>(orderPostDTO.getDishes().keySet()));
        Order order = createOrder(orderPostDTO, dishes);
        Order saved = orderRepository.save(order);
        List<DishOrder> dishOrders = createDishOrders(orderPostDTO, saved, dishes);
        dishOrderRepository.saveAll(dishOrders);
    }

    public OrdersReservationsDTO getOrdersByReservation(String code){
        Reservation reservation = reservationRepository.searchActiveReservationByCode(code, new Date());
        if(reservation == null){
            throw new KanapkaResourceNotFoundException("There are no active reservations by code: " + code);
        }
        List<OrderGetDTO> orderGetDTOS =  orderRepository.findOrdersByReservation(reservation)
                .stream().map(this::mapOrderToGetDto).collect(Collectors.toList());
        return new OrdersReservationsDTO(reservation.getGuest().getFirstName(),
                reservation.getGuest().getSecondName(),
                reservation.getGuest().getPhone(),
                reservation.getRoom().getRoomNumber(),
                reservation.getFrom(),
                reservation.getTo(),
                reservation.getReservationCode(),
                reservation.isCancelled(),
                orderGetDTOS);
    }

    public Page<OrdersReservationsDTO> getOrdersWithReservations(Pageable pageable){
        Page<Reservation> reservations = reservationRepository.searchAllActiveReservations(new Date(), pageable);
        List<Long> reservationIds = reservations.stream().map(Reservation::getId).collect(Collectors.toList());
        List<Order> allOrders = orderRepository.findOrdersByReservationIdIn(reservationIds);
        Map<Reservation, List<OrderGetDTO>> map = groupOrdersWithReservations(allOrders, reservations.getContent());
       List<OrdersReservationsDTO> ordersReservationsDTOS =  map.entrySet().stream().map( key ->
            new OrdersReservationsDTO(key.getKey().getGuest().getFirstName(),
                    key.getKey().getGuest().getSecondName(),
                    key.getKey().getGuest().getPhone(),
                    key.getKey().getRoom().getRoomNumber(),
                    key.getKey().getFrom(),
                    key.getKey().getTo(),
                    key.getKey().getReservationCode(),
                    key.getKey().isCancelled(),
                    key.getValue())).collect(Collectors.toList());

       return new PageImpl<>(ordersReservationsDTOS, pageable, reservations.getTotalElements());
    }

    public Page<DishPopularityScaleDto> getDishesByPopularity(Pageable pageable){

        return dishOrderRepository.searchSortedByPopularityPage(pageable);
    }

    public List<DishPopularityScaleDto> getDishesByPopularityFullList(){
       return dishOrderRepository.searchSortedByPopularity();
    }

    private Map<Reservation, List<OrderGetDTO>> groupOrdersWithReservations(List<Order> orders, List<Reservation> reservations){
        Map<Reservation, List<OrderGetDTO>> map = new HashMap<>();
        reservations.forEach(reservation -> map.put(reservation, new ArrayList<>()));
        for(Order order : orders){
            if(map.get(order.getReservation()) == null){
                List<OrderGetDTO> orderList = new ArrayList<>();
                orderList.add(mapOrderToGetDto(order));
                map.put(order.getReservation(), orderList);
            }else {
                map.get(order.getReservation()).add(mapOrderToGetDto(order));
            }
        }
        return map;
    }

    private List<DishOrder> createDishOrders(OrderPostDTO orderPostDTO, Order order, List<Dish> dishes) {
        List<DishOrder> dishOrders = new ArrayList<>();
        for (Dish dish: dishes){
            DishOrder dishOrder = new DishOrder();
            dishOrder.setId(null);
            dishOrder.setDish(dish);
            dishOrder.setOrder(order);
            dishOrder.setDishCount(orderPostDTO.getDishes().get(dish.getId()));
            dishOrders.add(dishOrder);
        }
        return dishOrders;
    }

    private Order createOrder(OrderPostDTO orderPostDTO, List<Dish> dishes){
        Order order = new Order();

        order.setCode(getVerifiedCode());
        Calendar calendar = Calendar.getInstance();

        order.setOrderedAt(calendar.getTime());
        if(orderPostDTO.getExpectedDate() == null){
            calendar.add(Calendar.HOUR, 1);
            order.setExpectedAt(calendar.getTime());
            order.setUrgent(true);
        }else {
            order.setExpectedAt(orderPostDTO.getExpectedDate());
        }
        order.setId(null);
        order.setConfirmed(true);
        order.setCancelled(false);
        order.setDone(false);
        order.setContactNumber(orderPostDTO.getPhone());

        Reservation reservation = reservationRepository.findReservationByGuestId(orderPostDTO.getGuestId());
        order.setReservation(reservation);

        double bill = dishes.stream().mapToDouble(dish -> (dish.getPrice() * orderPostDTO.getDishes().get(dish.getId()))).sum();
        order.setBill(bill);

        return order;
    }

    private String getVerifiedCode(){
        while (true) {
            String code = CodeUtils.getRandomNumberString();
            Order order = orderRepository.findOrderByCode(code);
            if(order == null){
                return code;
            }
        }
    }
    private OrderGetDTO mapOrderToGetDto(Order order){
        List<DishPopularityScaleDto> dishes = getAllDishesByOrder(order.getId());
        return new OrderGetDTO(order.getId(), order.getCode(), order.getReservation().getReservationCode(),
                order.getContactNumber(), order.isUrgent(), order.getOrderedAt(), order.getExpectedAt(),
                order.isConfirmed(), order.isCancelled(), order.isDone(), order.getBill(), dishes);
    }

    private List<Sort.Order> createSortOrder(List<String> sortList, List<String> sortDirection) {
        if(sortList.size() != sortDirection.size()){
            throw new KanapkaSortingException("Sorting list and direction list should have equal size");
        }
        List<Sort.Order> sorts = new ArrayList<>();
        Sort.Direction direction;
        int i = 0;
        for (String sort : sortList) {
            direction = Sort.Direction.fromString(sortDirection.get(i));
            sorts.add(new Sort.Order(direction, sort));
            i++;
        }
        return sorts;
    }

}
