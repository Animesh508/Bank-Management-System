package com.bankmanagmentsystem.www.controllers;

import java.security.spec.DSAPublicKeySpec;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagmentsystem.www.constants.TransferStatus;
import com.bankmanagmentsystem.www.entities.Account;
import com.bankmanagmentsystem.www.entities.FundTransferRequestBody;
import com.bankmanagmentsystem.www.exceptions.IdenticalAccountException;
import com.bankmanagmentsystem.www.exceptions.InsufficientfundException;
import com.bankmanagmentsystem.www.exceptions.NotFoundException;
import com.bankmanagmentsystem.www.service.AccountService;

@RestController
public class AccountController {
	private static final String INSUFFICIENT_FUNDS = "Insufficient_Funds";
	private static final String IDENTICAL_ACCOUNT_NUMBER = "Identical_Account_Number";
	private static final String ACCOUNT_NOT_FOUND="Account_Not_Found";
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value = "/account")
	public List<Account> getAllAccount(){
		return accountService.getAllAccounts();		
	}
	
	@GetMapping(value = "/accounts/{accountId}")
	public Account getAccount(@PathVariable int accountId) {
		Account account = accountService.getAccount(accountId);
		if(account == null) {
			throw new NotFoundException(ACCOUNT_NOT_FOUND);
		}
		return account;
	}
	public Account creatAccount(Account account) {
		return accountService.creatAccount(account);
	}
	@PutMapping(value = "/account/transferFunds")
	public String transferFunds(@RequestBody FundTransferRequestBody fundTransferRequestBody) {
		String fundtransferStatus = accountService.transferfund(fundTransferRequestBody);
		if(fundtransferStatus.equals(TransferStatus.IDENTICAL_ACCOUNT)) {
			throw new IdenticalAccountException(IDENTICAL_ACCOUNT_NUMBER);
		}
		if(fundtransferStatus.equals(TransferStatus.ID_MISSMATCH)) {
			throw new NotFoundException(ACCOUNT_NOT_FOUND);
		}
		if(fundtransferStatus.equals(TransferStatus.INSUFFICRNT_FUNDS)) {
			throw new InsufficientfundException(INSUFFICIENT_FUNDS);
		}
			
			
		return "FUND TRANSFER SUCCESSFULL";
	}

}
