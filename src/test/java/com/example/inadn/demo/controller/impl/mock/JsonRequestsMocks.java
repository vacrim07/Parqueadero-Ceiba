package com.example.inadn.demo.controller.impl.mock;

public class JsonRequestsMocks {
	
	private String caseCarIsOk =
			
			"{\"position\":19,\"state\":\"checked in\",\"startDate\":"
			+ "\"2019-00-31@22:00:00.000+0000\",\"vehicle\":{\"type\":"
			+ "\"car\",\"name\":\"car\",\"badge\":\"AGH-761\"},\"price\":"
			+ "{\"amount\":0,\"currency\":\"COP\"}}";

	private String caseCarNotOk = 
			
			"{\"position\":19,\"state\":\"checked in\",\"startDate\":"
			+ "\"2019-01-10@22:00:00.000+0000\",\"vehicle\":{\"type\":"
			+ "\"car\",\"name\":\"car\",\"badge\":\"AGH-761\"},\"price\":"
			+ "{\"amount\":0,\"currency\":\"COP\"}}";

	public String getCaseCarIsOk() {
		return caseCarIsOk;
	}

	public String getCaseCarNotOk() {
		return caseCarNotOk;
	}
	
	
}
