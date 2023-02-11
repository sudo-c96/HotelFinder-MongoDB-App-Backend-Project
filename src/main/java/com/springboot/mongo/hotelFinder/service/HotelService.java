package com.springboot.mongo.hotelFinder.service;

import java.util.List;

import com.springboot.mongo.hotelFinder.entity.Hotel;

public interface HotelService {

	List<Hotel> getAllHotels();
	
	Hotel insertHotel(Hotel hotel);
	
	Hotel getHotelById(String id);
	
	Hotel updateHotel(Hotel hotel, String id);
	
	void deleteHotel(String id);
	
	List<Hotel> getHotelsByPricePerNight(Double maxPrice);
	
	List<Hotel> getHotelsByCity(String city);
	
	List<Hotel> getHotelsByState(String state);
	
	List<Hotel> getHotelsByRating(Float rating);
	
	List<Hotel> getHotelsByPricePerNightAndCity(Double maxPrice, String city);
	
	List<Hotel> getHotelsByPricePerNightAndRating(Double maxPrice, Float rating);
	
}
