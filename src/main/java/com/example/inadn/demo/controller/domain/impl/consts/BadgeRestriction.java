package com.example.inadn.demo.controller.domain.impl.consts;

public enum BadgeRestriction {
	
	A ("a");
	
	private final String restriction;

	private BadgeRestriction(String restriction) {
		this.restriction = restriction;
	}

	public String getRestriction() {
		return restriction;
	}
}
