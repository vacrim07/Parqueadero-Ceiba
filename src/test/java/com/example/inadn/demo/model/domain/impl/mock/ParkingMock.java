package com.example.inadn.demo.model.domain.impl.mock;

import java.util.GregorianCalendar;

import com.example.inadn.demo.model.impl.Money;
import com.example.inadn.demo.model.impl.Motorcycle;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingState;
import com.example.inadn.demo.model.impl.consts.VehicleType;

public class ParkingMock {
	
	private Parking parkingMock;

	public ParkingMock(Parking parkingMock) {
		super();
		this.parkingMock = parkingMock;
	}

	public ParkingMock() {
		super();
	}

	public Parking getParkingMock() {
		return parkingMock;
	}

	public void setParkingMock(Parking parkingMock) {
		this.parkingMock = parkingMock;
	}
	
	public Parking getCreatePCase1() {
		
		Integer position = 21;
		GregorianCalendar checkIn = new GregorianCalendar(2019,1,10,22,0,0);
		GregorianCalendar checkOut = null;
		
		ParkingState parkingState = ParkingState.CHECKED_IN;
		
		VehicleType vehicleType = VehicleType.CAR;
		String badge = "EGH-761";
		Integer engineCapacity = 0;
		
		Money price = new Money("COP",null);
		Motorcycle vehicle = new Motorcycle(vehicleType, badge, engineCapacity);
		
		Parking p = new Parking(position, parkingState, price, vehicle, checkIn, checkOut);
		
		return p;
	}
}
