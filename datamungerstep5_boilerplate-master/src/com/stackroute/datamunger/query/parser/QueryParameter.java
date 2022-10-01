package com.stackroute.datamunger.query.parser;

import java.util.List;

/*
 * This class will contain the elements of the parsed Query String such as conditions,
 * logical operators,aggregate functions, file name, fields group by fields, order by
 * fields, Query Type
 * */
public class QueryParameter {

    private String fileName;
    private String baseQuery;
    List<Restriction> restrictions;
    List<String> logicalOperators;
    List<String> fields;
    List<AggregateFunction> aggregateFunctions;
    List<String> groupByFields;
    List<String> orderByFields;

    public String getFile() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    public String getBaseQuery() {
        return baseQuery;
    }

    public List<AggregateFunction> getAggregateFunctions() {
        return aggregateFunctions;
    }

    public List<String> getLogicalOperators() {
        return logicalOperators;
    }


    public List<String> getGroupByFields() {
        return groupByFields;
    }

    public List<String> getOrderByFields() {
        return orderByFields;
    }

    public String getQUERY_TYPE() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getFileName() {
        return fileName;
    }


    public void setBaseQuery(String baseQuery) {
        this.baseQuery = baseQuery;
    }


    public void setRestrictions(List<Restriction> restrictions) {
        this.restrictions = restrictions;
    }


    public void setLogicalOperators(List<String> logicalOperators) {
        this.logicalOperators = logicalOperators;
    }

    public void setAggregateFunctions(List<AggregateFunction> aggregateFunctions) {
        this.aggregateFunctions = aggregateFunctions;
    }

    public void setGroupByFields(List<String> groupByFields) {
        this.groupByFields = groupByFields;
    }

    public void setOrderByFields(List<String> orderByFields) {
        this.orderByFields = orderByFields;
    }


}
