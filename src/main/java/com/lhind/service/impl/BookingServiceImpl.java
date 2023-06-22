package com.lhind.service.impl;

import com.lhind.model.entity.Booking;
import com.lhind.model.entity.User;
import com.lhind.repository.BookingRepository;
import com.lhind.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository repository;

    @Override
    public Booking saveBooking(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public List<Booking> allBookings() {
        return repository.findAll();
    }

    @Override
    public Booking updateBooking(Booking bookingRequest, Long bookingId) {
        Booking booking;
        Optional<Booking> bookingFromDB = repository.findById(bookingId);
        if (bookingFromDB.isPresent()) {
            // This means that we have to do an update as the booking is currently registered on the database
            booking = bookingFromDB.get();
            booking.setBookingDate(bookingRequest.getBookingDate());
            booking.setBookingStatus(bookingRequest.getBookingStatus());

        } else {
            // This means that the booking does not exist on the database and that we need to create a new booking
            booking = new Booking();
            booking.setBookingDate(bookingRequest.getBookingDate());
            booking.setBookingStatus(bookingRequest.getBookingStatus());
        }
        return repository.save(booking);
    }

    @Override
    public List<User> userFlight(Long userId, Long flightId) {
        List<Booking> bookings = repository.findFlightById(flightId);
        List<User> users = new ArrayList<>();
        for (Booking booking : bookings) {
            users.add(booking.getUser());
        }
        return users;
    }

    @Override
    public void deleteBookingById(Long bookingId) {
        repository.deleteById(bookingId);
    }
}
