package vtiger.OrganizationsTests;
/**
 * 
 * @author ABHISHEK K
 *
 */

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationWithIndustryTest extends BaseClass
{
	//WebDriver driver;
	
	//create object off required class
	
	@Test(dataProvider = "orgNameWithIndType",groups = "SmokeSuite")
	public void createOrgWithIndTest(String orgName,String industryType) throws IOException
	{
		
		JavaUtility jUtil = new JavaUtility();
		String org = orgName+jUtil.getRandomNumber();

		
		//navigate to org
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLnk();
		
		//click on org lookup img
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnNewOrganizationImg();
		
		//create new org with ind and save it
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(org,industryType);
		
		//validation
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orgNameHeader = oip.getOrganizationHeaderText();
		/*if (orgNameHeader.contains(org)) 
		{
			System.out.println("org created");
			
		}
		else 
		{
			System.out.println("org not created");
		}*/
		
		Assert.assertTrue(orgNameHeader.contains(org));
		
	}
	
	@DataProvider(name = "orgNameWithIndType")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		Object[][] data = eUtil.readMultipleDataFromExcel("MultipleOrg");
		return data;
	}
	
	
	@Test(invocationCount = 3)
	public void createOrgWithIndDummyTest() 
	{
		Reporter.log("createOrgWithIndDummyTest created succesfully",true);
	}
	
}

