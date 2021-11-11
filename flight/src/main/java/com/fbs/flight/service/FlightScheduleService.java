package com.fbs.flight.service;

import com.fbs.common.model.DefaultResponse;
import com.fbs.flight.dto.FlightScheduleDto;
import com.fbs.flight.dto.SearchFlightParams;
import com.fbs.flight.entity.FlightSchedule;

public interface FlightScheduleService {

	public DefaultResponse<FlightSchedule> fetchAllFlights();
	public DefaultResponse<FlightSchedule> fetchFlightsByStatus(int status);
	public DefaultResponse<FlightSchedule> fetchFlightById(long flightId);
	public DefaultResponse<FlightSchedule> changeFlightStatus(long airlineId, int status);
	public DefaultResponse<FlightSchedule> createFlight(FlightScheduleDto flightSchedule);
	public DefaultResponse<FlightSchedule> editFlight(FlightScheduleDto flight);
	public DefaultResponse<FlightSchedule> searchFlights(SearchFlightParams params);
}
