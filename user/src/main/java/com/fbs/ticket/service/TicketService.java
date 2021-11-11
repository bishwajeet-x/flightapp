package com.fbs.ticket.service;

import java.util.List;

import com.fbs.common.model.DefaultResponse;
import com.fbs.ticket.dto.FlightDto;
import com.fbs.ticket.dto.TicketDto;
import com.fbs.ticket.dto.TicketHistoryParam;
import com.fbs.ticket.entity.Passenger;
import com.fbs.ticket.entity.Ticket;

public interface TicketService {

	public DefaultResponse cancelTicket(String pnr);
	public DefaultResponse bookTicket(TicketDto bookingReq, FlightDto flightDetails);
	public Ticket searchTicket(String pnr);
	public List<Passenger> fetchPassengers(long flightId);
	public FlightDto getFlightData(long flightId);
	public DefaultResponse getTicketHistory(TicketHistoryParam param);
}
