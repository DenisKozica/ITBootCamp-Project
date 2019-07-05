package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Input;

public class PostPage {

	public static final String POST_URL = "http://localhost/izlet/dashboard.php";
	private static final String MAKE_A_POST_BUTTON = "//a[contains(text(),'Make a post')]";
	private static final String NAZIV = "//input[@placeholder='Naziv']";
	private static final String LOKACIJA = "//input[@placeholder='Lokacija']";
	private static final String BROWSE_BUTTON = "//input[@id='image']";
	private static final String IMAGES_FOLDER = "C:\\Users\\Denis\\Desktop\\IT Bootcamp\\Project\\Project\\";
	private static final String TRANSPORT = "//div[@class='popupPost']//select[@name='transport']";
	private static final String OPIS = "//textarea[@placeholder='Opis']";
	private static final String POST_BUTTON = "//div[@class='popupPost']//input[@name='postSubmit']";
	private static final String DOTS_BUTTON = "fa-ellipsis-v";
	private static final String TRASH_BUTTON = "fa-trash-alt";
	private static final String EDIT_BUTTON = "fa-edit";
	private static final String EDIT_NAZIV = "//input[@id='title']";
	private static final String EDIT_LOKACIJA = "//input[@id='location']";
	private static final String EDIT_CHANGE_BUTTON = "//input[@id='editImage']";
	private static final String EDIT_TRANSPORT = "//select[@id='transport']";
	private static final String EDIT_OPIS = "//textarea[@id='description']";
	private static final String EDIT_POST_BUTTON = "//div[@class='popupEdit']//input[@name='postSubmit']";

	// Metode za objekat DUGME ZA PRAVLJENJE NOVE OBJAVE
	public static WebElement getMakeAPost(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(MAKE_A_POST_BUTTON));
		return wb;
	}

	public static void clickMakeAPost(WebDriver dr) {
		getMakeAPost(dr).click();
	}

	// Metode za objekat NAZIV OBJAVE
	public static WebElement getNaziv(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(NAZIV));
		return wb;
	}

	public static void clickNaziv(WebDriver dr) {
		getNaziv(dr).click();
	}

	public static void enterNaziv(WebDriver dr, String text) {
		getNaziv(dr).sendKeys(text);
	}

	// Metode za objekat LOKACIJA
	public static WebElement getLokacija(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOKACIJA));
		return wb;
	}

	public static void clickLokacija(WebDriver dr) {
		getLokacija(dr).click();
	}

	public static void enterLokacija(WebDriver dr, String text) {
		getLokacija(dr).sendKeys(text);
	}

	// Metode za objekat IZBOR DATOTEKE ZA OBJAVU
	public static WebElement getBrowse(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(BROWSE_BUTTON));
		return wb;
	}

	public static void clickBrowse(WebDriver dr) {
		getBrowse(dr).click();
	}

	public static void attachFile(WebDriver dr) {
		getBrowse(dr).sendKeys(IMAGES_FOLDER + Input.randomImage());
	}

	// Metode za objekat IZBOR NACINA TRANSPORTA
	public static WebElement getTransport(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(TRANSPORT));
		return wb;
	}

	public static void clickTransport(WebDriver dr) {
		getTransport(dr).click();
	}

	public static void selectTransport(WebDriver dr, String text) {
		Select transport = new Select(getTransport(dr));
		transport.selectByVisibleText(text);
	}

	// Metode za objekat OPIS OBJAVE
	public static WebElement getOpis(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(OPIS));
		return wb;
	}

	public static void clickOpis(WebDriver dr) {
		getOpis(dr).click();
	}

	public static void enterOpis(WebDriver dr, String text) {
		getOpis(dr).sendKeys(text);
	}

	// Metode za objekat DUGME ZA OBJAVLJIVANJE
	public static WebElement getPostButton(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(POST_BUTTON));
		return wb;
	}

	public static void clickPostButton(WebDriver dr) {
		getPostButton(dr).click();
	}

	// Metode za objekat DUGME ZA OPCIJE MANIPULISANJA OBJAVOM
	public static WebElement getDotsButton(WebDriver dr) {
		WebElement wb = dr.findElement(By.className(DOTS_BUTTON));
		return wb;
	}

	public static void clickDotsButton(WebDriver dr) {
		getDotsButton(dr).click();
	}

	// Metode za objekat DUGME ZA BRISANJE OBJAVE
	public static WebElement getTrashButton(WebDriver dr) {
		WebElement wb = dr.findElement(By.className(TRASH_BUTTON));
		return wb;
	}

	public static void clickTrashButton(WebDriver dr) {
		getTrashButton(dr).click();
	}

	// Metode za objekat DUGME ZA IZMENU SADRZAJA OBJAVE
	public static WebElement getEditButton(WebDriver dr) {
		WebElement wb = dr.findElement(By.className("fa-edit"));
		return wb;
	}

	public static void clickEditButton(WebDriver dr) {
		getEditButton(dr).click();
	}

	// Metode za objekat NOVI NAZIV OBJAVE
	public static WebElement getEditNaziv(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDIT_NAZIV));
		return wb;
	}

	public static void clickEditNaziv(WebDriver dr) {
		getEditNaziv(dr).click();
	}

	public static void enterEditNaziv(WebDriver dr, String text) {
		getEditNaziv(dr).sendKeys(text);
	}

	// Metode za objekat NOVA LOKACIJA OBJAVE
	public static WebElement getEditLokacija(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDIT_LOKACIJA));
		return wb;
	}

	public static void clickEditLokacija(WebDriver dr) {
		getEditLokacija(dr).click();
	}

	public static void enterEditLokacija(WebDriver dr, String text) {
		getEditLokacija(dr).sendKeys(text);
	}

	// Metode za objekat IZBOR NOVE DATOTEKE U OBJAVI
	public static WebElement getChange(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDIT_CHANGE_BUTTON));
		return wb;
	}

	public static void clickChange(WebDriver dr) {
		getChange(dr).click();
	}

	public static void attachNewFile(WebDriver dr) {
		getChange(dr).sendKeys(IMAGES_FOLDER + Input.randomImage());
	}

	// Metode za objekat IZBOR NOVOG NACINA TRANSPORTA
	public static WebElement getEditTransport(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDIT_TRANSPORT));
		return wb;
	}

	public static void clickEditTransport(WebDriver dr) {
		getEditTransport(dr).click();
	}

	public static void selectEditTransport(WebDriver dr, String text) {
		Select transport = new Select(getEditTransport(dr));
		transport.selectByVisibleText(text);
	}

	// Metode za objekat NOVI OPIS OBJAVE
	public static WebElement getEditOpis(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDIT_OPIS));
		return wb;
	}

	public static void clickEditOpis(WebDriver dr) {
		getEditOpis(dr).click();
	}

	public static void enterEditOpis(WebDriver dr, String text) {
		getEditOpis(dr).sendKeys(text);
	}

	// Metode za objekat DUGME ZA OBJAVLJIVANJE IZMENJENE OBJAVE
	public static WebElement getEditPostButton(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDIT_POST_BUTTON));
		return wb;
	}

	public static void clickEditPostButton(WebDriver dr) {
		getEditPostButton(dr).click();
	}

}
