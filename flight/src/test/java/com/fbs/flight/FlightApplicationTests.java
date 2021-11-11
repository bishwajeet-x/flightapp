package com.fbs.flight;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fbs.airline.dto.AirlineDto;
import com.fbs.airline.entity.Airline;
import com.fbs.airline.entity.AirlineStatus;
import com.fbs.airline.repo.AirlineRepo;
import com.fbs.airline.service.AirlineService;

@SpringBootTest
class FlightApplicationTests {
	
	@MockBean
	private AirlineRepo airlineRepo;
	
	@Autowired private AirlineService airlineService;
	

	@Test
	public void shouldFindAllAirlines() {
		Mockito.when(airlineRepo.findAll()).thenReturn(List.of(
				new Airline(101, "IndiGo", new AirlineStatus(101, "ACTIVE")),
				new Airline(102, "Air India", new AirlineStatus(101, "ACTIVE")),
				new Airline(103, "Vistara", new AirlineStatus(101, "ACTIVE"))
		));
		
		List<Airline> airlines = airlineService.fetchAllAirlines();
		Assertions.assertThat(airlines.size() > 0);
	}
	
	@Test
	public void shouldFindAirlineWithId() {
		long airlineId = 101l;
		
		Mockito.when(airlineRepo.findByAirlineId(airlineId)).thenReturn(
				Optional.of(new Airline(101, "IndiGo", new AirlineStatus(101, "ACTIVE")))
		);
		
		Optional<Airline> airline = airlineService.fetchAirlineById(airlineId);
		Assertions.assertThat(airline.isPresent());
	}
	
	@Test void shouldCreateAirline() {
		
		Mockito.when(airlineRepo.save(new Airline(101, "IndiGo", new AirlineStatus(101, "ACTIVE")))).thenReturn(
				new Airline(101, "IndiGo", new AirlineStatus(101, "ACTIVE"))
		);
		
		AirlineDto dto = new AirlineDto();
		dto.setAirlineId(101);
		dto.setAirlineName("INDIGO");
		dto.setAirlineStatus(101);
		
		Airline airline = airlineService.createAirline(dto);
		assertNotNull(airline);
	}

}
