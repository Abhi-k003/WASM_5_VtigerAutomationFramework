package vtiger.ReadDataFromMavenCmd;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest 
{
	@Test
	public void readDataTest()
	{
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}

}
