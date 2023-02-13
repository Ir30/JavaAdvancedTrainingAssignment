package com.nestjavatraining.dbDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	static void insertEmployee(String name,Statement s) throws SQLException {
		String query = String.format("INSERT INTO employee (employeename) VALUES('%s');", name);
		s.executeUpdate(query);
	}
	static void searchEmployee(int id,Statement s) throws SQLException  {
		String query = String.format("SELECT * FROM `employee` WHERE `employeeid`= %x",id );
		ResultSet resultSet = s.executeQuery(query);
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
		}
	}
	
	static void updateEmployee(int id,String name,Statement s) throws SQLException {
		String query = String.format("UPDATE employee SET employeename = '%s' WHERE employeeid = %x; ",name,id);
		s.executeUpdate(query);	
	}
	
	static void deleteEmoloyee(int id,Statement s) throws SQLException {
		String query = String.format("DELETE FROM employee WHERE employeeid = %x",id);
		s.executeUpdate(query);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			String connectionString = "jdbc:mysql://localhost:3306/canddella_employee_db?allowPublicKeyRetrieval=true&useSSL=false";
			String userName = "root";
			String password = "";
			
			Connection connection = DriverManager.getConnection(connectionString,userName,password);
			Statement statement = connection.createStatement();
			while(true) {
				System.out.println("*****MENU*****\n1.Insert Employee\n2.Search Employee\n3.Update Employee\n4.Delete Employee\n5.Exit");
				int choice = sc.nextInt();
				
				switch(choice) {
					case 1:{
						System.out.println("Enter employee name: ");
						String name = sc.next();
						insertEmployee(name,statement);
						break;
					}
					case 2:{
						System.out.println("Enter employee id: ");
						int id = sc.nextInt();
						searchEmployee(id,statement);
						break;
					}
					case 3:{
						System.out.println("Enter employee id: ");
						int id = sc.nextInt();
						System.out.println("Enter employee name to update: ");
						String name = sc.next();
						updateEmployee(id,name,statement);
						break;
					}
					case 4:{
						System.out.println("Enter employee id: ");
						int id = sc.nextInt();
						deleteEmoloyee(id,statement);
						break;
					}
					case 5:{
						connection.close();
						System.exit(0);
					}
				}
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
}
