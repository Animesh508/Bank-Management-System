package com.bankmanagmentsystem.www.repositery;

import java.util.List;

import com.bankmanagmentsystem.www.entities.Account;
import com.bankmanagmentsystem.www.entities.AccountType;

public interface AccountRepository {
	public List<Account> findbyaccountType(AccountType accountType);
	public List<Account> findbyBalance(double balance);

}
