package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExecution {
	public static void main(String[] args) {
		//Syntax ---> main protocol : subprotocol:host:portnumber/database_name
		String jdbcURL = "jdbc:mysql://localhost:3306/factory";
		String userName = "root";          //root or admin
		String password = "X-workZodc@123";         // Xworkzodc@123
		String driverClass = "com.mysql.jdbc.Driver";     //Fully Qualified Class Name
		//String driverClass = "com.oracle.jdbc.OracleDriver";
		
		try {
			//Class loading / class loader
			//Load and register driver class
			Class.forName(driverClass);
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String query = "INSERT into banks (id, name, branch, state) VALUE (2, 'HDFC', 'BTM', 'Karnataka')";
		String updateQuery = "UPDATE banks SET branch = 'BTM Layout' WHERE name = 'SBI'";
		String deleteQuery = "DELETE FROM bank WHERE name = 'SBI'";
		
		
		System.out.println("Connecting to database...");
		try {
			//get connection
			Connection conn = DriverManager.getConnection(jdbcURL,userName,password);
			System.out.println("Connection successful");
			
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			System.out.println("Executed Insert");
			stmt.execute(updateQuery);
			System.out.println("Executed Update");
			stmt.execute(deleteQuery);
			//Insert - execute
			//Update - 
			
			//execute, executeUpdate, executeQuery
			
			// Statement ---> PreparedStatement
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
