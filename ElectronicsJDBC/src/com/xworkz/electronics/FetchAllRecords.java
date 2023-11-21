package com.xworkz.electronics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchAllRecords {

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
		ResultSet rs = null;
		String query1 = "SELECT * FROM electronic";

		System.out.println();
		System.out.println("Establishing Connection...");

		try {
			conn = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connected to database");
			pstm = conn.prepareStatement(query1);
			rs = pstm.executeQuery(); // only DQL

			System.out.println("--------------------------------");
			while (rs.next()) {
				System.out.println("Column 1 : " + rs.getString(1));
				System.out.println("Column 2 : " + rs.getString(2));
				System.out.println("--------------------------------");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {

				try {
					conn.close();
					System.out.println("Connection closed");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (pstm != null) {
				try {
					pstm.close();
					System.out.println("Statement closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					pstm.close();
					System.out.println("Result set closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
