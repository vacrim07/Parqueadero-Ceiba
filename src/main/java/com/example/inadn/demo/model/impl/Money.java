package com.example.inadn.demo.model.impl;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Money implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
	private String currency;
	
	private BigDecimal amount;

	public Money() {
	}

	public Money(String currency, BigDecimal amount) {
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
