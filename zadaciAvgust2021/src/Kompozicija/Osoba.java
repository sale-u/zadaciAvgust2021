package Kompozicija;

public class Osoba {
	
	// Jmbg mora da ima taèno 13 cifara i spreèiti unos u konstruktoru ukoliko prosleðen
	// parametar(jmbg) nije validan.
	// Takoðe potrebno je zabraniti, u okviru konstruktora, da atribut brojGodina bude manji od 18.

	private String ime;
	private String prezime;
	private String adresa;
	private String jmbg;
	private int brojGodina;
	
	// =====================================================================================

	// full konstruktor sa validacijom JMBG i broja godina
	// baca exception u slucaju neispravnosti podataka
	public Osoba(String ime, String prezime, String adresa, String jmbg, int brojGodina) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;

		// validacija jmbg
		if (!this.validateJMBG(jmbg)) {
			throw (new IllegalArgumentException("JMBG je neispravan!"));
		} else {
//			System.out.println("JMBG je OK");
			this.jmbg = jmbg;
		}

		// validacija broja godina
		// zabraniti, u okviru konstruktora, da atribut brojGodina bude manji od 18
		if (brojGodina < 18) {
			throw (new IllegalArgumentException("Broj godina mora biti veci ili jednak od 18"));
		} else {
			this.brojGodina = brojGodina;
		}
	}
	
	// =====================================================================================

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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		// validacija jmbg
		if (!this.validateJMBG(jmbg)) {
			throw (new IllegalArgumentException("JMBG je neispravan!"));
		} else {
			this.jmbg = jmbg;
		}
	}

	public int getBrojGodina() {
		return brojGodina;
	}

	public void setBrojGodina(int brojGodina) {
		// validacija broja godina
		// zabraniti, u okviru konstruktora, da atribut brojGodina bude manji od 18
		if (brojGodina < 18) {
			throw (new IllegalArgumentException("Broj godina mora biti veci ili jednak od 18"));
		} else {
			this.brojGodina = brojGodina;
		}
	}
	
	// =====================================================================================

	@Override
	public String toString() {
		return ime + " " + prezime + " , " + adresa + ", JMBG=" + jmbg + ", starost=" + brojGodina;
	}

	public boolean validateJMBG(String jmbg) {
		// jmbg mora imati tacno 13 cifara
		// za validaciju koristim Regular Expressions
		if (jmbg == null) {
			return false;
		}

		// tacno 13 cifara
		String regex = "[0-9]{13}";
		return jmbg.matches(regex);
	}
}
