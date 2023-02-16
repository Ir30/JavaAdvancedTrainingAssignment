package com.javatraining.entity;

public class ActiveCurrentAccount extends CurrentAccount {
	private int freeLimit;

	public ActiveCurrentAccount(String accountName, String expiryDate) {
		super(accountName, expiryDate);
		this.freeLimit = 150;
		this.setBalance(10000);
		this.setType(4);
		this.setAccountCode("ACA"+String.valueOf(this.getBasicCode()));
	}
	
	@Override
	public String toString() {
		return super.toString()+"\t"+this.freeLimit;
	}

	public int getFreeLimit() {
		return freeLimit;
	}

	public void setFreeLimit(int freeLimit) {
		this.freeLimit = freeLimit;
	}
	
}
