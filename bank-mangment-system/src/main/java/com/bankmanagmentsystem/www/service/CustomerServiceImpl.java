package com.bankmanagmentsystem.www.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankmanagmentsystem.www.entities.Account;
import com.bankmanagmentsystem.www.entities.Customer;
import com.bankmanagmentsystem.www.repositery.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(int customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		return optionalCustomer.orElse(null);
	}

	@Override
	public Customer creatCustomer(Customer customer) {
		Optional<Customer> optionalCustomer = customerRepository.findBycustomeremail(customer.getCustomerEmail());
		if(optionalCustomer.isPresent()) {
			return null;
		}
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomerDetails(int custometId, Customer updatedcustomer) {
		Optional<Customer> optionalCustomer = customerRepository.findById(updatedcustomer.getCustomerId());
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			customer.setCustomerFirstName(updatedcustomer.getCustomerFirstName());
			customer.setCustomerLastName(updatedcustomer.getCustomerLastName());
			customer.setCustomerEmail(updatedcustomer.getCustomerEmail());
			customerRepository.save(customer);
			return customer;
			
		}
		return null;
	}

	@Override
	@Transactional
	public Account addAccountForCustomer(int customerId, Account account) {
		Customer customer = this.getCustomer(customerId);
		
		Set<Account> accounts = customer.getAcount();
		accounts.add(account);
		customer.setAcount(accounts);
		customerRepository.save(customer);
		
		return account;
	}

}
