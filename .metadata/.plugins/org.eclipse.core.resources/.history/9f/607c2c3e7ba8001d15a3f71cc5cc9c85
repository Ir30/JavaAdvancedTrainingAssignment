package com.nestjavatraining.dbDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Main {
	
	static void insertEmployee(String name,Connection c) throws SQLException {
		PreparedStatement statement = c.prepareStatement("insert into employee(employeename)values(?)");
		statement.setString(1, name);
		int i = statement.executeUpdate();
		System.out.println(i+" records inserted");
	}
	static void searchEmployee(int id,Connection c) throws SQLException  {
		PreparedStatement statement = c.prepareStatement("select * from employee where employeeid=?");
		statement.setInt(1,id);
		ResultSet resultSet = statement.executeQuery(); 
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
		}
	}
	
	static void updateEmployee(int id,String name,Connection c) throws SQLException {
		PreparedStatement statement = c.prepareStatement("UPDATE employee SET employeename = ? WHERE employeeid = ?");
		statement.setString(1, name);
		statement.setInt(2, id);
		int i=statement.executeUpdate();
		System.out.println(i+" records updated");
		
	}
	
	static void deleteEmoloyee(int id,Connection c) throws SQLException {
		PreparedStatement statement = c.prepareStatement("DELETE FROM employee WHERE employeeid =?");
		statement.setInt(1, id);
		int i = statement.executeUpdate();
		System.out.println(i+" recod deleted");
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			String connectionString = "jdbc:mysql://localhost:3306/canddella_employee_db?allowPublicKeyRetrieval=true&useSSL=false";
			String userName = "root";
			String password = "";
			
			Connection connection = DriverManager.getConnection(connectionString,userName,password);
			
			while(true) {
				System.out.println("*****MENU*****\n1.Insert Employee\n2.Search Employee\n3.Update Employee\n4.Delete Employee\n5.Exit");
				int choice = sc.nextInt();
				
				switch(choice) {
					case 1:{
						System.out.println("Enter employee name: ");
						String name = sc.next();
						insertEmployee(name,connection);
						break;
					}
					case 2:{
						System.out.println("Enter employee id: ");
						int id = sc.nextInt();
						searchEmployee(id,connection);
						break;
					}
					case 3:{
						System.out.println("Enter employee id: ");
						int id = sc.nextInt();
						System.out.println("Enter employee name to update: ");
						String name = sc.next();
						updateEmployee(id,name,connection);
						break;
					}
					case 4:{
						System.out.println("Enter employee id: ");
						int id = sc.nextInt();
						deleteEmoloyee(id,connection);
						break;
					}
					case 5:{
						connection.close();
						System.exit(0);
					}
					default:{
						System.out.println("Enter a valid choice");
					}
				}
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
}
