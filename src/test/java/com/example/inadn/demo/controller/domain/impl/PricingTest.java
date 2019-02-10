package com.example.inadn.demo.controller.domain.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.impl.consts.VehicleType;

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
	
	@Test
	public void parkingPricing() {
		
		boolean bonus = true;
		String car = VehicleType.CAR.getType();
		String motorcycle = VehicleType.MOTORCYCLE.getType();
		Integer timeOne = 10;
		Integer timeTwo = 50;
		Integer timeThree = 1;
		
		Pricing pricing= new Pricing();
		BigDecimal caseOne = pricing.parkingPricing(timeOne, car, !bonus);
		BigDecimal caseTwo = pricing.parkingPricing(timeOne, motorcycle, bonus);
		BigDecimal caseThree = pricing.parkingPricing(timeTwo, car, !bonus);
		BigDecimal caseFour = pricing.parkingPricing(timeTwo, motorcycle, !bonus);
		BigDecimal caseFive = pricing.parkingPricing(timeThree, car, !bonus);
		BigDecimal caseSix = pricing.parkingPricing(timeThree, motorcycle, bonus);
		
		
		assertEquals(new BigDecimal(8000),caseOne);
		assertEquals(new BigDecimal(6000),caseTwo);
		assertEquals(new BigDecimal(18000),caseThree);
		assertEquals(new BigDecimal(9000),caseFour);
		assertEquals(new BigDecimal(1000),caseFive);
		assertEquals(new BigDecimal(2500),caseSix);
	}
	
}
