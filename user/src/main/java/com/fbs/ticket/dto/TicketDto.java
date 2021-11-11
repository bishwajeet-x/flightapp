package com.fbs.ticket.dto;

import java.util.List;

import com.fbs.ticket.entity.Passenger;

public class TicketDto {

	private long ticketId;
	private String name;
	private String email;
	private String meal;
	private long flightId;
	private String pnr;
	private List<Passenger> passengers;
	
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
	@Override
	public String toString() {
		return "TicketDto [ticketId=" + ticketId + ", name=" + name + ", email=" + email + ", meal=" + meal
				+ ", flightId=" + flightId + ", pnr=" + pnr + ", passengers=" + passengers + "]";
	}
	
}
