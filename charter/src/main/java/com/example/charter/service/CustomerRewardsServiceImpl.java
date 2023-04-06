package com.example.charter.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.charter.dao.CustomerTransactionsDAO;
import com.example.charter.dao.ICustomerTransactionsDAO;
import com.example.charter.entities.CustomerRewards;
import com.example.charter.entities.CustomerTransactions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data
@AllArgsConstructor
public class CustomerRewardsServiceImpl implements CustomerRewardsService<CustomerRewards> {


	@Autowired
	private ICustomerTransactionsDAO customerTransactionsDAO;
	
	

	public List<CustomerRewards> findAll() {
      
		
		return calculateCustomerRewards();
	}

	private List<CustomerRewards> calculateCustomerRewards() {

		List<CustomerTransactions> custTransactionsList = customerTransactionsDAO.getCustomerTransactions();
		Map<String, List<CustomerTransactions>> custMap = new HashMap<>();
		for (CustomerTransactions trans : custTransactionsList) {

			if (custMap.get(trans.getCustId()) != null) {
				custMap.get(trans.getCustId()).add(trans);
			} else {
				List<CustomerTransactions> custList = new ArrayList<CustomerTransactions>();
				custList.add(trans);
				custMap.put(trans.getCustId(), custList);
			}
		}
		List<CustomerRewards> customerRewardsList = new ArrayList<CustomerRewards>();
		
		
		 for (String custId : custMap.keySet()) {
			 List<CustomerTransactions> custList  = custMap.get(custId);
			CustomerRewards customerRewards = new CustomerRewards();
			customerRewards.setCustId(custId);
			Map<String, Integer> monthTotal = new HashMap<>();
			for (CustomerTransactions trans : custList) {			   
			    Integer totalForEachMonth =  monthTotal.get(trans.getTransDate().getMonth().toString());
			     if (totalForEachMonth != null) {		    	
			    	 totalForEachMonth = totalForEachMonth + calculateRewardPoints(trans.getTransAmount());
			    	 monthTotal.put(trans.getTransDate().getMonth().toString(), totalForEachMonth);
			     } else {
			    	 monthTotal.put(trans.getTransDate().getMonth().toString(), calculateRewardPoints(trans.getTransAmount()));
			     }			     				
			}
			
			for (String month : monthTotal.keySet()) {
				customerRewards.setMonth(month);
				customerRewards.setTotal(monthTotal.get(month));
				customerRewardsList.add(customerRewards);
				customerRewards = new CustomerRewards();
			}
		}

		return customerRewardsList;

	}
	
	private int calculateRewardPoints(Double amount) {
		int rewardPoint = 0;
		if (amount >= 50.00 && amount <= 100.00) {
			rewardPoint =  1 * (int) Math.round(amount);
		} else if (amount > 100.00) {
			rewardPoint =  50 + (2 * (int) Math.round(amount - 100));
		}
		return rewardPoint;
	}

	

}
