package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.constants.AppConstants;
import com.example.demo.model.Order;

@Service 
public class OrderService {
	
	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;
	
	public String addMsg(Order order) {
	      kafkaTemplate.send(AppConstants.TOPIC, order);
		return "Msg published to Kafka Topic";
	}

}
