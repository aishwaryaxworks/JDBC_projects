package com.xworkz.electronics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultiElectronics {
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
		String query1 = "INSERT INTO electronic (id, ename, brand, price) VALUES (?,?,?,?)";
		
		System.out.println();
		System.out.println("Establishing Connection...");
		try {
			conn = DriverManager.getConnection(jdbcURL, userName,password);
			System.out.println("Connected to database");
			pstm = conn.prepareStatement(query1);
			
			//row1
			pstm.setInt(1, 1);
			pstm.setString(2, "Hair dryer");
			pstm.setString(3, "Philips");
			pstm.setInt(4, 5000);
			pstm.executeUpdate();
			
			//row2
			pstm.setInt(1, 2);
			pstm.setString(2, "Induction Stove");
			pstm.setString(3, "Prestige");
			pstm.setInt(4, 8000);
			pstm.executeUpdate();
			
			//row3
			pstm.setInt(1, 3);
			pstm.setString(2, "Phone Charger");
			pstm.setString(3, "Poco F3");
			pstm.setInt(4, 7000);
			pstm.executeUpdate();
			
			//row4
			pstm.setInt(1, 4);
			pstm.setString(2, "Air cooler");
			pstm.setString(3, "Philips");
			pstm.setInt(4, 15000);
			pstm.executeUpdate();
			
			//row5
			pstm.setInt(1, 5);
			pstm.setString(2, "Laptop");
			pstm.setString(3, "Asus");
			pstm.setInt(4, 60000);
			pstm.executeUpdate();
			
			System.out.println("Queries executed successfully...");
		} catch (SQLException e) {
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
