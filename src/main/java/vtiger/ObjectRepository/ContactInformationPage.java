package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ConHeaderText;
	
	//initialization
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//utilization
	public WebElement getConHeaderText() {
		return ConHeaderText;
	}
	
	//Business library
	/**
	 * this method will give created contact header Text and return it for further use
	 * @return
	 */
	public String getContactHeaderText() 
	{
		String conHeader = ConHeaderText.getText();
		return conHeader;
		
	}
	
	 

}
