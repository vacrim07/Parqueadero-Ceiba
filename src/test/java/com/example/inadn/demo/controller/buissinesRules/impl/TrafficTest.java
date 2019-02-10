package com.example.inadn.demo.controller.buissinesRules.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.impl.consts.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class TrafficTest {
	
	@Test
	public void vehicleOut() {
		
		Traffic traffic = new Traffic();
		int caseOne = traffic.vehicleOut(10);
		int caseTwo = traffic.vehicleOut(0);
		
		assertEquals(9,caseOne);
		assertEquals(0,caseTwo);
	}

}
