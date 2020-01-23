package no.hvl.dat108.bruker;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="oblig_3", name="brukere")
public class Bruker implements Comparable<Bruker> {

	@Id
	private String mobil;	
	
	private String fornavn;
	private String etternavn;
	private String passord;
	private String kjonn;
	
	
	public Bruker(String fn, String en, String m, String p, String k) {
		fornavn = fn;
		etternavn = en;
		mobil = m;
		passord = p;
		kjonn = k;
	}
	public Bruker () {
		
	}

	@Override
	public String toString() {
		return fornavn + " " + etternavn;
	}
	
	
	@Override
	public int compareTo(Bruker b2) {
		return (fornavn.compareTo(b2.fornavn) != 0) ? fornavn.compareTo(b2.fornavn) : etternavn.compareTo(b2.etternavn);		
	}
	public String getMobil() {
		return mobil;
	}
	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public String getPassord() {
		return passord;
	}
	public void setPassord(String passord) {
		this.passord = passord;
	}
	public String getKjonn() {
		return kjonn;
	}
	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

}
