package com.filling_station.allocationservice.service;

import com.filling_station.orderservice.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics= "allocation-topic", groupId = "allocation-group" )

    public void listenAllocationTopic(Order order)  {
        System.out.println("Listen to allocation topic in AllocationService from OrderService " + order);

    }
}
