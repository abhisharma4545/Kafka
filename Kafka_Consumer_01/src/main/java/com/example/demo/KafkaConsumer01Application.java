package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.example.demo.constants.AppConstants;
import com.example.demo.model.Order;

@SpringBootApplication
public class KafkaConsumer01Application {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumer01Application.class, args);
	}
	
	@KafkaListener(topics = AppConstants.TOPIC,groupId =AppConstants.GROUP_ID)
	public void subciberMsg(String order) {
		System.out.println("message get from kafka topic");
		System.out.println(order);
	}

}
