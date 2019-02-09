package com.example.inadn.demo.controller.buissinesRules.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.controller.buissinesRules.impl.*;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class CheckMethodsTest {
	
	
	@Test
	public void testMethod() {
		Integer number = 2;
		CheckMethods testCheckMethods = new CheckMethods();
		assertEquals(true, testCheckMethods.testMethod(number));
	}

}
