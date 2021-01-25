package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	WebDriver driver;

	public  loginpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="user_email")
	WebElement email;
	
	@FindBy(id="user_password")
	WebElement pass;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	public WebElement email() {
		return email;
	}
	
	public WebElement pass() {
		return pass;
	}
	
	public WebElement submit() {
		return submit;
	}
		
}
