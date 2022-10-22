package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	//Declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createNewContactsLookUpImg;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateNewContactsLookUpImg() {
		return createNewContactsLookUpImg;
	}
	
	//Business library
	/**
	 * this method will perform click on contacts LookUp img operation
	 */
	public void clickOnNewContactsImg() 
	{
		createNewContactsLookUpImg.click();
		
	}
	

}
