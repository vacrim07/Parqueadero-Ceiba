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
	
	// Case 1 : CAR: Parking is full
	public Parking getCase1(boolean isCreate) {
		
		Integer position = 21;
		GregorianCalendar checkIn = new GregorianCalendar(2019,1,10,22,0,0);
		
		//TODO revisar checkOut
		GregorianCalendar checkOut = isCreate ? null : new GregorianCalendar(2019,1,10,22,0,0);
		
		ParkingState parkingState = ParkingState.CHECKED_IN;
		
		VehicleType vehicleType = VehicleType.CAR;
		String badge = "EGH-761";
		Integer engineCapacity = 0;
		
		Money price = new Money("COP",null);
		Motorcycle vehicle = new Motorcycle(vehicleType, badge, engineCapacity);
		
		Parking p = new Parking(position, parkingState, price, vehicle, checkIn, checkOut);
		
		return p;
	}
	
	// Case 2 : CAR: Restricted by badge, but not by day
	public Parking getCase2(boolean isCreate) {
		
		Integer position = 15;
		GregorianCalendar checkIn = new GregorianCalendar(2019,1,10,22,0,0);
		
		//TODO revisar checkOut
		GregorianCalendar checkOut = isCreate ? null : new GregorianCalendar(2019,1,10,22,0,0);
		
		ParkingState parkingState = ParkingState.CHECKED_IN;
		
		VehicleType vehicleType = VehicleType.CAR;
		String badge = "AGH-761";
		Integer engineCapacity = 0;
		
		Money price = new Money("COP",null);
		Motorcycle vehicle = new Motorcycle(vehicleType, badge, engineCapacity);
		
		Parking p = new Parking(position, parkingState, price, vehicle, checkIn, checkOut);
		
		return p;
	}
	
	// Case 3 : CAR: Restricted not by badge, restricted by day
	public Parking getCase3(boolean isCreate) {
		
		Integer position = 15;
		GregorianCalendar checkIn = new GregorianCalendar(2019,1,14,22,0,0);
		
		//TODO revisar checkOut
		GregorianCalendar checkOut = isCreate ? null : new GregorianCalendar(2019,1,10,22,0,0);
		
		ParkingState parkingState = ParkingState.CHECKED_IN;
		
		VehicleType vehicleType = VehicleType.CAR;
		String badge = "AGH-761";
		Integer engineCapacity = 0;
		
		Money price = new Money("COP",null);
		Motorcycle vehicle = new Motorcycle(vehicleType, badge, engineCapacity);
		
		Parking p = new Parking(position, parkingState, price, vehicle, checkIn, checkOut);
		
		return p;
	}
	
	// Case 4 : MOTORCYCLE: Parking is full
	public Parking getCase4(boolean isCreate) {
		
		Integer position = 15;
		GregorianCalendar checkIn = new GregorianCalendar(2019,1,10,22,0,0);
		
		//TODO revisar checkOut
		GregorianCalendar checkOut = isCreate ? null : new GregorianCalendar(2019,1,10,22,0,0);
		
		ParkingState parkingState = ParkingState.CHECKED_IN;
		
		VehicleType vehicleType = VehicleType.MOTORCYCLE;
		String badge = "IGH-761";
		Integer engineCapacity = 0;
		
		Money price = new Money("COP",null);
		Motorcycle vehicle = new Motorcycle(vehicleType, badge, engineCapacity);
		
		Parking p = new Parking(position, parkingState, price, vehicle, checkIn, checkOut);
		
		return p;
	}
	
	// Case 5 : MOTORCYCLE: > 500 CC : With CAR restrictions ---> No problem
	public Parking getCase5(boolean isCreate) {
		
		Integer position = 6;
		GregorianCalendar checkIn = new GregorianCalendar(2019,1,2,2,0,0);
		GregorianCalendar checkOut = isCreate ? null : new GregorianCalendar(2019,1,2,12,0,0);
		
		ParkingState parkingState = ParkingState.CHECKED_IN;
		
		VehicleType vehicleType = VehicleType.MOTORCYCLE;
		String badge = "AGH-761";
		Integer engineCapacity = 650;
		
		Money price = new Money("COP",null);
		Motorcycle vehicle = new Motorcycle(vehicleType, badge, engineCapacity);
		
		Parking p = new Parking(position, parkingState, price, vehicle, checkIn, checkOut);
		
		return p;
	}
	
	// Case 6 : MOTORCYCLE: OK < 500 CC
	public Parking getCase6(boolean isCreate) {
		
		Integer position = 1;
		GregorianCalendar checkIn = new GregorianCalendar(2018,11,31,20,0,0);
		GregorianCalendar checkOut = isCreate ? null : new GregorianCalendar(2019,0,2,20,59,59);
		
		ParkingState parkingState = ParkingState.CHECKED_IN;
		
		VehicleType vehicleType = VehicleType.MOTORCYCLE;
		String badge = "LGH-761";
		Integer engineCapacity = 150;
		
		Money price = new Money("COP",null);
		Motorcycle vehicle = new Motorcycle(vehicleType, badge, engineCapacity);
		
		Parking p = new Parking(position, parkingState, price, vehicle, checkIn, checkOut);
		
		return p;
	}
	
	// Case 7 : CAR: OK
	public Parking getCase7(boolean isCreate) {
		
		Integer position = 10;
		GregorianCalendar checkIn = new GregorianCalendar(2019,0,31,22,0,0);
		GregorianCalendar checkOut = isCreate ? null : new GregorianCalendar(2019,1,2,1,0,0);
		
		ParkingState parkingState = ParkingState.CHECKED_IN;
		
		VehicleType vehicleType = VehicleType.CAR;
		String badge = "AGH-761";
		Integer engineCapacity = 0;
		
		Money price = new Money("COP",null);
		Motorcycle vehicle = new Motorcycle(vehicleType, badge, engineCapacity);
		
		Parking p = new Parking(position, parkingState, price, vehicle, checkIn, checkOut);
		
		return p;
	}
}
