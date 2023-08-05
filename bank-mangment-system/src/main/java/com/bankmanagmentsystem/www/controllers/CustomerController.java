package com.bankmanagmentsystem.www.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagmentsystem.www.entities.Account;
import com.bankmanagmentsystem.www.entities.Customer;
import com.bankmanagmentsystem.www.exceptions.CustomerOverwriteException;
import com.bankmanagmentsystem.www.exceptions.NotFoundException;
import com.bankmanagmentsystem.www.service.AccountService;
import com.bankmanagmentsystem.www.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@GetMapping(value = "/customers")
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = customerService.getAllCustomers();
		return allCustomers;
	}

	
	@GetMapping(value = "/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null) {
			throw new NotFoundException("Customer not found");
		}
		return customer;
		
	}
	
	
	@PostMapping(value = "/customers")
	public Customer creatCustomer(@RequestBody Customer customer) {
		Customer createdCustomer = customerService.creatCustomer(customer);
		if(createdCustomer == null) {
			throw new CustomerOverwriteException("Cant Creat customer. Customer already exists");
		}
		return createdCustomer;
	}
	
	@PutMapping(value="/cusstomer/{customerId}")
	public Customer updateCustomerDetails(@PathVariable int customerId, @RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updateCustomerDetails(customerId, customer);
		if(updatedCustomer == null) {
			throw new NotFoundException("Customer not found");
		}
		return updatedCustomer;
		
	}
	@PostMapping(value = "/customer/{customerId}/accounts")
	public Account addAccount(@PathVariable int customerId, @RequestBody Account account) {
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null) {
			throw new NotFoundException("Customer not found");
		}
		Account acc = accountService.getAccount(account.getAccountId());
		if(acc ==null) {
			accountService.creatAccount(account);
		}
		acc = accountService.addCustomerForAccount(account.getAccountId(), customer);
		return customerService.addAccountForCustomer(customerId, acc);
		
	}

}
