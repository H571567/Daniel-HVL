package no.hvl.dat108.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import no.hvl.dat108.UI.Validator;

public class Validator_test {

	private Validator v = new Validator();
	
	public final static String fornavnMedBindestrek = "Daniel-Lundegaard";
	public final static String fornavnMedSpace = "Daniel Lundegaard";
	public final static String etternavn = "Jacobsen";
	public final static String etternavnMedBindestrek = "Jaocbsen-Hei";
	public final static String mobil = "90666657";
	public final static String passord1 = "Djdan30";
	public final static String passord2 = "Djdan30";
	public final static String kjonnM = "mann";
	public final static String kjonnK = "kvinne";
	
	@Test
	public void korrektValidator() {
		assertTrue(v.korrektFornavn(fornavnMedBindestrek));
		assertTrue(v.korrektFornavn(fornavnMedSpace));
		assertTrue(v.korrektEtternavn(etternavn));
		assertTrue(v.korrektEtternavn(etternavnMedBindestrek));
		assertTrue(v.korrektMobil(mobil));
		assertTrue(v.korrektPassord(passord1, passord2));
		assertTrue(v.korrektKjonn(kjonnM));
		assertTrue(v.korrektKjonn(kjonnK));
	}
	
	@Test
	public void feilValidator() {
		assertFalse(v.korrektMobil("123456789")); 			// 9 siffer
		assertFalse(v.korrektFornavn("Daniel30"));			// tall i nanvn
		assertFalse(v.korrektEtternavn("Lundegaard Jaocbsen")); // Etternavn med space
		assertFalse(v.korrektEtternavn("Daniel er mye raskere enn Jakob Ingebrigsten"));	// For lang etternavn
		assertFalse(v.korrektPassord(passord1, "heieeeee"));// passord matcher ikke
		assertFalse(v.korrektKjonn(null)); 		//	Skal være false om kjonn er lik null
		assertFalse(v.korrektPassord("Dj123", "Dj123"));	// For kort passord
	}
}
