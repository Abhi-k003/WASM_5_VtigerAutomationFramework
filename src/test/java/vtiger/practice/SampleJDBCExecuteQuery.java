package vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleJDBCExecuteQuery 
{

	public static void main(String[] args) throws SQLException 
	{
	Driver driverRef = new Driver();
	
	//step:- register the driver
    DriverManager.registerDriver(driverRef);
    
    //step2:- get the connection
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
    
    //step3:-issue create statment
    Statement state = con.createStatement();
    
    //Step4:- execute the query
     ResultSet result = state.executeQuery("select * from customerinfo");
   
      while(result.next())
      {
	   System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
      }
      
      //step5:- close the database
      con.close();
	}

}
