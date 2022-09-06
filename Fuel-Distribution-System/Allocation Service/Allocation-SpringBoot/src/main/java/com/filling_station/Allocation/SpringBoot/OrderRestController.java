package com.filling_station.Allocation.SpringBoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class OrderRestController {



        private Producer producer;

        @Autowired
        public void TestController(Producer producer) {
                this.producer = producer;
        }
        @PostMapping("/publish")
        public void messageToTopic(@RequestParam("message") String message){

                this.producer.sendMessage(message);

        }


}