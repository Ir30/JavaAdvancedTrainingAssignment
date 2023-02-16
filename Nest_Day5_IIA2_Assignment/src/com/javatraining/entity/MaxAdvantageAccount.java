package com.javatraining.entity;

public class MaxAdvantageAccount extends CurrentAccount {

	public MaxAdvantageAccount(String accountName, String expiryDate) {
		super(accountName, expiryDate);
		this.setBalance(50000);
		this.setType(3);
		this.setAccountCode("MAA"+String.valueOf(this.getBasicCode()));
	}
	
}
