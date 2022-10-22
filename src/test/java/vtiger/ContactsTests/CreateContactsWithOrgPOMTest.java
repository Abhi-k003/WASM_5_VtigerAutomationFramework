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
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactsWithOrgPOMTest {

    @Test
    public void createConWithOrgPOMTest() throws IOException
	{
		
		WebDriver driver;
		
		//load all required Object classes
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//load all the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 2)+jUtil.getRandomNumber();
		String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 3)+jUtil.getRandomNumber();
		
		
		//launch the browser
		if (BROWSER.equalsIgnoreCase("CHROME")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched");
			
		}
		else if (BROWSER.equalsIgnoreCase("FIREFOX")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox browser launched");
			
		}
		else 
		{
			System.out.println("invalid browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched");
			
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoadInDom(driver);
		driver.get(URL);
		
		//login to app
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		
		//navigate to org
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLnk();
		
		//click on  create new org lookup img
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnNewOrganizationImg();
		
		//create new org page with mandatory field and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//validation
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orgHeader = oip.getOrganizationHeaderText();
		System.out.println(orgHeader);
				if (orgHeader.contains(ORGNAME)) 
				{
					System.out.println("org created");
					
				}
				else {
					System.out.println("org not created");
				}
		
		//navigate to contacts
		hp.clickOnContactsLnk();
		
		//click on creat new contacts
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnNewContactsImg();
		
		//create new contacts with org name and save it
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.createNewContact(LASTNAME, driver, ORGNAME);
		
		//validation
		ContactInformationPage cip = new ContactInformationPage(driver);
		String contacatHeader = cip.getContactHeaderText();
		System.err.println(contacatHeader);
		if (contacatHeader.contains(LASTNAME)) 
		{
			System.out.println("contact created");
			
		}
		else {
			System.out.println("contact not created");
		}
		
		
		//signout
		hp.signOutOfApp(driver);
		System.out.println("testScript execution got completed");
		
		
		
		

	}

}
