package com.study.kanapka.controller;

import com.study.kanapka.dto.GuestDTO;
import com.study.kanapka.dto.OrderDTO;
import com.study.kanapka.service.GuestService;
import com.study.kanapka.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuestController {

    private final GuestService guestService;
    private final OrderService orderService;

    public GuestController(GuestService guestService, OrderService orderService){
        this.guestService = guestService;
        this.orderService = orderService;
    }

    @GetMapping("/validate")
    public GuestDTO validateGuestByCode(@RequestParam("code") String code){
        return guestService.getGuestByReservationCode(code);
    }

    @PostMapping("/order")
    public HttpStatus createOrder(@RequestBody OrderDTO orderDTO){
        orderService.persistOrder(orderDTO);
        return HttpStatus.CREATED;
    }
}
