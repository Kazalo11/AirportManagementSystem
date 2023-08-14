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

    public Flight changeFlight(Flight updateFlight, Long id){
        return flightRepository.findById(id)
                .map(employee -> {
                    employee.setName(updateFlight.getName());
                    employee.setArrivalAirport(updateFlight.getArrivalAirport());
                    employee.setArrivalTime(updateFlight.getArrivalTime());
                    employee.setDepartureTime(updateFlight.getDepartureTime());
                    employee.setLeavingAirport(updateFlight.getLeavingAirport());
                    return flightRepository.save(employee);
                })
                .orElseGet(() -> {
                    updateFlight.setId(id);
                    return flightRepository.save(updateFlight);
                });
    }

    public void deleteFlight(Long id){
        flightRepository.deleteById(id);
    }

    public Optional<Flight> getFlightByName(String name) {
        return flightRepository.findFlightByName(name);
    }
}
