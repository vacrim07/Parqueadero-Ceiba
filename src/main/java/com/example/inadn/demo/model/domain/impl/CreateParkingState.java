package com.example.inadn.demo.model.domain.impl;


import java.util.Calendar;
import java.util.GregorianCalendar;

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
		
		boolean state2;
		
		String vehicleType = this.parking.getVehicle().getType().getType();
		Integer position = this.parking.getPosition();
		String badge = this.parking.getVehicle().getBadge();
		GregorianCalendar date = this.parking.getStartDate();
		Integer day = date.get(Calendar.DAY_OF_WEEK);
		
		Integer total = getMaximumVehicles(vehicleType);
		boolean state1 = isParkingAvailable(position, total);
		
		if(isVehicleRestricted(vehicleType)) {
			boolean badgeRestricted = isBadgeRestricted(badge);
			boolean restrictedDay = isARestrictedDay(day);
			state2 = !isAnAllowedCar(badgeRestricted, restrictedDay);
		}else {
			state2 = false;
		}
		
		p.setState(state1 && !state2 ? ParkingState.CHECKED_IN : ParkingState.NOT_ALLOWED);
		
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
		return position <= total;
	}

	@Override
	public boolean isVehicleRestricted(String vehicleType) {
		return vehicleType.equalsIgnoreCase(VehicleType.CAR.getType());
	}

	@Override
	public boolean isBadgeRestricted(String badge) {
		return badge.substring(0,1).equalsIgnoreCase(BadgeRestriction.A.getRestriction());
	}

	@Override
	public boolean isARestrictedDay(Integer day) {
		return !(day == Calendar.SUNDAY || day == Calendar.MONDAY);
	}

	@Override
	public boolean isAnAllowedCar(boolean badgeRestricted, boolean dayRestricted) {
		if(badgeRestricted) {
			return !(dayRestricted);
		}else {
			return true;
		}
	}

}
