package vtiger.OrganizationsTests;

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
 * this class contains create organization test script
 * @author ABHISHEK K
 *
 */
public class CreateOrganizationsTestsWithUtilityTest
{

     @Test
     public void createOrgWithUtilityTest() throws IOException
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
		
		String ORGNAME = eUtil.readDataFromExcelSheet("Organization", 1, 2);
		
		/*Step3:--launch the browser*/
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
			System.out.println("firefox driver launched");
			
		}
		else 
		{
          System.out.println("invalid browser , launch chrome");
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

		/*step5:-navigate to organization*/
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		/*step6:-click on create organization*/
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		/*step7:-create organization with mandatory info*/
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME+jUtil.getRandomNumber());
		
		/*Step8:-Choose Healthcare in the Industry dropdown*/
		WebElement element1 = driver.findElement(By.name(" [name='industry']"));
		wUtil.handleDropDown(element1, "Healthcare");
		
		/*step9:-save*/
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		/*step10:-logout*/
		WebElement element = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		wUtil.mouseHoverOn(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		
		

	}
 
}
