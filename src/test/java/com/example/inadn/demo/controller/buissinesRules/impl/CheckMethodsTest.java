package com.example.inadn.demo.controller.buissinesRules.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.controller.buissinesRules.impl.*;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class CheckMethodsTest {
	
	CheckMethods methods = null;
	private final Integer number = 2;
	
	@Before
	public void setUp() {
		methods = new CheckMethods();
	}
	
	@Test
	public void testMethod(Integer number) {
		assertEquals(true, methods.testMethod(number));
	}

}
