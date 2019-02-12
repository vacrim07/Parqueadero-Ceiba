package com.example.inadn.demo.model.domain.impl.consts;

public enum BadgeRestrictionEnum {
	
	A ("a");
	
	private final String restriction;

	private BadgeRestrictionEnum(String restriction) {
		this.restriction = restriction;
	}

	public String getRestriction() {
		return restriction;
	}
}
