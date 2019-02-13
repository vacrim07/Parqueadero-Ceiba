package com.example.inadn.demo.controller.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.model.domain.impl.mock.ParkingMock;
import com.example.inadn.demo.model.impl.Parking;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class ParkingControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	
	// Como se cual json de entrada tengo???
	@Test
	public void createParkingOK() throws Exception{
		String jsonContent = "jdas";
		this.mockMvc.perform(post("/parking")).andExpect(status().isCreated()).
		andExpect(content().json(jsonContent ));
	}
	
	// Test de integración:
	// https://www.tutorialspoint.com/spring_boot/spring_boot_rest_controller_unit_test.htm
	
	// Cosas por hacer:
	// 1 Ver q no me tiré nada. Ver los createParkingTest y modifyParkingTest
	// 2 pruebas unitarias de createParking method (Ver createParkingTest ultimo assert)
	// 3 Replicar esas pruebas para el modifyParking
	// 4 Intentar hacer la prueba de integración de ámbos métodos

}
