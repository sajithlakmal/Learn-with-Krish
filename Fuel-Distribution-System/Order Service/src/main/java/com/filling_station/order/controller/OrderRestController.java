package com.filling_station.order.controller;

import com.filling_station.order.service.OrderService;
import com.filling_station.order.service.Producer;
import com.filling_station.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OrderRestController {
    private Producer producer;
    private OrderService orderService;

    @Autowired

    @PostMapping("/order")
    public Order messageToTopic(@RequestBody Order o){

        Order order = orderService.addOrder(o);
        producer.publishToAllocation(order);
        return order;

    }
}
