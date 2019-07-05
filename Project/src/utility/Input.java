package utility;

import java.util.Random;
import java.util.Scanner;

public class Input {

	// Metoda koja poziva skener i vraca podatke unete od strane korisnika na
	// konzoli
	public static String input() throws Exception {

		Scanner sc = new Scanner(System.in);
		String input;

		input = sc.nextLine();

		return input;

	}

	// Metoda koja poziva skener i vraca podatke unete od strane korisnika na
	// konzoli
	public static int inputNum() throws Exception {

		Scanner sc = new Scanner(System.in);
		int input;

		input = sc.nextInt();

		return input;

	}

	// Metoda koja vraca nacin transporta po principu slucajnog odabira
	public static String randomTransport() {

		String[] transport = new String[] { "Walk", "Car", "Motorbike", "Bus", "Bicycle" };

		Random rand = new Random();

		int randomIndex = rand.nextInt(transport.length);

		return transport[randomIndex];

	}

	// Metoda koja vraca proizvoljan ceo broj od 1 do argumentovanog maksimuma i
	// sluzi za izbor jednog reda koji sadrzi skup podataka iz datoteke Data.xls
	public static int randRow(int max) {

		Random rand = new Random();

		int randomNum = rand.nextInt(max) + 1;

		return randomNum;
		
	}

	// Metoda koja vraca index elementa niza sastavljenog od imena datoteka koje se
	// nalaze u
	// odredjenom folderu i sluzi za dodavanje tih imena putanji samog foldera kako
	// bi slucajnim odabirom bila objavljena jedna datoteka iz pomenutog foldera
	public static String randomImage() {

		String[] image = new String[] { "Azra.jpg", "Che.jpg", "Lpool.png", "Yuga.png", "Partizan.jpg" };

		Random rand = new Random();

		int randomIndex = rand.nextInt(image.length);

		return image[randomIndex];

	}

}
