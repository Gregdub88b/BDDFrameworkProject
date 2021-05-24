package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import Listeners.ExtentReportListener;
import Utility.Constants;
import Utility.GenericUtility;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SchoolsHtml extends ExtentReportListener {

	WebDriver driver;
	GenericUtility utils;

	@Test
	@Given("check the Firefox browser is open")
	public void check_the_firefox_browser_is_open() throws IOException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		utils = new GenericUtility(driver);

		ExtentTest logInfo = null;
		try {
			test = extent.createTest(Feature.class, "3schools Feature");
			test = test.createNode(Scenario.class, "Scenario 3schools");
			logInfo = test.createNode(new GherkinKeyword("Given"), "check the Firefox browser is open");
			logInfo.pass("Browser is opened...");

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@Test
	@When("navigate to 3schools home page")
	public void navigate_to_3schools_home_page() throws IOException {

		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("When"), "navigate to 3schools home page");
			logInfo.pass("Navigate to 3Wschools....");
			utils.goToUrl(Constants.URL_3SCHOOLS);
			utils.dynamicWait(Constants.ACCEPT_COOKIE_3SCHOOLS, 1000);
			utils.acceptCookies(Constants.ACCEPT_COOKIE_3SCHOOLS);
			

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@Test
	@Then("validate title text")
	public void validate_title_text() {

		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("Then"), "validate title text");
			logInfo.pass("The Title has been validated succesfully");
			
		   // utils.validateText(Constants.HOMEPAGE_TEXT_LOCATOR, "Paid Courses");
			utils.validateTitle("HTML Tutorial");

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

		driver.close();

	}

}
