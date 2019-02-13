package com.example.inadn.demo.model.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.domain.impl.consts.MaximumVehiclesPerTypeEnum;
import com.example.inadn.demo.model.domain.impl.mock.ParkingMock;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingStateEnum;
import com.example.inadn.demo.model.impl.consts.VehicleTypeEnum;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class CreateParkingTest {
	
	CreateParking create;
	
	@Before
	public void setUp() {
		create = new CreateParking();
	}
	
	@After
	public void stop() {
		create = null;
	}
	
	@Test
	public void getMaximumVehicles() {
		
		String car = VehicleTypeEnum.CAR.getType();
		String motorcycle = VehicleTypeEnum.MOTORCYCLE.getType();
	
		Integer case1 = create.getMaximumVehicles(car);
		Integer case2 = create.getMaximumVehicles(motorcycle);
		
		assertEquals(new Integer(20),case1);
		assertEquals(new Integer(10),case2);
	}
	
	@Test
	public void isParkingAvailable() {
		
		Integer positionCar = 21;
		Integer positionMotorcycle = 11;
		
		boolean case1 = create.isParkingAvailable(positionCar, MaximumVehiclesPerTypeEnum.CAR.getMaximum());
		boolean case2 = create.isParkingAvailable(positionMotorcycle, MaximumVehiclesPerTypeEnum.MOTORCYCLE.getMaximum());
		boolean case3 = create.isParkingAvailable(positionCar-1, MaximumVehiclesPerTypeEnum.CAR.getMaximum());
		boolean case4 = create.isParkingAvailable(positionMotorcycle-1, MaximumVehiclesPerTypeEnum.MOTORCYCLE.getMaximum());
		
		assertEquals(false,case1);
		assertEquals(false,case2);
		assertEquals(true,case3);
		assertEquals(true,case4);
	}
	
	@Test
	public void isVehicleRestricted() {
		
		String car = VehicleTypeEnum.CAR.getType();
		String motorcycle = VehicleTypeEnum.MOTORCYCLE.getType();
		
		boolean case1 = create.isVehicleRestricted(car);
		boolean case2 = create.isVehicleRestricted(motorcycle);
		
		assertEquals(true,case1);
		assertEquals(false,case2);
	}
	
	@Test
	public void isBadgeRestricted() {
		
		String badge1 = "AFG-754";
		String badge2 = "FTM-921";
		
		boolean case1 = create.isBadgeRestricted(badge1);
		boolean case2 = create.isBadgeRestricted(badge2);
		
		assertEquals(true,case1);
		assertEquals(false,case2);
	}
	
	@Test
	public void isARestrictedDay() {
		
		Integer sunday = Calendar.SUNDAY;
		Integer monday = Calendar.MONDAY;
		Integer tuesday = Calendar.TUESDAY;
		
		boolean case1 = create.isARestrictedDay(sunday);
		boolean case2 = create.isARestrictedDay(monday);
		boolean case3 = create.isARestrictedDay(tuesday);
		
		assertEquals(false,case1);
		assertEquals(false,case2);
		assertEquals(true,case3);
	}
	
	@Test
	public void isAnAllowedCar() {
		
		boolean badgeRestricted = true;
		boolean dayRestricted = true;
		
		boolean case1 = create.isAnAllowedCar(badgeRestricted, dayRestricted);
		boolean case2 = create.isAnAllowedCar(!badgeRestricted, dayRestricted);
		boolean case3 = create.isAnAllowedCar(badgeRestricted, !dayRestricted);
		boolean case4 = create.isAnAllowedCar(!badgeRestricted, !dayRestricted);
		
		assertEquals(false,case1);
		assertEquals(true,case2);
		assertEquals(true,case3);
		assertEquals(true,case4);
	}
	
	@Test
	public void createParkingResponse() {
		
		
		// Case 1 : CAR: Parking is full
		Parking p1 = new ParkingMock().getCase1(true);
		// Case 2 : CAR: Restricted by badge, but not by day
		Parking p2 = new ParkingMock().getCase2(true);
		// Case 3 : CAR: Restricted not by badge, restricted by day
		Parking p3 = new ParkingMock().getCase3(true);
		// Case 4 : MOTORCYCLE: Parking is full
		Parking p4 = new ParkingMock().getCase4(true);
		// Case 5 : MOTORCYCLE: > 500 CC : With CAR restrictions ---> No problem
		Parking p5 = new ParkingMock().getCase5(true);
		// Case 6 : MOTORCYCLE: OK < 500 CC
		Parking p6 = new ParkingMock().getCase6(true);
		
		CreateParking response1 = new CreateParking(p1);
		CreateParking response2 = new CreateParking(p2);
		CreateParking response3 = new CreateParking(p3);
		CreateParking response4 = new CreateParking(p4);
		CreateParking response5 = new CreateParking(p5);
		CreateParking response6 = new CreateParking(p6);
		
		// Response 1		
		assertEquals(new Integer(20), response1.getMaximumVehicles(VehicleTypeEnum.CAR.getType()));
		assertEquals(false, response1.isParkingAvailable(p1.getPosition(), response1.getMaximumVehicles(VehicleTypeEnum.CAR.getType())));
		assertEquals(true, response1.isVehicleRestricted(response1.getParking().getVehicle().getName().getType()));
		assertEquals(false, response1.isBadgeRestricted(response1.getParking().getVehicle().getBadge()));
		assertEquals(false, response1.isARestrictedDay(response1.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingStateEnum.NOT_ALLOWED.getState(), response1.getParking().getState().getState());
		assertNotEquals(p1,response1.getParking());
		// Response 2
		assertEquals(new Integer(20), response2.getMaximumVehicles(VehicleTypeEnum.CAR.getType()));
		assertEquals(true, response2.isParkingAvailable(p2.getPosition(), response2.getMaximumVehicles(VehicleTypeEnum.CAR.getType())));
		assertEquals(true, response2.isVehicleRestricted(response2.getParking().getVehicle().getName().getType()));
		assertEquals(true, response2.isBadgeRestricted(response2.getParking().getVehicle().getBadge()));
		assertEquals(false, response2.isARestrictedDay(response2.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingStateEnum.CHECKED_IN.getState(), response2.getParking().getState().getState());
		assertEquals(p2,response2.getParking());
		// Response 3
		assertEquals(new Integer(20), response3.getMaximumVehicles(VehicleTypeEnum.CAR.getType()));
		assertEquals(true, response3.isParkingAvailable(p3.getPosition(), response3.getMaximumVehicles(VehicleTypeEnum.CAR.getType())));
		assertEquals(true, response3.isVehicleRestricted(response3.getParking().getVehicle().getName().getType()));
		assertEquals(true, response3.isBadgeRestricted(response3.getParking().getVehicle().getBadge()));
		assertEquals(true, response3.isARestrictedDay(response3.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingStateEnum.NOT_ALLOWED.getState(), response3.getParking().getState().getState());
		assertNotEquals(p3,response3.getParking());
		// Response 4
		assertEquals(new Integer(10), response4.getMaximumVehicles(VehicleTypeEnum.MOTORCYCLE.getType()));
		assertEquals(false, response4.isParkingAvailable(p4.getPosition(), response4.getMaximumVehicles(VehicleTypeEnum.MOTORCYCLE.getType())));
		assertEquals(false, response4.isVehicleRestricted(response4.getParking().getVehicle().getName().getType()));
		assertEquals(false, response4.isBadgeRestricted(response4.getParking().getVehicle().getBadge()));
		assertEquals(false, response4.isARestrictedDay(response4.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingStateEnum.NOT_ALLOWED.getState(), response4.getParking().getState().getState());
		assertNotEquals(p4,response4.getParking());
		// Response 5
		assertEquals(new Integer(10), response5.getMaximumVehicles(VehicleTypeEnum.MOTORCYCLE.getType()));
		assertEquals(true, response5.isParkingAvailable(p5.getPosition(), response5.getMaximumVehicles(VehicleTypeEnum.MOTORCYCLE.getType())));
		assertEquals(false, response5.isVehicleRestricted(response5.getParking().getVehicle().getName().getType()));
		assertEquals(true, response5.isBadgeRestricted(response5.getParking().getVehicle().getBadge()));
		assertEquals(true, response5.isARestrictedDay(response5.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingStateEnum.CHECKED_IN.getState(), response5.getParking().getState().getState());
		assertEquals(p5,response5.getParking());
		// Response 6
		assertEquals(new Integer(10), response6.getMaximumVehicles(VehicleTypeEnum.MOTORCYCLE.getType()));
		assertEquals(true, response6.isParkingAvailable(p6.getPosition(), response6.getMaximumVehicles(VehicleTypeEnum.MOTORCYCLE.getType())));
		assertEquals(false, response6.isVehicleRestricted(response6.getParking().getVehicle().getName().getType()));
		assertEquals(false, response6.isBadgeRestricted(response6.getParking().getVehicle().getBadge()));
		assertEquals(false, response6.isARestrictedDay(response6.getParking().getStartDate().get(Calendar.DAY_OF_WEEK)));
		assertEquals(ParkingStateEnum.CHECKED_IN.getState(), response6.getParking().getState().getState());
		assertEquals(p6,response6.getParking());
	}
}
