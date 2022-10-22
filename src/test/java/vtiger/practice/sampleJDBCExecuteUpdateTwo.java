package vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class sampleJDBCExecuteUpdateTwo {

	public static void main(String[] args) throws SQLException 
	{
		Driver driverRef = new Driver();
		Connection con= null;
	   
		try
		{
		   DriverManager.registerDriver(driverRef);
		
	       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","root");

		   Statement state = con.createStatement();
		
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
		}
		  catch(Exception e)
		  {
			
		  }
		  finally 
		  {
			
		  con.close();
		  System.out.println("database closed");
		  }

		

	}

}
