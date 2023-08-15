package com.example.airportmanagementsystem;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id){
        return flightRepository.findById(id);
    }

    public Flight addFlight(Flight newFlight){
        return flightRepository.save(newFlight);
    }

    public Flight changeFlightById(Flight updateFlight, Long id){
        return flightRepository.findById(id)
                .map(flight -> {
                    flight.setName(updateFlight.getName());
                    flight.setArrivalAirport(updateFlight.getArrivalAirport());
                    flight.setArrivalTime(updateFlight.getArrivalTime());
                    flight.setDepartureTime(updateFlight.getDepartureTime());
                    flight.setLeavingAirport(updateFlight.getLeavingAirport());
                    flight.setPassengerList(updateFlight.getPassengerList());
                    return flightRepository.save(flight);
                })
                .orElseGet(() -> {
                    updateFlight.setId(id);
                    return flightRepository.save(updateFlight);
                });
    }

    public void deleteFlightById(Long id){
        flightRepository.deleteById(id);
    }

    public Optional<Flight> getFlightByName(String name) {
        return flightRepository.findFlightByName(name);
    }

    public Optional<List<Flight>> getFlightsByPassengerName(String name) {
        return flightRepository.findFlightsByPassengerName(name);
    }
}
