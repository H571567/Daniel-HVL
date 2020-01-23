package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {

	private int antall;
	private LinearNode<CD> start;
	
	public CDarkiv2 () {
		start = null;
		antall = 0;
	}

	/**
	 * Returnere en tabell av CD-er
	 */
	public CD[] hentCdTabell() {
		CD[] tab = new CD[antall];
		LinearNode<CD> nynode = start;
		int i = 0;
		while (nynode != null) {
			tab[i] = nynode.getElement();
			nynode = nynode.getNeste();
			i++;
		}
		return tab;
	}

	/**
	 * Legger til en ny CD
	 */
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> nynode = new LinearNode<CD>(nyCd);
		nynode.setNeste(start);
		start = nynode;
		antall++;
	}

	/**
	 * Sletter en CD hvis den fins
	 */
	public boolean slettCd(int cdNr) {
		LinearNode<CD> nynode = start.getNeste();
		LinearNode<CD> forrige = start;

		if (start != null && start.getElement().getCDnummer() == cdNr) {
			start = start.getNeste();
			antall--;
			return true;
		}

		while (nynode != null) {
			if (nynode.getElement().getCDnummer() == cdNr) {
				forrige.setNeste(nynode.getNeste());
				antall--;
				return true;
			}
			forrige = nynode;
			nynode = nynode.getNeste();
		}
		return false;
	}

	/**
	 * Søker og henter CD-er med en gitt delstreng
	 */
	public CD[] sokTittel(String delstreng) {
		CD[] tab = new CD[antall];
		CD[] tab2 = new CD[0];
		LinearNode<CD> nynode = start;

		int i = 0;
		while (nynode != null) {
			tab[i] = nynode.getElement();
			nynode = nynode.getNeste();
			i++;
		}
		int x = 0;
		for (int y = 0; y < tab.length; y++) {
			if (tab[y].getCD().contains(delstreng)) {
				tab2[x] = tab[y];
				x++;
			}
		}
		return tab2;
	}

	/**
	 * Søker og henter artister med en gitt delstreng
	 */
	public CD[] sokArtist(String delstreng) {
		CD[] tab = new CD[antall];
		CD[] tab2 = new CD[0];
		LinearNode<CD> nynode = start;

		
		int i = 0;
		while (nynode != null) {
			tab[i] = nynode.getElement();
			nynode = nynode.getNeste();
			i++;
		}
		
		int x = 0;
		for (int y = 0; y < tab.length; y++) {
			if (tab[y].getArtist().contains(delstreng)) {
				tab2[x] = tab[y];
				x++;
			}
		}
		return tab2;
	}

	/**
	 * Henter antall CD-er for en gitt sjanger
	 */
	public int antallSjanger(Sjanger sjanger) {
		CD[] tab = new CD[antall];
		LinearNode<CD> nynode = start;
		
		int i = 0;
		while (nynode != null) {
			tab[i] = nynode.getElement();
			nynode = nynode.getNeste();
			i++;
		}
		
		int antallSjanger = 0;
		for (int y = 0; y < tab.length; y++) {
			if (tab[y].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	/**
	 * Returnerer antall CD-er
	 */
	public int antall() {
		return antall;
	}
}// interface }