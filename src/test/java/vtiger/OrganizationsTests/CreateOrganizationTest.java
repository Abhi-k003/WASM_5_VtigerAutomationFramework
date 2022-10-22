package vtiger.OrganizationsTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateOrganizationTest {

	@Test
	public void createOrgTest() throws IOException
	{
		
		WebDriver driver;
		
		Random r = new Random();
		int RANDOM = r.nextInt(10000);
		
		//Step1:-load file into file input stream
		
		//--------Property File--> Common data
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commomData.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//------Excel sheet---->Test data
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb =WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Organization");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(2);
		
		String ORGNAME = cell.getStringCellValue();
		
		//step2:- Launch the browser---best example for RUN TIME POLYMORPHISM
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
			System.out.println("chrome browser launched succesfully");
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
		   driver= new FirefoxDriver();
		   System.out.println("Firefox browser launched succesfully");
			
		}
		else 
		{
			System.out.println("invalid browser");
			driver = new ChromeDriver();
			System.out.println("default chrome browser launched succesfully");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		
		//STPE3:- LOgin to app
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//step4:- navigate to organization
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//step5:-navigate to create organization 
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//STEP6:- CREATE ORGANIZATION WITH MANDATORY FIELD
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(ORGNAME+RANDOM);
		
		
		//step7:-save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step8:-logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		Actions act = new Actions(driver);
		act.moveToElement(element);
		act.perform();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		
		System.out.println("Organization created succesfully");
		
		
		
	}

}
