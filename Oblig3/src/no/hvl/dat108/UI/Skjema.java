package no.hvl.dat108.UI;


import javax.servlet.http.HttpServletRequest;

import no.hvl.dat108.bruker.Bruker;

public class Skjema {

	private String fornavn;
	private String feilFornavn;
	private String etternavn;
	private String feilEtternavn;
	private String mobil;
	private String feilMobil;
	private String passord1;
	private String passord2;
	private String feilPassord1;
	private String feilPassord2;
	private String kjonn;
	private String feilKjonn;
	
	public Skjema(HttpServletRequest request) {
		fornavn = request.getParameter("fornavn");
		etternavn = request.getParameter("etternavn");
		mobil = request.getParameter("mobil");
		passord1 = request.getParameter("passord");
		passord2 = request.getParameter("passordRepetert");
		kjonn = request.getParameter("kjonn");
	}
	
	public Bruker lagBruker () {
		
		PassordUtil hash = new PassordUtil();
		passord1 = hash.krypterPassord(passord1);
		
		return new Bruker(fornavn, etternavn, mobil, passord1, kjonn);
	}
	
	public boolean altErGyldig() {
		
		return Validator.korrektFornavn(fornavn) && Validator.korrektEtternavn(etternavn) &&
				Validator.korrektMobil(mobil) && Validator.korrektPassord(passord1, passord2) &&
				Validator.korrektKjonn(kjonn);
	}
	
	public void gjemPassord() {
		passord1 = "";
		passord2 = "";
	}
	
	public boolean riktigFornavn() {
		
		return Validator.korrektFornavn(fornavn);
	}
	
	public boolean riktigEtternavn() {
		
		return Validator.korrektEtternavn(etternavn);
	}
	
	public boolean riktigMobil() {
		
		return Validator.korrektMobil(mobil);
	}
	
	public boolean riktigPassord() {
		
		return Validator.korrektPassord(passord1, passord2);
	}
	
	public boolean riktigKjonn() {
	
		return kjonn != null;
	}		
	
	public void feilmeldinger() {
		
		if (!Validator.korrektFornavn(fornavn)) {
			fornavn = "";
			feilFornavn = "Ugyldig fornavn";
		}
		if (!Validator.korrektEtternavn(etternavn)) {
			etternavn = "";
			feilEtternavn = "Ugyldig etternavn";
		}
		if (!Validator.korrektMobil(mobil)) {
			mobil = "";
			feilMobil = "Ugyldig mobil";
		}
		if (!Validator.korrektPassord(passord1, passord2)) {
			passord1 = "";
			feilPassord1 = "Ugyldig passord";
			passord2 = "";
			feilPassord2 = "Passordene må være like";
		}
		if (!Validator.korrektKjonn(kjonn)) {
			kjonn = "";
			feilKjonn = "Du må oppgi kjønn";
		}
		
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getFeilFornavn() {
		return feilFornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getFeilEtternavn() {
		return feilEtternavn;
	}

	public String getMobil() {
		return mobil;
	}
	
	public void setMobil(String m) {
		mobil = m;
	}

	public String getFeilMobil() {
		return feilMobil;
	}
	
	public void setFeilMobil(String mobil) {
		feilMobil = mobil;
	}

	public String getPassord1() {
		return passord1;
	}

	public String getPassord2() {
		return passord2;
	}

	public String getFeilPassord1() {
		return feilPassord1;
	}

	public String getFeilPassord2() {
		return feilPassord2;
	}

	public String getKjonn() {
		return kjonn;
	}

	public String getFeilKjonn() {
		return feilKjonn;
	}

}
