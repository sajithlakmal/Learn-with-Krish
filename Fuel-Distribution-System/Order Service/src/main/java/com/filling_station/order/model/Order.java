package com.filling_station.order.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Order")
public class Order {
    private int octane;
    private int litter;
    private String orderID;
}
