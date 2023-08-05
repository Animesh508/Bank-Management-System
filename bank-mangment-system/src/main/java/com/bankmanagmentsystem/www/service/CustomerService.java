package com.bankmanagmentsystem.www.service;

import java.util.List;

import com.bankmanagmentsystem.www.entities.Account;
import com.bankmanagmentsystem.www.entities.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomer(int customerId);
	
	public Customer creatCustomer(Customer customer);
	
	public Customer updateCustomerDetails(int custometId, Customer customer);
	
	public Account addAccountForCustomer(int customerId, Account account);
	

}
