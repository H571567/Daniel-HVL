package no.hvl.dat108.UI;


import javax.servlet.http.HttpServletRequest;

import no.hvl.dat108.bruker.BrukerEAO;

public class Skjema_login {

	private String mobil;
	private String passord;
	private String feilMelding;
	
	public Skjema_login (HttpServletRequest request) {
		this.mobil = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
		this.feilMelding = request.getParameter("feilMelding");
	}
	
	public boolean sjekkInnlogging(BrukerEAO bEAO) {
		
		if(Validator.korrektMobil(mobil) && bEAO.finnesMobil(mobil)) {
			PassordUtil hash = new PassordUtil();
			return hash.sjekkPassord(passord, bEAO.hentPassord(mobil));
		} else {
			return false;
		}
	}
	
	public void feilMelding() {
		mobil = "";
		passord = "";
		feilMelding = "Feil mobilnummer/passord";
	}

	public String getMobil() {
		return mobil;
	}

	public String getPassord() {
		return passord;
	}
	
	public String getFeilMelding() {
		return feilMelding;
	}

}
