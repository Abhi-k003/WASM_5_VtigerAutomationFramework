package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility
{  
	//Declaration
	@FindBy(name = "accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
    //Utilization
	public WebElement getOrganizationName() {
		return organizationNameEdt;
	}

	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	
	//Business  library
	/**
	 * this method will create organization and save it
	 * @param orgName
	 */
	public void createNewOrganization(String orgName) 
	{
		organizationNameEdt.sendKeys(orgName);
		saveBtn.click();
		
	}
	/**
	 * this method will creste organization with industryType and save it
	 * @param orgName
	 * @param industryType
	 */
	public void createNewOrganization(String orgName,String industryType) 
	{
		organizationNameEdt.sendKeys(orgName);
		handleDropDown(industryType, industryDropDown);
		saveBtn.click();
		
	}
	/**
	 * this method will creste organization with industryType,Type and save it
	 * @param orgName
	 * @param industryType
	 * @param type
	 */
	public void createNewOrganization(String orgName,String industryType,String type) 
	{
		organizationNameEdt.sendKeys(orgName);
		handleDropDown(industryType, industryDropDown);
		handleDropDown(type, typeDropDown);
		saveBtn.click();
		
	}
	

}
