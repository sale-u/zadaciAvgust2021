package fudbalskiKlub;

public class Trener extends Osoba {
	
	// svetskiTopTrener je atribut koji opisuje da li je trener top klasa (dobro poznat sirokoj masi) ili nije.
	// Da bi bio top klasa potrebno je da ima brojTrofeja veci od 15 i godinaRada veci od 20.
	
	private double godisnjaZarada;
	private String sponzor;
	private boolean svetskiTopTrener;
	private int godinaRada;
	private int brojTrofeja;
	
	
	public Trener(String ime, String prezime, String jmbg, String adresa, 
			double godisnjaZarada, String sponzor, int godinaRada, int brojTrofeja) {
		super(ime, prezime, jmbg, adresa);
		this.godisnjaZarada = godisnjaZarada;
		this.sponzor = sponzor;
		this.godinaRada = godinaRada;
		this.brojTrofeja = brojTrofeja;
		
		// Da bi bio top klasa potrebno je da ima brojTrofeja veci od 15 i godinaRada veci od 20. 
		if (brojTrofeja > 15 && godinaRada > 20) {
			this.svetskiTopTrener = true;
		} else {
			this.svetskiTopTrener = false;
		}
	}


	public double getGodisnjaZarada() {
		return godisnjaZarada;
	}

	public void setGodisnjaZarada(double godisnjaZarada) {
		this.godisnjaZarada = godisnjaZarada;
	}

	public String getSponzor() {
		return sponzor;
	}

	public void setSponzor(String sponzor) {
		this.sponzor = sponzor;
	}

	public boolean isSvetskiTopTrener() {
		return svetskiTopTrener;
	}

	public void setSvetskiTopTrener(boolean svetskiTopTrener) {
		this.svetskiTopTrener = svetskiTopTrener;
	}

	public int getGodinaRada() {
		return godinaRada;
	}

	public void setGodinaRada(int godinaRada) {
		this.godinaRada = godinaRada;
	}

	public int getBrojTrofeja() {
		return brojTrofeja;
	}

	public void setBrojTrofeja(int brojTrofeja) {
		this.brojTrofeja = brojTrofeja;
	}


	@Override
	public String toString() {
		return super.toString() + "\n\t[godZarada=" + godisnjaZarada + ", sponzor=" + sponzor + 
				", svetskiTopTrener=" + svetskiTopTrener + ", godinaRada=" + godinaRada + 
				", brojTrofeja=" + brojTrofeja + "]";
	}
	
	
	
	
	
	
	

}
