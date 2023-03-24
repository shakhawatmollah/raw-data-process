package com.shakhawat.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.shakhawat.model.Customer;

public class DBConnection {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/hello";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	Connection connection;

	public DBConnection() {
		connect();
	}

	public void connect() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("ERROR while closing connections!");
			System.out.println(e.toString());
		}
	}
	
	public ResultSet select(String query) {
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(query);
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR while executing select query!");
			System.out.println(e.toString());
			return null;
		}
	}
	
	public void createBulk(List<Customer> list, String tableName) {
		try {
			String SQL = "INSERT INTO "+tableName+" (FIRST_NAME,LAST_NAME,CITY,STATE_REGION,ZIP_CODE,PHONE_NUMBER,EMAIL,IP) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			connection.setAutoCommit(false);
			for (Iterator<Customer> iterator = list.iterator(); iterator.hasNext();) {
				Customer cust = (Customer) iterator.next();
				preparedStatement.setString(1, cust.getFirstName());
				preparedStatement.setString(2, cust.getLastName());
				preparedStatement.setString(3, cust.getCity());
				preparedStatement.setString(4, cust.getStateRegion());
				preparedStatement.setString(5, cust.getZipCode());
				preparedStatement.setString(6, cust.getPhoneNumber());
				preparedStatement.setString(7, cust.getEmail());
				preparedStatement.setString(8, cust.getIp());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("ERROR while executing select query!");
			System.out.println(e.toString());
		}
	}

}
