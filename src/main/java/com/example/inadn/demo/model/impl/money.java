package com.example.inadn.demo.model.impl;

public class money {
	
	private String currency;
	
	private BigDecimal amount;

	public money() {
		super();
	}

	public money(String currency, BigDecimal amount) {
		super();
		this.currency = currency;
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}	

}
