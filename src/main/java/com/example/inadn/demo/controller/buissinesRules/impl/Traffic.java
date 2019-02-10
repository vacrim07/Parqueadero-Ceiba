package com.example.inadn.demo.controller.buissinesRules.impl;

public class Traffic {
	
	public Integer vehicleOut(Integer position) {
		return position > 0 ? position-- : 0;
	}

}
