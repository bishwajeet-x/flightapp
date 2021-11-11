package com.fbs.api.dto;

public class AirlineDto {
	
	private long airlineId;
	private String airlineName;
	private int airlineStatus;
	
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
	public int getAirlineStatus() {
		return airlineStatus;
	}
	public void setAirlineStatus(int airlineStatus) {
		this.airlineStatus = airlineStatus;
	}
	
	@Override
	public String toString() {
		return "AirlineDto [airlineId=" + airlineId + ", airlineName=" + airlineName + ", airlineStatus="
				+ airlineStatus + "]";
	}
	
	
}
