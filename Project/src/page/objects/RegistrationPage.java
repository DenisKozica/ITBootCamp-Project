package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

	public static final String PAGE_URL = "http://localhost/izlet/index.php";
	private static final String FIRST_NAME = "//input[@name='firstname']";
	private static final String LAST_NAME = "//input[@name='lastname']";
	private static final String USERNAME = "//div[@class='register_form']//input[@name='username']";
	private static final String EMAIL = "//input[@name='email']";
	private static final String PASSWORD = "//div[@class='register_form']//input[@name='password']";
	private static final String REGISTER_BUTTON = "//input[@id='blue_btn']";

	// Metode za objekat IME
	public static WebElement getFirstName(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(FIRST_NAME));
		return wb;
	}

	public static void clickFirstName(WebDriver dr) {
		getFirstName(dr).click();
	}

	public static void enterFirstName(WebDriver dr, String text) {
		getFirstName(dr).sendKeys(text);
	}

	// Metode za objekat PREZIME
	public static WebElement getLastName(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LAST_NAME));
		return wb;
	}

	public static void clickLastName(WebDriver dr) {
		getLastName(dr).click();
	}

	public static void enterLastName(WebDriver dr, String text) {
		getLastName(dr).sendKeys(text);
	}

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

	// Metode za objekat E-MAIL
	public static WebElement getEmail(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EMAIL));
		return wb;
	}

	public static void clickEmail(WebDriver dr) {
		getEmail(dr).click();
	}

	public static void enterEmail(WebDriver dr, String text) {
		getEmail(dr).sendKeys(text);
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

	// Metode za objekat DUGME ZA REGISTRACIJU
	public static WebElement getRegister(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(REGISTER_BUTTON));
		return wb;
	}

	public static void clickRegister(WebDriver dr) {
		getRegister(dr).click();
	}

	// Metoda za povratak na POCETNU STRANU
	public static void loadHomepage(WebDriver dr) {
		dr.navigate().to(PAGE_URL);
	}

}
