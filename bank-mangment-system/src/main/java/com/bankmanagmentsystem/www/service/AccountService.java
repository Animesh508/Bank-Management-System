package com.bankmanagmentsystem.www.service;

import java.util.List;

import com.bankmanagmentsystem.www.entities.Account;
import com.bankmanagmentsystem.www.entities.Customer;
import com.bankmanagmentsystem.www.entities.FundTransferRequestBody;

public interface AccountService {
	public List<Account> getAllAccounts();
	
	public Account getAccount(int accountId);
	
	public Account creatAccount(Account account);
	
	public Account addCustomerForAccount(int accountId, Customer customer);
	
	public String transferfund(FundTransferRequestBody fundTransferRequestBody);

}
