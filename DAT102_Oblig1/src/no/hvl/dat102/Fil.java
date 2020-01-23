package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat102.adt.CDarkivADT;

public class Fil {

	private static final String SKILLE = "#";

	public static CDarkivADT lesFraFil(String filnavn) {
		CDarkivADT cda = null;
		try {

			FileReader ansFil = new FileReader(filnavn);

			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser den første posten som kun inneholder et heltall som er antall
			// info-poster

			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);
			cda = new CDarkiv();

			// 4 - Les postene, en hel post om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String artist = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				String sjStr = felt[4];
				Sjanger sj = Sjanger.finnSjanger(sjStr);
				String plateselskap = felt[5];

				CD cd = new CD(nr, artist, tittel, aar, sj, plateselskap);

				cda.leggTilCd(cd);

				// 4 - Lukk filen
				innfil.close();
			}

		} catch (FileNotFoundException unntak) {// arver fra IOE.. må stå først
												// hvis ikke vil unntaket for IOException skygge
			System.out.println("Finner ikke filen " + filnavn);
			System.exit(1); // avbryte utføringen
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2); // avbryte utføringen
		}

		return cda;

	}// metode

	public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn) {
		try {

			FileWriter ansFil = new FileWriter(filnavn, false);

			PrintWriter utfil = new PrintWriter(ansFil);
			int antall = cdarkiv.antall();

			// 3 - Skriver først ut antall cd-info-er på første linje
			utfil.println(antall);
			CD[] tabell = cdarkiv.hentCdTabell();
			for (int i = 0; i < antall; i++) {

				// 3 - Skriver postene, felt for felt
				utfil.print(tabell[i].getCDnummer());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getArtist());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getCD());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getLansering());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getSjanger());
				utfil.print(SKILLE);
				utfil.println(tabell[i].getPlateselskap());
			} // for
				// 4 - Lukk filen
			utfil.close();
		} // try

		catch (FileNotFoundException e) {
			System.out.print("feil ved åpning av fil: " + filnavn);
			System.exit(1); // avbryte utføringen
		} catch (IOException e) {
			System.out.println("Feil på skriving til fil: " + e);
			System.exit(2);// avbryte utføringen
		}

	}// metode

}// class