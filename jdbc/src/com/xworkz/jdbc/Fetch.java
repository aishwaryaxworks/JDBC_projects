package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {

	public static void main(String[] args) {

		fetchByName();
		
		fetchAllGames();

	}

	public static void fetchAllGames() {
		String jdbcURL = "jdbc:mysql://localhost:3306/games";
		String userName = "root";
		String password = "X-workZodc@123";
		String driverClass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String fetchQuery = "SELECT * FROM game_info";
		
		System.out.println("Establishing connection...");
		try {
			Connection conn = DriverManager.getConnection(jdbcURL,userName,password);
			System.out.println("Connected to database");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(fetchQuery);
			while(rs.next()) {
				System.out.println(rs.getString("game_title"));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}
			System.out.println("Execute done");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	private static void fetchByName() {
		String jdbcURL = "jdbc:mysql://localhost:3306/games";
		String userName = "root";
		String password = "X-workZodc@123";
		String driverClass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String fetchQuery = "SELECT * FROM game_info";
		
		System.out.println("Establishing connection...");
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(jdbcURL,userName,password);
			System.out.println("Connected to database");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(fetchQuery);
			while(rs.next()) {
				System.out.println(rs.getString("game_title"));
			}
			System.out.println("Execute done");
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
			
		}
	}
	
}
