package com.agh.product_catalouge.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "First-topic",groupId = "group1")
    public void consume(String message){
        System.out.println(message);
    }
}
