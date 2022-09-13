package com.filling_station.scheduleservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Schedule")
public class Schedule {

    @Id
    private String orderId;
    private String stationName;
    private LocalDateTime scheduleDate;


}
