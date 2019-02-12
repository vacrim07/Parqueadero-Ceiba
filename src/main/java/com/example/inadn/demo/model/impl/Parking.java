package com.example.inadn.demo.model.impl;

import java.util.GregorianCalendar;
import com.example.inadn.demo.model.impl.consts.ParkingStateEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Parking {
	
	private Integer position;
	
	private ParkingStateEnum state;
	
	@JsonSerialize()
	private Money price;
	

	private Vehicle vehicle;
	
	@JsonFormat(pattern="yyyy-MM-dd@HH:mm:ss.SSSZ")
	private GregorianCalendar startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd@HH:mm:ss.SSSZ")
	private GregorianCalendar endDate;

	public Parking() {
		super();
	}

	public Parking(Integer position, ParkingStateEnum state, Money price, Vehicle vehicle,
			GregorianCalendar startDate, GregorianCalendar endDate) {
		super();
		this.position = position;
		this.state = state;
		this.price = price;
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public ParkingStateEnum getState() {
		return state;
	}

	public void setState(ParkingStateEnum state) {
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
