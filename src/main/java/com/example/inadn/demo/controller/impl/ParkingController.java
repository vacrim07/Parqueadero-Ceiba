package com.example.inadn.demo.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.inadn.demo.model.domain.impl.CreateParking;
import com.example.inadn.demo.model.exception.impl.CreateParkingException;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingStateEnum;

@RestController
public class ParkingController {
	
	
	
	@PostMapping("/parking")
	@ResponseStatus(HttpStatus.CREATED)
    public Parking createParking(@RequestBody Parking parking) { // JSON input
		CreateParking c = new CreateParking(parking);		
		if (!c.getParking().getState().getState().equalsIgnoreCase(ParkingStateEnum.CHECKED_IN.getState())) {
			throw new CreateParkingException("You are not allowed to park here");
		}else {
			return c.getParking();
		}

    }
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String parkingNotAllowed(CreateParkingException exception) {
	    return exception.getMessage();
	}
}
