package com.javatraining.entity;

public class CurrentAccount extends Account {

	private double balance;
	
	@Override
	public String toString() {
		return super.toString()+"\t"+this.balance;
	}

	public CurrentAccount(String accountName, String expiryDate) {
		super(accountName, expiryDate);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
