package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.ZipkinServiceApplication;

@RestController
public class PaymentController {

	@Autowired
	RestTemplate template;
	
	public static final Logger log=LoggerFactory.getLogger(ZipkinServiceApplication.class);
	
	@GetMapping("/discount")
	public String discount()
	{
		log.info("Enter to Discount Service........");
		return "welcome discount service";
	}
	
	@GetMapping("/payment")
	public String payment()
	{
		log.info("Enter to Payment Service...............");
		return template.getForObject("http://localhost:8080/discount", String.class);
	}
}
