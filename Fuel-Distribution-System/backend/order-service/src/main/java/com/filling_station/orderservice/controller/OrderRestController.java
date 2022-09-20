package com.filling_station.orderservice.controller;

import com.filling_station.orderservice.model.Order;
import com.filling_station.orderservice.service.OrderService;
import com.filling_station.orderservice.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")


public class OrderRestController {
    private Producer producer;

    @Autowired
    OrderService orderService;


    @Autowired
    public void TestController(Producer producer) {

        this.producer = producer;
    }
    @PostMapping("/order")
    public Order messageToTopic( @RequestBody Order o){

        System.out.println(o);
        Order order = orderService.addOrder(o);

        this.producer.publishToAllocation(order);
        return order;

    }







}