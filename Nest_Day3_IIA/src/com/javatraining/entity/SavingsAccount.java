package com.javatraining.entity;

import java.io.Flushable;
import java.util.Formatter;

abstract public class SavingsAccount extends Account {

	private double accountBalance;
	
	@Override
	public String toString() {
		
		return String.format("%s\t%s",super.toString(),this.getAccountBalance());
	}

	public SavingsAccount(String accountName, String expiryDate,String userName,String password) {
		super(accountName, expiryDate,userName,password);
		this.accountBalance = 0;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
