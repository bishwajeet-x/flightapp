package com.fbs.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fbs.common.model.DefaultResponse;
import com.fbs.flight.dto.FlightScheduleDto;
import com.fbs.flight.entity.FlightSchedule;
import com.fbs.flight.service.FlightScheduleService;

public class FlightScheduleRest {
	
	@Autowired private FlightScheduleService service;
	
	//@GetMapping("/")
	public DefaultResponse<FlightSchedule> fetchAllFlights() {
		System.out.println("Inside fetchAllFlights");
		return service.fetchAllFlights();
	}
	
	//@GetMapping("/{id}")
	public DefaultResponse<FlightSchedule> fetchFlightsById(@PathVariable("id") long flightId) {
		System.out.println("Inside fetchFlightsById "+flightId);
		return service.fetchFlightById(flightId);
	}
	
	//@GetMapping("/status/{id}")
	public DefaultResponse<FlightSchedule> fetchFlightsByStatus(@PathVariable("id") int statusId) {
		System.out.println("Inside fetchFlightsByStatus "+ statusId);
		return service.fetchFlightsByStatus(statusId);
	}
	
	//@PostMapping("/")
	public DefaultResponse<FlightSchedule> createFlight(@RequestBody FlightScheduleDto FlightSchedule) {
		System.out.println("Inside createAirline "+FlightSchedule.toString());
		return service.createFlight(FlightSchedule);
	}
	
	//@PostMapping("/edit")
	public DefaultResponse<FlightSchedule> editFlight(@RequestBody FlightScheduleDto FlightSchedule) {
		System.out.println("Inside editAirline "+FlightSchedule.toString());
		return service.editFlight(FlightSchedule);
	}
	
	//@PostMapping("/status/{flightId}/{statusId}")
	public DefaultResponse<FlightSchedule> changeFlightStatus(@PathVariable("flightId") long flightId, @PathVariable("statusId") int statusId) {
		System.out.println("Inside changeAirlineStatus "+flightId+" status id "+statusId);
		return service.changeFlightStatus(flightId, statusId);
	}


}
