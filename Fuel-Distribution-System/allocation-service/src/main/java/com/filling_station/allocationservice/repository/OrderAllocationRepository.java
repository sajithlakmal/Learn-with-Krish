package com.filling_station.allocationservice.repository;

import com.filling_station.allocationservice.model.Allocation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderAllocationRepository extends MongoRepository<Allocation, String>{


}