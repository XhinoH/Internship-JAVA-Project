package com.lhind.service.impl;

import com.lhind.service.FlightService;
import com.lhind.model.entity.Flight;
import com.lhind.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository repository;

    @Override
    public Flight saveFlight(Flight flight) {
        return repository.save(flight);
    }

    @Override
    public List<Flight> allFlights() {
        return repository.findAll();
    }

    @Override
    public Flight updateFlight(Flight flightRequest, Long flightId) {
        Flight flight;
        Optional<Flight> flightFromDB = repository.findById(flightId);
        if (flightFromDB.isPresent()) {
            flight = flightFromDB.get();
            flight.setFlight_number(flightRequest.getFlight_number());
            flight.setFlightStatus(flightRequest.getFlightStatus());
            flight.setId(flightRequest.getId());
            flight.setAirline(flightRequest.getAirline());
            flight.setOrigin(flightRequest.getOrigin());
            flight.setDestination(flightRequest.getDestination());
            flight.setDepartureDate(flightRequest.getDepartureDate());
            flight.setArrivalDate(flightRequest.getArrivalDate());
        } else {
            flight = new Flight();
            flight.setFlight_number(flightRequest.getFlight_number());
            flight.setFlightStatus(flightRequest.getFlightStatus());
            flight.setId(flightRequest.getId());
            flight.setAirline(flightRequest.getAirline());
            flight.setOrigin(flightRequest.getOrigin());
            flight.setDestination(flightRequest.getDestination());
            flight.setDepartureDate(flightRequest.getDepartureDate());
            flight.setArrivalDate(flightRequest.getArrivalDate());
        }
        return repository.save(flight);
    }

    @Override
    public void deleteFById(Long flightId) {
        repository.deleteById(flightId);
    }
}
