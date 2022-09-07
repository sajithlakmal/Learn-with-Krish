package com.filling_station.allocationservice.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("Stock")
public class Stock {

    @Id
    private String id;
    private String orderId;

    //    OCTANE_92
    private int availableOcatane92;
    private int allocatedOcatane92;

    //    OCTANE_95
    private int availableOcatane95;
    private int allocatedOcatane95;

    //    AUTO_DIESEL
    private int availableAutoDiesel;
    private int allocatedAutoDiesel;

    //    SUPER_DIESEL
    private int availableSuperDiesel;
    private int allocatedSuperDiesel;

}
