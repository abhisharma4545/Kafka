package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.demo.constants.AppConstants;
import com.example.demo.model.Order;

@Configuration
public class KafkaConsumerConfig {
	

	@Bean
	public ConsumerFactory<String,Order> consumerFactory(){
		JsonDeserializer<Order> deserializer =new JsonDeserializer<>(Order.class);
		deserializer.addTrustedPackages("*");
		Map<String, Object> config = new HashMap<String, Object>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
		return new DefaultKafkaConsumerFactory<String, Order>(config,new StringDeserializer(),deserializer);
	}
		
	 @Bean
	public ConcurrentKafkaListenerContainerFactory<String, Order> kafkalistenFactory(){
		ConcurrentKafkaListenerContainerFactory<String, Order> factory = new ConcurrentKafkaListenerContainerFactory<String, Order>();
	    factory.setConsumerFactory(consumerFactory());
	    return factory;
	}
}
