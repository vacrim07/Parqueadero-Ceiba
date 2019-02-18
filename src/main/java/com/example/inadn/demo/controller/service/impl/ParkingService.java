package com.example.inadn.demo.controller.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inadn.demo.controller.repository.ParkingRepository;
import com.example.inadn.demo.controller.repository.VehicleRepository;
import com.example.inadn.demo.model.domain.impl.CreateParking;
import com.example.inadn.demo.model.domain.impl.ModifyParking;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.Vehicle;

@Service
public class ParkingService {
	
	@Autowired
	private ParkingRepository parkingRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private CreateParking createParking;
	
	@Autowired
	private ModifyParking modifyParking;
	
	public Parking saveCreateParkingService(Parking parking) {
		
		createParking.run(parking);
		
		Vehicle vehicleEntity = parking.getVehicle();
		vehicleEntity = vehicleRepository.save(vehicleEntity);
		
		parking.getVehicle().setId(vehicleEntity.getId());
		parking = parkingRepository.save(parking);
		
		return parking;
	}
	
public Parking modifyParkingService(Parking parking) {
		
		modifyParking.run(parking);
		
		Vehicle vehicleEntity = parking.getVehicle();
		vehicleEntity = vehicleRepository.save(vehicleEntity);
		
		parking.getVehicle().setId(vehicleEntity.getId());
		parking = parkingRepository.save(parking);
		
		return parking;
	}

}
