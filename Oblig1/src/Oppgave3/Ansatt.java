package Oppgave3;

public class Ansatt {

	private String fnavn;
	private String enavn;
	private kjonn kjonn;
	private String stilling;
	private double aarslonn;
	
	public Ansatt (String fn, String en, kjonn k, String st, double lonn) {
		
		this.fnavn = fn;
		this.enavn = en;
		this.kjonn = k;
		this.stilling = st;
		this.aarslonn = lonn;
	}

	public String getFnavn() {
		return fnavn;
	}

	public void setFnavn(String fnavn) {
		this.fnavn = fnavn;
	}

	public String getEnavn() {
		return enavn;
	}

	public void setEnavn(String enavn) {
		this.enavn = enavn;
	}

	public kjonn getKjonn() {
		return kjonn;
	}

	public void setKjonn(kjonn kjonn) {
		this.kjonn = kjonn;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public double getAarslonn() {
		return aarslonn;
	}

	public void setAarslonn(Double double1) {
		this.aarslonn = double1;
	}
	
	@Override
	public String toString() {
		return fnavn + " " + enavn + " " + kjonn + " " + stilling 
				+ " " + aarslonn;
	}
}

