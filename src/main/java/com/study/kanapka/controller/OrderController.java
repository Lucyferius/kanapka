package com.study.kanapka.controller;

import com.study.kanapka.dto.FilterDTO;
import com.study.kanapka.dto.OrderGetDTO;
import com.study.kanapka.model.Dish;
import com.study.kanapka.model.Order;
import com.study.kanapka.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders/details/{id}")
    public List<Dish> getDishesByOrder(@PathVariable long id){
        return orderService.getAllDishesByOrder(id);
    }

    @GetMapping("/orders/test")
    public List<OrderGetDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders")
    public Page<OrderGetDTO> getAllOrders(@RequestBody FilterDTO filterDTO, @PageableDefault(value = 6) Pageable pageable){
        return orderService.getAllWithFiltering(filterDTO, pageable);
    }

    @GetMapping("/orders/{id}")
    public OrderGetDTO getOrderById(@PathVariable("id") long id){
        return orderService.getOrderById(id);
    }

}
