package com.filling_station.orderservice.service;

import com.filling_station.orderservice.controller.OrderRestController;
import com.filling_station.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @Autowired
    OrderRestController orderController;
    @KafkaListener(topics= "allocation-complete-topic",  groupId = "order-group")
    public void listenAllocationCompleteTopic(Order order){
        System.out.println("Listen to allocation-complete-topic in OrderService from AllocationService " + order);

        orderController.allocationComplete(order);
    }

    @KafkaListener(topics = "scheduled-complete-topic" , groupId = "order-group")
    public void listenScheduledCompleteTopic(Order order){
        System.out.println("Listen to scheduled-complete-topic in OrderService from ScheduleService " + order);
        orderController.addScheduledDate(order);
    }

    @KafkaListener(topics = "dispatch-complete-topic" , groupId = "order-group" )
    public void listenDispatchCompleteTopic(String id){
        System.out.println("Listen to dispatch-complete-topic in OrderService from DispatchService " + id);

     orderController.changeDispatchStatus(id);

    }






}
