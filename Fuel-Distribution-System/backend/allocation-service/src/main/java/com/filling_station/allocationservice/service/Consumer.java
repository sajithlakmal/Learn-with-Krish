package com.filling_station.allocationservice.service;

import com.filling_station.allocationservice.controller.AllocationController;
import com.filling_station.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    AllocationController allocationController;
    @KafkaListener(topics= "allocation-topic", groupId = "allocation-group" )

    public void listenAllocationTopic(Order order)  {
        System.out.println("Listen to allocation topic in AllocationService from OrderService " + order);
        allocationController.allocation(order);

    }
}
