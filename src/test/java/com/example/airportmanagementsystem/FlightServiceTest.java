package com.example.airportmanagementsystem;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class FlightServiceTest {

    private FlightRepository flightRepository;

    private FlightService flightService;

    public Flight getFlight(){
        Flight testFlight = new Flight();
        testFlight.setId(10);
        testFlight.setName("M35HO");
        testFlight.setArrivalAirport("Mumbai");
        testFlight.setArrivalTime(LocalDateTime.parse("2007-12-03T10:15:30"));
        testFlight.setDepartureTime(LocalDateTime.parse("2008-12-03T10:15:30"));
        testFlight.setLeavingAirport("Manchester");
        return testFlight;
    }


    @BeforeEach
    public void setup(){
        flightRepository = mock(FlightRepository.class);
        flightService = new FlightService(flightRepository);
        Flight newFlight = getFlight();
        when(flightRepository.findAll()).thenReturn(List.of(newFlight));
        when(flightRepository.findFlightByName("M35HO")).thenReturn(Optional.of(newFlight));
        when(flightRepository.save(newFlight)).thenReturn(newFlight);
        when(flightRepository.findById(10L)).thenReturn(Optional.of(newFlight));
        when(flightRepository.findFlightByName("M35HO")).thenReturn(Optional.of(newFlight));
    }

    @Test
    void addFlight() {
        assertEquals(flightService.addFlight(getFlight()),getFlight());

    }

    @Test
    void getAllFlights() {
        assertEquals(flightService.getAllFlights().get(0),getFlight());

    }

    @Test
    void getFlightById() {
        Flight findFlight = getFlight();
        assertEquals(flightService.getFlightById(findFlight.getId()),Optional.of(findFlight));
    }



    @Test
    void changeFlightById() {
        Flight changeFlight = getFlight();
        changeFlight.setName("New Name");
        assertEquals(
                flightService.changeFlightById(
                        changeFlight,
                        changeFlight.getId()
                ),
                changeFlight
        );
    }

    @Test
    void deleteFlightById() {

    }

    @Test
    void getFlightByName() {
        flightService.addFlight(getFlight());
        assertEquals(
                flightService.getFlightByName(getFlight().getName()),
                Optional.of(getFlight())
        );

    }
}