package fudbalskiKlub;

public class Osoba implements IOsoba{
	
	private String ime;
	private String prezime;
	private String jmbg;
	private String adresa;
	
	public Osoba(String ime, String prezime, String jmbg, String adresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		
		// ako su jmbg ili adresa neispravni, nece ni biti stvoren objekat,
		// jer ce konstruktor da zavrsi u Exceptionu
		
		if (!this.validacijaJmbg(jmbg)) {
			throw (new IllegalArgumentException("JMBG je neispravan!"));
		} else {
//			System.out.println("JMBG je OK");
			this.jmbg = jmbg;	
		}
		if (!this.validacijaAdrese(adresa)) {
			throw (new IllegalArgumentException("Adresa je neispravna!"));
		} else {
//			System.out.println("Adresa je OK");
			this.adresa = adresa;
		}
	}
	

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	@Override
	public String toString() {
		return ime + " " + prezime + " (" + adresa + " , jmbg=" + jmbg + ")";
	}

	@Override
	public boolean validacijaJmbg(String jmbg) {
		// jmbg mora imati tacno 13 cifara
		// za validaciju koristim Regular Expressions
		if (jmbg == null) {
			return false;
		}
		
		// tacno 13 cifara
		String regex = "[0-9]{13}";
		return jmbg.matches(regex);
	}

	@Override
	public boolean validacijaAdrese(String adresa) {
		// adresa mora imati bar jedan broj i taj broj MORA biti na mestu poslednje reci.
		// za validaciju koristim Regular Expressions
		if (adresa == null) {
			return false;
		}
		
		// prvo veliko slovo, pa slova i brojevi i blanko, pa blanko, pa cifre uz crticu i da se zavrsava sa cifrom
		String regex = "[A-Z][A-Za-z0-9 ]* [0-9-]*[0-9]$"; 
		return adresa.matches(regex);

	}
	
}
