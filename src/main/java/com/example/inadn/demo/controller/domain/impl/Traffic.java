package com.example.inadn.demo.controller.domain.impl;

public class Traffic {
	
	public Integer vehicleCheckOut(Integer position) {
		return position > 0 ? position - 1 : 0;
	}

}
