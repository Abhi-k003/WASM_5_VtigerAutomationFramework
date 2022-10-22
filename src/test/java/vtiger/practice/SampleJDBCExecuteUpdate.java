package vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate 
{
	public static void main(String[] args) throws SQLException 
	{
	Driver driverRef = new Driver();
   
	//step:- register the driver
	DriverManager.registerDriver(driverRef);
	
	 //step2:- get the connection
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","root");
    
    //step3:-issue create statment
	Statement state = con.createStatement();
	
	 //Step4:- execute the query
	String query = "insert into customerinfo(name,id,address) values('Atish kelusker',14,'Bidar');";
	
	int result = state.executeUpdate(query);
	

	
	   if(result==1)
	   {
		System.out.println("the data is inserted");
	   }
	   else 
	   {
		System.out.println("the data is not inserted");
	   }
	   
	      //step5:- close the database
	   con.close();
	}
}
