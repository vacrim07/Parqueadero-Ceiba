package com.example.inadn.demo.model.domain.impl;


import java.util.Calendar;

import com.example.inadn.demo.model.domain.IAllowedVehicles;
import com.example.inadn.demo.model.domain.IMaximumVehicles;
import com.example.inadn.demo.model.domain.impl.consts.BadgeRestriction;
import com.example.inadn.demo.model.domain.impl.consts.MaximumVehiclesPerType;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingState;
import com.example.inadn.demo.model.impl.consts.VehicleType;

public class CreateParkingState implements IAllowedVehicles, IMaximumVehicles{
	
	private Parking parking;

	public CreateParkingState(Parking p) {
		super();
		this.parking = p;
		
		String vehicleType = this.parking.getVehicle().getType().getType();
		Integer position = p.getPosition();
		
		Integer total = getMaximumVehicles(vehicleType);
		boolean state = isParkingAvailable(position, total);
		
		p.setState(state ? ParkingState.CHECKED_IN : ParkingState.NOT_ALLOWED);
		
	}
	
	public CreateParkingState() {
		super();
	}
	
	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking p) {
		this.parking = p;
	}

	@Override
	public Integer getMaximumVehicles(String vehicleType) {
		return vehicleType.equalsIgnoreCase(VehicleType.CAR.getType()) ?
				MaximumVehiclesPerType.CAR.getMaximum() : MaximumVehiclesPerType.MOTORCYCLE.getMaximum();
	}

	@Override
	public boolean isParkingAvailable(Integer position, Integer total) {
		return position <= total ? true : false;
	}

	@Override
	public boolean isVehicleAllowed(String vehicleType) {
		if (vehicleType.equalsIgnoreCase(VehicleType.CAR.getType()) ||
				vehicleType.equalsIgnoreCase(VehicleType.MOTORCYCLE.getType())) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean isBadgeRestricted(String badge) {
		return badge.substring(0,1).equalsIgnoreCase(BadgeRestriction.A.getRestriction()) ? true : false;
	}

	@Override
	public boolean isARestrictedDay(Integer day) {
		return day == Calendar.SUNDAY || day == Calendar.MONDAY ? false : true;
	}

	@Override
	public boolean isAnAllowedCar(boolean badgeRestricted, boolean dayRestricted) {
		if(badgeRestricted) {
			return dayRestricted ? false : true;
		}else {
			return true;
		}
	}

}
