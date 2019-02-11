package com.example.inadn.demo.model.domain;

public interface IAllowedVehicles {
	
	boolean isVehicleRestricted(String vehicleType);
	
	boolean isBadgeRestricted(String badge);
	
	boolean isARestrictedDay(Integer day);
	
	boolean isAnAllowedCar(boolean badgeRestricted, boolean dayRestricted);

}
