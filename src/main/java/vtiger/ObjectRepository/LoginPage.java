package vtiger.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage //rule1:- create seperate class for every page
{
	//rule2:-identify the element using @FindBy,@FindAll,@FindBys
	//Declaration
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	//rulr3:- create a constructor to initialize
	//Initialization
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	

	//rule4:-provide getters to access the element

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//rule5:-Business library
	/**
	 * this method will login to application with username and password
	 * @param username
	 * @param password
	 */
	public void LoginToApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
	}
	
	
	

}
