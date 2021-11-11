package com.fbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbs.airline.dto.AirlineDto;
import com.fbs.airline.entity.Airline;
import com.fbs.airline.service.AirlineService;
import com.fbs.common.model.DefaultResponse;
import com.fbs.flight.dto.FlightScheduleDto;
import com.fbs.flight.dto.SearchFlightParams;
import com.fbs.flight.entity.FlightSchedule;
import com.fbs.flight.service.FlightScheduleService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired private FlightScheduleService flightService;
	@Autowired private AirlineService airlineService;
	
	/**
	* unauthenticated
	* getallairlines
	* getallflights
	**/

	@GetMapping("/airlines")
	public DefaultResponse<Airline> fetchAllAirlines() {
		System.out.println("Inside fetchAllAirlines");
		return new DefaultResponse<>(true, "Airlines fetched!", airlineService.fetchAllAirlines());
	}
	
	@GetMapping("/airlines/{id}")
	public DefaultResponse<Airline> fetchAirlinesById(@PathVariable("id") long airlineId) {
		System.out.println("Inside fetchAirlinesById "+airlineId);
		return new DefaultResponse<Airline>(true, "Airline successfully fetched", airlineService.fetchAirlineById(airlineId).get());
	}
	
	@GetMapping("/airlines/status/{id}")
	public DefaultResponse<Airline> fetchAirlinesByStatus(@PathVariable("id") int statusId) {
		System.out.println("Inside fetchAirlinesByStatus "+ statusId);
		return airlineService.fetchAirlinesByStatus(statusId);
	}
	
	@GetMapping("/flights")
	public DefaultResponse<FlightSchedule> fetchAllFlights() {
		System.out.println("Inside fetchAllFlights");
		return flightService.fetchAllFlights();
	}
	
	@GetMapping("/flight/{id}")
	public DefaultResponse<FlightSchedule> fetchFlightsById(@PathVariable("id") long flightId) {
		System.out.println("Inside fetchFlightsById "+flightId);
		return flightService.fetchFlightById(flightId);
	}
	
	@GetMapping("/flights/status/{id}")
	public DefaultResponse<FlightSchedule> fetchFlightsByStatus(@PathVariable("id") int statusId) {
		System.out.println("Inside fetchFlightsByStatus "+ statusId);
		return flightService.fetchFlightsByStatus(statusId);
	}
	
	@PostMapping("/flights/search")
	public DefaultResponse<FlightSchedule> searchFlights(@RequestBody SearchFlightParams params) {
		System.out.println("Inside fetchFlightsByStatus "+ params.toString());
		return flightService.searchFlights(params);
	}
	
	/**
	 * authenticated
	 * createairline
	 * createflight
	 * block/unblock flights**/
	
	@PostMapping("/airline")
	public DefaultResponse<Airline> createAirline(@RequestBody AirlineDto airline) {
		System.out.println("Inside createAirline "+airline.toString());
		return new DefaultResponse<Airline>(true, "Airline created successully", airlineService.createAirline(airline));
	}
	
	@PostMapping("/airline/edit")
	public DefaultResponse<Airline> editAirline(@RequestBody AirlineDto airline) {
		System.out.println("Inside editAirline "+airline.toString());
		return airlineService.editAirline(airline);
	}
	
	@PostMapping("/airline/status/{airlineId}/{statusId}")
	public DefaultResponse<Airline> changeAirlineStatus(@PathVariable("airlineId") long airlineId, @PathVariable("statusId") int statusId) {
		System.out.println("Inside changeAirlineStatus "+airlineId+" status id "+statusId);
		return airlineService.changeAirlineStatus(airlineId, statusId);
	}
	
	@PostMapping("/flight")
	public DefaultResponse<FlightSchedule> createFlight(@RequestBody FlightScheduleDto FlightSchedule) {
		System.out.println("Inside createAirline "+FlightSchedule.toString());
		return flightService.createFlight(FlightSchedule);
	}
	
	@PostMapping("/flight/edit")
	public DefaultResponse<FlightSchedule> editFlight(@RequestBody FlightScheduleDto FlightSchedule) {
		System.out.println("Inside editAirline "+FlightSchedule.toString());
		return flightService.editFlight(FlightSchedule);
	}
	
	@PostMapping("/flight/status/{flightId}/{statusId}")
	public DefaultResponse<FlightSchedule> changeFlightStatus(@PathVariable("flightId") long flightId, @PathVariable("statusId") int statusId) {
		System.out.println("Inside changeAirlineStatus "+flightId+" status id "+statusId);
		return flightService.changeFlightStatus(flightId, statusId);
	}

}
