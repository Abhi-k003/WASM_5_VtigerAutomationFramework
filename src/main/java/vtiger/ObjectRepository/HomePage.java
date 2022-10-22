package vtiger.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Declaration
	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement conctactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administatorImg;
	
	@FindAll({@FindBy(linkText = "Sign Out"),@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")})
	private WebElement signOutLnk;
	
	@FindBy(xpath = "//img[@style='padding-left:5px']")
	private WebElement moreLnk;
	
	@FindBy(name = "Vendors")
	private WebElement vendorsLnk;
	
	
	



	//initialization
	public HomePage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	//getter methods(utilization)
	public WebElement getMoreLnk() {
		return moreLnk;
	}



	public WebElement getVendorsLnk() {
		return vendorsLnk;
	}
	public WebElement getLeadsLnk() {
		return leadsLnk;
	}

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getConctactsLnk() {
		return conctactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getAdministatorImg() {
		return administatorImg;
	}



	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	    //Business library
	/**
	 * this method  will perform signout operation
	 * @param driver
	 */
		public void signOutOfApp(WebDriver driver) 
		{
			
			mouseHoverOn(driver,administatorImg);
			signOutLnk.click();
			
		}
		/**
		 * this method will perform clock on leads module
		 */
		public void clickOnLeadsLnk() 
		{
		leadsLnk.click();
			
		}
		/**
		 * this method will perform
		 * clink on organization link
		 */
		public void clickOnOrganizationLnk() 
		{
			organizationLnk.click();
			
		}
		/**
		 * this method is going click on contacts link
		 */
		public void clickOnContactsLnk() 
		{
			conctactsLnk.click();
			
		}
		/**
		 * this method will perform click operation product link
		 */
		public void clickOnProductsLnk() 
		{
			productsLnk.click();
			
		}
		
		/**
		 * this method will perform click operation on opportunities
		 */
		
		public void clickOnOpportunitiesLnk() 
		{
			opportunitiesLnk.click();
			
		}
		/**
		 * this method will perform click on vandors module link
		 * @param driver
		 */
		public void clickOnVendorsLnk(WebDriver driver) 
		{
			mouseHoverOn(driver, moreLnk);
			vendorsLnk.click();
			
		}
		
		
		
	

}
