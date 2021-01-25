package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreportNG {
	static ExtentReports extent;

	public static ExtentReports extentreport() {
		String path = System.getProperty("user.dir") + "\\newreport\\report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA-Analyst", "Naveen");
		return extent;
	}
}
