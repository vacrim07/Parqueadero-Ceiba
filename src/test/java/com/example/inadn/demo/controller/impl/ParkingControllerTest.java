package com.example.inadn.demo.controller.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.inadn.demo.DemoApplication;
import com.example.inadn.demo.controller.impl.consts.MessagesEnum;
import com.example.inadn.demo.controller.impl.mock.JsonRequestsMocks;
import com.example.inadn.demo.controller.impl.mock.JsonResponseMocks;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = DemoApplication.class)
public class ParkingControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private ParkingController controller;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
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
		String jsonResponse = new JsonResponseMocks().getCaseCarCreateOk();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/parking")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonRequest))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().json(jsonResponse));
	}
	
	@Test
	public void createParkingTestCarResponse400NotAllowedToPark() throws Exception{
		
		String jsonRequest = new JsonRequestsMocks().getCaseCarCreateNotOk();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/parking")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonRequest))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.content()
				.string(MessagesEnum.NOT_ALLOWED.getMessage()));
	}
	
	@Test
	public void createParkingTestMotorcycleResponse201() throws Exception{
		
		String jsonRequest = new JsonRequestsMocks().getCaseMotorcycleCreateOk();
		String jsonResponse = new JsonResponseMocks().getCaseMotorcycleCreateOk();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/parking")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonRequest))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().json(jsonResponse));
	}
	
	@Test
	public void createParkingTestMotorcycleResponse400NotAllowedToPark() throws Exception{
		
		String jsonRequest = new JsonRequestsMocks().getCaseMotorcycleCreateNotOk();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/parking")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonRequest))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.content()
				.string(MessagesEnum.NOT_ALLOWED.getMessage()));
	}
	
	@Test
	public void modifyParkingTestCarResponse200() throws Exception{
		
		String jsonRequest = new JsonRequestsMocks().getCaseCarModifyOk();
		String jsonResponse = new JsonResponseMocks().getCaseCarModifyOk();
		
		mockMvc.perform(MockMvcRequestBuilders.patch("/parking")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonRequest))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(jsonResponse));
	}
	
	@Test
	public void modifyParkingTestMotorcycleResponse200() throws Exception{
		
		String jsonRequest = new JsonRequestsMocks().getCaseMotorcycleModifyOk();
		String jsonResponse = new JsonResponseMocks().getCaseMotorcycleModifyOk();
		
		mockMvc.perform(MockMvcRequestBuilders.patch("/parking")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonRequest))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(jsonResponse));
	}

}
