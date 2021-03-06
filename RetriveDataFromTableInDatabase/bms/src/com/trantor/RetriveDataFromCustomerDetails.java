package com.trantor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveDataFromCustomerDetails {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		String sql = "select * from customer_details";
		int count = 0;

		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##BMS", "abcd");
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				count ++;
				System.out.println("----- " + count + " Record" + " ------");
				System.out.println();
				System.out.println(resultSet.getInt("cid"));
				System.out.println(resultSet.getString("firstname"));
				System.out.println(resultSet.getString("lastname"));
				System.out.println(resultSet.getString("street"));
				System.out.println(resultSet.getString("city"));
				System.out.println(resultSet.getString("state"));
				System.out.println(resultSet.getInt("zipcode"));
				System.out.println(resultSet.getString("product_name"));
				System.out.println(resultSet.getString("created_on"));
				System.out.println(resultSet.getString("created_by"));
				System.out.println(resultSet.getString("update_on"));
				System.out.println(resultSet.getString("updated_by"));
				
				System.out.println();
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	}

}
