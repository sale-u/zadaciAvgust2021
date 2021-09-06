package karticeZaPoene;

public class Kartica extends BasicCard implements IPoeni{
	
	private double sipanoLitara;
	private int tipKartice;		// 1-Normal, 2-Gold
	
	public Kartica() {
		super();
	}

	// ovaj full konstruktor jednim pozivom inicijalizuje sva 4 atributa (2 iz nadklase i 2 svoja)
	public Kartica(int id, String pan, double sipanoLitara, int tipKartice) {
		super(id, pan);
		this.sipanoLitara = sipanoLitara;
		this.tipKartice = tipKartice;
	}

	public double getSipanoLitara() {
		return sipanoLitara;
	}

	public void setSipanoLitara(double sipanoLitara) {
		this.sipanoLitara = sipanoLitara;
	}

	public int getTipKartice() {
		return tipKartice;
	}

	public void setTipKartice(int tipKartice) {
		this.tipKartice = tipKartice;
	}

	@Override
	public void ispisiKarticu() {
		System.out.print("ID kartice = " + this.getId() + " *** PAN kartice = " + this.getPan());
	}

	@Override
	// ulazni parametar Kartica kartica je visak jer se metoda poziva kroz konkretnu instancu klase Kartica
	public int izracunajBrojPoena(Kartica kartica) {
		// metod int izracunajBrojPoena(Kartica kartica), koji za svaku karticu raèuna koliko je poena 
		// dobila u zavisnosti da li je Normal ili Gold
		
		int brPoena = 0;
		
		if (kartica.getTipKartice() == 1) {							// Normal kartica -> 2 poena za svaki litar
			brPoena = (int) Math.floor(this.getSipanoLitara() * 2);	// zaokruzuje na donju int vrednost
		} else if (kartica.getTipKartice() == 2) {					// Gold kartica -> 3 poena za svaki litar
			brPoena = (int) Math.floor(this.getSipanoLitara() * 3);
		}
		
		return brPoena;
	}
	
	

}
