package com.fbs.ticket.dto;

public class AirlineDto {
	
	private long airlineId;
	
	private String airlineName;
	
	private AirlineStatus airlineStatus;

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
		return "AirlineDto [airlineId=" + airlineId + ", airlineName=" + airlineName + ", airlineStatus=" + airlineStatus
				+ "]";
	}
}

class AirlineStatus {
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
		return "AirlineStatus [id=" + id + ", status=" + status + "]";
	}
}

