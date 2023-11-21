package com.xworkz.jdbcmovie.service;

import com.xworkz.jdbcmovie.dto.MovieDTO;
import com.xworkz.jdbcmovie.repo.MovieRepo;
import com.xworkz.jdbcmovie.repo.MovieRepoImpl;

public class MovieServiceImpl implements MovieService{
	@Override
	public String validateAndSave(MovieDTO movieDto) {
		System.out.println("validateAndSave in Movie Service Impl");
		
		if(movieDto != null) {
			MovieRepo repo = new MovieRepoImpl();
			int saved = repo.save(movieDto);
			if(saved!=0) {
				return "Movie is saved";
			}
		}
		return "Movie is not saved";
	}
}
