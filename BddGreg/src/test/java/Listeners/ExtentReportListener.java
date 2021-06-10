package Listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utility.Log;

public class ExtentReportListener {

	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;

	
	//create  new ExtentReport
	
	public static ExtentReports setUp() {
		String reportLocation = System.getProperty("user.dir") + "./reports/" + getDateAndTimeReport() + ".html";
		;
		report = new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.DARK);
		Log.info("Extent Report location initialized . . .");
		report.start();
		//configuration ExtentReport
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "Test");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		Log.info("System Info. set in Extent Report");
		return extent;
	}

	
	//execute when the test is failed in catch block trigger 
	public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable) {
		switch (teststatus) {
		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));
			extenttest.error(throwable.fillInStackTrace());

			try {
				//taking the screenshot
				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
				
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (driver != null) {
				driver.quit();
			}
			break;

		case "PASS":
			extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
			break;

		default:
			break;
		}
	}
	
	public static String captureScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = "/reports/" + getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	//get the current time and date for Extent Report
	private static String getDateAndTimeReport() {

		String str = null;
		try {

			Date date = new Date();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd/HH.mm.ss").format(new Date());
			str = timeStamp.formatted(date);

		} catch (Exception e) {
		}
		return str;
	}
	
	//get the current time and date for screenshot
	private static String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replace("/", "").replace(":", "");

		} catch (Exception e) {
		}
		return str;
	}

}
