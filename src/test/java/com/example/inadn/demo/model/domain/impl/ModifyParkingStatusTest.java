package com.example.inadn.demo.model.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.domain.impl.mock.ParkingMock;
import com.example.inadn.demo.model.impl.Motorcycle;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingState;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class ModifyParkingStatusTest {
	
	ModifyParkingStatus modify;
	
	@Before
	public void start() {
		modify = new ModifyParkingStatus();
	}
	
	@After
	public void stop() {
		modify = null;
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
	public void parkingHours() {
		
		GregorianCalendar checkInOne = new GregorianCalendar(2018,11,31,20,55,0);
		GregorianCalendar checkOutOne = new GregorianCalendar(2019,0,2,20,20,59);
		
		Integer case1 = modify.parkingHours(checkInOne, checkOutOne);
		
		assertEquals(new Integer(47),case1);
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
		
		// Case 1 : CAR: OK
		Parking p1 = new ParkingMock().getCase7(false);
		// Case 2 : MOTORCYCLE: > 500 CC : With CAR restrictions ---> No problem
		Parking p2 = new ParkingMock().getCase5(false);
		// Case 3 : MOTORCYCLE: OK < 500 CC
		Parking p3 = new ParkingMock().getCase6(false);
		
		ModifyParkingStatus response1 = new ModifyParkingStatus(p1);
		ModifyParkingStatus response2 = new ModifyParkingStatus(p2);
		ModifyParkingStatus response3 = new ModifyParkingStatus(p3);
		
		// Response 1
		assertEquals(new Integer(27), response1.parkingHours(p1.getStartDate(), p1.getEndDate()));
		assertEquals(false, response1.isBonusMotorcycleRequired(((Motorcycle) p1.getVehicle()).getEngineCapacity()));
		assertEquals(new BigDecimal(11000), response1.getParking().getPrice().getAmount());
		assertEquals(ParkingState.CHECKED_OUT.getState(), response1.getParking().getState().getState());
		assertEquals(9, response1.getParking().getPosition().intValue());
		// Response 2
		assertEquals(new Integer(10), response2.parkingHours(p2.getStartDate(), p2.getEndDate()));
		assertEquals(true, response2.isBonusMotorcycleRequired(((Motorcycle) p2.getVehicle()).getEngineCapacity()));
		assertEquals(new BigDecimal(6000), response2.getParking().getPrice().getAmount());
		assertEquals(ParkingState.CHECKED_OUT.getState(), response2.getParking().getState().getState());
		assertEquals(5, response2.getParking().getPosition().intValue());
		// Response 3
		assertEquals(new Integer(48), response3.parkingHours(p3.getStartDate(), p3.getEndDate()));
		assertEquals(false, response3.isBonusMotorcycleRequired(((Motorcycle) p3.getVehicle()).getEngineCapacity()));
		assertEquals(new BigDecimal(8000), response3.getParking().getPrice().getAmount());
		assertEquals(ParkingState.CHECKED_OUT.getState(), response3.getParking().getState().getState());
		assertEquals(0, response3.getParking().getPosition().intValue());
	}

}
