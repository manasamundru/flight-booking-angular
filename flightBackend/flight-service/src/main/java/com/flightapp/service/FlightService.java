package com.flightapp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flightapp.model.Airline;
import com.flightapp.model.Flight;
import com.flightapp.repo.AirlineRepository;
import com.flightapp.repo.FlightRepository;

@Service
public class FlightService {

    private final AirlineRepository airlineRepo;
    private final FlightRepository flightRepo;

    public FlightService(AirlineRepository airlineRepo, FlightRepository flightRepo) {
        this.airlineRepo = airlineRepo;
        this.flightRepo = flightRepo;
    }

    public Airline addAirline(Airline airline) {
        return airlineRepo.save(airline);
    }

    public Flight addFlight(Flight flight, Long airlineId) {
        Airline airline = airlineRepo.findById(airlineId)
                .orElseThrow(() -> new RuntimeException("Airline not found"));
        flight.setAirline(airline);
        return flightRepo.save(flight);
    }

    public List<Flight> searchFlights(String from, String to, LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59);
        return flightRepo.findByFromPlaceIgnoreCaseAndToPlaceIgnoreCaseAndDepartureTimeBetween(
                from, to, start, end
        );
    }

    public Flight getFlight(Long id) {
        return flightRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }
}


