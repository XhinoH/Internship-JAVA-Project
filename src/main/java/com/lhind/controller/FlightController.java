package com.lhind.controller;

import com.lhind.model.entity.Flight;
import com.lhind.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }
    // Create a new flight
    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.saveFlight(flight);
        return ResponseEntity.created(URI.create("/flights/" + savedFlight.getId()))
                .body(savedFlight);
    }

    // Get all flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.allFlights();
        return ResponseEntity.ok(flights);
    }

    // Update a flight by ID
    @PutMapping("/{flightId}")
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight,
                                               @PathVariable Long flightId) {
        Flight updatedFlight = flightService.updateFlight(flight, flightId);
        return ResponseEntity.ok(updatedFlight);
    }

    // Delete a flight by ID
    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId) {
        flightService.deleteFById(flightId);
        return ResponseEntity.noContent().build();
    }

}
