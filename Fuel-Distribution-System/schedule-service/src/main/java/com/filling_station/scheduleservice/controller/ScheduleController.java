package com.filling_station.scheduleservice.controller;

import com.filling_station.orderservice.model.Order;
import com.filling_station.scheduleservice.service.Producer;
import com.filling_station.scheduleservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @Autowired
    Producer producer;

    public void scheduleDate(Order order) {
        Order scheduledOrder = scheduleService.addSchedule(order);
        producer.publishScheduledOrder(scheduledOrder);



    }
}
