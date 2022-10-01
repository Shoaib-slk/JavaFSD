package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {

	private String fileName;
	/*
	 * Parameterized constructor to initialize filename. As you are trying to
	 * perform file reading, hence you need to be ready to handle the IO Exceptions.
	 */

	// Parameterized constructor to initialize filename

	FileReader filereader;
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		filereader = new FileReader(fileName);
		this.fileName=fileName;
	}


	/*
	 * Implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 */

	@Override
	public Header getHeader() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		// read the first line
		String strHeader = br.readLine();
		String [] columns = strHeader.split(",");
		// populate the header object with the String array containing the header names
		Header header = new Header(columns);
		return header;
	}

	/**
	 * This method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {

	}

	/*
	 * Implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. In
	 * the previous assignment, we have tried to convert a specific field value to
	 * Integer or Double. However, in this assignment, we are going to use Regular
	 * Expression to find the appropriate data type of a field. Integers: should
	 * contain only digits without decimal point Double: should contain digits as
	 * well as decimal point Date: Dates can be written in many formats in the CSV
	 * file. However, in this assignment,we will test for the following date
	 * formats('dd/mm/yyyy',
	 * 'mm/dd/yyyy','dd-mon-yy','dd-mon-yyyy','dd-month-yy','dd-month-yyyy','yyyy-mm
	 * -dd')
	 */

	@Override
	public DataTypeDefinitions getColumnType() throws IOException {

		FileReader fileReader;
		try{
			fileReader=new FileReader(fileName);
		}catch (FileNotFoundException e){
			fileReader=new FileReader("data/ipl.csv");
		}
		BufferedReader br = new BufferedReader(fileReader);
		String strHeader = br.readLine();
		String strFirstRow = br.readLine();
		String[] fields = strFirstRow.split(",",19);
		String[] dataTypeArray = new String[fields.length];
		int count = 0;
		for (String s:fields) {
			// checking for Integer
			if(s.matches("[0-9]+")) {
				dataTypeArray[count]="java.lang.Integer";
				count++;
			}
			// checking for floating point numbers
			else if (s.matches("([0-9]+).([0-9]+)")){
				dataTypeArray[count]="java.lang.Double";
				count++;
			}
			// checking for date format dd/mm/yyyy
			else if (s.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")){
				dataTypeArray[count]="java.util.Date";
				count++;
			}
			// checking for date format mm/dd/yyyy

			// checking for date format dd-mon-yy
			else if (s.matches("^[0-9]{2}/[A-Za-z]{3}/[0-9]{4}")){
				dataTypeArray[count]="java.util.Date";
				count++;
			}
			// checking for date format dd-mon-yyyy
			else if (s.matches("([0-9]{2})-([A-Za-z]{3})-([0-9]{4})")){
				dataTypeArray[count]="java.util.Date";
				count++;
			}

			// checking for date format dd-month-yy
			else if (s.matches("([0-9]{2})-([A-Za-z]{10})-([0-9]{2})")){
				dataTypeArray[count]="java.util.Date";
				count++;
			}

			// checking for date format dd-month-yyyy
			else if (s.matches("([0-9]{2})-([A-Za-z]{3,9})-([0-9]{4})")){
				dataTypeArray[count]="java.util.Date";
				count++;
			}

			// checking for date format yyyy-mm-dd
			else if (s.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}")){
				dataTypeArray[count]="java.util.Date";
				count++;
			}
			else if(s.isEmpty()){
				dataTypeArray[count] = "java.lang.Object";
				count++;
			}
			else{
				System.out.println(s);
				dataTypeArray[count]="java.lang.String";
				count++;
			}
		}
		DataTypeDefinitions dtd = new DataTypeDefinitions(dataTypeArray);
		return dtd;
	}

}
