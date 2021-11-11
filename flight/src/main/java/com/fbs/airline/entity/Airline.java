package com.fbs.airline.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mst_airline")
public class Airline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long airlineId;
	
	private String airlineName;
	
	@OneToOne(fetch=FetchType.EAGER)
	private AirlineStatus airlineStatus;

	public Airline() {}

	public Airline(long airlineId, String airlineName, AirlineStatus airlineStatus) {
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.airlineStatus = airlineStatus;
	}

	public long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public AirlineStatus getAirlineStatus() {
		return airlineStatus;
	}

	public void setAirlineStatus(AirlineStatus airlineStatus) {
		this.airlineStatus = airlineStatus;
	}

	@Override
	public String toString() {
		return "Airline [airlineId=" + airlineId + ", airlineName=" + airlineName + ", airlineStatus=" + airlineStatus
				+ "]";
	}
	
	

}
