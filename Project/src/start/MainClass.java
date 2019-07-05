package start;

import page.tests.LogInTest;
import page.tests.PostTest;
import page.tests.RegistrationTest;
import page.objects.RegistrationPage;
import page.objects.LogInPage;
import page.objects.PostPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.*;

public class MainClass {

	// Glavna klasa koja pokrece meni preko kojeg se vrsi izbor metoda za
	// izvrsavanje
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Menu.meni(driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
