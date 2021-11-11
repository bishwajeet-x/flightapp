package com.fbs.flight.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fbs.airline.entity.Airline;

@Entity
@Table(name="flight_schedule")
public class FlightSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long flightId;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Airline airline;
	
	private Date scheduledFor;
	
	private int scheduledTimeHour;
	private int scheduledTimeMinutes;
	
	private String source;
	private String destination;
	
	private double price;
	
	@OneToOne(fetch = FetchType.EAGER)
	private FlightStatus status;

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
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
		return "FlightSchedule [flightId=" + flightId + ", airline=" + airline + ", scheduledFor=" + scheduledFor
				+ ", scheduledTimeHour=" + scheduledTimeHour + ", scheduledTimeMinutes=" + scheduledTimeMinutes
				+ ", source=" + source + ", destination=" + destination + ", price=" + price + ", status=" + status
				+ "]";
	}


}
