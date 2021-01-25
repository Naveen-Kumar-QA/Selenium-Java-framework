package EndtoEnd;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.landingpage;
import resources.base;

public class validateTitleTest extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void login() throws IOException {
		driver = driverinitialize();
		log.info("driver is initialised");
		driver.get(prop.getProperty("url"));
		
	}

	@Test
	public void land() {
		landingpage l = new landingpage(driver);
		if (l.getPopUpSize() > 0)

		{

			l.getPopUp().click();

		}

		Assert.assertEquals("FEATURED COURSS", l.title().getText());

		log.debug("title validated");
		log.error("tittle not valid");
	}

	@Test
	public void navbar() {
		landingpage l = new landingpage(driver);
		Assert.assertTrue(l.getnavbar().isDisplayed());
		log.info("Nav bar displayed");
	}

	@AfterTest
	public void quit() {
		driver.quit();
		log.info("driver quit");
	}
}
