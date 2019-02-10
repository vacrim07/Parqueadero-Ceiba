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
		
		p.setPosition(1);
		ModifyParkingStatus modify = new ModifyParkingStatus(p);
		
		int case1 = modify.vehicleCheckOut(p.getPosition());
		int case2 = modify.vehicleCheckOut(p.getPosition()-1);
		
		assertEquals(0,case1);
		assertEquals(0,case2);
	}

}
