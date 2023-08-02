package com.bankmanagmentsystem.www.service;

import java.util.List;

import com.bankmanagmentsystem.www.entities.Account;
import com.bankmanagmentsystem.www.entities.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomer(int customerId);
	
	public Customer getCustomer(Customer customer);
	
	public Customer updateCustomerDetails(int custometId, Customer customer);
	
	public Customer addCustomerForCustomer(int customerId, Account account);
	

}
