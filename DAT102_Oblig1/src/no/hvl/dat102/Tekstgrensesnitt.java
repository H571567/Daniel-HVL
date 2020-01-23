package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.adt.CDarkivADT;

public class Tekstgrensesnitt {

	private Scanner in;

	public Tekstgrensesnitt() {
		in = new Scanner(System.in);
	}

	// lese opplysningene om en CD fra tastatur
	public CD lesCD() {

		CD cd = new CD();
		System.out.println("CD nummer: ");

		cd.setCDnummer(in.nextInt());
		in.nextLine();

		System.out.println("Artistnavn: ");
		cd.setArtist(in.nextLine());

		System.out.println("AlbumTittel: ");
		cd.setCD(in.nextLine());

		System.out.println("Utgivelseaar: ");
		cd.setLansering(in.nextInt());
		in.nextLine();

		System.out.println("ROCK(1), POP(2), OPERA(3), KLASSISK(4)");
		System.out.println("Skriv inn et nummer: ");
		int valg = in.nextInt();
		in.nextLine();
		Sjanger sjangerK = Sjanger.KLASSISK;
		Sjanger sjangerR = Sjanger.ROCK;
		Sjanger sjangerO = Sjanger.OPERA;
		Sjanger sjangerP = Sjanger.POP;
		if (valg == 1) {
			cd.setSjanger(sjangerP);
		} else if (valg == 2) {
			cd.setSjanger(sjangerR);
		} else if (valg == 3) {
			cd.setSjanger(sjangerO);
		} else if (valg == 4) {
			cd.setSjanger(sjangerK);
		}
		System.out.println("Plateselskap: ");
		cd.setPlateselskap(in.nextLine());

		return cd;
	}

	// vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visCD(CD cd) {
		System.out.println(cd.getCDnummer());
		System.out.println(cd.getCD());
		System.out.println(cd.getArtist());
		System.out.println(cd.getSjanger());
		System.out.println(cd.getLansering());
		System.out.println(cd.getPlateselskap());
	}

	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {
		System.out.println();
		CD[] nye = cda.sokTittel(delstreng);
		for (int i = 0; i < nye.length; i++) {
			visCD(nye[i]);
			System.out.println("Neste CD: ");
		}
	}

	// Skriver ut alle CD-er av en artist / en gruppe
	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {

		CD[] nye = cda.sokArtist(delstreng);
		for (int i = 0; i < nye.length; i++) {
			visCD(nye[i]);
			System.out.println("Neste Artist: ");
		}
	}

	// Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(CDarkivADT cda) {

		System.out.println(
				"Antall CDer: " + cda.antall() + " med antallet \n" + cda.antallSjanger(Sjanger.POP) + " CDer med POP, \n"
						+ cda.antallSjanger(Sjanger.ROCK) + " CDer med ROCK, \n" + cda.antallSjanger(Sjanger.OPERA)
						+ " CDer med OPERA, \n" + cda.antallSjanger(Sjanger.KLASSISK) + " CDer med KLASSISK, \n");
	}

}