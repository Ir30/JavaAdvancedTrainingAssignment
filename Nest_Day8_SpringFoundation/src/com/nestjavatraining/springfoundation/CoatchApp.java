package com.nestjavatraining.springfoundation;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoatchApp {

	public static void main(String args[]) {

		Coatch theCoatch;
		Scanner sc = new Scanner(System.in);
//		load the spring configuration file 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		int option;
		do {
			System.out.println("Choose a Coach\n1.BaseBall\r\n" + "2.Hockey\r\n" + "3.Cricket \r\n" + "4.Football\r\n5.Exit");
			option = sc.nextInt();
			switch(option) {
				case 1:theCoatch = context.getBean("baseBallCoatch", Coatch.class);
					System.out.println(theCoatch.getDailyWorkout());
					break;
				case 2:
					theCoatch = context.getBean("hockeyCoach", Coatch.class);
					System.out.println(theCoatch.getDailyWorkout());
					break;
				case 3:
					theCoatch = context.getBean("cricketCoatch", Coatch.class);
					System.out.println(theCoatch.getDailyWorkout());
					break;
				case 4:
					theCoatch = context.getBean("footBallCoatch", Coatch.class);
					System.out.println(theCoatch.getDailyWorkout());
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Invalid choice");
			}
		}while(option!=5);
		context.close();
		
	}
}
