package com.nestjavatraining.utility;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nestjavatraoning.service.Service;

public class AccountUtility {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Service service;
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		int option;

		do {
			System.out
					.println("Choose One\n1.ATM Withdrawl\n2.Cash Deposit\n3.Cash Withdrawl\n4.Check Deposit\n5.Exit");
			option = sc.nextInt();
			switch (option) {
			case 1:
				service = context.getBean("atmWithdrawal", Service.class);
				System.out.println("Enter amount to withdraw");
				service.withdrawAmount(sc.nextDouble());
				break;
			case 2:
				service = context.getBean("cashDeposit", Service.class);
				System.out.println("Enter amount to deposit");
				service.depositeAmount(sc.nextDouble());
				break;
			case 3:
				service=context.getBean("CashWithdrawl",Service.class);
				System.out.println("Enter amount to withdraw");
				service.withdrawAmount(sc.nextDouble());
				break;
			case 4:
				service=context.getBean("CheckDeposit",Service.class);
				service.checkDeposite();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid Choice!!!");
			}
		} while (option != 5);
	}

}
