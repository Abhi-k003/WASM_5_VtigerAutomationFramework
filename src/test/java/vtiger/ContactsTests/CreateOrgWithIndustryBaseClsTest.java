package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateOrgWithIndustryBaseClsTest extends BaseClass 
{
	@Test(dataProvider = "orgNameWithIndudtry",groups = "RegressionSuite",retryAnalyzer = vtiger.GenericUtility.RetryAnalyzerImplementation.class)
	public void CreateOrgWithIndusTest(String oRgName,String industryType)
	{
		
	    String org = oRgName+jUtil.getRandomNumber();
       
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLnk();
		Reporter.log("clicked on  organization link", true);
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnNewOrganizationImg();
		Reporter.log("clicked on create new org lookup img",true);
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(org, industryType);
		Reporter.log("data added succesfully",true);
		
		//validation
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orgHeader = oip.getOrganizationHeaderText();
		if (orgHeader.contains(org)) 
		{
			
			System.out.println(" org created");
			Reporter.log("org with industryType created succesfully",true);
		}
		else 
		{
			System.out.println(" org not created");
			Reporter.log("org with industryType not created succesfully",true);
		}
	}
	
	@DataProvider(name = "orgNameWithIndudtry")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eUtil.readMultipleDataFromExcel("MultipleOrg");
		return data;
	}

}
