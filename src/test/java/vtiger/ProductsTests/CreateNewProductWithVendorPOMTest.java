package vtiger.ProductsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewProductPage;
import vtiger.ObjectRepository.CreateNewVendorPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.ProductInformation;
import vtiger.ObjectRepository.ProductsPage;
import vtiger.ObjectRepository.VendorInformationPage;
import vtiger.ObjectRepository.VendorsPage;

public class CreateNewProductWithVendorPOMTest
{

	@Test
	public void CreateNewProWithVenPOMTest() throws IOException
	{
		WebDriver driver = null;
		//load all the object class
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//load all the data
		 String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String VENDORNAME = eUtil.readDataFromExcelSheet("Product", 1, 2)+jUtil.getRandomNumber();
		String PRODUCTNAME = eUtil.readDataFromExcelSheet("Product", 1, 3)+jUtil.getRandomNumber();
		
		
		//LAUNCH THE BROWSER
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
		
		//login
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		
		HomePage hp = new HomePage(driver);
		hp.clickOnVendorsLnk(driver);
		
		VendorsPage vp = new VendorsPage(driver);
		vp.clickOnCreateNewVendorImg();
		
		
		//create new vendor and save it
		CreateNewVendorPage cnvp = new CreateNewVendorPage(driver);
		cnvp.createNewVendor(VENDORNAME);
		
		//validation
		VendorInformationPage vip = new VendorInformationPage(driver);
		String vendorHeaderText = vip.getVendorInformationText();
		/*if (vendorHeaderText.contains(VENDORNAME)) 
		{
			System.out.println("vendor created");
			
		}
		else 
		{
			System.out.println("vendor not created");
			
		}
		*/
		
		Assert.assertEquals(vendorHeaderText.equals(VENDORNAME), true);
		
		//navigate to product link
		hp.clickOnProductsLnk();
		
		
		
		ProductsPage pg = new ProductsPage(driver);
		pg.clickOnCreateNewProductLookUPImg();
		
		CreateNewProductPage cnpg = new CreateNewProductPage(driver);
		cnpg.CreateNewProduct(PRODUCTNAME, driver, VENDORNAME);
		
		//validation
		ProductInformation pi = new ProductInformation(driver);
		String productHeaderText = pi.getProductHeaderText();
		/*if (productHeaderText.contains(PRODUCTNAME)) 
		{
			System.out.println("product created");
			
		}
		else 
		{
			System.out.println("product not created");
			
		}*/
		Assert.assertEquals(productHeaderText.contains(PRODUCTNAME), true);
		
		//signout
		hp.signOutOfApp(driver);
		System.out.println("executed");
		
		
		

	}

}
