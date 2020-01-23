package Oppgave4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Oppgave3.Ansatt;
import Oppgave3.kjonn;

public class Oppgave4 {

	public static void main(String[] args) {

		List<Ansatt> ansatte = Arrays.asList(
			new Ansatt("Daniel", "Jacobsen", kjonn.M, "Løper", 700000),
			new Ansatt("Gus", "Fring", kjonn.M, "sjef Drug Kingpin", 10000000),
			new Ansatt("Lydia", "BrBa", kjonn.K, "Noe buisness", 1000000),
			new Ansatt("Mamma", "Pappa", kjonn.K, "Støttekontakt", 350000)
		);
		
		
		//A
		List<String> etternavn = ansatte.stream()
			.map(a -> a.getEnavn()).collect(Collectors.toList());
		System.out.println(etternavn);
		
		System.out.println();
		
		//B
		long antallKvinner =
			ansatte.stream().filter(a -> a.getKjonn() == kjonn.K).count();
		System.out.println(antallKvinner);
		
		System.out.println();
		
		//C
		double Totalt = ansatte.stream()
				.filter(a -> a.getKjonn() == kjonn.K)
				.map(a -> a.getAarslonn())
				.reduce(0.0, (sum, a) -> sum += a);
		
		System.out.println(Totalt / antallKvinner);
		System.out.println();
		
		//D
		ansatte.stream().
			filter(a -> a.getStilling().startsWith("sjef"))
			.map(a -> a.getAarslonn() + 70000)
			.forEach(System.out::println);
		System.out.println();
		
		//E
		boolean joda = ansatte.stream()
			.anyMatch(a -> a.getAarslonn() > 800000);
		System.out.println(joda);
		System.out.println();
		
		//F
		ansatte.stream().forEach(System.out::println);
		System.out.println();
		
		//G
		Optional<Ansatt> lavLonn = ansatte.stream()
		.min(Comparator.comparing(Ansatt::getAarslonn));
		System.out.println(lavLonn);
		System.out.println();
		
		//H
		IntStream.range(1, 1000)
		.filter(i -> i % 3 == 0 || i % 5 == 0).forEach(System.out::println);;
		
	}
	
}
