package com.study.kanapka.service;

import com.study.kanapka.dto.OrderDTO;
import com.study.kanapka.model.Dish;
import com.study.kanapka.model.DishOrder;
import com.study.kanapka.model.Order;
import com.study.kanapka.model.Reservation;
import com.study.kanapka.repository.DishOrderRepository;
import com.study.kanapka.repository.DishRepository;
import com.study.kanapka.repository.OrderRepository;
import com.study.kanapka.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final DishOrderRepository dishOrderRepository;
    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;
    private final ReservationRepository reservationRepository;

    public OrderService(DishOrderRepository dishOrderRepository, OrderRepository orderRepository,
                        DishRepository dishRepository, ReservationRepository reservationRepository) {
        this.dishOrderRepository = dishOrderRepository;
        this.orderRepository = orderRepository;
        this.dishRepository = dishRepository;
        this.reservationRepository = reservationRepository;
    }

    public void persistOrder(OrderDTO orderDTO){
        Order order = createOrder(orderDTO);
        Order saved = orderRepository.save(order);
        List<DishOrder> dishOrders = createDishOrders(orderDTO, saved);
        dishOrders.forEach(dishOrderRepository::save);
    }

    private List<DishOrder> createDishOrders(OrderDTO orderDTO, Order order) {
        List<Dish> dishes = dishRepository.findAllByIdIsIn(new ArrayList<>(orderDTO.getDishes().keySet()));
        List<DishOrder> dishOrders = new ArrayList<>();
        for (Dish dish: dishes){
            DishOrder dishOrder = new DishOrder();
            dishOrder.setDish(dish);
            dishOrder.setOrder(order);
            dishOrder.setDishCount(orderDTO.getDishes().get(dish.getId()));
            dishOrders.add(dishOrder);
        }
        return dishOrders;
    }

    private Order createOrder(OrderDTO orderDTO){
        Order order = new Order();
        Calendar calendar = Calendar.getInstance();
        order.setOrderedAt(calendar.getTime());
        if(orderDTO.getExpectedDate() == null){
            calendar.add(Calendar.HOUR, 1);
            order.setExpectedAt(calendar.getTime());
            order.setUrgent(true);
        }else {
            order.setExpectedAt(orderDTO.getExpectedDate());
        }
        order.setConfirmed(true);
        order.setCancelled(false);
        order.setDone(false);
        order.setContactNumber(orderDTO.getPhone());

        Reservation reservation = reservationRepository.findReservationByGuestId(orderDTO.getGuestId());
        order.setReservation(reservation);

        return order;
    }
}
