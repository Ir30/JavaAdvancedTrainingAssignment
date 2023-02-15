package com.javatraining.entity;

public class WomenSavingsAccount extends SavingsAccount {

	private int freeLimit;

	public WomenSavingsAccount(String accountName, String expiryDate) {
		super(accountName, expiryDate);
		this.setAccountCode("WSA"+String.valueOf(basicCode));
		basicCode+=1;
		this.freeLimit = 3;
		this.setType(1);
		
	}
	@Override
	public String toString() {
		return String.format("%s\t%s",super.toString(),this.freeLimit);
	}


	public int getFreeLimit() {
		return freeLimit;
	}

	public void setFreeLimit(int freeLimit) {
		this.freeLimit = freeLimit;
	}

}
