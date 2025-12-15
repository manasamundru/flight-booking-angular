package com.flightapp.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.model.Flight;

public interface FlightRepository extends JpaRepository<Flight,Long> {
	List<Flight> findByFromPlaceIgnoreCaseAndToPlaceIgnoreCaseAndDepartureTimeBetween(String fromPlace, String toPlace,
			LocalDateTime start, LocalDateTime end);
}
