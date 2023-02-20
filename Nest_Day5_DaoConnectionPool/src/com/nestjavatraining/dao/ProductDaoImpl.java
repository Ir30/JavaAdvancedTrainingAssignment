package com.nestjavatraining.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nestjavatraining.ConnectionPool.ConnectionPool;
import com.nestjavatraining.entity.Product;

public class ProductDaoImpl implements ProductDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	@Override
	public void saveProduct(Product product) {

		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO product (`productcode`,`productname`,`productdescription`,`activationdate`,`expirtydate`) VALUES(?,?,?,?,?)");
			preparedStatement.setString(1, product.getProductCode());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setString(3, product.getProductDescription());
			preparedStatement.setDate(4, (Date) product.getActivationDate());
			preparedStatement.setDate(5, (Date) product.getExpiryDate());
			
			
			System.out.println(preparedStatement.executeUpdate()+" recode inserted");
			connection.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Product> listAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		String selectSQL = "Select * from product";
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				productList.add(new Product(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getDate(6)));
				} 
			connection.close();
			} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
			}
		return productList;
	
	}

	@Override
	public Product getProduct(String produPctCode) {
		Product product=null;
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM `product` WHERE `productcode`= ? LIMIT 1;");
			preparedStatement.setString(1, produPctCode);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				product= new Product(resultSet.getString(2),resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getDate(6)); 
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return product;
		
	}

	@Override
	public void deleteProduct(String productCode) {
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM product WHERE productcode =?");
			preparedStatement.setString(1, productCode);
			
			System.out.println(preparedStatement.executeUpdate()+" recode deleted");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
