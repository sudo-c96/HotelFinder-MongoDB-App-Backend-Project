package com.springboot.mongo.hotelFinder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	
	private String username;
	
	private Float rating;
	
	private Boolean approved;

}
