package com.example.inadn.demo.model.domain.impl;

import com.example.inadn.demo.model.domain.ITraffic;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingState;

public class ModifyParkingStatus implements ITraffic{
	
	private Parking parking;	
	
	public ModifyParkingStatus(Parking parking) {
		super();
		this.parking = parking;
		
		vehicleCheckOut(this.parking.getPosition());
		parking.setState(ParkingState.CHECKED_OUT);
	}

	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	@Override
	public Integer vehicleCheckOut(Integer position) {
		return position > 0 ? position - 1 : 0;
	}

}
