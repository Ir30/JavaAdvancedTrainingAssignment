package com.javatraining.utility;

import java.util.Scanner;

import com.javatraining.entity.Customer;
import com.javatraining.entity.SavingsAccount;
import com.javatraining.service.SavingsAccountimpl;

public class BankUtility {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SavingsAccount savingsAccount = null;
		SavingsAccountimpl savingsAccountimpl = new SavingsAccountimpl();
		Customer customer = null;
		while (true) {
			System.out.println(" 1. Create Account\n 2. Login \n 3. Display All Account\n 4. Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("1. Womens Savings Account\n2. Savings Max Account");
				int option = scanner.nextInt();
				System.out.println("Enter Username: ");
				String userName = scanner.next();
				System.out.println("Enter Password:");
				String password = scanner.next();
				savingsAccount = savingsAccountimpl.createAccount(option, userName, password);
				customer = savingsAccountimpl.createCustomer(savingsAccount);
				System.out.println("Customer Name: " +customer.getCustomerName()+"Account Balance: "+customer.getAccount().getAccountCode());
				break;
			}
			case 2: {
				System.out.println("Enter username: ");
				String username = scanner.next();
				System.out.println("Enter Password: ");
				String password = scanner.next();

				boolean b = false;
				for (SavingsAccount ac : savingsAccountimpl.accountList) {

					if ((ac.getUserName().equals(username)) && (ac.getPassword().equals(password))) {
						System.out.println("Login Successfull");
						b = true;
						int option;
						do {
							System.out.println(" 1. Deposite Amount \n 2. Withdraw Amount \n 3. Exit");
							option = scanner.nextInt();

							switch (option) {

							case 1: {
								System.out.println("enter the amount:");
								double amount = scanner.nextDouble();
								savingsAccountimpl.depositAmount(amount, ac);
								break;
							}
							case 2: {
								System.out.println("enter the amount:");
								double amount = scanner.nextDouble();
								savingsAccountimpl.withdrawAmount(amount, ac);
								break;
							}
							case 3:
								System.out.println("logout succesfull");
								break;
							default:
								System.out.println("Invalid choice");
							}
						} while (option != 3);

					}
					
				}
				if (!b) {
					System.out.println("invalid credentials");
				}
				break;
			}

			case 3: {
				savingsAccountimpl.displayDetiles();
				break;
			}
			case 4: {
				System.exit(0);
				break;
			}
			}

		}
	}
}
