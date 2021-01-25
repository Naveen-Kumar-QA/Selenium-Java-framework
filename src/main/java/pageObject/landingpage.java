package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage {

	WebDriver driver;

	public  landingpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//*[text()='Login']")
	WebElement login;
	
	@FindBy(xpath="//h2[text()='Featured Courses']")
	WebElement title;
	
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']")
	WebElement getnavbar;
	
	public WebElement login() {
		return login;
	}
	public int getPopUpSize()

	{

	return  driver.findElements(popup).size();

	}

	public WebElement getPopUp()

	{

	return driver.findElement(popup);

	}
	public WebElement title()

	{

	return title;

	}
	
	public WebElement getnavbar()

	{

	return getnavbar;
	}
}
