package EndtoEnd;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.landingpage;
import pageObject.loginpage;
import resources.base;

public class homePageTest extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void login1() throws IOException {
		driver = driverinitialize();
		driver.get(prop.getProperty("url"));
		log.info("driver is initialised again");
	}

	// click on login and check if any popup present and kill it.
	@Test
	public void login() {
		landingpage L = new landingpage(driver);
		if (L.getPopUpSize() > 0)

		{

			L.getPopUp().click();

		}

		L.login().click();
		log.info("clicked login");
	}

	@Test(dataProvider = "data")
	public void login1(String username, String pass) throws InterruptedException {
		loginpage l1 = new loginpage(driver);
		l1.email().sendKeys(username);
		l1.pass().sendKeys(pass);
		l1.submit().click();
		Thread.sleep(2000);
		l1.email().clear();
		l1.pass().clear();
		log.info("sent email and pass");

	}

	@AfterTest
	public void quit() {
		driver.quit();
		log.info("driver closed");
	}

	@DataProvider
	public Object[][] data() {

		return new Object[][] { { "username1", "pass1" }, { "username2", "pass2" } };
	}

}
