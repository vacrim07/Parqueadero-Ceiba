package com.example.inadn.demo.model.impl;

import java.util.GregorianCalendar;

import com.example.inadn.demo.model.impl.consts.ParkingState;

public class Parking {
	
	private static Integer position;
	
	private ParkingState state;
	
	private Money price;
	
	private Vehicle vehicle;
	
	private GregorianCalendar startDate;
	
	private GregorianCalendar endDate;

	public Parking() {
		super();
	}

	public Parking(Integer position, ParkingState state, Money price, Vehicle vehicle,
			GregorianCalendar startDate, GregorianCalendar endDate) {
		super();
		Parking.position++;
		this.state = state;
		this.price = price;
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public static Integer getPosition() {
		return position;
	}

	public ParkingState getState() {
		return state;
	}

	public void setState(ParkingState state) {
		this.state = state;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public GregorianCalendar getStartDate() {
		return startDate;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}
	
}
