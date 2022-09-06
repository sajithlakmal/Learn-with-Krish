package com.filling_station.orderservice.controller;


import com.filling_station.orderservice.model.Order;
import com.filling_station.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImp implements OrderService {


    @Override
    public Order addOrder(Order order) {
        String id = genarateID();
        order.setOrderID(id);

        return order;
    }


    private String  genarateID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }



}