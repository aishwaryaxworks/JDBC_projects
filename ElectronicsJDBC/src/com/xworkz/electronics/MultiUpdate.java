package com.xworkz.electronics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultiUpdate {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/electronics";
		String userName = "root";
		String password = "X-workZodc@123";
		String driverClass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement pstm = null;
		String query1 = "UPDATE electronic SET brand = ? WHERE ename = ?";
		
		System.out.println();
		System.out.println("Establishing Connection...");
		
		try {
			conn = DriverManager.getConnection(jdbcURL, userName,password);
			System.out.println("Connected to database");
			pstm = conn.prepareStatement(query1);
			
			//row 1
			pstm.setString(1, "HP");
			pstm.setString(2, "Laptop");
			
			//row2
			pstm.setString(1, "Apple");
			pstm.setString(2, "Phone");
			
			pstm.executeUpdate();
						
			System.out.println("Updated data...");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn != null) {

				try {
					conn.close();
					System.out.println("Connection closed");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			if(pstm != null) {
				try {
					pstm.close();
					System.out.println("Statement closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
