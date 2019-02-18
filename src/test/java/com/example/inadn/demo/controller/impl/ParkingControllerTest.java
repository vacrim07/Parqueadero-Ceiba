package com.example.inadn.demo.controller.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.inadn.demo.controller.impl.consts.MessagesEnum;
import com.example.inadn.demo.controller.impl.mock.JsonRequestsMocks;
import com.example.inadn.demo.controller.impl.mock.JsonResponseMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private ParkingController controller;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createParkingTestResponse400NoPayload() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.post("/parking")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void createParkingTestCarResponse201() throws Exception{
		
		String jsonRequest = new JsonRequestsMocks().getCaseCarCreateOk();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/parking")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonRequest))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void createParkingTestMotorcycleResponse201() throws Exception{
		
		String jsonRequest = new JsonRequestsMocks().getCaseMotorcycleCreateOk();
		String jsonResponse = new JsonResponseMocks().getCaseMotorcycleCreateOk();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/parking")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonRequest))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

}
