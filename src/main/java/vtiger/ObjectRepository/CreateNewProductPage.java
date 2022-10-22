package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility
{
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement vendorNameLookUpImg;
	
	@FindBy(id = "search_txt")
	private WebElement searchBoxEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(className = "crmbutton small save")
	private WebElement saveBtn;
	
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getVendorNameLookUpImg() {
		return vendorNameLookUpImg;
	}

	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * this method will perform create product with vendor name and save it
	 * @param productName
	 * @param driver
	 * @param vendorName
	 */
	public void CreateNewProduct(String productName,WebDriver driver,String vendorName) 
	{
		productNameEdt.sendKeys(productName);
		vendorNameLookUpImg.click();
		switchToWindow(driver,"Vendors");
		searchBoxEdt.sendKeys(vendorName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		switchToWindow(driver, "Products");
		saveBtn.click();
		
	}

}
