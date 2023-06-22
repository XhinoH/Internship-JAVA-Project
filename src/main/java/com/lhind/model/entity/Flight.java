package com.lhind.model.entity;

import com.lhind.model.enums.FlightStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name = "origin",nullable = false)
    private String origin;

    @Column(name = "destination",nullable = false)
    private String destination;

    @Column(name = "airline",nullable = false)
    private String airline;

    @Column(name = "flight_number",nullable = false)
    private String flight_number;

    @Column(name = "departure_date",nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date departureDate;

    @Column(name = "arrival_date",nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date arrivalDate;

    @Column(name = "status",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private FlightStatus flightStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", airline='" + airline + '\'' +
                ", flight_number='" + flight_number + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", flightStatus=" + flightStatus +
                '}';
    }
}
