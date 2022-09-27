package com.filling_station.orderservice.service;

import com.filling_station.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);
    Order getOrder(String id);

    List<Order> viewAllOrders();
   Order changeDispatchStatus(String orderId);
   Order addScheduledDate(Order order);
   Order changeAllocationStatus(Order order);
}