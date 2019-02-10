package com.example.inadn.demo.controller.domain.impl;

import java.util.Calendar;

import com.example.inadn.demo.controller.domain.impl.consts.BadgeRestriction;
import com.example.inadn.demo.model.impl.consts.VehicleType;

public class AllowedVehicles {
	
	public boolean isVehicleAllowed(String vehicleType) {
		if (vehicleType.equalsIgnoreCase(VehicleType.CAR.getType()) ||
				vehicleType.equalsIgnoreCase(VehicleType.MOTORCYCLE.getType())) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isBadgeRestricted(String badge) {
		return badge.substring(0,1).equalsIgnoreCase(BadgeRestriction.A.getRestriction()) ? true : false;
	}
	
	public boolean isARestrictedDay(Integer day) {
		return day == Calendar.SUNDAY || day == Calendar.MONDAY ? false : true;
	}
	
	public boolean isAnAllowedCar(boolean badgeRestricted, boolean dayRestricted) {
		if(badgeRestricted) {
			return dayRestricted ? false : true;
		}else {
			return true;
		}
	}
}