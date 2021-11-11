package com.flightapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightapp.dto.FlightScheduleDto;


public class ApiController {

	@PostMapping("/flight")
	public DefaultResponse createSchedule(@RequestBody FlightScheduleDto flight, HttpServletRequest request) {
		System.out.println("Creating flight");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<DefaultResponse> resp = null;
		try {
			restTemplate.exchange("http://vishwajeet:8080/admin/api/flight",
					HttpMethod.POST,
					new HttpEntity<FlightScheduleDto>(flight),
					DefaultResponse.class);
		} catch(Exception e) {
			System.out.println("Something went wrong here");
			e.printStackTrace();
		}
		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody());
		
		return resp.getBody();
	}
}
