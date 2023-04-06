package com.example.charter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.charter.entities.CustomerTransactions;

@Repository
public interface ICustomerTransactionsDAO {
	public List<CustomerTransactions> getCustomerTransactions() ;
}
