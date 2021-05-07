package EndtoEnd;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
import resources.base;

@Listeners({ AllureListener.class })
public class validateTitleTest extends base {

	public WebDriver driver;

	@BeforeTest
	public void setup() throws IOException {
		driver = driverinitialize();
		driver.get(prop.getProperty("url"));

	}

	@Test
	@Description("Verify Title")
	@Epic("Epic003")
	@Feature("Feature 03")
	@Story(" Story : Enter base Url and check the title")
	@Step("Verify title is correct")
	@Severity(SeverityLevel.TRIVIAL)
	public void land() {
		landingpage l = new landingpage(driver);
		if (l.getPopUpSize() > 0)

		{

			l.getPopUp().click();

		}

		Assert.assertEquals("FEATURED COURSE", l.title().getText());

	}

	@Test
	@Description("Navigation bar is displayed")
	@Epic("Epic004")
	@Feature("Feature 04")
	@Story(" Story : TO check if Nav bar is displayed")
	@Step("Verify navigation bar is displayed")
	@Severity(SeverityLevel.NORMAL)
	public void navbar() {
		landingpage l = new landingpage(driver);
		Assert.assertTrue(l.getnavbar().isDisplayed());
		
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		
	}
}
