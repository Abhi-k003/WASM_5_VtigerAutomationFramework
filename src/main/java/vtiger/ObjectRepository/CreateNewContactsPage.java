 package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility
{
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orgLookUpImg;
	
	@FindBy(id = "search_txt")
	private WebElement searchBoxEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	

    //initialization
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public WebElement getSearchBox() {
		return searchBoxEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	
	//Business library
	/**
	 * this method will create new contact and save it
	 * @param lastName
	 */
	public void CreateNewContact(String lastName) 
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
		
	}
	/**
	 * this method will create new contact with leadsource type and save it
	 * @param lastName
	 * @param LeadSourceType
	 */
	public void CreateNewContact(String lastName,String LeadSourceType ) 
	{
		lastNameEdt.sendKeys(lastName);
		handleDropDown(LeadSourceType, leadSourceDropDown);
		saveBtn.click();
		
	}
	/**
	 * this method will create contact with lastname and organization name
	 * @param lastName
	 * @param driver
	 * @param orgName
	 */
	public void createNewContact(String lastName,WebDriver driver,String orgName) //we can give or no need to give String partialName
	{
		lastNameEdt.sendKeys(lastName);
		orgLookUpImg.click();
		switchToWindow(driver,"Accounts");//becuse i know exact partial name
		searchBoxEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();//Dynamic xPath
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}
	

}
