package com.filling_station.scheduleservice.service;
import com.filling_station.orderservice.model.Order;
import com.filling_station.scheduleservice.model.Schedule;
import com.filling_station.scheduleservice.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;
    @Override
    public Order addSchedule(Order order) {

        Schedule schedule = new Schedule();
        LocalDateTime curretDateTime = LocalDateTime.now();

        schedule.setOrderId(order.getOrderID());
        schedule.setStationName(order.getStationId());
        schedule.setScheduleDate(curretDateTime);

        order.setScheduledTime(curretDateTime);
        order.setScheduled(true);
        scheduleRepository.save(schedule);

       return  order;
    }

}
