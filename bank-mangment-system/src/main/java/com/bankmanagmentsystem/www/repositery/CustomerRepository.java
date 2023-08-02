package com.bankmanagmentsystem.www.repositery;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bankmanagmentsystem.www.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	public Optional<Customer> findBycustomerFirstName(String FirstName);
	public Optional<Customer> findBycustomerLastName(String Lastname);
	public Optional<Customer> findBycustomeremail(String email);

}
