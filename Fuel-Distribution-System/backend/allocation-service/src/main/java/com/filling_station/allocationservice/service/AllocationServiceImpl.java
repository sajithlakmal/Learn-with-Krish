package com.filling_station.allocationservice.service;
import com.filling_station.allocationservice.model.Allocation;
import com.filling_station.allocationservice.model.Stock;
import com.filling_station.allocationservice.repository.OrderAllocationRepository;
import com.filling_station.allocationservice.repository.StockAllocationRepository;
import com.filling_station.orderservice.model.Order;
import com.filling_station.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.filling_station.orderservice.model.FuelType.OCTANE92;
import static com.filling_station.orderservice.model.Quantity.*;

@Service
public class AllocationServiceImpl implements AllocationService {
    @Autowired
    StockAllocationRepository  stockAllocationRepository;
    @Autowired
    OrderAllocationRepository orderAllocationRepository;



    @Autowired
    Producer producer;




    @Override
    public Stock addStock(int octane92, int octane95, int autoDiesel, int superDiesel) {

        LocalDateTime currentDate= LocalDateTime.now();
        Stock stock = lastStockRecord();

        //Very First One
        if(stock == null) {

            Stock initStock = new Stock();

            initStock.setId("00000");
            initStock.setDate(currentDate);


            initStock.setAvailableOcatane92(octane92);
            initStock.setAvailableOcatane95(octane95);
            initStock.setAvailableAutoDiesel(autoDiesel);
            initStock.setAvailableSuperDiesel(superDiesel);



            stockAllocationRepository.save(initStock);

            return  initStock;
        }

        //Add a new stock to available stocks
        else {
            Stock newStock = stock.clone();

            newStock.setId("00000");



            newStock.setAvailableOcatane92(stock.getAvailableOcatane92()+octane92);
            newStock.setAvailableOcatane95(stock.getAvailableOcatane95()+octane95);
            newStock.setAvailableAutoDiesel(stock.getAvailableAutoDiesel()+autoDiesel);
            newStock.setAvailableSuperDiesel(stock.getAvailableSuperDiesel()+superDiesel);

            stockAllocationRepository.save(newStock);

            return newStock;
        }

    }
    @Override
    public Order orderAllocation(Order order) {
       Allocation newOrder = new Allocation();
       LocalDateTime currentDateTime = LocalDateTime.now();

       newOrder.setOrderId(order.getOrderID());
       newOrder.setAllocatedDateTime(currentDateTime);

        switch(order.getFuelType()) {
            case OCTANE92:

                if(order.getQuantity()==L3300)
                    newOrder.setAllocatedOcatane92(3300);

                else if (order.getQuantity()==L6600)
                    newOrder.setAllocatedOcatane92(6600);

                else newOrder.setAllocatedOcatane92(13200);

                break;

            case OCTANE95:
                if(order.getQuantity()==L3300)
                    newOrder.setAllocatedOcatane95(3300);

                else if (order.getQuantity()==L6600)
                    newOrder.setAllocatedOcatane95(6600);

                else newOrder.setAllocatedOcatane95(13200);
                break;

            case AUTO_DIESEL:
                if(order.getQuantity()==L3300)
                    newOrder.setAllocatedAutoDiesel(3300);

                else if (order.getQuantity()==L6600)
                    newOrder.setAllocatedAutoDiesel(6600);

                else newOrder.setAllocatedAutoDiesel(13200);
                break;


            case SUPER_DIESEL:
                if(order.getQuantity()==L3300)
                    newOrder.setAllocatedSuperDiesel(3300);

                else if (order.getQuantity()==L6600)
                    newOrder.setAllocatedSuperDiesel(6600);

                else newOrder.setAllocatedSuperDiesel(13200);
                break;
        }
        order.setAllocatedTime(currentDateTime);

        order.setAllocated(true);
       orderAllocationRepository.save(newOrder);
       producer.publisToSchedule(order);
        System.out.println("Order details "+order);

        return null;
    }

    @Override
    public List<Stock> findAllStockDesc() {
        return null;
    }
    public Stock lastStockRecord() {
        Stock stock = stockAllocationRepository.findFirstByOrderByDateTimeDesc();

        if(stock == null) {
            return null;
        }

        else {
            return stock;
        }
    }

}
