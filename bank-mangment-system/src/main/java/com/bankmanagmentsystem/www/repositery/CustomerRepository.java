package com.bankmanagmentsystem.www.repositery;

import java.util.Optional;

import com.bankmanagmentsystem.www.entities.Customer;

public interface CustomerRepository {
	public Optional<Customer> findBycustomerFirstName(String FirstName);
	public Optional<Customer> findBycustomerLastName(String Lastname);
	public Optional<Customer> findByemail(String email);

}
