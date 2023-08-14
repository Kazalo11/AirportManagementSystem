package com.example.airportmanagementsystem;

public class FlightNotFoundException extends RuntimeException {
    public <T> FlightNotFoundException(T t) {
        super("Can't find flight "+ t);
    }
}
