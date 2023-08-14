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

   @GetMapping("/flights/{id}")
    public Flight getFlight(@PathVariable Long id){
        return flightService.getFlight(id).orElseThrow(() -> new FlightNotFoundException(id));
   }

   @PostMapping("/flights")
    public Flight getFlight(@RequestBody Flight newFlight){
        return flightService.addFlight(newFlight);
   }

   @PutMapping("/flights/{id}")
    public Flight updateFlight(@RequestBody Flight updatedFlight, @PathVariable Long id){
        return flightService.changeFlight(updatedFlight, id);
   }

   @DeleteMapping("/flights/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
   }





}
