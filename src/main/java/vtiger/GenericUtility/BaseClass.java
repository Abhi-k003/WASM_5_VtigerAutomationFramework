package vtiger.GenericUtility;


import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
/**
 * This class consist of all basic methods
 * @author ABHISHEK K
 *
 */ 
public class BaseClass 
{
	
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public DatabaseUtility dUtil = new DatabaseUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver = null;
	@BeforeSuite
	public void bsConfig() throws SQLException 
	{
		//dUtil.connectToDB();
		Reporter.log("--Database connected succesfully--",true);
		
	}
	//@Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void  bcConfig(/*String BROWSER*/) throws IOException 
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log(BROWSER+" browser connected succesfully--", true);
			
		}
		else if (BROWSER.equalsIgnoreCase("Firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log(BROWSER+" browser connected succesfully", true);
			
		}
		else 
		{
			System.out.println("invalid browser");
			
		}
		sdriver = driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoadInDom(driver);
		driver.get(URL);
		
	}
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"	})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		Reporter.log("Login Succesfull", true);
	}
	
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("Logout succesfull",true);
	}
	
	
	//@AfterTest
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.close();
		Reporter.log("Browser closed succesfully",true);
		
	}
	@AfterSuite(groups = { "SmokeSuite","RegressionSuite"})
	public void asConfig() throws SQLException
	{
		//dUtil.closeDB();
		Reporter.log("Database closed succesfully",true);
	}
	

}
