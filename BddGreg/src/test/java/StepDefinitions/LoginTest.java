package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Listeners.ExtentReportListener;
import Utility.Constants;
import Utility.ExcelReader;
import Utility.ExcelReader3;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginTest extends ExtentReportListener{
	

	public static  WebDriver driver;
	PageLogin login;
	
	//@Test
	@Given("browser is open")
	public void browser_is_open() {
        WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		login = new PageLogin(driver);
	}
	//@Test
	@And("user is on example login page")
	public void user_is_on_google_login_page() {

		driver.get(Constants.LoginTest);

	}
	
	
	
	//@Test
	@When("user enters {string} and {int}")
	public void user_enters(String Login, Integer RowNumber)
			throws InterruptedException, InvalidFormatException, IOException {
  
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(Constants.EXCEL_DATA_SHEET, Login);
        
		String dataUser = testData.get(RowNumber).get("username");
		String dataPassword = testData.get(RowNumber).get("password");
		login.navigateToForm();
		login.ProvideData(dataUser, dataPassword);
		

		System.out.println("UserName :" + dataUser);
		System.out.println("Password :" + dataPassword);
   
		Thread.sleep(200);

	}
	//@Test
	@And("user click on login button and fill out the form")
	public void user_click_on_login_button()
			throws InterruptedException, IOException, InvalidFormatException {
		

		
		login.clickLogin();
		
		
		  driver.findElement(By.id("country")).sendKeys("Ireland");
		  driver.findElement(By.id("address")).sendKeys("12 Rialto Dublin 8");
		  driver.findElement(By.id("email")).sendKeys("greg@gmail.com");
		  driver.findElement(By.id("phone")).sendKeys("0101010101");
		 
	


		login.clickSave();
		login.clickLogout();
		
		
		Thread.sleep(200);

	}
	//@Test
	@Then("user is navigate to home page")
	public void user_is_navigate_to_home_page() {
		driver.close();
	}
	

}
