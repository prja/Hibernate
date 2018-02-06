package com.pnj.hibernate.util;

public enum IDType {

	AADHAR("AADHAR"),PAN("PAN"), PASSPORT("PASSPORT"), DRIVING_LICENCE("DRIVING_LICENCE"),VOTER_ID("VOTER_ID");
	
	private final String type;
	private IDType(String type){
		this.type=type;
	}
	public String getType() {
		return type;
	}
}
