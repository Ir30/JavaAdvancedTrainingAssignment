package com.javatraining.service;

import com.javatraining.entity.Account;
import com.javatraining.entity.ActiveCurrentAccount;
import com.javatraining.entity.CurrentAccount;
import com.javatraining.entity.MaxAdvantageAccount;
import com.javatraining.entity.SavingsAccount;

public class CurrentAccountImpl implements AccountService {

	@Override
	public CurrentAccount createAccount(int choice) {
		CurrentAccount currentAccount = null;

		if (choice == 1) {
			currentAccount = new MaxAdvantageAccount("Max Advantage Account","");
		} else {
			currentAccount = new ActiveCurrentAccount("Active Current Account","");
		}

		return currentAccount;
	}

	@Override
	public void depositAmount(double amount, Account account) {
		((CurrentAccount)account).setBalance(((CurrentAccount)account).getBalance()+amount);
	}

	@Override
	public void withdrawAmount(double amount, Account account) {
		if (((SavingsAccount) account).getAccountBalance() - amount < 0) {
			System.out.println("insufficient balance");
		} else {
			((CurrentAccount) account).setBalance(((CurrentAccount) account).getBalance() - amount);
			System.out.println("you withdrawed " + amount + "Rupees");
		}
	}



}
