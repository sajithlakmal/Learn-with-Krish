package com.filling_station.allocationservice.controller;
import com.filling_station.allocationservice.model.Stock;
import com.filling_station.allocationservice.service.AllocationService;
import com.filling_station.allocationservice.service.Producer;
import com.filling_station.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationController  {
    @Autowired
    AllocationService allocationService;
    @Autowired
    Producer producer;

    public void allocation(Order order) {

        Order result = allocationService.orderAllocation(order);

      /*  if(result.isAllocated()) {

            producer.publisAllocation(result);

        }

        else {
            producer.rejectionAllocation(result);
        }
*/
    }

    public Stock addStock(int octane92, int octane95, int autoDiesel , int superDiesel) {
        return allocationService.addStock(octane92, octane95, autoDiesel, superDiesel);
    }

}