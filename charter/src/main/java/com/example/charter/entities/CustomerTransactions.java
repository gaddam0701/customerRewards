package com.example.charter.entities;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Component
public class CustomerTransactions {
	private String custId;
	private LocalDate transDate;
	private Double transAmount;
	public CustomerTransactions() {
		
	}
}
