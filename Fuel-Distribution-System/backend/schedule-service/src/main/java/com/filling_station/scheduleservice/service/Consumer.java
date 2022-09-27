package com.filling_station.scheduleservice.service;

import com.filling_station.orderservice.model.Order;
import com.filling_station.scheduleservice.controller.ScheduleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    ScheduleController scheduleController;


    @KafkaListener(topics = "schedule-topic", groupId = "schedule-group")

    public void listenAllocationTopic(Order order) {
        System.out.println("Listen to allocation topic in AllocationService from OrderService " + order);
        scheduleController.scheduleDate(order);

    }
}