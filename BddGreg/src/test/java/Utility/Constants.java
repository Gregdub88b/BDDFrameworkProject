package Utility;

import org.openqa.selenium.By;

public class Constants {

	public static final String URL_3SCHOOLS = "https://www.w3schools.com/html/default.asp";
	public static final String HOMEPAGE_TXT = "/html[1]/body[1]/div[1]/div[2]/a[1]";
	public static final By HOMEPAGE_TEXT_LOCATOR = By.xpath(HOMEPAGE_TXT);
	public static final By ACCEPT_COOKIE_3SCHOOLS = By.id("accept-choices");
	public static final String URL_LOGIN_TEST = "https://example.testproject.io/web/";
	public static final String data = "C:\\Users\\gbujnows\\Desktop\\BDDDataDriven\\BddGreg\\testng.xml";
	public static final String EXCEL_DATA_SHEET = "C:\\Users\\gbujnows\\Desktop\\BDDDataDriven\\BddGreg\\automation.xlsx";
	public static final String LOGINBTN = "login";
	public static final By LOGINBTN_L = By.id(LOGINBTN);
	public static final String SAVEBTN = "save";
	public static final By SAVEBTN_L = By.id(SAVEBTN);
	public static final String LOGOUTBTN = "logout";
	public static final By LOGOUTBTN_L = By.id(LOGOUTBTN);
	public static final String COUNTRY = "Ireland";
	public static final String ADDRESS = "12 Herbert Street";
	public static final String EMAIL = "greg@gmail.com";
	public static final String PHONE = "01010101010";

}
