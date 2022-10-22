package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactsPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class CreateContactsWithMandatoryFieldsTest 
{
	@Test
	public void createConWithMandFieldTest() throws IOException
	{
		WebDriver driver;
		//create object of REQUIRED classes
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//load all required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2)+jUtil.getRandomNumber();
		
		//LAUNCH THE BROWSER
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched ");
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox launched ");
		}
		else 
		{
			System.out.println("invalid browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched ");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoadInDom(driver);
		driver.get(URL);
		
		//login to app
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		//click on contacts
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLnk();
		
		//click on create new contacts img
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnNewContactsImg();
		
		//create new contacts with mandatory fields
		CreateNewContactsPage cnp = new CreateNewContactsPage(driver);
		cnp.CreateNewContact(LASTNAME);
		
		//validation
		ContactInformationPage cip = new ContactInformationPage(driver);
		String contactHeader = cip.getContactHeaderText();
		if (contactHeader.contains(LASTNAME)) 
		{
			System.out.println("PASS");
			
		}
		else 
		{
			System.out.println("FAIL");
		}
		
		//SIGNOUT
		hp.signOutOfApp(driver);
        System.out.println("contacts created succesfully");		
		
		
	}
	

}
