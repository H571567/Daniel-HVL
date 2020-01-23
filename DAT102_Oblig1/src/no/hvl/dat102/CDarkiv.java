package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

public class CDarkiv implements CDarkivADT {

	private CD[] liste;
	private int maxantall;
	private final int antall = 100;
	
	public CDarkiv() {
		liste = new CD[antall];
		maxantall = 0;
	}

	public CD finnesang(String tittel) {

		for (int i = 0; i < liste.length; i++) {

			if (liste[i].getCD() == tittel) {
				return liste[i];
			}
		}
		return null;
	}

	public String finneartist(int CDnr) {

		for (int i = 0; i < maxantall; i++) {

			if (liste[i].getCDnummer() == CDnr) {
				return liste[i].getArtist();
			}
		}
		return null;
	}

	@Override
	public CD[] hentCdTabell() {
		// TODO Auto-generated method stub
		return liste;
	}

	@Override
	public void leggTilCd(CD nyCd) {

		for (int i = 0; i <= maxantall; i++) {
			if (liste[i] == null) {
				liste[i] = nyCd;
				maxantall++;
				break;
			}
		}
	}

	@Override
	public boolean slettCd(int cdNr) {

		for (int i = 0; i <= maxantall; i++) {
			if (liste[i].getCDnummer() == cdNr) {
				liste[i] = null;
				maxantall--;
				
				int x = 0;
				for (int y = 0; y < maxantall; y++) {
					if (!(liste[y] == null)) {
						liste[x] = liste[y];
						x++;
					}
				}
				
				return true;
			}
		}

		return false;
	}

	@Override
	public CD[] sokTittel(String delstreng) {

		CD[] hei = new CD[maxantall];

		int a = 0;
		for (int i = 0; i < maxantall; i++) {
			if ((liste[i].getCD().equals(delstreng))) {
				hei[a] = liste[i];
				a++;
			}
		}
		return hei;
	}

	@Override
	public CD[] sokArtist(String delstreng) {

		CD[] hei = new CD[maxantall];

		int a = 0;
		for (int i = 0; i < maxantall; i++) {
			if ((liste[i].getArtist().equals(delstreng))) {
				hei[a] = liste[i];
				a++;
			}
		}
		return hei;
	}

	@Override
	public int antallSjanger(Sjanger sjanger) {
		int antallSjanger = 0;
		for (int i = 0; i < maxantall; i++) {
			if (liste[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	@Override
	public int antall() {
		return maxantall;
	}
}