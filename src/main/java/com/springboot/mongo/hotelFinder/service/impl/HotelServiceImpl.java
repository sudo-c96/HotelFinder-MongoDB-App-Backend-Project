package com.springboot.mongo.hotelFinder.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.mongo.hotelFinder.exception.ResourceNotFoundException;
import com.springboot.mongo.hotelFinder.entity.Hotel;
import com.springboot.mongo.hotelFinder.repository.HotelRepository;
import com.springboot.mongo.hotelFinder.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	private HotelRepository hotelRepository;
	
	public HotelServiceImpl(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = hotelRepository.findAll();
		return hotels;
	}

	@Override
	public Hotel insertHotel(Hotel hotel) {
		Hotel insertedHotel = hotelRepository.insert(hotel);
		return insertedHotel;
	}
	
	@Override
	public Hotel getHotelById(String id) {
		Hotel hotel = hotelRepository.getById(id);
		
		if(hotel == null) {
			throw new ResourceNotFoundException("Hotel", "id", id);
		}
		
		return hotel;
	}

	@Override
	public Hotel updateHotel(Hotel hotel, String id) {
		Hotel newHotel = hotelRepository.getById(id);
		
		if(newHotel == null) {
			throw new ResourceNotFoundException("Hotel", "id", id);
		}
				
		newHotel.setName(hotel.getName());
		newHotel.setPricePerNight(hotel.getPricePerNight());
		newHotel.setAddress(hotel.getAddress());
		newHotel.setReviews(hotel.getReviews());
		
		Hotel updatedHotel = hotelRepository.save(newHotel);
		return updatedHotel;
	}

	@Override
	public void deleteHotel(String id) {
		Hotel hotel = hotelRepository.getById(id);
		
		if(hotel == null) {
			throw new ResourceNotFoundException("Hotel", "id", id);
		}
		
		hotelRepository.delete(hotel);
	}

	@Override
	public List<Hotel> getHotelsByPricePerNight(Double maxPrice) {
		List<Hotel> hotels = hotelRepository.findByPricePerNightLessThan(maxPrice);
		
		if(hotels.size() == 0) {
			throw new ResourceNotFoundException("Hotels", "pricePerNight less than", maxPrice.toString());
		}
		
		return hotels;
	}

	@Override
	public List<Hotel> getHotelsByCity(String city) {
		List<Hotel> hotels = hotelRepository.findByCity(city);
		
		if(hotels.size() == 0) {
			throw new ResourceNotFoundException("Hotels", "city", city);
		}
		
		return hotels;
	}

	@Override
	public List<Hotel> getHotelsByState(String state) {
		List<Hotel> hotels = hotelRepository.findByState(state);
		
		if(hotels.size() == 0) {
			throw new ResourceNotFoundException("Hotels", "state", state);
		}
		
		return hotels;
	}

	@Override
	public List<Hotel> getHotelsByRating(Float rating) {
		List<Hotel> hotels = hotelRepository.findByRating(rating);
		
		if(hotels.size() == 0) {
			throw new ResourceNotFoundException("Hotels", "rating more than", rating.toString());
		}
		
		return hotels;
	}
	
	@Override
	public List<Hotel> getHotelsByPricePerNightAndCity(Double maxPrice, String city) {
		List<Hotel> hotels = hotelRepository.findByPricePerNightLessThanAndAddressCity(maxPrice, city);
		
		if(hotels.size() == 0) {
			throw new ResourceNotFoundException("Hotels", "pricePerNight less than : "+maxPrice.toString()+" and city", city.toString());
		}
		
		return hotels;
	}

	@Override
	public List<Hotel> getHotelsByPricePerNightAndRating(Double maxPrice, Float rating) {
		List<Hotel> hotels = hotelRepository.findByPricePerNightLessThanAndReviewsRatingGreaterThanEqual(maxPrice, rating);
		
		if(hotels.size() == 0) {
			throw new ResourceNotFoundException("Hotels", "pricePerNight less than : "+maxPrice.toString()+" and rating more than", rating.toString());
		}
		
		return hotels;
	}

}
