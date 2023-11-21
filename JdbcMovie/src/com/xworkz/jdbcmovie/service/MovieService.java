package com.xworkz.jdbcmovie.service;

import com.xworkz.jdbcmovie.dto.MovieDTO;

public interface MovieService {
	public String validateAndSave(MovieDTO movieDto);
	
}
