package com.trantor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataIsInCustomerDetailsTable {
	public int updateRecord(CustomerDetails emp){
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String sql ="update customer_details set  firstname = ?, lastname = ?, street = ?, city = ?, state = ?, zipcode = ? where cid = ? ";
		int update = 0;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##BMS","abcd");
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(7, emp.getCid() );
			prepareStatement.setString(1, emp.getFirstName());
			prepareStatement.setString(2, emp.getLastName());
			prepareStatement.setString(3, emp.getStreet());
			prepareStatement.setString(4, emp.getCity());
			prepareStatement.setString(5, emp.getState());
			prepareStatement.setInt(6, emp.getZipCode());
			
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
