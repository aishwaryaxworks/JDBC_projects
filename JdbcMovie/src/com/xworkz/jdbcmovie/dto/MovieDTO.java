package com.xworkz.jdbcmovie.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

public class MovieDTO implements Serializable{
	private Integer id;
	private String movieName;
	private Date releaseDate;
	private String language;
	
}
