package com.fbs.api.dto;

public class FlightScheduleDto {
	
	private long flightId;
	private long airlineId;
	private String scheduledFor;
	private int scheduledTimeHour;
	private int scheduledTimeMinutes;
	private String source;
	private String destination;
	private double price;
	private int statusId;
	
	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
	public long getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}
	public String getScheduledFor() {
		return scheduledFor;
	}
	public void setScheduledFor(String scheduledFor) {
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
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	@Override
	public String toString() {
		return "FlightScheduleDto [flightId=" + flightId + ", airlineId=" + airlineId + ", scheduledFor=" + scheduledFor
				+ ", scheduledTimeHour=" + scheduledTimeHour + ", scheduledTimeMinutes=" + scheduledTimeMinutes
				+ ", source=" + source + ", destination=" + destination + ", price=" + price + ", statusId=" + statusId
				+ "]";
	}
}
