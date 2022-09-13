package com.filling_station.scheduleservice.repository;
import com.filling_station.scheduleservice.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduleRepository extends MongoRepository<Schedule, String>{


}