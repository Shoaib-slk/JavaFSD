package com.stackroute.datamunger.query.parser;

/*
 * This class is used for storing name of field, condition and value for 
 * each conditions
 * */
public class Restriction {

	private final String propertyName;
	private final String propertyValue;
	private final String condition;
	public Restriction(String propertyName, String propertyValue, String condition) {
		super();
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
		this.condition = condition;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public String getPropertyValue() {
		return propertyValue;
	}

	public String getCondition() {
		return condition;
	}
}
