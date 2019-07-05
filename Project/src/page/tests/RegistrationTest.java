package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.LogInPage;
import page.objects.RegistrationPage;
import utility.*;

public class RegistrationTest {

	// Metoda za obavljanje procesa registracije sa podacima unetim od strane
	// korisnika i testiranje unetih podataka
	public static void manualRegister(WebDriver driver) throws Exception {

		driver.get(RegistrationPage.PAGE_URL);

		System.out.println("Ime: ");
		String firstName = Input.input();
		RegistrationPage.enterFirstName(driver, firstName);

		System.out.println("Prezime: ");
		String lastName = Input.input();
		RegistrationPage.enterLastName(driver, lastName);

		System.out.println("Korisnicko ime: ");
		String username = Input.input();
		RegistrationPage.enterUsername(driver, username);

		System.out.println("E-mail: ");
		String email = Input.input();
		RegistrationPage.enterEmail(driver, email);

		System.out.println("Sifra: ");
		String password = Input.input();
		RegistrationPage.enterPassword(driver, password);

		RegistrationPage.clickRegister(driver);

		LogInPage.userLogIn(driver, username, password);

		if (driver.getCurrentUrl().equals(LogInPage.LOG_IN_URL)) {
			System.out.println("Registracija je uspesna.");
		} else {
			System.err.println("Registracija je neuspesna!");
		}

	}

	// Metoda koja obavlja proces registracije sa skupom podataka uzetih iz datoteke
	// Data.xls i testira proces vracajuci informaciju o uspesnosti testa koju
	// smesta u datoteku Data.xls
	public static void fillRegForm(WebDriver dr, int i) throws Exception {

		String data;
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.RegSheet_TestData);

		dr.get(RegistrationPage.PAGE_URL);

		RegistrationPage.clickFirstName(dr);
		data = ExcelUtils.getCellData(i, 0);
		RegistrationPage.enterFirstName(dr, data);

		RegistrationPage.clickLastName(dr);
		data = ExcelUtils.getCellData(i, 1);
		RegistrationPage.enterLastName(dr, data);

		RegistrationPage.clickUsername(dr);
		data = ExcelUtils.getCellData(i, 2);
		String username = data;
		RegistrationPage.enterUsername(dr, data);

		RegistrationPage.clickEmail(dr);
		data = ExcelUtils.getCellData(i, 3);
		RegistrationPage.enterEmail(dr, data);

		RegistrationPage.clickPassword(dr);
		data = ExcelUtils.getCellData(i, 4);
		String password = data;
		RegistrationPage.enterPassword(dr, data);

		RegistrationPage.clickRegister(dr);

		Thread.sleep(1000);
		LogInPage.userLogIn(dr, username, password);

		ExcelUtils.setCellData("LogInTest", 0, 5);

		if (dr.getCurrentUrl().equals(LogInPage.LOG_IN_URL)) {
			System.out.println("Registrovanje je uspesno.");
			ExcelUtils.setCellData("Pass", i, 5);
		} else {
			System.err.println("Registrovanje je neuspesno!");
			ExcelUtils.setCellData("Fail", i, 5);
		}

	}

	// Obavlja proces registracije sa celokupnim skupom podataka iz datoteke
	// Data.xls i testira proces vracajuci informaciju o uspesnosti testa koju
	// smesta u datoteku Data.xls
	public static void regAllUsers(WebDriver dr) throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.RegSheet_TestData);

		for (int i = 1; i < ExcelUtils.getWorkSheet().getLastRowNum() + 1; i++) {
			fillRegForm(dr, i);
			Thread.sleep(500);
			LogInPage.clickLogOut(dr);
		}

	}

}
