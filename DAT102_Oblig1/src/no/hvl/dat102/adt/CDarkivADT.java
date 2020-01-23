package no.hvl.dat102.adt;

import no.hvl.dat102.CD;
import no.hvl.dat102.Sjanger;

public interface CDarkivADT {
	/**
	 * Returnere en tabell av CD-er
	 */
	CD[] hentCdTabell();

	/**
	 * Legger til en ny CD
	 */
	void leggTilCd(CD nyCd);

	/**
	 * Sletter en CD hvis den fins
	 */
	boolean slettCd(int cdNr);

	/**
	 * Søker og henter CD-er med en gitt delstreng
	 */
	CD[] sokTittel(String delstreng);

	/**
	 * Søker og henter artister med en gitt delstreng
	 */
	CD[] sokArtist(String delstreng);

	/**
	 * Henter antall CD-er for en gitt sjanger
	 */
	int antallSjanger(Sjanger sjanger);

	/**
	 * Returnerer antall CD-er
	 */
	int antall();
}// interface