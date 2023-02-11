package com.springboot.mongo.hotelFinder.payload;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.mongo.hotelFinder.entity.Address;
import com.springboot.mongo.hotelFinder.entity.Hotel;
import com.springboot.mongo.hotelFinder.entity.Review;
import com.springboot.mongo.hotelFinder.repository.HotelRepository;

@Component
public class DBSeeder implements CommandLineRunner {

	private HotelRepository hotelRepository;
	
	public DBSeeder(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Hotel jwMarriot = new Hotel(
				"JW Marriot",
				8500.00,
				new Address("ByPass Road","Kolkata","West Bengal","700689","India"),
				Arrays.asList(
						new Review("Ramesh",4.5f,false),
						new Review("Suresh",4.3f,true)
				)
		);
		
		Hotel lemonTree = new Hotel(
				"LemonTree",
				7400.00,
				new Address("MG Road","Kolkata","West Bengal","700450","India"),
				Arrays.asList(
						new Review("Sameer",4.8f,true)
				)
		);
		
		Hotel royalBengal = new Hotel(
				"ITC RoyalBengal",
				8800.00,
				new Address("Tangra Road","Kolkata","West Bengal","700890","India"),
				Arrays.asList(
						new Review("Dinesh",4.0f,true),
						new Review("Reena",3.5f,false),
						new Review("Priyanka",4.2f,false)
				)
		);
		
		Hotel maratha = new Hotel(
				"Maratha",
				7200.00,
				new Address("Maharana Pratap Lane","Lucknow","Uttar Pradesh","500642","India"),
				Arrays.asList()
		);
		
		Hotel ibis = new Hotel(
				"New Ibis",
				7600.00,
				new Address("Rajpath Road","Delhi","New Delhi","234900","India"),
				Arrays.asList(
						new Review("Soumya",3.8f,false),
						new Review("Ravi",4.0f,true)
				)
		);
		
		//Drop all hotels
		//this.hotelRepository.deleteAll();
		
		//Add new hotels
		//List<Hotel> hotels = Arrays.asList(jwMarriot,lemonTree,royalBengal,maratha,ibis);
		//this.hotelRepository.saveAll(hotels);
		
	}

}
