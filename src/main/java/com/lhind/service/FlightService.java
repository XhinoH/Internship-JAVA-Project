package com.lhind.service;

import com.lhind.model.entity.Flight;

import java.util.List;

public interface FlightService {
    //Save Operation
    Flight saveFlight (Flight flight);

    //Read Operation
    List<Flight> allFlights();

    //Update Operation
    Flight updateFlight(Flight flight, Long flightId);

    //Delete Operation
    void deleteFById(Long flightId);
}
