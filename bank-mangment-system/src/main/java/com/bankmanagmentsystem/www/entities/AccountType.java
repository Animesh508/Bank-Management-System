package com.bankmanagmentsystem.www.entities;



public enum AccountType {
	CURRENT("Current"),
	SAVINGS("Savings");
	
	private final String accounType;
	
	private AccountType(String accountType) {
		this.accounType = accountType;
	}

}
