package com.javatraining.entity;

public class SavingsMaxAccount extends SavingsAccount {

	public SavingsMaxAccount(String accountName, String expiryDate,String userName,String password) {
		super( accountName, expiryDate,userName,password);
		this.setAccountCode("SMA"+String.valueOf(smaBasicCode));
		smaBasicCode+=1;
	}

}
