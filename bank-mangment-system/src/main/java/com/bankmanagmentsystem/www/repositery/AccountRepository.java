package com.bankmanagmentsystem.www.repositery;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bankmanagmentsystem.www.entities.Account;
import com.bankmanagmentsystem.www.entities.AccountType;



public interface AccountRepository extends CrudRepository<Account, Integer>{
	
	public List<Account> findbyaccountType(AccountType accountType);
	public List<Account> findbyBalance(double balance);

}
