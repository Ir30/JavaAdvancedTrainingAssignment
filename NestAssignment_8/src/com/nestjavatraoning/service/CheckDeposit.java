package com.nestjavatraoning.service;

import com.nestjavatraining.entity.Account;

public class CheckDeposit implements Service {

	private Account account;
	
	
	public CheckDeposit(Account account) {

		this.account = account;
	}


	@Override
	public void withdrawAmount(double amount) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void depositeAmount(double amount) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void checkDeposite() {
		System.out.println("Account balance: "+this.account.getBalance()+" Rupees");
		
	}






}
