package no.hvl.dat108.UI;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

public class PassordUtil {

	private static final int saltlengde = 32;
    private static final String Passord_Tegnesett = "UTF-8";
    private static final String hashAlgorytme = "SHA-256";
    private static final int Hash_Iteration = 1000;
	
    public String krypterPassord(String passord) {
        byte[] salt = tilfeldigSalt();
        return krypterMedSalt(salt, passord);
    }
    
    private byte[] tilfeldigSalt() {
        byte[] salt = new byte[saltlengde];
        new SecureRandom().nextBytes(salt);
        return salt;
    }
    
    public boolean sjekkPassord(String passord, String kryptert) {
    	
    	byte[] salt = hentUtSaltFraKryptertStreng(kryptert);
        return krypterMedSalt(salt, passord).equals(kryptert);
    }

	private byte[] hentUtSaltFraKryptertStreng(String kryptert) {
        
		byte[] saltPlusDigest = DatatypeConverter.parseBase64Binary(kryptert);
        byte[] salt = Arrays.copyOf(saltPlusDigest, saltlengde);
        return salt;
    }
	
	private String krypterMedSalt(byte[] salt, String passord) {

        String kryptert = "";

        try {
            byte[] passordBytes = passord.getBytes(Passord_Tegnesett);

            byte[] saltPlusPassord = leggSammen(salt, passordBytes);

            MessageDigest md = MessageDigest.getInstance(hashAlgorytme);
            
            byte[] digest = saltPlusPassord;
            for (int i=1; i<=Hash_Iteration; i++) {
                digest = md.digest(digest);
            }

            byte[] saltPlusDigest = leggSammen(salt, digest);

            kryptert = DatatypeConverter.printBase64Binary(saltPlusDigest);
            
        } catch (Exception e) {
            
        }
        return kryptert;
    }
	
	private byte[] leggSammen(byte[] tabell1, byte[] tabell2) {
        
        byte[] tabell = new byte[tabell1.length + tabell2.length];
        System.arraycopy(tabell1, 0, tabell, 0, tabell1.length);
        System.arraycopy(tabell2, 0, tabell, tabell1.length, tabell2.length);
        return tabell;
    }
	
}
