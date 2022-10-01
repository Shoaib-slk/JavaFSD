package com.stackroute.datamunger.query.parser;

/*
 * This class is used for storing name of field, condition and value for 
 * each conditions
 * generate getter and setter for this class,
 * Also override toString method
 * */

public class Restriction {

	private String fieldName, fieldCondition, fieldValue;
	// Write logic for constructor
	public Restriction(String name, String value, String condition) {
		this.fieldName = name;
		this.fieldValue = value;
		this.fieldCondition = condition;

	}

	public String getRestriction() {
		return this.toString();
	}

	public void setRestriction(String name, String value, String condition) {
		this.fieldName = name;
		this.fieldValue = value;
		this.fieldCondition = condition;
	}


	@Override
	public String toString() {
		return "Restriction{" +
				"fieldName='" + fieldName + '\'' +
				", fieldCondition='" + fieldCondition + '\'' +
				", fieldValue='" + fieldValue + '\'' +
				'}';
	}
}