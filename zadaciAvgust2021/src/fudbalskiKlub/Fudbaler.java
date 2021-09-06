package fudbalskiKlub;

public class Fudbaler extends Osoba {
	
	private double nedeljnaPlata;
	private int brojOdigranihSezona;
	private String sponzor;
	private boolean rezerva;
	private double godisnjaZarada;
	private int brojGolovaIAsistencija;
	private String pozicija;

	// full konstruktor : za prva 4 podatka poziva super Osoba konstruktora
	public Fudbaler(String ime, String prezime, String jmbg, String adresa, 
			double nedeljnaPlata, int brojOdigranihSezona, String sponzor, boolean rezerva, 
			int brojGolovaIAsistencija, String pozicija) {
		
		// atribut godisnjaZarada se racuna u konstruktoru na osnovu nedeljne plate, 
		// uzimajuci u obzir da fudbaler igra citavu godinu.
		// brojOdigranihSezona mora biti veci od 0 i treba spreciti nedozvoljen unos,
		// u suprotnom, objekat nece biti kreiran i nastupice Exception
		
		super(ime, prezime, jmbg, adresa);
		this.nedeljnaPlata = nedeljnaPlata;
		if (brojOdigranihSezona <= 0) {
			throw (new IllegalArgumentException("Broj odigranih sezona mora biti veci od 0 !"));
		}
		this.brojOdigranihSezona = brojOdigranihSezona;
		this.sponzor = sponzor;
		this.rezerva = rezerva;
		this.godisnjaZarada = nedeljnaPlata * 52;
		this.brojGolovaIAsistencija = brojGolovaIAsistencija;
		this.pozicija = pozicija;
	}

	public double getNedeljnaPlata() {
		return nedeljnaPlata;
	}

	public void setNedeljnaPlata(double nedeljnaPlata) {
		this.nedeljnaPlata = nedeljnaPlata;
	}

	public int getBrojOdigranihSezona() {
		return brojOdigranihSezona;
	}

	public void setBrojOdigranihSezona(int brojOdigranihSezona) {
		this.brojOdigranihSezona = brojOdigranihSezona;
	}

	public String getSponzor() {
		return sponzor;
	}

	public void setSponzor(String sponzor) {
		this.sponzor = sponzor;
	}

	public boolean isRezerva() {
		return rezerva;
	}

	public void setRezerva(boolean rezerva) {
		this.rezerva = rezerva;
	}

	public double getGodisnjaZarada() {
		return godisnjaZarada;
	}

	public void setGodisnjaZarada(double godisnjaZarada) {
		this.godisnjaZarada = godisnjaZarada;
	}

	public int getBrojGolovaIAsistencija() {
		return brojGolovaIAsistencija;
	}

	public void setBrojGolovaIAsistencija(int brojGolovaIAsistencija) {
		this.brojGolovaIAsistencija = brojGolovaIAsistencija;
	}

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t" + pozicija + " [nedeljPlata=" + nedeljnaPlata + ", brOdigrSezona=" + brojOdigranihSezona
				+ ", sponzor=" + sponzor + ", rezerva=" + rezerva + ", godZarada=" + godisnjaZarada
				+ ", brGolovaIAsist=" + brojGolovaIAsistencija + "]";
	}
	
	
	
	

}
