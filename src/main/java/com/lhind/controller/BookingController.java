package com.lhind.controller;

import com.lhind.model.entity.Booking;
import com.lhind.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    // Create a new booking
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.saveBooking(booking);
        return ResponseEntity.created(URI.create("/bookings/" + savedBooking.getId()))
                .body(savedBooking);
    }

    // Get all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.allBookings();
        return ResponseEntity.ok(bookings);
    }

    // Update a booking by ID
    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking,
                                                 @PathVariable Long bookingId) {
        Booking updatedBooking = bookingService.updateBooking(booking, bookingId);
        return ResponseEntity.ok(updatedBooking);
    }

    // Delete a booking by ID
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBookingById(bookingId);
        return ResponseEntity.noContent().build();
    }

}
