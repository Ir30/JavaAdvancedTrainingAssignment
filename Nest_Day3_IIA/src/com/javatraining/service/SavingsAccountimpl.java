package com.javatraining.service;

import java.util.ArrayList;

import com.javatraining.entity.SavingsAccount;
import com.javatraining.entity.SavingsMaxAccount;
import com.javatraining.entity.WomenSavingsAccount;

public class SavingsAccountimpl implements AccountService {
	private ArrayList<SavingsAccount> accountList = new ArrayList();

	public ArrayList<SavingsAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(ArrayList<SavingsAccount> accountList) {
		this.accountList = accountList;
	}

	@Override
	public SavingsAccount createAccount(int choice,String userName,String password) {
		SavingsAccount savingsAccount = null;

		if (choice == 1) {
			savingsAccount = new WomenSavingsAccount("Women Savings Account", "",userName,password);
		} else {
			savingsAccount = new SavingsMaxAccount("Savings Max Account","",userName,password);
		}
		accountList.add(savingsAccount);

		return savingsAccount;

	}

	@Override
	public void depositAmount(double amount, SavingsAccount savingsAccount) {
		savingsAccount.setAccountBalance(savingsAccount.getAccountBalance() + amount);
		System.out.println("you deposited " + amount + "Rupees");

	}

	@Override
	public void withdrawAmount(double amount, SavingsAccount savingsAccount) {
		if (savingsAccount.getAccountBalance() - amount < 0) {
			System.out.println("insufficient balance");
		} else {
			savingsAccount.setAccountBalance(savingsAccount.getAccountBalance() - amount);
			System.out.println("you withdrawed " + amount + "Rupees");
		}

	}

	@Override
	public void displayDetiles() {
		System.out.println("SINo\tAccountCode\t AccountType\t\tCreateDate\tBalance\tFreeLimit\r\n"
				+ "--------------------------------------------------------------------------------\r\n");
		int count=1;
		for(SavingsAccount savingsAccount:accountList) {
			System.out.println(count+" \t"+savingsAccount);
			count+=1;
		}
	}

}
