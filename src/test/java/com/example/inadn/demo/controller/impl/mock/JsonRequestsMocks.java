package com.example.inadn.demo.controller.impl.mock;

public class JsonRequestsMocks {
	
	private String caseCarCreateOk =
			
			"{\"position\":19,\"state\":\"checked in\",\"startDate\":"
			+ "\"2019-00-31@22:00:00.000+0000\",\"vehicle\":{\"type\":"
			+ "\"car\",\"name\":\"car\",\"badge\":\"AGH-761\"},\"price\":"
			+ "{\"amount\":0,\"currency\":\"COP\"}}";

	private String caseCarCreateNotOk = 
			
			"{\"position\":19,\"state\":\"checked in\",\"startDate\":"
			+ "\"2019-01-10@22:00:00.000+0000\",\"vehicle\":{\"type\":"
			+ "\"car\",\"name\":\"car\",\"badge\":\"AGH-761\"},\"price\":"
			+ "{\"amount\":0,\"currency\":\"COP\"}}";
	
	private String caseMotorcycleCreateOk =
			
			"{\"position\":9,\"state\":\"checked in\",\"startDate\":"
			+ "\"2019-01-10@22:00:00.000+0000\",\"vehicle\":{\"type\":"
			+ "\"motorcycle\",\"name\":\"motorcycle\",\"badge\":\"AGH-761\","
			+ "\"engineCapacity\":600},\"price\":{\"amount\":0,\"currency\":\"COP\"}}";
	
	private String caseMotorcycleCreateNotOk =
			
			"{\"position\":19,\"state\":\"checked in\",\"startDate\":"
			+ "\"2019-01-10@22:00:00.000+0000\",\"vehicle\":{\"type\":"
			+ "\"motorcycle\",\"name\":\"motorcycle\",\"badge\":\"AGH-761\","
			+ "\"engineCapacity\":600},\"price\":{\"amount\":0,\"currency\":\"COP\"}}";
	
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
