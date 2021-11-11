package com.fbs.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fbs.common.model.DefaultResponse;
import com.fbs.ticket.dto.FlightDto;
import com.fbs.ticket.dto.SearchFlightParams;
import com.fbs.ticket.dto.TicketDto;
import com.fbs.ticket.dto.TicketHistoryParam;
import com.fbs.ticket.dto.TicketResponseDto;
import com.fbs.ticket.entity.Passenger;
import com.fbs.ticket.entity.Ticket;
import com.fbs.ticket.service.TicketService;

@RestController
@RequestMapping("/")
public class ApiController {
	
	@Autowired private TicketService ticketService;
	
	@PostMapping("/search/flight")
	public DefaultResponse searchFlights(@RequestBody SearchFlightParams params) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<DefaultResponse> flights = restTemplate.exchange("http://vishwajeet:8080/flight/api/flights/search", 
				HttpMethod.POST, 
				new HttpEntity<SearchFlightParams>(params), 
				DefaultResponse.class);
		return flights.getBody();
	}
	
	@PostMapping("/ticket/book")
	public DefaultResponse bookTicket(@RequestBody TicketDto bookingReq) {
		return ticketService.bookTicket(bookingReq, getFlightData(bookingReq.getFlightId()));
	}

	@GetMapping("/search/ticket/{pnr}")
	public DefaultResponse searchTicket(@PathVariable("pnr") String pnr) {
		TicketResponseDto response = new TicketResponseDto();
		Ticket ticket = ticketService.searchTicket(pnr);
		response.setTicket(ticket);
		response.setFlight(getFlightData(ticket.getFlightId()));
		response.setPassengers(fetchPassengers(ticket.getTicketId()));
		return new DefaultResponse(true, "Ticket fetched!", response);
	}
	
	@PostMapping("/ticket/history")
	public DefaultResponse getTicketHistory(@RequestBody TicketHistoryParam param) {
		return ticketService.getTicketHistory(param);
	}
	
	@GetMapping("/cancel/ticket/{pnr}")
	public DefaultResponse cancelTicket(@PathVariable("pnr") String pnr) {
		return ticketService.cancelTicket(pnr);
	}
	
	public List<Passenger> fetchPassengers(long ticketId) {
		return ticketService.fetchPassengers(ticketId);
	}
	
	public FlightDto getFlightData(long flightId) {
		return ticketService.getFlightData(flightId);
	}
	
}