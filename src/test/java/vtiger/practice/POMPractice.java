package vtiger.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class POMPractice {

	public static void main(String[] args) 
	{
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8888/");
	
	//login
	LoginPage lp = new LoginPage(driver);
    /*WebElement username = lp.getUserNameEdt();
    username.sendKeys("admin");
    
    lp.getPasswordEdt().sendKeys("admin");
    lp.getLoginBtn().click();
    */
	
	lp.LoginToApp("admin", "admin");

	}

}
