package com.nestjavatraining.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.nestjavatraining.sortingdemo.Customer;

public class CollectionUtility {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch;
		String sortingParameter = "";
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer(36, "Suneesh"));
		customerList.add(new Customer(4, "Keyaan"));
		customerList.add(new Customer(32, "Remi"));
		customerList.add(new Customer(22, "Saranya"));
		customerList.add(new Customer(23, "Arjun"));
		customerList.add(new Customer(19, "Vineeth"));
		System.out.println("");
		System.out.println("Customer List Before Sorting");
		System.out.println("Customer Name" + " " + "Customer Age");
		for (Customer customer : customerList)
		System.out.println(customer.getName() + " " + customer.getAge());
		do
		{
		System.out.println("");
		System.out.println("1. Sort Based On Name, 2. Sort Based On Age");
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1 : Collections.sort(customerList,new Comparator<Customer>() {
			
			public int compare(Customer o1, Customer o2) {
				
				return o1.getName().compareTo(o2.getName());
			}
		});
		sortingParameter = "Customer List After Sorting Based On Name";
		break;
		case 2 :Collections.sort(customerList,new Comparator<Customer>() {
			public int compare(Customer o1, Customer o2) {
				
				return o1.getAge()-o2.getAge();
			}
		});
		sortingParameter = "Customer List After Sorting Based On Age";
		break;
		}
		

		System.out.println(sortingParameter);
		System.out.println("Customer Name" + " " + "Customer Age");
		for (Customer customer : customerList)
		System.out.println(customer.getName() + " " + customer.getAge());
		System.out.println("");
		System.out.println("Do you want to continue (y/n)");
		ch = scanner.next().charAt(0);
		}
		while(ch == 'y');
		}

	}

