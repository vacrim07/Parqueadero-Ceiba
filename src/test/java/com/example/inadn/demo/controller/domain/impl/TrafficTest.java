package com.example.inadn.demo.controller.domain.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.controller.domain.impl.Traffic;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class TrafficTest {
	
	@Test
	public void vehicleCheckOut() {
		
		Integer numberOne = 1;
		Integer numberTwo = 0;
		
		Traffic traffic = new Traffic();
		int caseOne = traffic.vehicleCheckOut(numberOne);
		int caseTwo = traffic.vehicleCheckOut(numberTwo);
		
		assertEquals(0,caseOne);
		assertEquals(0,caseTwo);
	}

}
