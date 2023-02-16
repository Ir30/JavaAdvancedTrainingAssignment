package com.javatraining.entity;

public class SavingsMaxAccount extends SavingsAccount {

	public SavingsMaxAccount(String accountName, String expiryDate) {
		super( accountName, expiryDate);
		this.setAccountCode("SMA"+String.valueOf(smaBasicCode));
		smaBasicCode+=1;
		this.setType(2);
	}

}
