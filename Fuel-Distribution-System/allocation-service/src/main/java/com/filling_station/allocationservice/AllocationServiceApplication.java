package com.filling_station.allocationservice;

import com.filling_station.allocationservice.controller.AllocationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AllocationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllocationServiceApplication.class, args);

	}


}
