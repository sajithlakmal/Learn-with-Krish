package com.filling_station.allocationservice.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
@Document("Stock")
public class Stock {

    @Id
    private String id;
    private LocalTime time;
    private LocalDateTime date;

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


    public Stock clone() {

        Stock stock = new Stock();

        stock.setAvailableOcatane92(availableOcatane92);
        stock.setAllocatedOcatane92(allocatedOcatane92);

        stock.setAvailableOcatane95(availableOcatane95);
        stock.setAllocatedOcatane95(allocatedOcatane95);

        stock.setAvailableAutoDiesel(availableAutoDiesel);
        stock.setAllocatedAutoDiesel(allocatedAutoDiesel);

        stock.setAvailableSuperDiesel(availableSuperDiesel);
        stock.setAllocatedSuperDiesel(allocatedSuperDiesel);

        return stock;

    }

}
