package com.filling_station.orderservice.service;


import com.filling_station.orderservice.model.Order;
import com.filling_station.orderservice.repository.OrderRepository;
import com.filling_station.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        String id = genarateID();
        LocalDateTime currentDateTime = LocalDateTime.now();
        order.setOrderID(id);
        order.setOrderedTime(currentDateTime);
        orderRepository.save(order);
        return order;
    }

    private String  genarateID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}