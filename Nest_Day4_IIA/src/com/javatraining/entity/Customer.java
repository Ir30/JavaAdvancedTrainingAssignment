package com.javatraining.entity;

public class Customer {
	private String cusomerCode;
	private String customerName;
	private Account account;
	
	

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "Customer Name"+this.customerName+" Account Balance"+this.account.	;
//	}

	public Customer(String cusomerCode, String customerName, Account account) {
		this.cusomerCode = cusomerCode;
		this.customerName = customerName;
		this.account = account;
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
