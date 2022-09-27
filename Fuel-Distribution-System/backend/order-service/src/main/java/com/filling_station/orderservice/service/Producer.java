package com.filling_station.orderservice.service;
import com.filling_station.orderservice.dto.OrderEvent;
import com.filling_station.orderservice.model.Order;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;
@Service
public class Producer {
    public static final String ALLOCATION_TOPIC = "allocation-topic";
    public static final String SCHEDULE_TOPIC = "schedule-topic";
    public static final String DISPATCH_TOPIC = "dispatch-topic";

    private NewTopic topic;
   // private  static  final Logger LOGGER =  LoggerFactory.getLogger(Producer.class);
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void publishToAllocation(Order o){
        System.out.println("Publish order to allocation service " + o);
        Message<Order>message = MessageBuilder.withPayload(o)
                .setHeader(TOPIC, ALLOCATION_TOPIC)
                .build();
        kafkaTemplate.send(message);

    }

    public void publishToSchedule(Order o){
        System.out.println("Publish order to allocation service " + o);
        Message<Order>message = MessageBuilder.withPayload(o)
                .setHeader(TOPIC, SCHEDULE_TOPIC)
                .build();
        kafkaTemplate.send(message);

    }


    public void publishToDispatch(Order o){
        System.out.println("Publish order to allocation service " + o);
        Message<Order>message = MessageBuilder.withPayload(o)
                .setHeader(TOPIC, DISPATCH_TOPIC)
                .build();
        kafkaTemplate.send(message);

    }


    @Bean
    public NewTopic createTopic(){
        return new NewTopic(TOPIC,3,(short) 1);
    }

}
