package com.filling_station.orderservice.repository;

import com.filling_station.orderservice.model.Order;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



public interface OrderRepository extends MongoRepository<Order,String> {

}