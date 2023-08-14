package com.example.airportmanagementsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query("SELECT f FROM Flight f WHERE f.name=?1")
    Optional<Flight> findFlightByName(String name);
}
