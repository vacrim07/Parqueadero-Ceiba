package com.example.inadn.demo.model.impl;

import java.util.Date;

import com.example.inadn.demo.model.impl.consts.ParkingState;

public class Parking {
	
	private static Integer position;
	
	private ParkingState state;
	
	private Money price;
	
	private Vehicle vehicle;
	
	private Date startDate;
	
	private Date endDate;

	public Parking() {
		super();
	}

	public Parking(Integer position, ParkingState state, Money price, com.example.inadn.demo.model.impl.Vehicle vehicle,
			Date startDate, Date endDate) {
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
