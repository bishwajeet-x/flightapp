package com.fbs.airline.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbs.airline.entity.Airline;

public interface AirlineRepo extends JpaRepository<Airline, Long> {

	public Optional<List<Airline>> findByAirlineStatusId(int status);
	public Optional<Airline> findByAirlineId(long airlineId);
}
