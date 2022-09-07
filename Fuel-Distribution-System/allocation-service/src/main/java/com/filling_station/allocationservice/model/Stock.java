package com.filling_station.allocationservice.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Stock")
public class Stock {

    @Id
    private String id;


}
