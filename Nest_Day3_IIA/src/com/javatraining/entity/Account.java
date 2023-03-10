package com.javatraining.entity;

import java.time.LocalDate;

abstract public class Account {

	private String accountCode;
	private String accountName;
	private String openingDate;
	private String expiryDate;
	private String userName;
	private String password;
	static int basicCode=101;
	static int smaBasicCode=101;
	public Account(String accountName, String expiryDate,String userName,String password) {
		this.accountName = accountName;
		this.openingDate =   String.valueOf(LocalDate.now());  
		this.expiryDate = expiryDate;
		this.userName=userName;
		this.password=password;
		
		
	}
	

	@Override
	public String toString() {
		return String.format("%10s\t%10s\t%10s",this.getAccountCode(),this.getAccountName(),this.getOpeningDate());

	}
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}


	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public static int getBasicCode() {
		return basicCode;
	}

	public static void setBasicCode(int basicCode) {
		Account.basicCode = basicCode;
	}
	

}