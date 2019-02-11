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
import com.example.inadn.demo.model.impl.Motorcycle;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.Vehicle;
import com.example.inadn.demo.model.impl.consts.ParkingState;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class ModifyParkingStatusTest {
	
	ModifyParkingStatus modify;
	
	@Before
	public void setUp() {
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
		
		Parking p1 = new Parking();
		Parking p2 = new Parking();
		Parking p3 = new Parking();
		
		// Response 1 : CAR
		Integer position1 = 10;
		Integer engineCapacity1 = 0;
		GregorianCalendar checkIn1 = new GregorianCalendar(2018,11,31,20,0,0);
		GregorianCalendar checkOut1 = new GregorianCalendar(2019,0,2,20,59,59);
		Motorcycle vehicle1 = new Motorcycle();
		vehicle1.setEngineCapacity(engineCapacity1);
		vehicle1.setType(VehicleType.CAR);
		p1.setVehicle(vehicle1);
		p1.setPosition(position1);
		p1.setStartDate(checkIn1);
		p1.setEndDate(checkOut1);
		
		// Response 2 : MOTORCYCLE > 500 CC
		Integer position2 = 6;
		Integer engineCapacity2 = 650;
		GregorianCalendar checkIn2 = new GregorianCalendar(2019,1,2,20,0,0);
		GregorianCalendar checkOut2 = new GregorianCalendar(2019,1,2,20,59,59);
		Motorcycle vehicle2 = new Motorcycle();
		vehicle2.setEngineCapacity(engineCapacity2);
		vehicle2.setType(VehicleType.MOTORCYCLE);
		p2.setVehicle(vehicle2);
		p2.setPosition(position2);
		p2.setStartDate(checkIn2);
		p2.setEndDate(checkOut2);
		
		// Response 3 : MOTORCYCLE < 500 CC
		Integer position3 = 1;
		Integer engineCapacity3 = 150;
		GregorianCalendar checkIn3 = new GregorianCalendar(2018,11,31,20,0,0);
		GregorianCalendar checkOut3 = new GregorianCalendar(2019,0,2,20,59,59);
		Motorcycle vehicle3 = new Motorcycle();
		vehicle3.setEngineCapacity(engineCapacity3);
		vehicle3.setType(VehicleType.MOTORCYCLE);
		p3.setVehicle(vehicle3);
		p3.setPosition(position3);
		p3.setStartDate(checkIn3);
		p3.setEndDate(checkOut3);
		
		
		
		ModifyParkingStatus response1 = new ModifyParkingStatus(p1);
		ModifyParkingStatus response2 = new ModifyParkingStatus(p2);
		
		// Response 1
		assertEquals(new Integer(48), response1.parkingHours(checkIn1, checkOut1));
		assertEquals(false, response1.isBonusMotorcycleRequired(engineCapacity1));
		assertEquals(new BigDecimal(16000), response1.getParking().getPrice().getAmount());
		assertEquals(ParkingState.CHECKED_OUT.getState(), response1.getParking().getState().getState());
		assertEquals(9, response1.getParking().getPosition().intValue());
		// Response 2
		assertEquals(new Integer(0), response2.parkingHours(checkIn2, checkOut2));
		assertEquals(true, response2.isBonusMotorcycleRequired(engineCapacity2));
		assertEquals(new BigDecimal(2000), response2.getParking().getPrice().getAmount());
		assertEquals(ParkingState.CHECKED_OUT.getState(), response2.getParking().getState().getState());
		assertEquals(5, response2.getParking().getPosition().intValue());
		// Response 3
		assertEquals(new Integer(48), response1.parkingHours(checkIn1, checkOut1));
		assertEquals(false, response1.isBonusMotorcycleRequired(engineCapacity1));
		assertEquals(new BigDecimal(8000), response1.getParking().getPrice().getAmount());
		assertEquals(ParkingState.CHECKED_OUT.getState(), response1.getParking().getState().getState());
		assertEquals(0, response1.getParking().getPosition().intValue());
	}

}
