package com.springboot.mongo.hotelFinder.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Hotels")
public class Hotel {
	
	@Id
	private String id;
	
	private String name;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	private Double pricePerNight;
	
	private Address address;
	
	private List<Review> reviews;
	
	protected Hotel() {
		this.reviews = new ArrayList<>();
	}

	public Hotel(String name, Double pricePerNight, Address address, List<Review> reviews) {
		this.name = name;
		this.pricePerNight = pricePerNight;
		this.address = address;
		this.reviews = reviews;
	}
	
}
