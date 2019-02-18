package com.example.inadn.demo.controller.impl.mock;

public class JsonRequestsMocks {
	
	private String caseCarCreateOk =
			
			"{\"position\":1,\"state\":\"checked in\",\"startDate\":"
			+ "\"2019-00-31@22:00:00.000+0000\",\"vehicle\":{\"id\":1,"
			+ "\"type\":\"car\",\"name\":\"car\",\"badge\":\"AGH-761\"},"
			+ "\"price\":{\"amount\":0,\"currency\":\"COP\"}}";

	private String caseCarCreateNotOk = 
			
			"{\"position\":26,\"state\":\"checked in\",\"startDate\":"
			+ "\"2018-12-31@22:00:00.000+0000\",\"endDate\":null,\"price\":"
			+ "{\"currency\":\"COP\",\"amount\":0},\"vehicle\":{\"type\":"
			+ "\"car\",\"id\":21,\"name\":\"car\",\"badge\":\"AGH-761\"}}";
	
	private String caseMotorcycleCreateOk =
			
			"{\"position\":2,\"state\":\"checked in\",\"startDate\":"
			+ "\"2018-01-20@22:00:00.000+0000\",\"endDate\":null,\"price\":"
			+ "{\"currency\":\"COP\",\"amount\":0},\"vehicle\":{\"type\":"
			+ "\"motorcycle\",\"id\":1,\"name\":\"motorcycle\",\"badge\":"
			+ "\"AGH-761\",\"engineCapacity\":600}}";
	
	private String caseMotorcycleCreateNotOk =
			
			"{\"position\":14,\"state\":\"checked in\",\"startDate\":"
			+ "\"2018-01-20@22:00:00.000+0000\",\"endDate\":null,\"price\":"
			+ "{\"currency\":\"COP\",\"amount\":0},\"vehicle\":{\"type\":"
			+ "\"motorcycle\",\"id\":14,\"name\":\"motorcycle\",\"badge\":"
			+ "\"AGH-761\",\"engineCapacity\":600}}";
	
	private String caseCarModifyOk =
			
			"{\"position\":10,\"state\":\"checked in\",\"startDate\":\"2019-01-13@22:00:00.000+0000\","
			+ "\"endDate\":\"2019-01-15@22:00:00.000+0000\",\"vehicle\":{\"type\":"
			+ "\"car\",\"name\":\"car\",\"badge\":\"AGH-761\"},\"price\":{\"amount\":"
			+ "0,\"currency\":\"COP\"}}";
	
	private String caseMotorcycleModifyOk =
			
			"{\"position\":10,\"state\":\"checked in\",\"startDate\":"
			+ "\"2019-01-13@22:00:00.000+0000\",\"endDate\":\"2019-01-15@22:00:00.000+0000\","
			+ "\"vehicle\":{\"type\":\"motorcycle\",\"name\":\"motorcycle\",\"badge\":"
			+ "\"AGH-761\",\"engineCapacity\":\"600\"},\"price\":{\"amount\":"
			+ "0,\"currency\":\"COP\"}}";

	public String getCaseCarCreateOk() {
		return caseCarCreateOk;
	}

	public String getCaseCarCreateNotOk() {
		return caseCarCreateNotOk;
	}

	public String getCaseMotorcycleCreateOk() {
		return caseMotorcycleCreateOk;
	}

	public String getCaseMotorcycleCreateNotOk() {
		return caseMotorcycleCreateNotOk;
	}

	public String getCaseCarModifyOk() {
		return caseCarModifyOk;
	}

	public String getCaseMotorcycleModifyOk() {
		return caseMotorcycleModifyOk;
	}	
}
