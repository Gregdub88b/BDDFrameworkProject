package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import Listeners.ExtentReportListener;
import Pages.PageLogin;
import Utility.Constants;
import Utility.ExcelReader;
import Utility.GenericUtility;
import Utility.Log;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends ExtentReportListener {

	WebDriver driver;
	GenericUtility utils;
	PageLogin login;
	ExtentTest logInfo;

	@Given("browser is open")
	public void browser_is_open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		login = new PageLogin(driver);
		utils = new GenericUtility(driver);
		test = extent.createTest(Feature.class, "Login Test");
		test = test.createNode(Scenario.class, "Login");

		try {

			logInfo = test.createNode(new GherkinKeyword("Given"), "browser is open");
			logInfo.pass("Browser is opened...");

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}
	}

	@And("user is on example login page")
	public void user_is_on_example_login_page() {

		try {

			logInfo = test.createNode(new GherkinKeyword("And"), "navigate to login page");
			logInfo.pass("user is on login page...");

			utils.goToUrl(Constants.URL_LOGIN_TEST);

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@When("user enters {string} and {int}")
	public void user_enters(String Login, Integer RowNumber)
			throws InterruptedException, InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(Constants.DATA, Login);

		String dataUser = testData.get(RowNumber).get("username");
		String dataPassword = testData.get(RowNumber).get("password");

		try {
			String runMode = testData.get(RowNumber).get("Runmode");
			if (runMode.equals("Yes")) {
				Log.info("Found data for test");
				utils.navigateToForm(Constants.LOGINBTN_L);
				login.ProvideData(dataUser, dataPassword);
			} else {
				Log.info("Skipped test..");
			}

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@And("user click on login button and fill out the form")
	public void user_click_on_login_button() throws InterruptedException, IOException, InvalidFormatException {

		try {

			logInfo = test.createNode(new GherkinKeyword("And"), "user click on login button and fill out the form");
			logInfo.pass("user is succesfully logged on..");

			utils.clickOnButton(Constants.LOGINBTN_L);
			login.setupForm(Constants.COUNTRY, Constants.ADDRESS, Constants.EMAIL, Constants.PHONE);

			utils.clickOnButton(Constants.SAVEBTN_L);
			utils.clickOnButton(Constants.LOGOUTBTN_L);

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@Then("user is navigate to home page")
	public void user_is_navigate_to_home_page() {
		try {

			logInfo = test.createNode(new GherkinKeyword("Then"), "user is navigate to home page");
			logInfo.pass("driver has been closed");
			utils.close();

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

}
