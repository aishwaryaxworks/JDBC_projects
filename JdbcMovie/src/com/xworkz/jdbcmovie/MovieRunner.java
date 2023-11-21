package com.xworkz.jdbcmovie;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.xworkz.jdbcmovie.dto.MovieDTO;
import com.xworkz.jdbcmovie.service.MovieService;
import com.xworkz.jdbcmovie.service.MovieServiceImpl;

public class MovieRunner {
	public static void main(String[] args) {
		MovieDTO dto1 = new MovieDTO(1, "Jailer", Date.valueOf(LocalDate.of(2020, 8, 15)), "Tamil");
		MovieDTO dto2 = new MovieDTO(2, "Pathan", Date.valueOf(LocalDate.of(2021, 5, 17)), "Hindi");
		MovieDTO dto3 = new MovieDTO(3, "KGF 2", Date.valueOf(LocalDate.of(2017, 3, 23)), "Kannada");
		MovieDTO dto4 = new MovieDTO(4, "My Lovely Liar", Date.valueOf(LocalDate.of(2005, 9, 3)), "Korean");
		MovieDTO dto5 = new MovieDTO(5, "Twinkling WaterMelon", Date.valueOf(LocalDate.of(2015, 12, 9)), "Korean");

		MovieService service = new MovieServiceImpl();
		service.validateAndSave(dto1);
		service.validateAndSave(dto2);
		service.validateAndSave(dto3);
		service.validateAndSave(dto4);
		service.validateAndSave(dto5);

		Collection<MovieDTO> coll = new ArrayList<MovieDTO>();
		coll.add(dto1);
		coll.add(dto2);
		coll.add(dto3);
		coll.add(dto4);
		coll.add(dto5);
		
		
	}
}
