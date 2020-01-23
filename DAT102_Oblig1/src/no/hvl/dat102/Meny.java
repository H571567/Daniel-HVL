package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.adt.CDarkivADT;

public class Meny {

	 private Tekstgrensesnitt tekstgr;
	 private CDarkivADT cda;
	 
	 public Meny(CDarkivADT cda) {
	 tekstgr = new Tekstgrensesnitt();
	 this.cda = cda;
	 
	 }
	
	 public void start(){
		
		 boolean run = true;
	        Scanner sc = new Scanner(System.in);
	        while (run) {
	            System.out.println("\n--- MENY ---\n");
	            System.out.println("1) Legg til en ny CD i arkivet");
	            System.out.println("2) Finn plater ved hjelp av tittel");
	            System.out.println("3) Finn plater ved hjelp av artistnavn");
	            System.out.println("4) Skriv ut statistikk");
	            System.out.println("5) Slett en plate fra lageret");
	            System.out.println("6) Lagre lageret til en fil");
	            System.out.println("7) Last inn et lager fra fil");
	            System.out.println("9) Avslutt programmet");

	            int valg = sc.nextInt();
	            sc.nextLine();

	            if (valg == 1){
	                CD cd = tekstgr.lesCD();
	                cda.leggTilCd(cd);
	                System.out.println(cd.getCD() + " ble lagt til på lageret");
	            }
	            else if(valg == 2){
	                System.out.println("\n--- Finn CD ---\n");
	                System.out.println("Skriv inn tittelen, eller en del av tittelen");
	                String delstreng = sc.nextLine();
	                tekstgr.skrivUtCdDelstrengITittel(cda, delstreng);
	            }
	            else if (valg == 3){
	                System.out.println("\n--- Finn CD ---\n");
	                System.out.println("Skriv inn artistnavnet, eller en del av artistnavnet");
	                String delstreng = sc.nextLine();
	                tekstgr.skrivUtCdArtist(cda, delstreng);
	            }
	            else if (valg == 4){
	                tekstgr.skrivUtStatistikk(cda);
	            }
	            else if (valg == 5){
	                System.out.println("--- Slett en CD ---\n");
	                System.out.println("CD-er på lager:");
	                CD[] cd = cda.hentCdTabell();
	                for (int i = 0; i < cda.antall(); i++){
	                    System.out.print(cd[i].getLansering() + " - " + cd[i].getCD() + ", ");
	                }
	                System.out.println();
	                System.out.println("Hva er ID til platen:");
	                int id = sc.nextInt();
	                sc.nextLine();
	                cda.slettCd(id);
	            }
	            else if (valg == 6){
	                System.out.println("\n--- Lagre til fil ---\n");
	                System.out.println("Skriv inn navnet til filen du vil lagre til, uten .txt");
	                String filnavn = sc.nextLine();
	                filnavn += ".txt";
	                Fil.skrivTilFil(cda, filnavn);
	                System.out.println("Lageret ble skrevet til filen " + filnavn);
	            }
	            else if (valg == 7){
	                System.out.println("\n--- Les fra fil ---\n");
	                System.out.println("Hva heter filen du vil lese fra, uten .txt");
	                String filnavn = sc.nextLine();
	                filnavn += ".txt";
	                Fil.lesFraFil(filnavn);
	            }
	            else if (valg == 9){
	                System.out.println("Avslutter programmet..");
	                sc.close();
	                run = false;
	            }
	            else {
	                System.out.println("Ugyldig valg, prøv igjen");
	            }
	}

}
}