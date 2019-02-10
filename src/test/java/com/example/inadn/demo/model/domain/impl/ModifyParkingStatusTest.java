package com.example.inadn.demo.model.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingState;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class ModifyParkingStatusTest {
	
	Parking p;
	ModifyParkingStatus modify;
	
	@Before
	public void setUp() {
		p = new Parking();
		modify = new ModifyParkingStatus();
	}
	
	@Test
	public void vehicleCheckOut() {
		
		Integer position = 1;
		
		Integer case1 = modify.vehicleCheckOut(position);
		Integer case2 = modify.vehicleCheckOut(position - 1);
		
		assertEquals(new Integer(0),case1);
		assertNull(case2);
	}
	
	@Test
	public void isBonusMotorcycleRequired() {
		
		Integer engineCapacityOne = 500;
		Integer engineCapacityTwo = 501;
		
		boolean case1 = modify.isBonusMotorcycleRequired(engineCapacityOne);
		boolean case2 = modify.isBonusMotorcycleRequired(engineCapacityTwo);
		
		assertEquals(false,case1);
		assertEquals(true,case2);
	}
	
	@Test
	public void pricingHours() {
		
		GregorianCalendar checkInOne = new GregorianCalendar(2018,11,31,20,0,0);
		GregorianCalendar checkOutOne = new GregorianCalendar(2019,0,2,20,59,59);
		
		Integer case1 = modify.parkingHours(checkInOne, checkOutOne);
		
		assertEquals(new Integer(48),case1);
	}
	
	@Test
	public void parkingPricing() {
		
		boolean bonus = true;
		String car = VehicleType.CAR.getType();
		String motorcycle = VehicleType.MOTORCYCLE.getType();
		Integer timeOne = 10;
		Integer timeTwo = 50;
		Integer timeThree = 1;
		
		BigDecimal case1 = modify.parkingPricing(timeOne, car, !bonus);
		BigDecimal case2 = modify.parkingPricing(timeOne, motorcycle, bonus);
		BigDecimal case3 = modify.parkingPricing(timeTwo, car, !bonus);
		BigDecimal case4 = modify.parkingPricing(timeTwo, motorcycle, !bonus);
		BigDecimal case5 = modify.parkingPricing(timeThree, car, !bonus);
		BigDecimal case6 = modify.parkingPricing(timeThree, motorcycle, bonus);
		
		
		assertEquals(new BigDecimal(8000),case1);
		assertEquals(new BigDecimal(6000),case2);
		assertEquals(new BigDecimal(18000),case3);
		assertEquals(new BigDecimal(9000),case4);
		assertEquals(new BigDecimal(1000),case5);
		assertEquals(new BigDecimal(2500),case6);
		
	}
	
	@Test
	public void modifyParkingStatusResponse() {
		
		p.setPosition(10);
		
		ModifyParkingStatus response = new ModifyParkingStatus(p);
		
		assertEquals(ParkingState.CHECKED_OUT.getState(),response.getParking().getState().getState());
		assertEquals(9,response.getParking().getPosition().intValue());
	}

}
