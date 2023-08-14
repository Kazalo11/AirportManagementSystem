package com.example.airportmanagementsystem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
    @Id @GeneratedValue
    private long id;
    private String name;
    private String leavingAirport;
    private String arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Flight)) {
            return false;
        }

        Flight f = (Flight) o;
        return(
                id == f.getId() &&
                name.equals(f.getName()) &&
                leavingAirport.equals(f.getLeavingAirport()) &&
                arrivalAirport.equals(f.getArrivalAirport()) &&
                departureTime.equals(f.getDepartureTime()) &&
                arrivalTime.equals(f.getArrivalTime())
        );
    }
}
