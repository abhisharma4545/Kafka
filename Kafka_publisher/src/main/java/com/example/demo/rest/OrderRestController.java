package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderRestController {
	
	
	@Autowired
	private OrderService service;
	
	
	@PostMapping("/order")
	public String createOrder(@RequestBody Order order) {
		String msg =  service.addMsg(order);
		return msg;
	}

}
