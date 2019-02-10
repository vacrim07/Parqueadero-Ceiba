package com.example.inadn.demo.model.domain.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.impl.Parking;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class ModifyParkingStatusTest {
	
	@Test
	public void vehicleCheckOut() {
		
		Parking p = new Parking();
		
		Integer numberOne = 1;
		Integer numberTwo = 0;
		ModifyParkingStatus modify = new ModifyParkingStatus(p);
		
		
//		modify.getParking().setPosition(numberOne);
//		int case1 = modify.vehicleCheckOut(p.getPosition());
//		modify.getParking().setPosition(numberTwo);
//		int case2 = modify.vehicleCheckOut(p.getPosition());
//		
//		assertEquals(0,case1);
//		assertEquals(0,case2);
	}

}
