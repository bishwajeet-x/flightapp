package com.fbs.airline.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbs.airline.entity.AirlineStatus;

public interface AirlineStatusRepo extends JpaRepository<AirlineStatus, Integer> {

}
