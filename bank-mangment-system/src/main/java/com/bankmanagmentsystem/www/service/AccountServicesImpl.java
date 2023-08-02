package com.bankmanagmentsystem.www.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagmentsystem.www.constants.TransferStatus;
import com.bankmanagmentsystem.www.entities.Account;
import com.bankmanagmentsystem.www.entities.Customer;
import com.bankmanagmentsystem.www.entities.FundTransferRequestBody;
import com.bankmanagmentsystem.www.repositery.AccountRepository;

@Service
public class AccountServicesImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccounts() {
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public Account getAccount(int accountId) {
		Optional<Account> optionalAccount = accountRepository.findById(accountId);
		return optionalAccount.orElse(null);
	}

	@Override
	public Account creatAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account addCustomerForAccount(int accountId, Customer customer) {
		Account account = this.getAccount(accountId);
		Set<Customer> customers = account.getCustomers();
		customers.add(customer);
		account.setCustomer(customers);
		accountRepository.save(account);
		return account;
	}

	@Override
	public String transferfund(FundTransferRequestBody fundTransferRequestBody) {
		if (fundTransferRequestBody.getFromAccountNo() == fundTransferRequestBody.getFromAccountNo())
			return TransferStatus.IDENTICAL_ACCOUNT;
		Account fromAccount = this.getAccount(fundTransferRequestBody.getFromAccountNo());
		if (fromAccount == null)
			return TransferStatus.ID_MISSMATCH;
		Account toAccount = this.getAccount(fundTransferRequestBody.getToAccountNo());
		if (toAccount == null)
			return TransferStatus.ID_MISSMATCH;
		if (fromAccount.getBalabce() < fundTransferRequestBody.getAmount() + 10_000)
			return TransferStatus.INSUFFICRNT_FUNDS;

		double balance = fromAccount.getBalabce();
		balance = balance - fundTransferRequestBody.getAmount();
		fromAccount.setBalabce(balance);

		balance = toAccount.getBalabce();
		balance = balance + toAccount.getBalabce();
		toAccount.setBalabce(balance);

		return TransferStatus.SUCCESS;
	}

}
