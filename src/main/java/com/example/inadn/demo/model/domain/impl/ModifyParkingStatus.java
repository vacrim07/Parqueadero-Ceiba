package com.example.inadn.demo.model.domain.impl;

import com.example.inadn.demo.model.domain.ITraffic;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingState;

public class ModifyParkingStatus implements ITraffic{
	
	private Parking parking;	
	
	public ModifyParkingStatus(Parking p) {
		super();
		this.parking = p;
		
		p.setPosition(vehicleCheckOut(this.parking.getPosition()));
		p.setState(ParkingState.CHECKED_OUT);
	}

	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking p) {
		this.parking = p;
	}

	@Override
	public Integer vehicleCheckOut(Integer position) {
		return position > 0 ? position - 1 : -1;
	}

}
