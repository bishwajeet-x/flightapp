package com.fbs.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fbs.airline.dto.AirlineDto;
import com.fbs.airline.entity.Airline;
import com.fbs.airline.service.AirlineService;
import com.fbs.common.model.DefaultResponse;

//@RestController
//@RequestMapping("/airline")
public class AirlineRest {
	
	@Autowired private AirlineService service;
	
	//@GetMapping("/")
	public DefaultResponse<Airline> fetchAllAirlines() {
		System.out.println("Inside fetchAllAirlines");
		return new DefaultResponse<>(true, "Airlines fetched!", service.fetchAllAirlines());
	}
	
	//@GetMapping("/{id}")
	public DefaultResponse<Airline> fetchAirlinesById(@PathVariable("id") long airlineId) {
		System.out.println("Inside fetchAirlinesById "+airlineId);
		return new DefaultResponse<Airline>(true, "Airline successfully fetched", service.fetchAirlineById(airlineId).get());
	}
	
	//@GetMapping("/status/{id}")
	public DefaultResponse<Airline> fetchAirlinesByStatus(@PathVariable("id") int statusId) {
		System.out.println("Inside fetchAirlinesByStatus "+ statusId);
		return service.fetchAirlinesByStatus(statusId);
	}
	
	//@PostMapping("/")
	public DefaultResponse<Airline> createAirline(@RequestBody AirlineDto airline) {
		System.out.println("Inside createAirline "+airline.toString());
		return new DefaultResponse<>(true, "Airline created successully", service.createAirline(airline));
	}
	
	//@PostMapping("/edit")
	public DefaultResponse<Airline> editAirline(@RequestBody AirlineDto airline) {
		System.out.println("Inside editAirline "+airline.toString());
		return service.editAirline(airline);
	}
	
	//@PostMapping("/status/{airlineId}/{statusId}")
	public DefaultResponse<Airline> changeAirlineStatus(@PathVariable("airlineId") long airlineId, @PathVariable("statusId") int statusId) {
		System.out.println("Inside changeAirlineStatus "+airlineId+" status id "+statusId);
		return service.changeAirlineStatus(airlineId, statusId);
	}

}
