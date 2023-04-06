package com.example.charter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.charter.entities.CustomerRewards;
import com.example.charter.service.CustomerRewardsService;
import com.example.charter.service.CustomerRewardsServiceImpl;

@RestController
@RequestMapping("/")
public class CustomerRewardsController {
	
	@Autowired
	private CustomerRewardsServiceImpl customerRewardsServiceImpl;
	
	@GetMapping(value = "/customerRewards")
	public List<CustomerRewards> GetCustomerRewardPoints() {
		
		return customerRewardsServiceImpl.findAll();
	}
	
	@GetMapping(value = "/customer")
	public String GetCustomerRewardPoints2() {
		return "Sample Rest Message";
	}
}
