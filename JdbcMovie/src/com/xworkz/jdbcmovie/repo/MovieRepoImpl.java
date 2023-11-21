package com.xworkz.jdbcmovie.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.xworkz.jdbcmovie.dto.MovieDTO;

public class MovieRepoImpl implements MovieRepo{
	@Override
	public int save(MovieDTO movieDto) {
		
		String driverClass = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driverClass);
			System.out.println("Class is loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/movie";
		String userName = "root";
		String password = "X-workZodc@123";
//		String insertQuery = "INSERT into movie_info(id, mname, mreleaseDate, mLanguage) VALUES (" +movieDto.getId()+ ","
//				+"'"+movieDto.getMovieName()+"'" +",'"+movieDto.getReleaseDate()+"',"+"'"+movieDto.getLanguage()+"')";
//		
		String insertMulQuery = "INSERT INTO movie_info (id, mname, mreleaseDate, mLanguage) VALUES (?,?,?,?)";
		
		Connection conn=null;
		Statement stmt = null;
		PreparedStatement pstm=null;
		
		int inserted = 0;
		try {
			//get connection to database server
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Connection to database successfull....!!!!");
			
			stmt = conn.createStatement();
//			boolean inserted = stmt.execute(insertQuery);
			
			pstm = conn.prepareStatement(insertMulQuery);
			pstm.setInt(1, movieDto.getId());
			pstm.setString(2, movieDto.getMovieName());
			pstm.setDate(3, movieDto.getReleaseDate());
			pstm.setString(4, movieDto.getLanguage());
			
			ResultSet rs = pstm.getResultSet();
			
			
			inserted = pstm.executeUpdate();
			
			System.out.println("Inserted Movie Data");
			
			return inserted;
			
			
		}catch(SQLException e){
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
			
			if(stmt != null) {
				try {
					stmt.close();
					System.out.println("Statement closed");
				} catch(Exception e3) {
					e3.printStackTrace();
				}
			}
			
			if(pstm != null) {
				try {
					pstm.close();
					System.out.println("Prepared Statement closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return inserted;
	}

	@Override
	public void save(List<MovieDTO> movieDTO) {
		for(MovieDTO movie : movieDTO) {
			pstm.setInt(1, movieDTO.getId());
		}
	}
}
