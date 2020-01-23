package no.hvl.dat108.UI;

public class Validator {
    
    public static boolean korrektFornavn(String navn) {
    
    	if (navn == null) {
    		return false;
    	}
    	return navn.matches("^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-\\s]{2,20}");
    }
    
    public static boolean korrektEtternavn(String navn) {
    	
    	if (navn == null) {
    		return false;
    	}
    	return navn.matches("^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-]{2,20}");
    }
    
    public static boolean korrektMobil (String mobil) {
    	
    	if (mobil == null) {
    		return false;
    	}
    	
    	return mobil.matches("^[0-9]{8}");
    }
    
    public static boolean korrektPassord(String passord1, String passord2) {
    	
    	if (passord1 == null) {
    		return false;
    	}
    	
    	return passord1 != null && passord1.length() >= 6 && passord1.equals(passord2);
    }
    
    public static boolean korrektKjonn (String kjonn) {
    	
    	return kjonn != null;
    }
    
}

