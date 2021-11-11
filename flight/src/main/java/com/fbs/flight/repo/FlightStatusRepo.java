package com.fbs.flight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbs.flight.entity.FlightSchedule;
import com.fbs.flight.entity.FlightStatus;

public interface FlightStatusRepo extends JpaRepository<FlightStatus, Integer> {

}
