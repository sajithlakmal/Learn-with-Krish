package com.filling_station.scheduleservice.service;

import com.filling_station.orderservice.model.Order;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
public class Producer {

    public static final String DISPATCH_TOPIC = "dispatch-topic";


    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void publishScheduledOrder(Order order){
        System.out.println("Publish order to Schedule service " + order);
        Message<Order> message = MessageBuilder.withPayload(order)
                .setHeader(TOPIC, DISPATCH_TOPIC)
                .build();
        kafkaTemplate.send(message);

    }

    @Bean
    public NewTopic createTopic(){
        return new NewTopic(TOPIC,3,(short) 1);
    }
}
