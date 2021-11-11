package com.fbs.ticket.dto;

public class SearchFlightParams {

	private String date;
	private String source;
	private String destination;
	private String trip;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getTrip() {
		return trip;
	}
	public void setTrip(String trip) {
		this.trip = trip;
	}
	
	@Override
	public String toString() {
		return "SearchFlightParams [date=" + date + ", source=" + source + ", destination=" + destination + ", trip="
				+ trip + "]";
	}
}
