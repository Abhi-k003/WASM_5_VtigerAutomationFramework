package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this class contains all the generic methods related to Database
 * @author ABHISHEK K
 *
 */
public class DatabaseUtility 
{
	Driver driverRef;
	Connection con= null;
	/**
	 * this method is use to connect to the Database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException 
	{
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(ConstantsUtility.DBUrl,ConstantsUtility.DBUsername,ConstantsUtility.DBPassword);
		
	}
	/**
	 * this method will use to close the database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException 
	{
		con.close();
		
	}
	public String executeQueryAndVerifyTheData(String query,int colIndex,String expData) throws SQLException 
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(colIndex);
			if (actData.equals(expData)) 
			{
				flag=true; //flag rising event
				break;
				
			}
		}
		if (flag) 
		{
			System.out.println("data present "+expData);
			return expData;
		}
		else 
		{
			System.out.println("data not present");
			return " ";
		}
		
	}

}
