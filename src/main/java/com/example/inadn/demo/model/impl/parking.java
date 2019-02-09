package com.example.inadn.demo.model.impl;

import java.util.Date;

import com.example.inadn.demo.model.impl.consts.parkingState;

public class parking {
	
	private Integer id;
	
	private parkingState state;
	
	private money price;
	
	private vehicle vehicle;
	
	private Date startDate;
	
	private Date endDate;

	public parking() {
		super();
	}

	public parking(Integer id, parkingState state, money price, com.example.inadn.demo.model.impl.vehicle vehicle,
			Date startDate, Date endDate) {
		super();
		this.id = id;
		this.state = state;
		this.price = price;
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public parkingState getState() {
		return state;
	}

	public void setState(parkingState state) {
		this.state = state;
	}

	public money getPrice() {
		return price;
	}

	public void setPrice(money price) {
		this.price = price;
	}

	public vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(vehicle vehicle) {
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
