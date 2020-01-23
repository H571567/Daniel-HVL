package no.hvl.dat102;

import java.util.Random;
import java.util.*;

import no.hvl.dat102.*;

public class BSTklient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int ANTALL_NODER = 8192;
		final int Antall_trer = 100;
		Random tilfeldig = new Random();

		int minste_hoyde = ANTALL_NODER;
		int storste_hoyde = 0;
		int sum_hoyde = 0;
		for (int i = 0; i < Antall_trer; i++) {

			KjedetBinaerSokeTre<Integer> bs = new KjedetBinaerSokeTre<Integer>();
			Integer resultat = null;

			for (int y = 0; y < ANTALL_NODER; y++) {
				Integer element = new Integer(tilfeldig.nextInt());
				bs.leggTil(element);
			}
			
			
			int hoyde = bs.hoyde();
			if (hoyde < minste_hoyde) {
				minste_hoyde = hoyde;
			}
			if (hoyde > storste_hoyde) {
				storste_hoyde = hoyde;
			}
			
			sum_hoyde += hoyde;
		}
		double snitt_hoyde = (double)sum_hoyde / Antall_trer;

		System.out.println("Antall noder: " + ANTALL_NODER);
		System.out.println("Største teoretiske høyde: " + (ANTALL_NODER - 1));
		System.out.println("Minste teoretiske høyde: " + ((Math.log(ANTALL_NODER))/Math.log(2)-1));
		System.out.println("Minste høyde: " + minste_hoyde);
		System.out.println("Største høyde: " + storste_hoyde);
		System.out.println("Gjennomsnittlig høyde: " + snitt_hoyde);
		System.out.println();
		
	}

}
