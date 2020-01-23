package no.hvl.dat108.bruker;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BrukerEAO {

	@PersistenceContext(name = "brukerPU")
	private EntityManager em;

	// Legger til bruker
	public void leggTilBruker(Bruker b) {
		em.persist(b);
	}

	// Henter listen av deltagere 
	public List<Bruker> hentBrukere() {
		
		return em.createQuery("SELECT p From Bruker p").getResultList();
	}

	// Skjekker om mobilnummeret eksisterer i databasen
	public boolean finnesMobil(String mobil) {
		
		Long l = (long) em.createQuery("SELECT COUNT(p) FROM Bruker p WHERE p.mobil=:mobil").setParameter("mobil", mobil).getSingleResult();
		return l >= 1;
	}
	

	
	public String hentPassord(String mobil) {
			return em.find(Bruker.class, mobil).getPassord();
		}
}	
