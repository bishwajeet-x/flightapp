package com.fbs.api.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fbs.api.dto.AirlineDto;
import com.fbs.api.dto.FlightScheduleDto;
import com.fbs.common.model.DefaultResponse;

@RestController
@RequestMapping("/")
public class ApiController {
	
	@PostMapping("/airline")
	public DefaultResponse createAirline(@RequestBody AirlineDto req) {
		return consumeApi("http://vishwajeet:8080/flight/api/airline", 
				HttpMethod.POST,
				new HttpEntity<AirlineDto>(req));
	}
	
	@PostMapping("/flight")
	public DefaultResponse createFlight(@RequestBody FlightScheduleDto req) {
		return consumeApi("http://vishwajeet:8080/flight/api/flight", 
				HttpMethod.POST, 
				new HttpEntity<FlightScheduleDto>(req));
	}
	
	@PostMapping("/airline/block/{airlineId}")
	public DefaultResponse createAirline(@PathVariable("airlineId") String airlineId) {
		return consumeApi("http://vishwajeet:8080/flight/api/airline/status/"+airlineId+"/102", 
				HttpMethod.POST,
				null);
	}
	
	public DefaultResponse consumeApi(String url, HttpMethod type, HttpEntity req) {
		System.out.println("inside admin micro");
		RestTemplate rt = new RestTemplate();
		ResponseEntity<DefaultResponse> saved = rt.exchange(url, type, req, DefaultResponse.class);
		
		System.out.println(saved.getBody());
		
		return saved.getBody();
	}
	
}
