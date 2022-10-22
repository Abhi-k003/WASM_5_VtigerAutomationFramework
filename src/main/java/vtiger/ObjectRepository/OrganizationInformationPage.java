package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage 
{
	//Declaration
	@FindBy(className = "dvHeaderText")
	private WebElement orgHeaderText;
	
	//Initialization
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	//Business library
	/**
	 * this method will display Organization header Text and return it for furthur use
	 * @return
	 */
	public String getOrganizationHeaderText() 
	{
		String orgHeader = orgHeaderText.getText();
		return orgHeader;
		
	}
	

}
