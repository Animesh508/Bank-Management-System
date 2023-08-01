package com.bankmanagmentsystem.www.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	@Column
	private double balabce;
	@Column
	private AccountType accountType;

	@ManyToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Customer> customer = new HashSet<>();

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalabce() {
		return balabce;
	}

	public void setBalabce(double balabce) {
		this.balabce = balabce;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((accountType == null) ? 0 : customer.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balabce);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() == obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (accountType != other.accountType)
			return false;
		if (Double.doubleToLongBits(balabce) != Double.doubleToLongBits(other.balabce))
			return false;
		if (customer == null) {
			return false;
		}else if(!customer.equals(other.customer))
			return false;
		return true;
	}

}
