package com.example.inadn.demo.model.domain;

public interface IAllowedVehicles {
	
	boolean isVehicleAllowed(String vehicleType);
	
	boolean isBadgeRestricted(String badge);
	
	boolean isARestrictedDay(Integer day);
	
	boolean isAnAllowedCar(boolean badgeRestricted, boolean dayRestricted);

}
