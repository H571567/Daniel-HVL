package no.hvl.dat108;
import java.util.ArrayList;

public class HandleObjekt {
	private ArrayList<String> handleliste;
	
	public HandleObjekt() {
		handleliste = new ArrayList<>();
	}
	public void LeggTil(String vare) {
		handleliste.add(vare);
	}
	public void slettVare(String vare) {
		handleliste.remove(vare);
	}
	public ArrayList<String> getHandleObjekt() {
		return handleliste;
	}
}