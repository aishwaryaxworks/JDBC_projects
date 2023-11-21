package com.xworkz.jdbcmovie.repo;

import java.util.List;

import com.xworkz.jdbcmovie.dto.MovieDTO;

public interface MovieRepo {
	public int save(MovieDTO movieDto);
	
	public void save(List<MovieDTO> movieDTO);

}
