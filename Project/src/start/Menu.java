package start;

import org.openqa.selenium.WebDriver;

import page.tests.LogInTest;
import page.tests.PostTest;
import page.tests.RegistrationTest;
import utility.Input;

public class Menu {

	// Metoda za pokretanje menija za automatsko registrovanje korisnika
	public static void regAuto(WebDriver dr) throws Exception {

		int opcija;
		System.out.println(
				"MENI ZA AUTOMATSKO REGISTROVANJE\nIzaberite opciju: \n1 - Registracija jednog korisnika \n2 - Registracija svih korisnika");
		opcija = Input.inputNum();

		switch (opcija) {

		case 1:
			RegistrationTest.fillRegForm(dr, Input.randRow(40));
			break;
		case 2:
			RegistrationTest.regAllUsers(dr);
			break;
		default:
			System.err.println("Pogresan unos! Ponovo pokrenite meni!");
		}

	}

	// Metoda za pokretanje menija za registraciju korisnika
	public static void register(WebDriver dr) throws Exception {

		int opcija;
		System.out.println(
				"MENI ZA REGISTROVANJE\nIzaberite opciju: \n1 - Manuelna registracija \n2 - Automatska registracija");
		opcija = Input.inputNum();

		switch (opcija) {

		case 1:
			RegistrationTest.manualRegister(dr);
			break;
		case 2:
			regAuto(dr);
			break;
		default:
			System.err.println("Pogresan unos! Ponovo pokrenite meni!");
		}

	}

	// Metoda za pokretanje menija za automatsko prijavljivanje korisnika
	public static void logInAuto(WebDriver dr) throws Exception {

		int opcija;
		System.out.println(
				"MENI ZA AUTOMATSKO PRIJAVLJIVANJE\nIzaberite opciju: \n1 - Prijavljivanje jednog korisnika \n2 - Prijavljivanje svih korisnika");
		opcija = Input.inputNum();

		switch (opcija) {

		case 1:
			LogInTest.fillLogInForm(dr, Input.randRow(40));
			break;
		case 2:
			LogInTest.logInAllUsers(dr);
			break;
		default:
			System.err.println("Pogresan unos! Ponovo pokrenite meni!");
		}

	}

	// Metoda za pokretanje menija za prijavljivanje korisnika
	public static void logIn(WebDriver dr) throws Exception {

		int opcija;
		System.out.println(
				"MENI ZA PRIJAVLJIVANJE\nIzaberite opciju: \n1 - Manuelno prijavljivanje \n2 - Automatsko prijavljivanje");
		opcija = Input.inputNum();

		switch (opcija) {

		case 1:
			LogInTest.manualLogIn(dr);
			break;
		case 2:
			logInAuto(dr);
			break;
		default:
			System.err.println("Pogresan unos! Ponovo pokrenite meni!");
		}

	}

	// Metoda za pokretanje menija za automatsko objavljivanje objava
	public static void postAuto(WebDriver dr) throws Exception {

		int opcija;
		System.out.println(
				"MENI ZA AUTOMATSKO OBJAVLJIVANJE\nIzaberite opciju: \n1 - Objava jednog post-a \n2 - Objava vise post-ova");
		opcija = Input.inputNum();

		switch (opcija) {

		case 1:
			PostTest.autoNewPost(dr, Input.randRow(100));
			Thread.sleep(2000);
			break;
		case 2:
			PostTest.userMultiplePost(dr, 6);
			break;
		default:
			System.err.println("Pogresan unos!");
		}

	}

	// Metoda za pokretanje menija za manipulisanje objavama
	public static void post(WebDriver dr) throws Exception {

		int opcija;
		System.out.println(
				"MENI ZA MANIPULISANJE OBJAVAMA\nIzaberite opciju: \n1 - Manuelna objava post-a \n2 - Automatska objava post-a \n3 - Brisanje post-a \n4 - Izmena post-a");
		opcija = Input.inputNum();

		switch (opcija) {

		case 1:
			PostTest.manualNewPost(dr);
			Thread.sleep(2000);
			break;
		case 2:
			postAuto(dr);
			break;
		case 3:
			PostTest.deletePost(dr, 2);
			break;
		case 4:
			PostTest.editPost(dr);
			break;
		default:
			System.err.println("Pogresan unos! Ponovo pokrenite meni!");
		}

	}

	// Metoda za pokretanje glavnog menija
	public static void meni(WebDriver dr) throws Exception {

		int opcija;
		System.out.println(
				"--Servis za testiranje--\nGLAVNI MENI\nIzaberite opciju: \n1 - Meni za registrovanje \n2 - Meni za prijavljivanje \n3 - Meni za manipulisanje objavama");
		opcija = Input.inputNum();

		switch (opcija) {

		case 1:
			register(dr);
			break;
		case 2:
			logIn(dr);
			break;
		case 3:
			post(dr);
			break;
		default:
			System.err.println("Pogresan unos! Ponovo pokrenite meni!");
		}

	}

}
