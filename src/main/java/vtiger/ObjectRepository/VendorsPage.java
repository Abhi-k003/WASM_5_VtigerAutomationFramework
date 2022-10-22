package vtiger.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage 
{
	//Declaration
	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement createNewVendorLnk;
	
	//initialization
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateNewVendorLnk() {
		return createNewVendorLnk;
	}
	
	//Business library
	/**this method will perform clock on create new vendor look up img
	 * 
	 */
	public void clickOnCreateNewVendorImg() 
	{
		createNewVendorLnk.click();
		
	}
	
	

}
