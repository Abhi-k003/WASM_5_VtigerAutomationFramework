package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * this class contains all java specific generic methods
 * @author ABHISHEK K
 * 
 *
 */
public class JavaUtility 
{
	/**
	 * this method will generate random number for every execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
		int jLib = r.nextInt(1000);
		return jLib;
	}
	/**
	 * this method will generate system date and time and return the value
	 * @return
	 */
	public String getSystemDate() 
	{
		Date date = new Date();
		String d = date.toString();
		return d;
		
	}
	/**
	 * this method will generate current system date and time in specific format and return the value
	 * @return
	 */
	public String getSystemDateInFormat() 
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":","-");
		String currentDateandTime = date+" "+month+" "+year+" "+time;
		return currentDateandTime;
		
	}

	
	
	
}
