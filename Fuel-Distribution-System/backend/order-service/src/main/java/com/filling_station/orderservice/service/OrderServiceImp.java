package com.filling_station.orderservice.service;


import com.filling_station.orderservice.model.Order;
import com.filling_station.orderservice.repository.OrderRepository;
import com.filling_station.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

    public Order getOrder(String id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isPresent()) {
            return order.get();
        }
        return null;

    }

    @Override
    public List<Order> viewAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders;

    }

    private String genarateID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Override
    public Order changeDispatchStatus(String orderId) {

        Optional<Order> order = orderRepository.findById(orderId);

        if (order.isPresent()) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            Order dispatchedOrder = order.get();
            dispatchedOrder.setDispatchedTime(currentDateTime);
            dispatchedOrder.setDispatched(true);
            orderRepository.save(dispatchedOrder);
            return order.get();
        }

        return null;

    }

    @Override
    public Order addScheduledDate(Order order) {
        orderRepository.save(order);

        return order;
    }

    @Override
    public Order changeAllocationStatus(Order order) {
        orderRepository.save(order);
        return order;
    }

}