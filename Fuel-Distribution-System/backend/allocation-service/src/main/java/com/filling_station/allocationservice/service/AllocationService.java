package com.filling_station.allocationservice.service;

import com.filling_station.allocationservice.model.Stock;
import com.filling_station.orderservice.model.Order;

import java.util.List;

public interface AllocationService {
    Stock addStock(int octane92, int octane95, int autoDiesel , int superDiesel);
    Order orderAllocation(Order order);
    List<Stock> findAllStockDesc();

}
