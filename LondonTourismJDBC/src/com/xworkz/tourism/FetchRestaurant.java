package com.xworkz.tourism;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRestaurant {

	private static void fetchName() {
		String jdbcURL = "jdbc:mysql://localhost:3306/london_tourism";
		String userName = "root";
		String password = "X-workZodc@123";
		String driverClass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String fetchQuery = "SELECT * FROM restaurants";
		String insertQuery = "INSERT into parks (park_id, park_name, location,size_in_acres,has_playground,"
				+ "has_picnic_area,has_cycling_routes,has_wildlife,park_opening_hours,website) "
				+ "VALUE (6,'Richmond Park', 'Richmond London', 2360.00,1,1,1,1,'Open 24 hours',"
				+ "'https://www.royalparks.org.uk/parks/richmond-park')";
		String updateQuery = "UPDATE parks SET size_in_acres = 57.0 WHERE park_id = 6";
		String deleteQuery = "DELETE from parks WHERE park_id = 3";

		System.out.println("Establishing connection...");
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connected to database");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(fetchQuery);
			stm.executeQuery(insertQuery);
			stm.executeQuery(updateQuery);
			stm.executeQuery(deleteQuery);
			while (rs.next()) {
				System.out.println(rs.getString("factory_name"));
				
			}
			System.out.println("Execute done");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void fetchEmpCount() {
		String jdbcURL = "jdbc:mysql://localhost:3306/london_tourism";
		String userName = "root";
		String password = "X-workZodc@123";
		String driverClass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String fetchQuery = "SELECT * FROM restaurants";
		String insertQuery = "INSERT into restaurants (restaurant_id, restaurant_name, cuisine_type) "
				+ "VALUE (6,'Richmond Park', 'Richmond London', 2360.00,1,1,1,1,'Open 24 hours',"
				+ "'https://www.royalparks.org.uk/parks/richmond-park')";

		System.out.println("Establishing connection...");
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connected to database");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(fetchQuery);
			while (rs.next()) {
				System.out.println(rs.getString(4));
			}
			System.out.println("Execute done");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		fetchEmpCount();
		fetchName();
	}

}
