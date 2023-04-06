package com.example.charter.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CustomerRewards {
	private String custId;
	private String month;
	private double total;	
}
