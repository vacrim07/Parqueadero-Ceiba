package com.example.inadn.demo.controller.buissinesRules.impl;

public class Traffic {
	
	public Integer vehicleCheckOut(Integer position) {
		return position > 0 ? position - 1 : 0;
	}

}
