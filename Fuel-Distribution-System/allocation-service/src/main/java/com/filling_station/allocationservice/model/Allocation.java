package com.filling_station.allocationservice.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
@Document("Allocation")
public class Allocation {

    @Id
    private String orderId;
    private LocalDateTime allocatedDateTime;
    private int allocatedOcatane92;
    private int dispatchedOcatane92;
    private String statusOcatane92;
    private int allocatedOcatane95;
    private int dispatchedOcatane95;
    private String statusOcatane95;
    private int allocatedAutoDiesel;
    private int dispatchedAutoDiesel;
    private String statusAutoDiesel;
    private int allocatedSuperDiesel;
    private int dispatchedSuperDiesel;
    private String statusSuperDiesel;


    public Allocation clone() {
       Allocation order = new Allocation();

        //    OCTANE_92
       order.setAllocatedOcatane92(allocatedOcatane92);
       order.setDispatchedOcatane92(dispatchedOcatane92);

        //    OCTANE_95
        order.setAllocatedOcatane95(allocatedOcatane95);
        order.setDispatchedOcatane95(dispatchedOcatane95);

        //    AUTO_DIESEL
        order.setAllocatedAutoDiesel(allocatedAutoDiesel);
        order.setDispatchedAutoDiesel(dispatchedAutoDiesel);

        //    SUPER_DIESEL
        order.setAllocatedSuperDiesel(allocatedSuperDiesel);
        order.setDispatchedSuperDiesel(dispatchedSuperDiesel);

        return order;

    }

}
