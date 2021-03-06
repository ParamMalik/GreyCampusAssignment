package com.trantor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FetchingDataFromCustomerDetails {
	public ArrayList<CustomerDetails> fetchRecords() {
		Connection connection = null;
		Statement statement = null;
		ResultSet query = null;
		ArrayList<CustomerDetails> empList = null;

		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abcd");
			statement = connection.createStatement();
			query = statement.executeQuery("select * from customer_details");
			empList = new ArrayList<CustomerDetails>();
			while (query.next()) {
				CustomerDetails customer = new CustomerDetails();
				customer.setCid(query.getInt("cid"));
				customer.setFirstName(query.getString("firstname"));
				customer.setLastName(query.getString("lastname"));
				customer.setCity(query.getString("city"));
				customer.setStreet(query.getString("state"));
				customer.setZipCode(query.getInt("zipcode"));
				customer.setProductName(query.getString("product_name"));
				customer.setCreatedOn(query.getString("created_on"));
				customer.setCreatedBy(query.getString("created_by"));
				customer.setUpdateOn(query.getString("update_on"));
				customer.setUpdatedBy(query.getString("updated_by"));
				empList.add(customer);

			}
			System.out.println("data fetched successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				query.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return empList;

	}

}
