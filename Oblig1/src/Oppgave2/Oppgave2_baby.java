package Oppgave2;

import java.util.*;
import java.util.function.BiFunction;

public class Oppgave2_baby {

	public static void main(String[] args) {

		// Oppgave A
		List<String> listen = 
				Arrays.asList("10", "1", "20", "110", "21", "12");
		
		Collections.sort(listen, (s1, s2) -> s1.hashCode() - s2.hashCode());
		System.out.println(listen);
		
		// Oppgave B
		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		BiFunction<Integer, Integer, Integer> storst = (a, b) -> storst(a, b);
		BiFunction<Integer, Integer, Integer> differanse = (a, b) -> absoluttverdi(a, b);
		
		System.out.println(beregn(-5, 3, storst)); 
		System.out.println(beregn(12, 13, add)); 
		System.out.println(beregn(54, 45, differanse)); 
				
	}
	
	public static int storst (int a, int b) {
		
		if (a > b) {
			return a;
		} else if (b > a) {
		return b;
		} else {
			return 0;
		}
	}
	
	public static int absoluttverdi (int a, int b) {
		
		int storst = storst(a, b);
		int minst = minst(a, b);
		
		return storst - minst;
	}
	
	private static int minst(int a, int b) {
		
		if (a < b) {
			return a;
		} else if (b < a) {
			return b;
		} else {
			return 0;
		}
	}

	public static int beregn (int a, int b, BiFunction<Integer, Integer, Integer> c) {

		return c.apply(a, b);
	}


}

