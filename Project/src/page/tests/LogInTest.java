package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.LogInPage;
import page.objects.RegistrationPage;
import utility.Constant;
import utility.ExcelUtils;
import utility.Input;

public class LogInTest {

	// Metoda koja obavlja proces prijavljivanja sa podacima unetim od strane
	// korisnika i testiranja unetih podataka
	public static void manualLogIn(WebDriver driver) throws Exception {

		driver.get(LogInPage.PAGE_URL);

		System.out.println("Korisnicko ime: ");
		String username = Input.input();

		System.out.println("Sifra: ");
		String password = Input.input();

		LogInPage.userLogIn(driver, username, password);

		if (driver.getCurrentUrl().equals(LogInPage.LOG_IN_URL)) {
			System.out.println("Prijava je uspesna.");
		} else {
			System.err.println("Prijava je neuspesna!");
		}

	}

	// Metoda koja obavlja proces prijavljivanja sa skupom podataka uzetih iz
	// datoteke Data.xls i testira proces vracajuci informaciju o uspesnosti testa
	// koju
	// smesta u datoteku Data.xls
	public static void fillLogInForm(WebDriver dr, int i) throws Exception {

		String data;
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.RegSheet_TestData);

		dr.get(RegistrationPage.PAGE_URL);

		LogInPage.clickUsername(dr);
		data = ExcelUtils.getCellData(i, 2);
		LogInPage.enterUsername(dr, data);

		LogInPage.clickPassword(dr);
		data = ExcelUtils.getCellData(i, 4);
		LogInPage.enterPassword(dr, data);

		LogInPage.clickLogIn(dr);

		ExcelUtils.setCellData("LogInTest", 0, 5);

		if (dr.getCurrentUrl().equals(LogInPage.LOG_IN_URL)) {
			System.out.println("Prijavljivanje je uspesno.");
			ExcelUtils.setCellData("Pass", i, 5);
		} else {
			System.err.println("Prijavljivanje je neuspesno!");
			ExcelUtils.setCellData("Fail", i, 5);
		}

	}

	// Metoda koja obavlja proces prijavljivanja sa celokupnim skupom podataka iz
	// datoteke Data.xls i testira proces vracajuci informaciju o uspesnosti testa
	// koju
	// smesta u datoteku Data.xls
	public static void logInAllUsers(WebDriver dr) throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.RegSheet_TestData);

		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillLogInForm(dr, i);
			Thread.sleep(500);
			LogInPage.clickLogOut(dr);
		}

	}

}
