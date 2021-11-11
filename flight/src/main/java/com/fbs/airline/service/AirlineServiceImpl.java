package com.fbs.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbs.airline.dto.AirlineDto;
import com.fbs.airline.entity.Airline;
import com.fbs.airline.repo.AirlineRepo;
import com.fbs.airline.repo.AirlineStatusRepo;
import com.fbs.common.exception.NotFoundException;
import com.fbs.common.model.DefaultResponse;

@Service
public class AirlineServiceImpl implements AirlineService {
	
	@Autowired private AirlineRepo airlineRepo;
	@Autowired private AirlineStatusRepo statusRepo;

	@Override
	public List<Airline> fetchAllAirlines() {
		return airlineRepo.findAll();
	}

	@Override
	public DefaultResponse<Airline> fetchAirlinesByStatus(int status) {
		Optional<List<Airline>> airlines = airlineRepo.findByAirlineStatusId(status);
		if(airlines.isEmpty()) {
			throw new NotFoundException("No airlines with status "+status+" was found in the DB.");
		}
		return new DefaultResponse<Airline>(true, "Airlines successfully fetched", airlines.get());
	}

	@Override
	public Optional<Airline> fetchAirlineById(long airlineId) {
		Optional<Airline> airline = airlineRepo.findByAirlineId(airlineId);
		if(airline.isEmpty()) {
			throw new NotFoundException("Airline id "+airlineId+" was not found in the DB");
		}
		return airline;
	}

	@Override
	public DefaultResponse<Airline> changeAirlineStatus(long airlineId, int status) {
		Optional<Airline> existing = fetchAirlineById(airlineId);
		if(existing.isEmpty()) {
			throw new NotFoundException("Airline id "+airlineId+" was not found in the DB");
		}
		Airline airline = (Airline) existing.get();
		airline.setAirlineStatus(statusRepo.findById(status).get());
		return persistAirline(airline, "Airline status changed to "+status);
	}

	@Override
	public Airline createAirline(AirlineDto airline) {
		Airline newAirline = new Airline();
		newAirline.setAirlineName(airline.getAirlineName());
		newAirline.setAirlineStatus(statusRepo.findById(101).get());
		return airlineRepo.save(newAirline);
	}

	@Override
	public DefaultResponse<Airline> editAirline(AirlineDto airline) {
		Optional<Airline> existing = fetchAirlineById(airline.getAirlineId());
		if(existing.isEmpty()) {
			throw new NotFoundException("Airline id "+airline.getAirlineId()+" was not found in the DB");
		}
		Airline response = (Airline) existing.get();
		response.setAirlineName(airline.getAirlineName());
		response.setAirlineStatus(statusRepo.findById(response.getAirlineStatus().getId()).get());
		return persistAirline(response, "Airline edited successfully");
	}
	
	public DefaultResponse<Airline> persistAirline(Airline existing, String msg) {
		Airline response = null;
		try {
			response = airlineRepo.save(existing);
			return new DefaultResponse<>(true, msg, response);
		} catch(Exception e) {
			return new DefaultResponse<>(false, e.getMessage(), response);
		}
	}

}
