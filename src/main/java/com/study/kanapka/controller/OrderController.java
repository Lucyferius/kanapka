package com.study.kanapka.controller;

import com.study.kanapka.dto.DishPopularityScaleDto;
import com.study.kanapka.dto.FilterDTO;
import com.study.kanapka.dto.OrderGetDTO;
import com.study.kanapka.dto.OrdersReservationsDTO;
import com.study.kanapka.model.Dish;
import com.study.kanapka.service.OrderService;
import com.study.kanapka.util.DishPopularityReportExporter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/admin/orders/details/{id}")
    public List<Dish> getDishesByOrder(@PathVariable long id){
        return orderService.getAllDishesByOrder(id);
    }

    @GetMapping("/admin/orders/test")
    public List<OrderGetDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/admin/orders/{ids}")
    public List<OrderGetDTO> getOrderById(@PathVariable("ids") Long[] ids){
        return orderService.getOrdersByIds(ids);
    }

    @GetMapping("/admin/orders")
    public Page<OrderGetDTO> getAllOrders( @RequestBody FilterDTO filterDTO, @PageableDefault(value = 6) Pageable pageable){
        return orderService.getAllWithFiltering(filterDTO, pageable);
    }

    @GetMapping("/reservation/all/orders")
    public OrdersReservationsDTO getOwnOrderHistory(@RequestParam("code") String code){
        return orderService.getOrdersByReservation(code);
    }

    @GetMapping("/admin/reservation/all/orders")
    public Page<OrdersReservationsDTO> getFullOrderHistory(@PageableDefault(value = 1) Pageable pageable){
        return orderService.getOrdersWithReservations(pageable);
    }

    @GetMapping("/admin/reservation/orders")
    public OrdersReservationsDTO getOrderHistoryByReservation(@RequestParam("code") String code){
        return orderService.getOrdersByReservation(code);
    }

    @GetMapping("/admin/orders/popular")
    public Page<DishPopularityScaleDto> getDishesByPopularity(Pageable pageable){
        return orderService.getDishesByPopularity(pageable);
    }

    @GetMapping("/admin/orders/popular/export")
    void exportPopularityReport(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=popular_dishes_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        DishPopularityReportExporter exporter = new DishPopularityReportExporter(orderService.getDishesByPopularityFullList());
        exporter.export(response);
    }
}
