package com.example.inadn.demo.controller.impl.mock;

public class JsonResponseMocks {
	
	private String caseCarIsOk =
			
			"{\"position\":19,\"state\":\"checked in\",\"startDate\":"
			+ "\"2018-12-31@22:00:00.000+0000\",\"endDate\":null,\"price\":"
			+ "{\"currency\":\"COP\",\"amount\":0},\"vehicle\":{\"type\":"
			+ "\"car\",\"name\":\"car\",\"badge\":\"AGH-761\"}}";

	private String caseMotorcycleIsOk =
			
			"{\"position\":9,\"state\":\"checked in\",\"startDate\":"
			+ "\"2019-01-10@22:00:00.000+0000\",\"endDate\":null,\"price\":"
			+ "{\"currency\":\"COP\",\"amount\":0},\"vehicle\":{\"type\":"
			+ "\"motorcycle\",\"name\":\"motorcycle\",\"badge\":\"AGH-761\","
			+ "\"engineCapacity\":600}}";

	public String getCaseCarIsOk() {
		return caseCarIsOk;
	}

	public String getCaseMotorcycleIsOk() {
		return caseMotorcycleIsOk;
	}
}
