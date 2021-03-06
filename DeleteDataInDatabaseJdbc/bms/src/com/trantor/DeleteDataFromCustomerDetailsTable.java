package com.trantor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDataFromCustomerDetailsTable {
	public int deleteRecord(CustomerDetails emp) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String sql ="delete from customer_details where cid = ? ";
		int update = 0;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##BMS","abcd");
			
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, emp.getCid());
			update = prepareStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
