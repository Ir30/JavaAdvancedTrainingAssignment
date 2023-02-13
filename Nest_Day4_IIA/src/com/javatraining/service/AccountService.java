package com.javatraining.service;

import com.javatraining.entity.Account;
import com.javatraining.entity.Customer;
import com.javatraining.entity.SavingsAccount;

public interface AccountService {

	public SavingsAccount createAccount(int choice,String userName,String password);
	public void depositAmount(double amount,SavingsAccount savingsAccount);
	public void withdrawAmount(double amount,SavingsAccount savingsAccount);
	public void displayDetiles();
	public Customer createCustomer(Account account);



}
