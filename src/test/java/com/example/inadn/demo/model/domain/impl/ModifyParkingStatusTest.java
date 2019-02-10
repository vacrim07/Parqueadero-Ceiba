package com.example.inadn.demo.model.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.impl.Parking;
import com.example.inadn.demo.model.impl.consts.ParkingState;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class ModifyParkingStatusTest {
	
	Parking p;
	
	@Before
	public void setUp() {
		p = new Parking();
	}
	
	@Test
	public void vehicleCheckOut() {
		
		Integer position = 1;
		p.setPosition(position);
		
		ModifyParkingStatus modify = new ModifyParkingStatus(p);
		
		int case1 = modify.vehicleCheckOut(position);
		Integer case2 = modify.vehicleCheckOut(p.getPosition()-1);
		
		assertEquals(0,case1);
		assertNull(case2);
	}
	
	@Test
	public void modifyParkingStatusResponse() {
		
		p.setPosition(10);
		
		ModifyParkingStatus response = new ModifyParkingStatus(p);
		
		assertEquals(ParkingState.CHECKED_OUT.getState(),response.getParking().getState().getState());
		assertEquals(9,response.getParking().getPosition().intValue());
	}

}
