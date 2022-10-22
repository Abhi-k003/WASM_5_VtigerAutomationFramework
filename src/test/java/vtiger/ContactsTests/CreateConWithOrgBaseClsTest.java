package vtiger.ContactsTests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactsPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateConWithOrgBaseClsTest extends BaseClass
{
	    // WebDriver driver ; dont give this thing in this program wont execute at all we  already declared as global in BaseClass and extended in this program
	    @Test(groups = "SmokeSuite")
	    public void createConWithOrgTest() throws IOException
		{
			
		    //load required data
			
			String ORGNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 3);
			String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 4, 2);
			String ORG = ORGNAME+jUtil.getRandomNumber();
			String LAST = LASTNAME+jUtil.getRandomNumber();
			
			/* navigate to organization*/
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLnk();
			Reporter.log("click on Organization  succesfully",true);
			
			/*CLICK 0N CREATE ORGANIZATION*/
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnNewOrganizationImg();
			Reporter.log("click on create new Organization  succesfully",true);
			
			/*create organization with mandatory info AND SAVE*/
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createNewOrganization(ORG);
			
			//validation
			OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			String orgHeader = oip.getOrganizationHeaderText();
			System.out.println(orgHeader);
			
			Assert.assertTrue(orgHeader.contains(ORG));
			
			/* navigate to contacts*/
			hp.clickOnContactsLnk();
			
			/*Step8:-click on creatr contact*/
			ContactsPage cp = new ContactsPage(driver);
			cp.clickOnNewContactsImg();
			
			/*create contacts with organization field and save it*/
			CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
			cncp.createNewContact(LAST, driver, ORG);
			
			
			
			//validation
			ContactInformationPage cip = new ContactInformationPage(driver);
			String contactHeader = cip.getContactHeaderText();
			System.out.println(contactHeader);
			//Assert.assertTrue(contactHeader.contains(LAST));
			Assert.assertEquals(contactHeader.contains(LAST), true);
                                   //true  //false           //true
				
			}

		}



