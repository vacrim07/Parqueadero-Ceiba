package com.example.inadn.demo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.inadn.demo.controller.impl.consts.MessagesEnum;
import com.example.inadn.demo.controller.service.impl.ParkingService;
import com.example.inadn.demo.model.domain.impl.CreateParking;
import com.example.inadn.demo.model.domain.impl.ModifyParking;
import com.example.inadn.demo.model.exception.impl.CreateParkingException;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingStateEnum;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	
	@Autowired
	private CreateParking create;
	
	@Autowired
	private ModifyParking modify;
	
	@Autowired
	private ParkingService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public Parking createParking(@RequestBody Parking parking) {
		create.run(parking);		
		if (!create.getParking().getState().getState().equalsIgnoreCase(ParkingStateEnum.CHECKED_IN.getState())) {
			throw new CreateParkingException(MessagesEnum.NOT_ALLOWED.getMessage());
		}else {
			return service.saveCreateParkingService(parking);
		}

    }
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String parkingNotAllowed(CreateParkingException exception) {
	    return exception.getMessage();
	}
	
	@PatchMapping
	@ResponseStatus(HttpStatus.OK)
    public Parking modifyParking(@RequestBody Parking parking) {
		ModifyParking c = new ModifyParking(parking);		
		return c.getParking();
    }
}
