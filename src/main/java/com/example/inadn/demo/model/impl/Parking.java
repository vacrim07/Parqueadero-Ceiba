package com.example.inadn.demo.model.impl;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.inadn.demo.model.impl.consts.ParkingStateEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Parking implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer position;
	
	private ParkingStateEnum state;
	
	@JsonFormat(pattern="yyyy-MM-dd@HH:mm:ss.SSSZ")
	private GregorianCalendar startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd@HH:mm:ss.SSSZ")
	private GregorianCalendar endDate;
	
	@Embedded
	private Money price;

	@OneToOne
	@JoinColumn(name="vehicle")
	private Vehicle vehicle;

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
