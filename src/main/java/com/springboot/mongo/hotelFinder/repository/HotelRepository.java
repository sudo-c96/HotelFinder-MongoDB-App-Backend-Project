package com.springboot.mongo.hotelFinder.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.mongo.hotelFinder.entity.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
	
	Hotel getById(String id);
	
	List<Hotel> findByPricePerNightLessThan(Double maxPrice);
	
	@Query(value = "{'address.city':?0}")
	List<Hotel> findByCity(String city); 
	
	@Query(value = "{'address.state':?0}")
	List<Hotel> findByState(String state); 
	
	@Query(value = "{'reviews.rating':{$gte:?0}}")
	List<Hotel> findByRating(Float rating);
	
	List<Hotel> findByPricePerNightLessThanAndAddressCity(Double maxPrice, String city);

	List<Hotel> findByPricePerNightLessThanAndReviewsRatingGreaterThanEqual(Double maxPrice, Float rating);
	
}
