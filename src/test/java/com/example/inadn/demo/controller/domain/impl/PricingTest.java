package com.example.inadn.demo.controller.domain.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class PricingTest {
	
	@Test
	public void isBonusMotorcycleRequired() {
		
		Integer engineCapacityOne = 500;
		Integer engineCapacityTwo = 501;
		
		Pricing pricing= new Pricing();
		boolean caseOne = pricing.isBonusMotorcycleRequired(engineCapacityOne);
		boolean caseTwo = pricing.isBonusMotorcycleRequired(engineCapacityTwo);
		
		assertEquals(false,caseOne);
		assertEquals(true,caseTwo);
	}
	
}
