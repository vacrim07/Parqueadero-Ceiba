package com.example.inadn.demo.model.domain;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public interface IPricing {
	
	boolean isBonusMotorcycleRequired(Integer engineCapacity);
	
	Integer parkingHours(GregorianCalendar checkIn, GregorianCalendar checkOut);
	
	BigDecimal parkingPricing(Integer hours, String vehicleType, boolean bonus);
}
