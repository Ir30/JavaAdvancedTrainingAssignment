package com.nestjavatraoning.service;

import com.nestjavatraining.entity.Account;

public class CashWithdrawl implements Service {

	private Account account;
	
	
	
	public CashWithdrawl(Account account) {
		super();
		this.account = account;
	}



	@Override
	public void withdrawAmount(double amount) {
		if (this.account.getBalance() - amount >= 0) {
			this.account.setBalance(this.account.getBalance() - amount);
			System.out.println("You withdrawed " + amount + " through Bank");
		} else
			System.out.println("Insufficient balance");
		
	}



	@Override
	public void depositeAmount(double amount) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void checkDeposite() {
		// TODO Auto-generated method stub
		
	}

	



}
