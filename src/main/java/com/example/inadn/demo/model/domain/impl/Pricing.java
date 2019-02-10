package com.example.inadn.demo.model.domain.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.example.inadn.demo.model.domain.IPricing;
import com.example.inadn.demo.model.domain.impl.consts.DayHoursParking;
import com.example.inadn.demo.model.domain.impl.consts.MotorcycleEngineCapacity;
import com.example.inadn.demo.model.domain.impl.consts.PricingValues;
import com.example.inadn.demo.model.impl.consts.VehicleType;

public class Pricing implements IPricing{
	
	@Override
	public boolean isBonusMotorcycleRequired(Integer engineCapacity) {
		return engineCapacity > MotorcycleEngineCapacity.TOP.getValue() ? true : false;
	}
	
	@Override
	public Integer parkingHours(GregorianCalendar checkIn, GregorianCalendar checkOut) {
		
		Integer years = checkOut.get(Calendar.YEAR) - checkIn.get(Calendar.YEAR);
		Integer days = checkOut.get(Calendar.DAY_OF_YEAR) - checkIn.get(Calendar.DAY_OF_YEAR);
		Integer hours = checkOut.get(Calendar.HOUR_OF_DAY) - checkIn.get(Calendar.HOUR_OF_DAY);
		
		return years*8760 + days*24 + hours;
	}
	
	@Override
	public BigDecimal parkingPricing(Integer hours, String vehicleType, boolean bonus) {
		
		Integer days = hours / 24;
		Integer hoursAdded = hours % 24;
		Integer result;
		
		if(hoursAdded >= DayHoursParking.PARKING_DAY_START.getHours()) {
			hoursAdded = 0;
			days++;
		}
		
		if(vehicleType.equalsIgnoreCase(VehicleType.CAR.getType())) {
			result = days*PricingValues.DAY_CAR.getAmount() + hoursAdded*PricingValues.HOUR_CAR.getAmount();
		}else {
			result = days*PricingValues.DAY_MOTORCYCLE.getAmount() + hoursAdded*PricingValues.HOUR_MOTORCYCLE.getAmount();
			result = bonus ? result = result + PricingValues.EXTRA_MOTORCYCLE.getAmount() : result;
		}
		
		return new BigDecimal(result);
	}
}