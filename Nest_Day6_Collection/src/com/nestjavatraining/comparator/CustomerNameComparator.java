package com.nestjavatraining.comparator;

import java.util.Comparator;

import com.nestjavatraining.sortingdemo.Customer;

public class CustomerNameComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		
		return o1.getName().compareTo(o2.getName());
	}

}
