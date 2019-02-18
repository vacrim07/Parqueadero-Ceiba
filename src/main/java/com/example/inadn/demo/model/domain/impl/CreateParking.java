package com.example.inadn.demo.model.domain.impl;


import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.stereotype.Service;
import com.example.inadn.demo.model.domain.IAllowedVehicles;
import com.example.inadn.demo.model.domain.IMaximumVehicles;
import com.example.inadn.demo.model.domain.impl.consts.BadgeRestrictionEnum;
import com.example.inadn.demo.model.domain.impl.consts.MaximumVehiclesPerTypeEnum;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingStateEnum;
import com.example.inadn.demo.model.impl.consts.VehicleTypeEnum;

@Service
public class CreateParking implements IAllowedVehicles, IMaximumVehicles{
	
	private Parking parking;

	public CreateParking(Parking p) {
		this.parking = p;
		
		run(this.parking);
		
	}
	
	public CreateParking() {
		super();
	}
	
	public Parking getParking() {		
		return parking;
	}

	public void setParking(Parking p) {
		this.parking = p;
	}
	
	public void run(Parking p) {
		
		this.parking = p;
		
		boolean state2;
		
		String vehicleType = this.parking.getVehicle().getName().getType();
		Integer position = this.parking.getVehicle().getId();
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
		
		p.setState(state1 && !state2 ? ParkingStateEnum.CHECKED_IN : ParkingStateEnum.NOT_ALLOWED);
	}

	@Override
	public Integer getMaximumVehicles(String vehicleType) {
		return vehicleType.equalsIgnoreCase(VehicleTypeEnum.CAR.getType()) ?
				MaximumVehiclesPerTypeEnum.CAR.getMaximum() : MaximumVehiclesPerTypeEnum.MOTORCYCLE.getMaximum();
	}

	@Override
	public boolean isParkingAvailable(Integer position, Integer total) {
		return position <= total;
	}

	@Override
	public boolean isVehicleRestricted(String vehicleType) {
		return vehicleType.equalsIgnoreCase(VehicleTypeEnum.CAR.getType());
	}

	@Override
	public boolean isBadgeRestricted(String badge) {
		return badge.substring(0,1).equalsIgnoreCase(BadgeRestrictionEnum.A.getRestriction());
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
