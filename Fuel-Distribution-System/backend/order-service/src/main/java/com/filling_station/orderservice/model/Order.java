package com.filling_station.orderservice.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document("Order")
public class Order {

    @Id
    private String orderID;
    private FuelType fuelType;
    private Quantity quantity;
    private String stationId;

    private LocalDateTime orderedTime;
    private boolean allocated;
    private LocalDateTime allocatedTime;
    private boolean scheduled;
    private LocalDateTime scheduledTime;
    private boolean dispatched;
    private LocalDateTime dispatchedTime;
    private boolean delivered;
    private LocalDateTime deliveredTime;

}
