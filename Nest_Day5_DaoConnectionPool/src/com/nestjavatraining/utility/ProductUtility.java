package com.nestjavatraining.utility;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.nestjavatraining.entity.Product;
import com.nestjavatraining.service.ProductService;
import com.nestjavatraining.service.ProductServiceImpl;

public class ProductUtility {
	private static ProductService productService = new ProductServiceImpl();
	private static Product product = null;

	public static void main(String[] args) {
		char ch;
		String productCode;
		String productName;
		String productDescription;
		Date activationDate;
		Date expiryDate;

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1.Save Product, 2.Delete Product, 3.List All Products, 4.Search Product");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter product code");
				productCode = scanner.next();
				System.out.println("Enter product name");
				productName = scanner.next();
				System.out.println("Enter product description");
				productDescription = scanner.next();
				activationDate = java.sql.Date.valueOf(LocalDate.now());
				expiryDate = null;
				saveProduct(productCode, productName, productDescription, activationDate, expiryDate);
				break;
			case 2:
				System.out.println("Enter product code");
				deleteProduct(scanner.next());
				break;
			case 3:
				listAllProducts();
				break;
			case 4:
				System.out.println("Enter product code");
				searchProduct(scanner.next());
				break;
			default:
				System.out.println("Invalid Choice");
			}
			System.out.println("Do you want to continue (y/n)");
			ch = scanner.next().charAt(0);
		} while (ch == 'y');
	}

	private static void searchProduct(String productCode) {
		try {
			product = productService.getProduct(productCode);
			System.out.println(
					"Product Code " + " " + "Product Name" + " " + "Product Description" + " " + "Activation Date");
			System.out.println(product.getProductCode() + " " + product.getProductName() + " "
					+ product.getProductDescription() + " " + product.getActivationDate());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void listAllProducts() {
		List<Product> productList = productService.listAllProducts();
		System.out.println(
				"Product Code " + " " + "Product Name" + " " + "Product Description" + " " + "Activation Date");
		for (Product product : productList)
			System.out.println(product.getProductCode() + " " + product.getProductName() + " "
					+ product.getProductDescription() + " " + product.getActivationDate());
	}

	private static void deleteProduct(String productCode) {
		try {
			productService.deleteProduct(productCode);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}

	private static void saveProduct(String productCode, String productName, String productDescription,
			Date activationDate, Date expiryDate) {
		product = new Product(productCode, productName, productDescription, activationDate, expiryDate);

		productService.saveProduct(product);
	}

}
