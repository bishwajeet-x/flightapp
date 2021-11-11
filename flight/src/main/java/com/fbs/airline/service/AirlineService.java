package com.fbs.airline.service;

import java.util.List;
import java.util.Optional;

import com.fbs.airline.dto.AirlineDto;
import com.fbs.airline.entity.Airline;
import com.fbs.common.model.DefaultResponse;

public interface AirlineService {
	
	public List<Airline> fetchAllAirlines();
	public DefaultResponse<Airline> fetchAirlinesByStatus(int status);
	public Optional<Airline> fetchAirlineById(long airlineId);
	public DefaultResponse<Airline> changeAirlineStatus(long airlineId, int status);
	public Airline createAirline(AirlineDto airline);
	public DefaultResponse<Airline> editAirline(AirlineDto airline);

}
