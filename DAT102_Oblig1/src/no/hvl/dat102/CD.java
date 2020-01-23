package no.hvl.dat102;

public class CD {
	private int CDnummer;
	private String artist;
	private String CD;
	private int lansering;
	private Sjanger sjanger;
	private String plateselskap;

	public CD() {

	}

	public CD(int CDnummer, String artist, String CD, int lansering, Sjanger sjanger, String plateselskap) {
		this.CDnummer = CDnummer;
		this.artist = artist;
		this.CD = CD;
		this.lansering = lansering;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getCD() {
		return CD;
	}

	public void setCD(String CD) {
		this.CD = CD;
	}

	public int getLansering() {
		return lansering;
	}

	public void setLansering(int lansering) {
		this.lansering = lansering;
	}

	public int getCDnummer() {
		return CDnummer;
	}

	public void setCDnummer(int CDnummer) {
		this.CDnummer = CDnummer;
	}

	public String getPlateselskap() {
		return plateselskap;
	}

	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}
}