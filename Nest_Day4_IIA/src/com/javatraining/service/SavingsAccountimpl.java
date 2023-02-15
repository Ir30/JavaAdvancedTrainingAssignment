package com.javatraining.service;

import java.util.ArrayList;

import com.javatraining.entity.Account;
import com.javatraining.entity.Customer;
import com.javatraining.entity.SavingsAccount;
import com.javatraining.entity.SavingsMaxAccount;
import com.javatraining.entity.WomenSavingsAccount;

public class SavingsAccountimpl implements AccountService {

	@Override
	public SavingsAccount createAccount(int choice) {
		SavingsAccount savingsAccount = null;

		if (choice == 1) {
			savingsAccount = new WomenSavingsAccount("Women Savings Account", "");
		} else {
			savingsAccount = new SavingsMaxAccount("Savings Max Account", "");
		}

		return savingsAccount;

	}

	@Override
	public void depositAmount(double amount, Account account) {
		
		((SavingsAccount) account).setAccountBalance(((SavingsAccount) account).getAccountBalance() + amount);
		System.out.println("you deposited " + amount + "Rupees");

	}

	@Override
	public void withdrawAmount(double amount, Account account) {
		if (((SavingsAccount) account).getAccountBalance() - amount < 0) {
			System.out.println("insufficient balance");
		} else {
			((SavingsAccount) account).setAccountBalance(((SavingsAccount) account).getAccountBalance() - amount);
			System.out.println("you withdrawed " + amount + "Rupees");
		}

	}





}
