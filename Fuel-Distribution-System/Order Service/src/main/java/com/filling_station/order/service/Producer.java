package com.filling_station.order.service;
import com.filling_station.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class Producer {
    public static final String ALLOCATION_TOPIC = "allocation-topic";
    public static final String SCHEDULE_TOPIC = "schedule-topic";
    public static final String DISPATCH_TOPIC = "dispatch-topic";
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void publishToAllocation(Order order){
        this.kafkaTemplate.send(ALLOCATION_TOPIC, order);
        System.out.println("Publish to allocation service");
    }


}