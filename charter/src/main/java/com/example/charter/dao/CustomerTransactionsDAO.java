package com.example.charter.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.charter.entities.CustomerTransactions;


@Repository
public class CustomerTransactionsDAO implements ICustomerTransactionsDAO {
	
	static List<CustomerTransactions> custTransactionsList;
	
	static {
		
		custTransactionsList = new ArrayList<CustomerTransactions>();
		
		CustomerTransactions custTrans1 = new CustomerTransactions("111", LocalDate.of(2023, 1, 1),120.00);
		CustomerTransactions custTrans2 = new CustomerTransactions("111", LocalDate.of(2023, 2, 1),80.00);
		CustomerTransactions custTrans3 = new CustomerTransactions("111", LocalDate.of(2023, 3, 1),49.00);
		
		CustomerTransactions custTrans4 = new CustomerTransactions("112", LocalDate.of(2023, 1, 10),120.00);
		CustomerTransactions custTrans5 = new CustomerTransactions("112", LocalDate.of(2023, 2, 10),80.00);
		CustomerTransactions custTrans6 = new CustomerTransactions("112", LocalDate.of(2023, 3, 10),49.00);
		
		CustomerTransactions custTrans7 = new CustomerTransactions("113", LocalDate.of(2023, 1, 21),200.00);
		CustomerTransactions custTrans8 = new CustomerTransactions("113", LocalDate.of(2023, 2, 21),80.00);
		CustomerTransactions custTrans9 = new CustomerTransactions("113", LocalDate.of(2023, 3, 21),49.00);
		
		custTransactionsList.add(custTrans1);
		custTransactionsList.add(custTrans2);
		custTransactionsList.add(custTrans3);
		custTransactionsList.add(custTrans4);
		custTransactionsList.add(custTrans5);
		custTransactionsList.add(custTrans6);
		custTransactionsList.add(custTrans7);
		custTransactionsList.add(custTrans8);
		custTransactionsList.add(custTrans9);
		
	}

	public List<CustomerTransactions> getCustomerTransactions() {
		return custTransactionsList;
	}
}
