package com.example.airportmanagementsystem;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(Long id) {
        super("Can't find flight "+ id);
    }
}
