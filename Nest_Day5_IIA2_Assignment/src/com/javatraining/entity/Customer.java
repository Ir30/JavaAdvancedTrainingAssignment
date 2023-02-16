package com.javatraining.entity;

import java.util.ArrayList;

public class Customer {
	private String cusomerCode;
	private String customerName;
	private Account account;
	private String password;
	private ArrayList<Account> personalAccounts=new ArrayList();
	private static int basicCode=101;
	
	public Customer(String customerName,String password, Account account) {
		this.cusomerCode = "CUS"+String.valueOf(basicCode);
		this.customerName = customerName;
		this.account = account;
		this.password=password;
		basicCode+=1;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Account> getPersonalAccounts() {
		return personalAccounts;
	}

	public void setPersonalAccounts(Account account) {
		this.personalAccounts.add(account);
	}

	

	public String getCusomerCode() {
		return cusomerCode;
	}

	public void setCusomerCode(String cusomerCode) {
		this.cusomerCode = cusomerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
