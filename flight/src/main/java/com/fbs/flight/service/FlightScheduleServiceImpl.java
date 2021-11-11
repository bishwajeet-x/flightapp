package com.fbs.flight.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbs.airline.repo.AirlineRepo;
import com.fbs.airline.repo.AirlineStatusRepo;
import com.fbs.common.exception.IllegalInputException;
import com.fbs.common.exception.NotFoundException;
import com.fbs.common.model.DefaultResponse;
import com.fbs.flight.dto.FlightScheduleDto;
import com.fbs.flight.dto.SearchFlightParams;
import com.fbs.flight.entity.FlightSchedule;
import com.fbs.flight.entity.FlightStatus;
import com.fbs.flight.repo.FlightScheduleRepo;
import com.fbs.flight.repo.FlightStatusRepo;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {
	
	@Autowired private FlightScheduleRepo flightRepo;
	@Autowired private FlightStatusRepo statusRepo;
	@Autowired private AirlineRepo airlineRepo;
	@Autowired private AirlineStatusRepo airlineStatusRepo;
	
	SimpleDateFormat parse = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public DefaultResponse<FlightSchedule> fetchAllFlights() {
		List<FlightSchedule> flights = flightRepo.findAll();
		return new DefaultResponse<>(true, "Flights fetched successfully.", flights);
	}

	@Override
	public DefaultResponse<FlightSchedule> fetchFlightsByStatus(int status) {
		Optional<List<FlightSchedule>> flights = flightRepo.findByStatus(status);
		return new DefaultResponse<>(true, "Flights fetched successfully.", flights);
	}

	@Override
	public DefaultResponse<FlightSchedule> fetchFlightById(long flightId) {
		Optional<FlightSchedule> flight = flightRepo.findByFlightId(flightId);
		if(flight.isEmpty()) {
			throw new NotFoundException("Flight id "+flightId+" was not found in the DB.");
		}
		return new DefaultResponse<>(true, "Flights fetched successfully.", flight);
	}

	@Override
	public DefaultResponse<FlightSchedule> changeFlightStatus(long flightId, int status) {
		Optional<FlightSchedule> existing = flightRepo.findByFlightId(flightId);
		if(existing.isEmpty()) {
			throw new NotFoundException("Flight id "+flightId+" was not found in the DB.");
		}
		
		Optional<FlightStatus> fStatus = statusRepo.findById(status);
		if(fStatus.isEmpty()) {
			throw new IllegalInputException("Invalid status code "+status);
		}
		
		existing.get().setStatus(statusRepo.findById(status).get());
		return persistFlight(existing.get(), "Flight status changed to "+status);
	}

	@Override
	public DefaultResponse<FlightSchedule> createFlight(FlightScheduleDto flight) {
		FlightSchedule newFlight = new FlightSchedule();
		newFlight.setAirline(airlineRepo.findByAirlineId(flight.getAirlineId()).get());
		newFlight.setSource(flight.getSource());
		newFlight.setDestination(flight.getDestination());
		newFlight.setPrice(flight.getPrice());
		try {
			newFlight.setScheduledFor(parse.parse(flight.getScheduledFor()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		newFlight.setScheduledTimeHour(flight.getScheduledTimeHour());
		newFlight.setScheduledTimeMinutes(flight.getScheduledTimeMinutes());
		newFlight.setPrice(flight.getPrice());
		newFlight.setStatus(statusRepo.findById(flight.getStatusId()).get());
		return persistFlight(newFlight, "Flight created successfully");
	}

	@Override
	public DefaultResponse<FlightSchedule> editFlight(FlightScheduleDto flight) {
		Optional<FlightSchedule> existing = flightRepo.findByFlightId(flight.getFlightId());
		if(existing.isEmpty()) {
			throw new NotFoundException("Flight id "+flight.getFlightId()+" was not found in the DB.");
		}
		existing.get().setAirline(airlineRepo.findByAirlineId(flight.getAirlineId()).get());
		existing.get().setSource(flight.getSource());
		existing.get().setDestination(flight.getDestination());
		existing.get().setPrice(flight.getPrice());
		try {
			existing.get().setScheduledFor(parse.parse(flight.getScheduledFor()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		existing.get().setScheduledTimeHour(flight.getScheduledTimeHour());
		existing.get().setScheduledTimeMinutes(flight.getScheduledTimeMinutes());
		existing.get().setPrice(flight.getPrice());
		existing.get().setStatus(statusRepo.findById(flight.getStatusId()).get());
		return persistFlight(existing.get(), "Flight schedule edited successfully.");
	}

	public DefaultResponse<FlightSchedule> persistFlight(FlightSchedule existing, String msg) {
		FlightSchedule response = null;
		try {
			response = flightRepo.save(existing);
			return new DefaultResponse<FlightSchedule>(true, msg, response);
		} catch(Exception e) {
			return new DefaultResponse<FlightSchedule>(false, e.getMessage(), response);
		}
	}

	@Override
	public DefaultResponse<FlightSchedule> searchFlights(SearchFlightParams params) {
		Optional<List<FlightSchedule>> searchResults = null;
		try {
			searchResults = flightRepo.findByScheduledForAndSourceIgnoreCaseAndDestinationIgnoreCaseAndAirlineAirlineStatusId(
					parse.parse(params.getDate()),
					params.getSource(), params.getDestination(), 101);
			return new DefaultResponse<FlightSchedule>(true, "Search results successfully failed", searchResults.get());
		} catch (ParseException e) {
			return new DefaultResponse<FlightSchedule>(false, e.getMessage(), searchResults);
		}
	}
}
