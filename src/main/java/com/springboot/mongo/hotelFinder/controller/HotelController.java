package com.springboot.mongo.hotelFinder.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongo.hotelFinder.entity.Hotel;
import com.springboot.mongo.hotelFinder.service.HotelService;


@RestController
@RequestMapping("api/v1/hotels")
public class HotelController {
	
	private HotelService hotelService;
	
	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	//Build Get All Hotels REST API
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
	
	//Build Insert Hotel REST API
	@PostMapping
	public ResponseEntity<Hotel> insertHotel(@RequestBody Hotel hotel){
		Hotel insertedHotel = hotelService.insertHotel(hotel);
		return new ResponseEntity<>(insertedHotel, HttpStatus.CREATED);
	}
	
	//Get Hotel by Id REST Api
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(hotelService.getHotelById(id));
	}
	
	//Build Update Hotel REST API
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable(name = "id") String id){
		Hotel updatedHotel = hotelService.updateHotel(hotel, id);
		return new ResponseEntity<>(updatedHotel,HttpStatus.OK);
	}
		
	//Build Delete Hotel REST API
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable(name = "id") String id){
		hotelService.deleteHotel(id);
		return ResponseEntity.ok("Hotel removed successfully!");
	}
	
	//Build Get All Hotels less than provided price REST API
	@GetMapping("/price/{maxPrice}")
	public ResponseEntity<List<Hotel>> getHotelsByPricePerNight(@PathVariable(name = "maxPrice") Double maxPrice){
		return ResponseEntity.ok(hotelService.getHotelsByPricePerNight(maxPrice));
	}
	
	//Build Get All Hotels in the provided City REST API
	@GetMapping("/address/city/{city}")
	public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable(name = "city") String city){
		return ResponseEntity.ok(hotelService.getHotelsByCity(city));
	}
	
	//Build Get All Hotels in the provided State REST API
	@GetMapping("/address/state/{state}")
	public ResponseEntity<List<Hotel>> getHotelsByState(@PathVariable(name = "state") String state){
		return ResponseEntity.ok(hotelService.getHotelsByState(state));
	}
	
	//Build Get All Hotels more than provided Rating REST API
	@GetMapping("/reviews/{rating}")
	public ResponseEntity<List<Hotel>> getHotelsByRating(@PathVariable(name = "rating") Float rating){
		return ResponseEntity.ok(hotelService.getHotelsByRating(rating));
	}
	
	//Build Get All Hotels less than provided price and  provided city REST API
	@GetMapping("/recommendations/{maxPrice}/city/{city}")
	public ResponseEntity<List<Hotel>> getHotelsByPricePerNightAndCity(@PathVariable(name = "maxPrice") Double maxPrice,
			@PathVariable(name = "city") String city){
		return ResponseEntity.ok(hotelService.getHotelsByPricePerNightAndCity(maxPrice, city));
	}

	//Build Get All Hotels less than provided price and more than provided Rating REST API
	@GetMapping("/recommendations/{maxPrice}/rating/{rating}")
	public ResponseEntity<List<Hotel>> getHotelsByPricePerNightAndRating(@PathVariable(name = "maxPrice") Double maxPrice,
			@PathVariable(name = "rating") Float rating){
		return ResponseEntity.ok(hotelService.getHotelsByPricePerNightAndRating(maxPrice, rating));
	}
	
}
