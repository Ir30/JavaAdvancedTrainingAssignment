package com.javatraining.service;

import java.util.ArrayList;

import com.javatraining.entity.Account;
import com.javatraining.entity.Customer;
import com.javatraining.entity.SavingsAccount;

public interface AccountService {

	public Account createAccount(int choice);
	public void depositAmount(double amount,Account account);
	public void withdrawAmount(double amount,Account account);

	
	public static Customer createCustomer(Account account,String name,String password) {
		Customer customer = new Customer(name,password, account);
		return customer;
	}

	public static void displayDetiles(ArrayList<Customer> accountList) {
		System.out.println("SINo\tCustomer Name\t\tAccountCode\t\tAccountType\t\tCreateDate\tBalance\tFreeLimit\r\n"
				+ "--------------------------------------------------------------------------------\r\n");
		int count = 0;
		for (Customer c : accountList) {
			count+=1;
			for(Account ac:c.getPersonalAccounts())
			System.out.println(count + " \t" +c.getCustomerName()+"\t"+ ac);
			count += 1;
		}
	}


}
