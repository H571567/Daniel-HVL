package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

public class CDarkivKlient{
	
	 public static void main(String[] args){
	 //… meny
	 CDarkivADT cda = new CDarkiv();
	 Meny meny = new Meny(cda);
	 
	 meny.start();
	}
	 
}//class