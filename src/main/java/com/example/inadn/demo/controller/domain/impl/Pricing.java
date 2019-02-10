package com.example.inadn.demo.controller.domain.impl;

import com.example.inadn.demo.controller.domain.impl.consts.MotorcycleEngineCapacity;

public class Pricing {
	
	public boolean isBonusMotorcycleRequired(Integer engineCapacity) {
		return engineCapacity > MotorcycleEngineCapacity.TOP.getValue() ? true : false;
	}

}
