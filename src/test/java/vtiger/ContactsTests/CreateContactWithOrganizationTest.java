package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

/**
 * 
 * @author ABHISHEK K
 *
 */
public class CreateContactWithOrganizationTest 
{

    @Test
    public void createConWithOrgTest() throws IOException
	{
		WebDriver driver ;
		/*Step1:-create objects of generic utilities*/
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		/*step2:- load all the necesary data*/
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 2)+jUtil.getRandomNumber();
		
		/*Step3:- launch the browser*/
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome driver launched");
			
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox driver launched ");
			
		}
		else 
		{
			System.out.println("---invalid browser----");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome driver launched");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoadInDom(driver);
		driver.get(URL);
		
		
		/*Step4:-login to app*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		/*Step5:- navigate to organization*/
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		/*Step5:-CLICK 0N CREATE ORGANIZATION*/
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		/*Step6:-create organization with mandatory info AND SAVE*/
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		/*if (orgHeader.contains(ORGNAME)) 
		{
			System.out.println("PASS");
			System.out.println("---organization created---");
			
		}
		else 
		{
			System.out.println("FAIL");
			System.out.println("---organization not created---");
			
		}*/
		
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		
		
		
		/*Step7:-navigate to contacts*/
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		/*Step8:-click on creatr contact*/
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		/*Step9:-create contacts with organization field*/
		driver.findElement(By.xpath("[name='lastname']")).sendKeys(LASTNAME);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		//switch to child window
		wUtil.switchToWindow(driver, "Accounts");
		
		driver.findElement(By.id("[id='search_txt']")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("[name='search']")).click();
		
		driver.findElement(By.linkText(ORGNAME)).click();
		
		//switch control to parentt window
		wUtil.switchToWindow(driver, "Contacts");
		
		/*Step10:- save*/
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String contactHeader = driver.findElement(By.xpath("//span[text()='[ CON2 ] sgdhtg  -  Contact Information']")).getText();
		System.out.println(contactHeader);
		/*if (contactHeader.contains(LASTNAME)) 
		{
			System.out.println("pass");
			System.out.println("---Contact created succesfully-----");
			
		}
		else 
		{
			System.out.println("Fail");
			System.out.println("---Contact not created succesfully-----");
			
		}*/
		
		Assert.assertEquals(contactHeader.contains(LASTNAME), true);
		
		
		/*step11:-logout*/
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverOn(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
			
		}

	}


