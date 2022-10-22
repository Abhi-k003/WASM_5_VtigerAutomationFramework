package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage 
{
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createNewProductLookUpImg;
	
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getCreateNewProductLookUpImg() {
		return createNewProductLookUpImg;
	}
	
	/**
	 * this method will perform click on create new product lookup img
	 */
	public void clickOnCreateNewProductLookUPImg() 
	{
		createNewProductLookUpImg.click();
		
	}

}
