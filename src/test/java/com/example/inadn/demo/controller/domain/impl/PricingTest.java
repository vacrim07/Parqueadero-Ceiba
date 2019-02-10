package com.example.inadn.demo.controller.domain.impl;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
	
	@Test
	public void pricingHours() {
		
		GregorianCalendar checkInOne = new GregorianCalendar(2018,11,31,20,0,0);
		GregorianCalendar checkOutOne = new GregorianCalendar(2019,0,2,20,59,59);
		
		Pricing pricing= new Pricing();
		int caseOne = pricing.parkingHours(checkInOne, checkOutOne);
		
		assertEquals(48,caseOne);
	}
	
}
