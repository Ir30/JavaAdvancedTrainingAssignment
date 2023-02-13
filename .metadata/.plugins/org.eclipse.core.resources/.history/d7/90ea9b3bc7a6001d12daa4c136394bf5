package com.nestjavatraining.service;

import com.nestjavatraining.entity.Account;

public class AccountService {
	
	public static Account createAccount(String name,String username,String password){
		Account account = new Account(name,username,password);
		System.out.println("Account created succesfully\n"+"Name: "+account.getAccountName()+"\nAccount No: "+account.getAccountNo());
		return account;
	}
	
	public static void displayAccount(Account account) {
		
		System.out.println("Name: "+account.getAccountName());
		System.out.println("Account No: "+account.getAccountNo());
		System.out.println("Balance: "+account.getBalance());
		
	}
	
	public static void investMoney(float amount,Account account) {
		
		account.setBalance(account.getBalance()+amount);
		System.out.println("You invested "+amount+ " successfully");
		
	}
	
	public static void withdrawMoney(float amount,Account account) {
		if((account.getBalance()-amount)<0) {
			System.out.println("Sorry!.. Insufficient balance");
		}else {
			account.setBalance(account.getBalance()-amount);
			System.out.println("You Withdrawed "+amount+ " successfully");
		}
		

	}

}
