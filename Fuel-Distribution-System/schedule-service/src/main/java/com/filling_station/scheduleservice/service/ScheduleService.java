package com.filling_station.scheduleservice.service;

import com.filling_station.orderservice.model.Order;
import com.filling_station.scheduleservice.model.Schedule;

public interface ScheduleService {
    Order addSchedule(Order order);
}
