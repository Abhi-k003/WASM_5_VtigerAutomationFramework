package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException 
	{
		//Step:- Load the file location to File input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commomData.properties");
		
		//Step:- Create an Object of Properties  in java
		Properties pObj = new Properties();
		
		//Step3:-load the file to properties object
		pObj.load(fis);
		
		//Step4:- Read the data thru keys
		String BROWSER = pObj.getProperty("browser");
	    System.out.println(BROWSER);
	    
	    String URL = pObj.getProperty("url");
        System.out.println(URL);
        
        String USERNAME = pObj.getProperty("username");
        System.out.println(USERNAME);
	}

}
