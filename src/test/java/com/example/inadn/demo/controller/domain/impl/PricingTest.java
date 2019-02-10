package com.example.inadn.demo.controller.domain.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class PricingTest {
	
	@Autowired
	Pricing pricing;
	
	@Test
	public void isBonusMotorcycleRequired() {
		
		Integer engineCapacityOne = 500;
		Integer engineCapacityTwo = 501;
		
		//Pricing pricing= new Pricing();
		boolean case1 = pricing.isBonusMotorcycleRequired(engineCapacityOne);
		boolean case2 = pricing.isBonusMotorcycleRequired(engineCapacityTwo);
		
		assertEquals(false,case1);
		assertEquals(true,case2);
	}
	
	@Test
	public void pricingHours() {
		
		GregorianCalendar checkInOne = new GregorianCalendar(2018,11,31,20,0,0);
		GregorianCalendar checkOutOne = new GregorianCalendar(2019,0,2,20,59,59);
		
		//Pricing pricing= new Pricing();
		int case1 = pricing.parkingHours(checkInOne, checkOutOne);
		
		assertEquals(48,case1);
	}
	
	@Test
	public void parkingPricing() {
		
		boolean bonus = true;
		String car = VehicleType.CAR.getType();
		String motorcycle = VehicleType.MOTORCYCLE.getType();
		Integer timeOne = 10;
		Integer timeTwo = 50;
		Integer timeThree = 1;
		
		//Pricing pricing= new Pricing();
		BigDecimal case1 = pricing.parkingPricing(timeOne, car, !bonus);
		BigDecimal case2 = pricing.parkingPricing(timeOne, motorcycle, bonus);
		BigDecimal case3 = pricing.parkingPricing(timeTwo, car, !bonus);
		BigDecimal case4 = pricing.parkingPricing(timeTwo, motorcycle, !bonus);
		BigDecimal case5 = pricing.parkingPricing(timeThree, car, !bonus);
		BigDecimal case6 = pricing.parkingPricing(timeThree, motorcycle, bonus);
		
		
		assertEquals(new BigDecimal(8000),case1);
		assertEquals(new BigDecimal(6000),case2);
		assertEquals(new BigDecimal(18000),case3);
		assertEquals(new BigDecimal(9000),case4);
		assertEquals(new BigDecimal(1000),case5);
		assertEquals(new BigDecimal(2500),case6);
		
	}
	
}
