package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{
	//Declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createNew0rganizationLookUpImg;

	//intialization
	public OrganizationsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
		
	}

	//utilization
	public WebElement getCreateNew0rganizationLookUpImg() {
		return createNew0rganizationLookUpImg;
	}
	
	//Business library
	/**
	 * this method will click on create new organization lookup img 
	 */
	public void clickOnNewOrganizationImg() 
	{
		createNew0rganizationLookUpImg.click();
		
	}
	

	
}
