package EndtoEnd;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import resources.base;

public class AllureListener extends base implements ITestListener {

	// returns test case name
	public static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// takes screenshot for allure reports
	@Attachment(value = "screenshot on failure", type = "img/png")
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// attaches log message to allure reports
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		Object testclass = result.getInstance();
		// get the thread driver at failure from the test class
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(testclass);
		} catch (Exception e) {
		}
 		// AllureReport screenshot
		if (driver instanceof WebDriver)
			saveFailureScreenShot(driver);

		// save a log entry in allure
		saveTextLog(getTestMethodName(result) + "Failed and screenshot taken");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
