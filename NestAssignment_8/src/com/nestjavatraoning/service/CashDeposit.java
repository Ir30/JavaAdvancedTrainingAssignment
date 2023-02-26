package com.nestjavatraoning.service;

import com.nestjavatraining.entity.Account;

public class CashDeposit implements Service {

	private Account account;
	
	
	
	public CashDeposit(Account account) {
		this.account = account;
	}



	@Override
	public void withdrawAmount(double amount) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void depositeAmount(double amount) {
		this.account.setBalance(this.account.getBalance()+amount);
		System.out.println("You deposited "+amount+ " rupees");
	}



	@Override
	public void checkDeposite() {
		// TODO Auto-generated method stub
		
	}



	





}
