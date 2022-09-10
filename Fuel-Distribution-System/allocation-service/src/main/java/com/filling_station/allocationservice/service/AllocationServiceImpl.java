package com.filling_station.allocationservice.service;
import com.filling_station.allocationservice.model.Stock;
import com.filling_station.allocationservice.repository.StockAllocationRepository;
import com.filling_station.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService {
    @Autowired
    StockAllocationRepository  stockAllocationRepository;

    @Override
    public Stock addStock(int octane92, int octane95, int autoDiesel, int superDiesel) {

        Stock stock = lastStockRecord();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime date = LocalDateTime.now();

        //Very First time load the stock
        if (stock==null){

            Stock initStoke =  new Stock();
            initStoke.setId("00000");
            initStoke.setAvailableOcatane92(octane92);
            initStoke.setAllocatedOcatane95(octane95);
            initStoke.setAllocatedAutoDiesel(autoDiesel);
            initStoke.setAllocatedSuperDiesel(superDiesel);
            initStoke.setTime(currentTime);
            initStoke.setDate(date);

            stockAllocationRepository.save(initStoke);
            System.out.println("==== Stock added ====");
            return  initStoke;

        }

    //Load the stock to available stocks
        else {
            Stock newStock = stock.clone();

            newStock.setId("00000");
            newStock.setAvailableOcatane92(stock.getAvailableOcatane92()+octane92);
            newStock.setAllocatedOcatane95(stock.getAvailableOcatane92()+octane95);
            newStock.setAllocatedAutoDiesel(stock.getAvailableOcatane92()+autoDiesel);
            newStock.setAllocatedSuperDiesel(stock.getAvailableOcatane92()+superDiesel);
            newStock.setTime(currentTime);
            newStock.setDate(date);

            stockAllocationRepository.save(newStock);
        }
            return  null;
    }
    @Override
    public Order orderAllocation(Order order) {
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

    @Override
    public List<Stock> findAllStockDesc() {
        return null;
    }
}
