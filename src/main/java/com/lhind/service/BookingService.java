package com.lhind.service;

import com.lhind.model.entity.Booking;
import com.lhind.model.entity.User;

import java.util.List;

public interface BookingService {

    //Save Operation
    Booking saveBooking (Booking booking);

    //Read Operation
    List<Booking> allBookings();

    //Update Operation
    Booking updateBooking(Booking booking,Long bookingId);

    //Delete Operation
    void deleteBookingById(Long bookingId);

    // Method that gets all userDetails who have booked on a specific flight
    List<User> userFlight(Long userId, Long flightId);
}
