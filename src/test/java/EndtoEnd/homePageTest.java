package EndtoEnd;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pageObject.landingpage;
import pageObject.loginpage;
import resources.base;

@Listeners({ AllureListener.class })
public class homePageTest extends base {

	public WebDriver driver;

	@BeforeTest
	public void setup() throws IOException {
		driver = driverinitialize();
		driver.get(prop.getProperty("url"));

	}

	// click on login and check if any popup present and kill it.
	@Test(description = "click login button")
	@Description("click login button")
	@Epic("Epic001")
	@Feature("Feature 01")
	@Story(" Story : login button clickable")
	@Step("Verify login button is clickable")
	@Severity(SeverityLevel.MINOR) // severity of test case
	public void login() {
		landingpage L = new landingpage(driver);
		if (L.getPopUpSize() > 0)

		{

			L.getPopUp().click();

		}

		L.login().click();

	}

	@Test(dataProvider = "data")
	@Description("enter pswd and usrname")
	@Epic("Epic002")
	@Feature("Feature 02")
	@Story(" Story : Enter username and password")
	@Step("Verify login fields take input")
	@Severity(SeverityLevel.TRIVIAL)
	public void login1(String username, String pass) throws InterruptedException {
		loginpage l1 = new loginpage(driver);
		l1.email().sendKeys(username);
		l1.pass().sendKeys(pass);
		l1.submit().click();
		Thread.sleep(2000);
		l1.email().clear();
		l1.pass().clear();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] data() {

		return new Object[][] { { "username1", "pass1" }, { "username2", "pass2" } };
	}

}
