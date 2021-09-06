package karticeZaPoene;

public abstract class BasicCard {
	
	private int id;
	private String pan;
	
	public BasicCard() {		
	}
	
	// ubacen je full konstruktor iako nije trazeno
	// Medjutim, ovako je zgodno jednim pozivom konstruktora subklase Kartica 
	// odjednom inicijalizovati vrednosti za sva 4 atributa (id, pan, sipanoLitara, tipKartice)
	public BasicCard(int id, String pan) {	
		super();
		this.id = id;
		this.pan = pan;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	
	public abstract void ispisiKarticu();
	// apstrakta metoda ispisiKarticu, koja kao ulazne parametre uzima id, pan i ispisuje ih.
	

}
