package Oppgave3;

import java.util.*;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {

		List<Ansatt> ansatte = Arrays.asList(
			new Ansatt("Daniel", "Jacobsen", kjonn.M, "Løper", 700000),
			new Ansatt("Gus", "Fring", kjonn.M, "sjef Drug Kingpin", 10000000),
			new Ansatt("Lydia", "BrBa", kjonn.K, "Noe buisness", 1000000),
			new Ansatt("Mamma", "Pappa", kjonn.K, "Støttekontakt", 350000)
		);
		
		//Lambda Uttrykk
		Function<Ansatt, Double> lonnokning 
			= a -> 50000.00 + a.getAarslonn();
		Function<Ansatt, Double> lonnokning_prosent 
			= a -> a.getAarslonn() + (a.getAarslonn()*0.02);
		Function<Ansatt, Double> lonnokning_lavLonn 
			= a -> lavLonn(a);
		Function<Ansatt, Double> lonnForMann
			= a -> lonnForMann(a);
		
		List<Ansatt> ansatteTest = ansatte;
		
		//Kall på lambda uttrykk
		lonnsoppgjor(ansatteTest, lonnokning);
		lonnsoppgjor(ansatteTest, lonnokning_prosent);
		lonnsoppgjor(ansatteTest, lonnokning_lavLonn);
		lonnsoppgjor(ansatteTest, lonnForMann);
		
		
		//Skriv ut
		skrivUtAlle(ansatte);
		System.out.println();
		skrivUtAlle(ansatteTest);
	}
	
	static double lonnForMann (Ansatt a) {
		
		if (a.getKjonn() == kjonn.M) {
			return a.getAarslonn() + 25000.00;
		}
		
		return a.getAarslonn();
	}
	
	static double lavLonn (Ansatt a) {
		
		if (a.getAarslonn() < 500000) {
			return a.getAarslonn()+100000;
		}
		
		return a.getAarslonn();
	}

	private static void lonnsoppgjor
		(List<Ansatt> ansatte, Function<Ansatt, Double> c) {
		
		for (Ansatt a : ansatte) {
		a.setAarslonn(c.apply(a));
		}
	}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for (Ansatt a : ansatte) {
			System.out.println(a);
		}	
	}
}
