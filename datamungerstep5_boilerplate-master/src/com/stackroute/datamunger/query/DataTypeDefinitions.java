package com.stackroute.datamunger.query;


/*
 * implementation of DataTypeDefinitions class. This class contains a method getDataTypes()
 * which will contain the logic for getting the datatype for a given field value. This
 * method will be called from QueryProcessors.
 * In this assignment, we are going to use Regular Expression to find the
 * appropriate data type of a field.
 * Integers: should contain only digits without decimal point
 * Double: should contain digits as well as decimal point
 * Date: Dates can be written in many formats in the CSV file.
 * However, in this assignment,we will test for the following date formats('dd/mm/yyyy',
 * 'mm/dd/yyyy','dd-mon-yy','dd-mon-yyyy','dd-month-yy','dd-month-yyyy','yyyy-mm-dd')
 */
public class DataTypeDefinitions {

    //method stub
    public static Object getDataType(String s) {

        // checking for Integer
        if (s.matches("[0-9]+")) {
            return "java.lang.Integer";
        }
        // checking for floating point numbers
        else if (s.matches("([0-9]+).([0-9]+)")) {
			return "java.lang.Double";
        }
        // checking for date format dd/mm/yyyy
        else if (s.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
			return "java.util.Date";
        }
        // checking for date format mm/dd/yyyy

        // checking for date format dd-mon-yy
		else if (s.matches("^[0-9]{2}/[A-Za-z]{3}/[0-9]{4}")){
			return "java.util.Date";
		}
        // checking for date format dd-mon-yyyy
		else if (s.matches("([0-9]{2})-([A-Za-z]{3})-([0-9]{4})")){
			return "java.util.Date";
		}
        // checking for date format dd-month-yy
		else if (s.matches("([0-9]{2})-([A-Za-z]{10})-([0-9]{2})")){
			return "java.util.Date";
		}
        // checking for date format dd-month-yyyy
		else if (s.matches("([0-9]{2})-([A-Za-z]{3,9})-([0-9]{4})")){
			return "java.util.Date";
		}
        // checking for date format yyyy-mm-dd
		else if (s.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}")){
			return "java.util.Date";
		}
		else if(s.isEmpty()){
			return "java.lang.Object";
		}
		else{
			return "java.lang.String";
		}
    }
}
