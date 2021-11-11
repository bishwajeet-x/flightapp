package com.fbs.ticket.dto;

import java.util.Date;

public class FlightDto {
	
	private long flightId;
	
	private AirlineDto airline;
	
	private Date scheduledFor;
	
	private int scheduledTimeHour;
	private int scheduledTimeMinutes;
	
	private String source;
	private String destination;
	
	private double price;
	
	private FlightStatus status;

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public AirlineDto getAirline() {
		return airline;
	}

	public void setAirline(AirlineDto airline) {
		this.airline = airline;
	}

	public Date getScheduledFor() {
		return scheduledFor;
	}

	public void setScheduledFor(Date scheduledFor) {
		this.scheduledFor = scheduledFor;
	}

	public int getScheduledTimeHour() {
		return scheduledTimeHour;
	}

	public void setScheduledTimeHour(int scheduledTimeHour) {
		this.scheduledTimeHour = scheduledTimeHour;
	}

	public int getScheduledTimeMinutes() {
		return scheduledTimeMinutes;
	}

	public void setScheduledTimeMinutes(int scheduledTimeMinutes) {
		this.scheduledTimeMinutes = scheduledTimeMinutes;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FlightDto [flightId=" + flightId + ", airline=" + airline + ", scheduledFor=" + scheduledFor
				+ ", scheduledTimeHour=" + scheduledTimeHour + ", scheduledTimeMinutes=" + scheduledTimeMinutes
				+ ", source=" + source + ", destination=" + destination + ", price=" + price + ", status=" + status
				+ "]";
	}
}

class FlightStatus {
	private int id;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FlightStatus [id=" + id + ", status=" + status + "]";
	}
	
}