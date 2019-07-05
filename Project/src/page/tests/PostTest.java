package page.tests;

import org.openqa.selenium.WebDriver;

import page.objects.LogInPage;
import page.objects.PostPage;
import utility.Constant;
import utility.ExcelUtils;
import utility.Input;

public class PostTest {

	// Metoda koja obavlja proces objavljivanja objave sa podacima unetim od strane
	// korisnika i testira uspesnost obajavljivanja
	public static void manualNewPost(WebDriver dr) throws Exception {

		dr.get(LogInPage.PAGE_URL);
		LogInPage.userLogIn(dr, "denis", "denis");

		PostPage.clickMakeAPost(dr);

		System.out.println("Unesite naslov objave: ");
		String naziv = Input.input();
		PostPage.enterNaziv(dr, naziv);

		System.out.println("Unesite lokaciju: ");
		String lokacija = Input.input();
		PostPage.enterLokacija(dr, lokacija);

		PostPage.attachFile(dr);
		System.out.println("Datoteka ubacena!");

		// Ukoliko korisnik 3 puta pogresno unese nacin transporta metoda prestaje sa
		// izvrsavanjem
		System.out.println("Izaberite nacin transporta (Walk, Car, Motorbike, Bicycle ili Bus): ");
		int wrongResult = 0;
		boolean result = false;
		String transport = "";
		String[] trans_options = new String[] { "Walk", "Car", "Motorbike", "Bicycle", "Bus" };
		while (true) {
			transport = Input.input();
			for (int i = 0; i < trans_options.length; i++) {
				if (trans_options[i].equals(transport)) {
					System.out.println("Pravilan unos!");
					result = true;
					break;
				}
			}
			if (result == true) {
				PostPage.clickTransport(dr);
				PostPage.selectTransport(dr, transport);
				break;
			} else {
				System.err.println("Pogresan unos! Probajte ponovo (Walk, Car, Motorbike, Bicycle ili Bus): ");
				wrongResult++;
				if (wrongResult == 3) {
					System.err.println(
							"Tri puta unet pogresan transport. Prekinuto izvrsavanje! \nObjavljivanje neuspesno!");
					return;
				}
			}
		}

		System.out.println("Unesite kratak opis posta: ");
		String opis = Input.input();
		PostPage.enterOpis(dr, opis);

		Thread.sleep(3000);

		PostPage.clickPostButton(dr);

		if (dr.getCurrentUrl().equals(PostPage.POST_URL)) {
			System.out.println("Objavljivanje uspesno.");
		} else {
			System.err.println("Objavljivanje neuspesno!");
		}

	}

	// Metoda koja obavlja proces objavljivanja objave sa skupom podataka uzetih iz
	// datoteke Data.xls i testira uspesnost objavljivanja
	public static void autoNewPost(WebDriver dr, int i) throws Exception {

		dr.get(LogInPage.PAGE_URL);
		LogInPage.userLogIn(dr, "denis", "denis");

		String data;
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.TextSheet_TestData);

		PostPage.clickMakeAPost(dr);

		PostPage.clickNaziv(dr);
		data = ExcelUtils.getCellData(i, 1);
		PostPage.enterNaziv(dr, data);

		PostPage.clickLokacija(dr);
		data = ExcelUtils.getCellData(i, 2);
		PostPage.enterLokacija(dr, data);

		PostPage.attachFile(dr);

		PostPage.clickTransport(dr);
		PostPage.selectTransport(dr, Input.randomTransport());

		PostPage.clickOpis(dr);
		data = ExcelUtils.getCellData(i, 0);
		PostPage.enterOpis(dr, data);

		Thread.sleep(1000);
		PostPage.clickPostButton(dr);
		Thread.sleep(1000);

		if (dr.getCurrentUrl().equals(PostPage.POST_URL)) {
			System.out.println("Objavljivanje uspesno.");
		} else {
			System.err.println("Objavljivanje neuspesno!");
		}

	}

	// Metoda koja obavlja proces objavljivanja objava sa vise skupova podataka
	// uzetih iz datoteke Data.xls i testira uspesnost objavljivanja
	public static void userMultiplePost(WebDriver dr, int n) throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.TextSheet_TestData);

		for (int i = 1; i <= n; i++) {
			autoNewPost(dr, i);
			Thread.sleep(1000);
			LogInPage.clickLogOut(dr);
		}

	}

	// Metoda koja obavlja proces brisanja poslednjih n objava i testira uspesnost
	// brisanja
	public static void deletePost(WebDriver dr, int n) throws Exception {

		dr.get(LogInPage.PAGE_URL);
		LogInPage.userLogIn(dr, "denis", "denis");

		for (int i = 0; i < n; i++) {
			PostPage.clickDotsButton(dr);
			PostPage.clickTrashButton(dr);
		}

		if (dr.getCurrentUrl().equals(PostPage.POST_URL)) {
			System.out.println("Poslednjih " + n + " objava je obrisano.");
		} else {
			System.err.println("Objave nisu obrisane!");
		}

	}

	// Metoda koja obavlja proces izmene poslednje objave koristeci podatke unete od
	// strane korisnika i testira uspesnost izmene
	public static void editPost(WebDriver dr) throws Exception {

		dr.get(LogInPage.PAGE_URL);
		LogInPage.userLogIn(dr, "denis", "denis");

		PostPage.clickDotsButton(dr);
		PostPage.clickEditButton(dr);

		PostPage.clickEditNaziv(dr);
		PostPage.getEditNaziv(dr).clear();
		System.out.println("Unesite ispravljen naziv objave: ");
		PostPage.enterEditNaziv(dr, Input.input());

		PostPage.clickEditLokacija(dr);
		PostPage.getEditLokacija(dr).clear();
		System.out.println("Unesite ispravljenu lokaciju: ");
		PostPage.enterEditLokacija(dr, Input.input());

		PostPage.attachNewFile(dr);
		System.out.println("Nova slika postavljena.");

		PostPage.clickEditTransport(dr);
		PostPage.selectEditTransport(dr, Input.randomTransport());
		System.out.println("Nacin transporta izabran.");

		PostPage.clickEditOpis(dr);
		PostPage.getEditOpis(dr).clear();
		System.out.println("Unesite ispravljen opis objave: ");
		PostPage.enterEditOpis(dr, Input.input());

		PostPage.clickEditPostButton(dr);

		if (dr.getCurrentUrl().equals(PostPage.POST_URL)) {
			System.out.println("Objava je izmenjena.");
		} else {
			System.err.println("Objava nije izmenjena!");
		}
	}

}
