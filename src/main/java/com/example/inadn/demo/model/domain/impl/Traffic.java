package com.example.inadn.demo.model.domain.impl;

import com.example.inadn.demo.model.domain.ITraffic;

public class Traffic implements ITraffic{
	
	@Override
	public Integer vehicleCheckOut(Integer position) {
		return position > 0 ? position - 1 : 0;
	}

}
