package com.example.airportmanagementsystem;


import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }


   @GetMapping("/flights")
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
   }

   @GetMapping("/flights/id/{id}")
    public Flight getFlightById(@PathVariable Long id){
        return flightService.getFlightById(id).orElseThrow(() -> new FlightNotFoundException(id));
   }

   @GetMapping("/flights/name/{name}")
   public Flight getFlightByName(@PathVariable String name){
        return flightService.getFlightByName(name).orElseThrow(() -> new FlightNotFoundException(name));
   }

   @PostMapping("/flights")
    public Flight getFlight(@RequestBody Flight newFlight){
        return flightService.addFlight(newFlight);
   }

   @PutMapping("/flights/id/{id}")
    public Flight updateFlight(@RequestBody Flight updatedFlight, @PathVariable Long id){
        return flightService.changeFlightById(updatedFlight, id);
   }

   @DeleteMapping("/flights/id/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlightById(id);
   }





}
