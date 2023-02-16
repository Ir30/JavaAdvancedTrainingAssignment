package com.javatraining.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.javatraining.entity.Account;
import com.javatraining.entity.CurrentAccount;
import com.javatraining.entity.Customer;
import com.javatraining.entity.SavingsAccount;
import com.javatraining.service.AccountService;
import com.javatraining.service.CurrentAccountImpl;
import com.javatraining.service.SavingsAccountimpl;

public class BankUtility {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SavingsAccount savingsAccount = null;
		CurrentAccount currentAccount = null;
		SavingsAccountimpl savingsAccountimpl = new SavingsAccountimpl();
		CurrentAccountImpl currentAccountImpl = new CurrentAccountImpl();
		Customer customer = null;
		ArrayList<Customer> accountList = new ArrayList();
		int select;
		while (true) {
			System.out.println(" 1. Create Account\n 2. Login \n 3. Display All Account\n 4. Exit");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("1.Savings Account\n2.Current Account");
				int option = scanner.nextInt();
				
				if (option == 1) {
					System.out.println("1.Women Savings Account\n2.Savings Max Account");
					select = scanner.nextInt();
					System.out.println("Enter Name: ");
					String name = scanner.next();
					System.out.println("Enter Password:");
					String password = scanner.next();
					savingsAccount = savingsAccountimpl.createAccount(select);
					customer = AccountService.createCustomer(savingsAccount, name, password);
					customer.setPersonalAccounts(savingsAccount);
					accountList.add(customer);

				} else {
					System.out.println("1.Max Advantage Account\n2.Active Current Account");
					select = scanner.nextInt();
					System.out.println("Enter Name: ");
					String name = scanner.next();
					System.out.println("Enter Password:");
					String password = scanner.next();
					currentAccount = currentAccountImpl.createAccount(select);
					customer = AccountService.createCustomer(currentAccount, name, password);
					customer.setPersonalAccounts(currentAccount);
					accountList.add(customer);
				}
				break;
			}
			case 2: {
				System.out.println("Enter username: ");
				String username = scanner.next();
				System.out.println("Enter Password: ");
				String password = scanner.next();
				System.out.println("Enter account type: \n1.Women Savings Account\n2.Savings Max Account\n3.Max Advantage Account\n4.Active Current Account");
				int type = scanner.nextInt();

				boolean b = false;
				for (Customer c : accountList) {
					for(Account ac:c.getPersonalAccounts()) {
						if(c.getCustomerName().equals(username) && c.getPassword().equals(password) && ac.getType()==type) {
							System.out.println("Login Succesfull");
							b=true;
							int option;
							do {
								System.out.println("1. Create Another Account\n2. Deposite Amount \n3. Withdraw Amount\n4. Display All Accounts\n5. Exit");
								option = scanner.nextInt();

								switch (option) {
									case 1:{
										System.out.println("1.Savings Account\n2.Current Account");
										int acc = scanner.nextInt();
										
										if (acc == 1) {
											System.out.println("1.Women Savings Account\n2.Savings Max Account");
											select = scanner.nextInt();
											savingsAccount = savingsAccountimpl.createAccount(select);
											c.setPersonalAccounts(savingsAccount);
										} else {
											System.out.println("1.Max Advantage Account\n2.Active Current Account");
											select = scanner.nextInt();
											currentAccount = currentAccountImpl.createAccount(select);
											c.setPersonalAccounts(currentAccount);
										}
										break;
									}
									case 2: {
										System.out.println("enter the amount:");
										double amount = scanner.nextDouble();
										if(ac.getType()==1 ||ac.getType()==2) {
											savingsAccountimpl.depositAmount(amount, ac);
										}else {
											currentAccountImpl.depositAmount(amount, ac);
										}
										break;
									}
									case 3: {
										System.out.println("enter the amount:");
										double amount = scanner.nextDouble();
										if(ac.getType()==1 ||ac.getType()==2) {
											savingsAccountimpl.withdrawAmount(amount,ac);
										}else {
											currentAccountImpl.withdrawAmount(amount,ac);
										}
										break;
									}
									case 4:{
										int count=1;
										System.out.println("SINo\tCustomer Name\tAccountCode\t AccountType\t\tCreateDate\tBalance\tFreeLimit\r\n"
												+ "--------------------------------------------------------------------------------\r\n");
										for(Account a:c.getPersonalAccounts()) {
											
											System.out.println(count+"\t"+c.getCustomerName()+"\t"+a);
										}
										break;
									}
									case 5:{
										System.out.println("Logout successfull");
										break;
									}
									default:
										System.out.println("Invalid choice");
								}
							} while (option != 5);
						}
					}
					if (!b) {
						System.out.println("invalid credentials");
					}
				}
				
				break;
			}
			case 3: {
				AccountService.displayDetiles(accountList);
				break;
			}
			case 4: {
				System.exit(0);
				break;
			}
			default:
				System.out.println("Invalid choice");
			}
		}
	}
}
