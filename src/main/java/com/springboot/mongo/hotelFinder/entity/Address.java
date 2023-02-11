package com.springboot.mongo.hotelFinder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String postalCode;
	
	private String country;

}
