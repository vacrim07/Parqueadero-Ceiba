package com.example.inadn.demo.model.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.example.inadn.demo.model.impl.consts.VehicleTypeEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@Type(value = Motorcycle.class, name = "motorcycle"),@Type(value = Car.class, name = "car")})
public abstract class Vehicle implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	protected Integer id;
	
	private VehicleTypeEnum name;
	
	private String badge;


	public Vehicle() {
	}

	public Vehicle(VehicleTypeEnum name, String badge) {
		this.name = name;
		this.badge = badge;
	}

	public VehicleTypeEnum getName() {
		return name;
	}

	public void setName(VehicleTypeEnum type) {
		this.name = type;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
