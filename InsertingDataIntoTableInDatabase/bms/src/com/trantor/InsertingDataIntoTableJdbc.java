package com.trantor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertingDataIntoTableJdbc {
	public int insertData(CustomersDetail emp) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String sql = "insert into customer_details values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int update = 0;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##BMS", "abcd");
			prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setInt(1, emp.getCid());
			prepareStatement.setString(2, emp.getFirstName());
			prepareStatement.setString(3, emp.getLastName());
			prepareStatement.setString(4, emp.getStreet());
			prepareStatement.setString(5, emp.getCity());
			prepareStatement.setString(6, emp.getState());
			prepareStatement.setInt(7, emp.getZipCode());
			prepareStatement.setString(8, emp.getProductName());
			prepareStatement.setDate(9, Date.valueOf(emp.getCreatedOn()));
			prepareStatement.setString(10, emp.getCreatedBy());
			prepareStatement.setDate(11, Date.valueOf(emp.getUpdateOn()));
			prepareStatement.setString(12, emp.getUpdatedBy());

			update = prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return update;

	}
}