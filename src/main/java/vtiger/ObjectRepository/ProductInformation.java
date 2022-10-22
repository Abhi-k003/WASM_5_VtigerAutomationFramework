package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformation 
{
	@FindBy(className = "lvtHeaderText")
	private WebElement proHeader;
	
	public ProductInformation(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getProHeader	() {
		return proHeader;
	}
	/**
	 * this method will display product Header Text
	 * @return
	 */
	public String getProductHeaderText() 
	{
		String productHeader = proHeader.getText();
		return productHeader;
		
	}
	
	

}
