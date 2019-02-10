package com.example.inadn.demo.model.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.domain.impl.consts.MaximumVehiclesPerType;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class CreateParkingStateTest {
	
	Parking p;
	
	@Before
	public void setUp() {
		p = new Parking();
	}
	
	@Test
	public void getMaximumVehicles() {
		
		String car = VehicleType.CAR.getType();
		String motorcycle = VehicleType.MOTORCYCLE.getType();
		CreateParkingState create = new CreateParkingState();
	
		Integer case1 = create.getMaximumVehicles(car);
		Integer case2 = create.getMaximumVehicles(motorcycle);
		
		assertEquals(new Integer(20),case1);
		assertEquals(new Integer(10),case2);
	}
	
	@Test
	public void isParkingAvailable() {
		
		Integer positionCar = 21;
		Integer positionMotorcycle = 11;
		CreateParkingState create = new CreateParkingState();
		
		boolean case1 = create.isParkingAvailable(positionCar, MaximumVehiclesPerType.CAR.getMaximum());
		boolean case2 = create.isParkingAvailable(positionMotorcycle, MaximumVehiclesPerType.MOTORCYCLE.getMaximum());
		boolean case3 = create.isParkingAvailable(positionCar-1, MaximumVehiclesPerType.CAR.getMaximum());
		boolean case4 = create.isParkingAvailable(positionMotorcycle-1, MaximumVehiclesPerType.MOTORCYCLE.getMaximum());
		
		assertEquals(false,case1);
		assertEquals(false,case2);
		assertEquals(true,case3);
		assertEquals(true,case4);
	}
}
