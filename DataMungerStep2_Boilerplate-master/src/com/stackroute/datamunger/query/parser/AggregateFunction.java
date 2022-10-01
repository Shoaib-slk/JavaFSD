package com.stackroute.datamunger.query.parser;

/* This class is used for storing name of field, aggregate function for
 * each aggregate function
 * generate getter and setter for this class,
 * Also override toString method
 * */

public class AggregateFunction {
    private String fieldName, fieldFunction;

    // Write logic for constructor
    public AggregateFunction(String field, String function) {
        this.fieldName = field;
        this.fieldFunction = function;
    }
    public String getAggregateFunction() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "AggregateFunction{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldFunction='" + fieldFunction + '\'' +
                '}';
    }

    public void setAggregateFunction(String  field, String function) {
        this.fieldName = field;
        this.fieldFunction = function;
    }

}