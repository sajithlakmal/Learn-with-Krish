package com.filling_station.orderservice.controller;
import com.filling_station.orderservice.model.Order;
import com.filling_station.orderservice.service.OrderService;
import com.filling_station.orderservice.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class OrderRestController {
    private Producer producer;

    @Autowired
    OrderService orderService;

    @Autowired
    public void TestController(Producer producer) {

        this.producer = producer;
    }
    @PostMapping("/order")
    public Order messageToTopic( @RequestBody Order o){

        System.out.println(o);
        Order order = orderService.addOrder(o);

        this.producer.publishToAllocation(order);
        return order;
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable String id) {
        Order order = orderService.getOrder(id);
        return order;
    }
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public Object fetch() {
        List<Order> orders = orderService.viewAllOrders();
        if (orders == null) {
            return "Order list is empty.";
        } else {
            return orders;
        }
    }

    public void allocationComplete(Order order){
        Order allocatedOrder  = orderService.changeAllocationStatus(order);
        producer.publishToSchedule(allocatedOrder);

    }

    public void addScheduledDate(Order order) {
        Order scheduleOrder  = orderService.addScheduledDate(order);
        producer.publishToDispatch(scheduleOrder);

    }
    public void changeDispatchStatus(String orderId) {
        Order order = orderService.changeDispatchStatus(orderId);
        producer.publishToDispatch(order);

    }

}