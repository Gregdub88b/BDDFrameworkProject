package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//POM - Page Object Model
public class PageLogin {

	WebDriver driver;

	By txt_username = By.id("name");
	By txt_usernamepassword = By.id("password");
	By country_L = By.id("country");
	By address_L = By.id("address");
	By email_L = By.id("email");
	By phone_L = By.id("phone");

	public PageLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void ProvideData(String username, String password) {
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_usernamepassword).sendKeys(password);

	}

	public void setupForm(String country,String address,String email, String phone) {
		driver.findElement(country_L).sendKeys(country);
		driver.findElement(address_L).sendKeys(address);
		driver.findElement(email_L).sendKeys(email);
		driver.findElement(phone_L).sendKeys(phone);
		}


	

}
