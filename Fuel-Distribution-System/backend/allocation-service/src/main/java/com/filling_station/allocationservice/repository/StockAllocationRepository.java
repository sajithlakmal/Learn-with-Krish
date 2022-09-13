package com.filling_station.allocationservice.repository;

import com.filling_station.allocationservice.model.Stock;
import com.filling_station.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface StockAllocationRepository extends MongoRepository<Stock,String> {
   Stock findFirstByOrderByDateTimeDesc();

}