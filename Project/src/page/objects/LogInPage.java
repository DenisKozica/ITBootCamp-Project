package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	public static final String PAGE_URL = "http://localhost/izlet/index.php";
	public static final String LOG_IN_URL = "http://localhost/izlet/dashboard.php";
	private static final String USERNAME = "//input[@placeholder='username']";
	private static final String PASSWORD = "//input[@placeholder='password']";
	private static final String LOGIN_BUTTON = "//input[@name='login']";
	private static final String LOGOUT_BUTTON = "//a[@id='logoutBtn']";

	// Metode za objekat KORISNICKO IME
	public static WebElement getUsername(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(USERNAME));
		return wb;
	}

	public static void clickUsername(WebDriver dr) {
		getUsername(dr).click();
	}

	public static void enterUsername(WebDriver dr, String text) {
		getUsername(dr).sendKeys(text);
	}

	// Metode za objekat SIFRA
	public static WebElement getPassword(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(PASSWORD));
		return wb;
	}

	public static void clickPassword(WebDriver dr) {
		getPassword(dr).click();
	}

	public static void enterPassword(WebDriver dr, String text) {
		getPassword(dr).sendKeys(text);
	}

	// Metode za objekat DUGME ZA PRIJAVLJIVANJE
	public static WebElement getLogIn(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOGIN_BUTTON));
		return wb;
	}

	public static void clickLogIn(WebDriver dr) {
		getLogIn(dr).click();
	}

	// Metode za objekat DUGME ZA ODJAVLJIVANJE
	public static WebElement getLogOut(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOGOUT_BUTTON));
		return wb;
	}

	public static void clickLogOut(WebDriver dr) {
		getLogOut(dr).click();
	}

	// Metoda za PRIJAVLJIVANJE REGISTROVANOG KORISNIKA
	public static void userLogIn(WebDriver dr, String username, String password) throws Exception {
		enterUsername(dr, username);
		enterPassword(dr, password);
		Thread.sleep(2000);
		clickLogIn(dr);
	}

}
