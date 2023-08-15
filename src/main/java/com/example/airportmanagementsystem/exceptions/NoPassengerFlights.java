package com.example.airportmanagementsystem.exceptions;

public class NoPassengerFlights extends RuntimeException {
    public NoPassengerFlights(String name) {
        super("Can't find any flights for Passenger " + name);

    }
}
