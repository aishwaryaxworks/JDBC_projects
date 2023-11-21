package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultipleRecords {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/games";
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
		
		String insertQuery = "INSERT into games_info (<---All column names--->) VALUES (?,?,?,?,?);";
		try {
			conn = DriverManager.getConnection(jdbcURL,userName,password);
			System.out.println("Connection established successfully...");
			pstm = conn.prepareStatement(insertQuery);
			//row1
			pstm.setInt(1, 3);
			pstm.setString(2, "name");
			pstm.setString(3, "");
			pstm.setString(4, "");
			pstm.execute();
			
			//row2
			pstm.setInt(1, 3);
			pstm.setString(2, "name");
			pstm.setString(3, "");
			pstm.setString(4, "");
			pstm.execute();
			
			System.out.println("Queries executed succesfully...");
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
