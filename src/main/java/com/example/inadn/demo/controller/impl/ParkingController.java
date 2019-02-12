package com.example.inadn.demo.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.inadn.demo.model.impl.Parking;

@RestController
public class ParkingController {
	
//	@PostMapping("/parking")
//    public CreateParking createParking(@RequestBody Parking parking) { // JSON input
//        return new CreateParking(parking);  // JSON output
//    }
	
	@PostMapping("/parking")
    public Parking createParking(@RequestBody Parking parking) { // JSON input
        return parking;  // JSON output
    }
}
