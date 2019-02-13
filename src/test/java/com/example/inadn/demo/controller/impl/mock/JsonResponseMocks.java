package com.example.inadn.demo.controller.impl.mock;

public class JsonResponseMocks {
	
	private String caseCarCreateOk =
			
			"{\"position\":19,\"state\":\"checked in\",\"startDate\":"
			+ "\"2018-12-31@22:00:00.000+0000\",\"endDate\":null,\"price\":"
			+ "{\"currency\":\"COP\",\"amount\":0},\"vehicle\":{\"type\":"
			+ "\"car\",\"name\":\"car\",\"badge\":\"AGH-761\"}}";

	private String caseMotorcycleCreateOk =
			
			"{\"position\":9,\"state\":\"checked in\",\"startDate\":"
			+ "\"2019-01-10@22:00:00.000+0000\",\"endDate\":null,\"price\":"
			+ "{\"currency\":\"COP\",\"amount\":0},\"vehicle\":{\"type\":"
			+ "\"motorcycle\",\"name\":\"motorcycle\",\"badge\":\"AGH-761\","
			+ "\"engineCapacity\":600}}";
	
	private String caseCarModifyOk =
			
			"{\"position\":9,\"state\":\"checked out\",\"startDate\":\"2019-01-13@22:00:00.000+0000\","
			+ "\"endDate\":\"2019-01-15@22:00:00.000+0000\",\"price\":{\"currency\":"
			+ "\"COP\",\"amount\":16000},\"vehicle\":{\"type\":\"car\",\"name\":\"car\","
			+ "\"badge\":\"AGH-761\"}}";
	
	private String caseMotorcycleModifyOk =
			
			"{\"position\":9,\"state\":\"checked out\",\"startDate\":"
			+ "\"2019-01-13@22:00:00.000+0000\",\"endDate\":\"2019-01-15@22:00:00.000+0000\","
			+ "\"price\":{\"currency\":\"COP\",\"amount\":10000},\"vehicle\":{\"type\":"
			+ "\"motorcycle\",\"name\":\"motorcycle\",\"badge\":\"AGH-761\","
			+ "\"engineCapacity\":600}}";

	public String getCaseCarCreateOk() {
		return caseCarCreateOk;
	}

	public String getCaseMotorcycleCreateOk() {
		return caseMotorcycleCreateOk;
	}

	public String getCaseCarModifyOk() {
		return caseCarModifyOk;
	}

	public String getCaseMotorcycleModifyOk() {
		return caseMotorcycleModifyOk;
	}
}
