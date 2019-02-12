package com.example.inadn.demo.model.domain.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.example.inadn.demo.model.domain.IPricing;
import com.example.inadn.demo.model.domain.ITraffic;
import com.example.inadn.demo.model.domain.impl.consts.DayHoursParkingEnum;
import com.example.inadn.demo.model.domain.impl.consts.MotorcycleEngineCapacityEnum;
import com.example.inadn.demo.model.domain.impl.consts.PricingValuesEnum;
import com.example.inadn.demo.model.impl.Money;
import com.example.inadn.demo.model.impl.Motorcycle;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.Vehicle;
import com.example.inadn.demo.model.impl.consts.ParkingStateEnum;
import com.example.inadn.demo.model.impl.consts.VehicleTypeEnum;

public class ModifyParking implements ITraffic, IPricing{

	private Parking parking;	
	
	public ModifyParking(Parking p) {
		super();
		this.parking = p;
		
		run(this.parking);
	}
	
	public ModifyParking() {
		super();
	}

	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking p) {
		this.parking = p;
	}
	
	public void run(Parking p) {
		
		Money money = new Money();
		Vehicle vehicle = this.parking.getVehicle();
		String vehicleType = this.parking.getVehicle().getName().getType();
		Integer engineCapacity = vehicleType.equalsIgnoreCase(VehicleTypeEnum.MOTORCYCLE.getType()) ?
				((Motorcycle) vehicle).getEngineCapacity() : null;
		Integer parkingTime = parkingHours(this.parking.getStartDate(), this.parking.getEndDate());
		boolean bonusCondition = isBonusMotorcycleRequired(engineCapacity);
		BigDecimal price = parkingPricing(parkingTime,vehicleType,bonusCondition);
		money.setAmount(price);
		
		p.setPrice(money);
		p.setPosition(vehicleCheckOut(this.parking.getPosition()));
		p.setState(ParkingStateEnum.CHECKED_OUT);
	}

	@Override
	public Integer vehicleCheckOut(Integer position) {
		return position > 0 ? position - 1 : null;
	}
	
	@Override
	public boolean isBonusMotorcycleRequired(Integer engineCapacity) {
		Integer e = engineCapacity == null ? 0 : engineCapacity;
		return e > MotorcycleEngineCapacityEnum.TOP.getValue();
	}

	@Override
	public Integer parkingHours(GregorianCalendar checkIn, GregorianCalendar checkOut) {
		
		Integer years = checkOut.get(Calendar.YEAR) - checkIn.get(Calendar.YEAR);
		Integer days = checkOut.get(Calendar.DAY_OF_YEAR) - checkIn.get(Calendar.DAY_OF_YEAR);
		Integer hours = checkOut.get(Calendar.HOUR_OF_DAY) - checkIn.get(Calendar.HOUR_OF_DAY);
		Integer minutes = checkOut.get(Calendar.MINUTE) - checkIn.get(Calendar.MINUTE);
		Integer hourCorrection = minutes < 0 ? -1 : 0;
		
		return years*8760 + days*24 + hours + hourCorrection;
	}

	@Override
	public BigDecimal parkingPricing(Integer hours, String vehicleType, boolean bonus) {
		
		Integer days = hours / 24;
		Integer hoursAdded = hours % 24;
		Integer result;
		
		if(hoursAdded >= DayHoursParkingEnum.PARKING_DAY_START.getHours()) {
			hoursAdded = 0;
			days++;
		}
		
		if(vehicleType.equalsIgnoreCase(VehicleTypeEnum.CAR.getType())) {
			result = days*PricingValuesEnum.DAY_CAR.getAmount() + hoursAdded*PricingValuesEnum.HOUR_CAR.getAmount();
		}else {
			result = days*PricingValuesEnum.DAY_MOTORCYCLE.getAmount() + hoursAdded*PricingValuesEnum.HOUR_MOTORCYCLE.getAmount();
			if(bonus) {
				result = result + PricingValuesEnum.EXTRA_MOTORCYCLE.getAmount();
			}
		}
		
		return new BigDecimal(result);
	}
}
