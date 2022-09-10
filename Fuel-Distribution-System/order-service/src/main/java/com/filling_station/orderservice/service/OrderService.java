package com.filling_station.orderservice.service;

import com.filling_station.orderservice.model.Order;
import org.springframework.stereotype.Service;

public interface OrderService {
    Order addOrder(Order order);

}