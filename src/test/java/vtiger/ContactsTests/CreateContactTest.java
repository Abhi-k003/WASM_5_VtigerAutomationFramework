package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

/**
 * This class contains create contact test script
 * @author ABHISHEK K
 *
 */
public class CreateContactTest {

	@Test
	public void createConTest() throws IOException
	{
		
		  WebDriver driver;
		
		/*step1:-Create object of all utilities*/
	    JavaUtility jUtil = new JavaUtility();
	    PropertyFileUtility pUtil = new PropertyFileUtility();
	    ExcelFileUtility eUtil = new ExcelFileUtility();
	    WebDriverUtility wUtil = new WebDriverUtility();
		
		/*Step2:read all necessary data*/
	   String BROWSER = pUtil.readDataFromPropertyFile("browser");
	   String URL = pUtil.readDataFromPropertyFile("url");
	   String USERNAME = pUtil.readDataFromPropertyFile("username");
	   String PASSWORD = pUtil.readDataFromPropertyFile("password");
	   
	  String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2);
	  
		
		/*Step3:--launch the browser*/
	   if (BROWSER.equalsIgnoreCase("chrome")) 
	   {
		   
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  System.out.println("chrome browser launched");
		
	   }
	   else if (BROWSER.equalsIgnoreCase("firefox")) 
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
		   System.out.println("firefox browser launched");
		
	   }
	   else
	   {
		   System.out.println("browser is invalid,hence launch chrome browser");
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		   System.out.println("chrome browser launched");
		
	   }
	   
	    wUtil.maximizeWindow(driver);
	    wUtil.waitForElementsToLoadInDom(driver);
	    driver.get(URL);
	    
	   
		
		/*Step4:-login to the app*/
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
		
		/*step5:-navigate to concats*/
	    driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	    
		
		/*step6:-click on create contacts*/
	    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	    
		
		/*step7:-create contacts with mandatory info*/
	    driver.findElement(By.xpath("[name='lastname']")).sendKeys(LASTNAME+jUtil.getRandomNumber());
	    
	    
		/*step8:-save*/
	    driver.findElement(By.name("[name='button']")).click();
		
		/*step9:-logout*/
	    WebElement element = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
	    wUtil.mouseHoverOn(driver, element);
	    driver.findElement(By.linkText("Sign Out")).click();
	    
		

	}

}
