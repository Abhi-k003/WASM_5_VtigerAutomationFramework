package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInformationPage 
{
	@FindBy(className = "class=\"lvtHeaderText\"")
	private WebElement venInformation;
	
	public VendorInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getVenInformation() {
		return venInformation;
	}
	/**
	 * this method will give vendor name Text
	 * @return
	 */
	public String getVendorInformationText() 
	{
		String vendorHeader = venInformation.getText();
		return vendorHeader;
		
		
	}

}
