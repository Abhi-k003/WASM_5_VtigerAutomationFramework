package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage 
{
	//Declaration
	@FindBy(name = "vendorname")
	private WebElement vendorNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	//initialization
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization

	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business library
	/**
	 * this method will create new vendor and save it
	 * @param vendorName
	 */
	public void createNewVendor(String vendorName) 
	{
		vendorNameEdt.sendKeys(vendorName);
		saveBtn.click();
		
	}
	
	

}
