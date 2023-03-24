package com.shakhawat.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.shakhawat.config.DBConnection;
import com.shakhawat.model.Customer;
import com.shakhawat.util.CustomerValidation;

public class CustomerService {
	
	private static final String ALL_CUSTOMER = "CUSTOMERS";
	private static final String INVALID_CUSTOMER = "CUSTOMER_INVALID";
	private static final String VALID_CUSTOMER = "CUSTOMER_VALID";

	/**
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public static void readFileAndProcessCustomers(String fileName) throws IOException {

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String line = null;

		List<Customer> allCustomers = new ArrayList<>();
		List<Customer> invalidCustomers = new ArrayList<>();
		Set<Customer> validCustomers = new HashSet<>();
		
		while ((line = br.readLine()) != null) {
			String[] values = line.split(",");
			
			// All Customers
			if (values.length >= 8) {
				allCustomers.add(new Customer(null, values[0], values[1], values[2], values[3], values[4], values[5],
						values[6], values[7]));
			}
			
			//Invalid Customers
			if (!(CustomerValidation.isPhoneNumberValid(values[5])) || !(CustomerValidation.isEmailValid(values[6]))) {
				if (values.length >= 8) {
					invalidCustomers.add(new Customer(null, values[0], values[1], values[2], values[3], values[4],
							values[5], values[6], values[7]));
				}
			}
			
			// Unique Valid Customers
			if ((CustomerValidation.isPhoneNumberValid(values[5])) && (CustomerValidation.isEmailValid(values[6]))) {
				if (values.length >= 8) {
					validCustomers.add(new Customer(null, values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]));
				}
			}
		}

		List<Customer> validCustomerList = validCustomers.stream().collect(Collectors.toList());

		DBConnection dbConnection = new DBConnection();
		dbConnection.createBulk(allCustomers, ALL_CUSTOMER);
		dbConnection.close();
		
		DBConnection dbConnection1 = new DBConnection();
		dbConnection1.createBulk(invalidCustomers, INVALID_CUSTOMER);
		dbConnection1.close();
		
		DBConnection dbConnection2 = new DBConnection();
		dbConnection2.createBulk(validCustomerList, VALID_CUSTOMER);
		dbConnection2.close();

		br.close();
	}

	/**
	 * Export batch wise valid customer data
	 */
	public static void chunkValidCustomerExport() {

		DBConnection dbConnection = new DBConnection();
		String selectQuery = "SELECT * FROM CUSTOMER_VALID;";
		ResultSet rs = dbConnection.select(selectQuery);

		int totalCustomers = 0;

		try {
			if (rs != null) {
				rs.beforeFirst();
				rs.last();
				totalCustomers = rs.getRow();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i <= totalCustomers; i = i + 100000) {
			try {
				String fileName = "batch-" + i;
				String rawLimitSql = "SELECT * FROM CUSTOMER_VALID LIMIT " + i + ", 100000;";
				exportDataFromDatabase(rawLimitSql, fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dbConnection.close();
	}

	/**
	 * 
	 * @param sql
	 * @param fileName
	 * @throws Exception
	 */
	public static void exportDataFromDatabase(String sql, String fileName) throws Exception {
		try {

			DBConnection dbConnection = new DBConnection();
			ResultSet rs = dbConnection.select(sql);

			ResultSetMetaData md = rs.getMetaData();

			String filepath = System.getProperty("user.home") + "/Downloads/export-" + fileName + ".csv";
			try (FileWriter fw = new FileWriter(filepath)) {
				int columnCount = md.getColumnCount();

				for (int i = 1; i <= columnCount; i++) {
					String columnheader = md.getColumnName(i);
					fw.append(columnheader.toUpperCase());
					fw.append(",");
				}

				while (rs.next()) {
					fw.append("\r\n");
					for (int i = 1; i <= columnCount; i++) {
						fw.append(rs.getString(i));
						fw.append(",");
					}
				}
			}
			dbConnection.close();

		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
