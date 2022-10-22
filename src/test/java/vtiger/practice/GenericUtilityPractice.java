package vtiger.practice;

import java.io.IOException;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException 
	{
		JavaUtility jLib = new JavaUtility();
		
		int ra = jLib.getRandomNumber();
		System.out.println(ra);
		
		String d = jLib.getSystemDate();
		System.out.println(d);
		
		String date = jLib.getSystemDateInFormat();
		System.out.println(date);
		
		PropertyFileUtility pLib = new PropertyFileUtility();
		String u = pLib.readDataFromPropertyFile("username");
	    System.out.println(u);
	    
	    ExcelFileUtility eLib = new ExcelFileUtility();
	    eLib.writeDataIntoExcel("Organization", 4, 7, "Abhishek");
	    System.out.println("added successfully");

	}

}
