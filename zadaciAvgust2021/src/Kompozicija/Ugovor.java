package Kompozicija;

public class Ugovor {

	private Osoba fizickoLice;
	private Osoba sluzbenoLice;
	private double vrednostUgovora;
	private int trajanjeUgovora;
	private boolean luksuzan;
	
	// =====================================================================================

	public Ugovor(Osoba fizickoLice, Osoba sluzbenoLice, double vrednostUgovora, int trajanjeUgovora) {

		// Logièki atribut luksuzan (true/false) zavisi od atributa
		// vrednostUgovora.Ukoliko je atribut
		// vrednostUgovora veæi od 10.000 on dobija vrednost true u suprotnom dobija
		// vrendnost false

		super();
		this.fizickoLice = fizickoLice;
		this.sluzbenoLice = sluzbenoLice;
		this.vrednostUgovora = vrednostUgovora;
		this.trajanjeUgovora = trajanjeUgovora;
		if (vrednostUgovora > 10000) {
			this.luksuzan = true;
		} else {
			this.luksuzan = false;
		}
	}
	
	// =====================================================================================

	public Osoba getFizickoLice() {
		return fizickoLice;
	}

	public void setFizickoLice(Osoba fizickoLice) {
		this.fizickoLice = fizickoLice;
	}

	public Osoba getSluzbenoLice() {
		return sluzbenoLice;
	}

	public void setSluzbenoLice(Osoba sluzbenoLice) {
		this.sluzbenoLice = sluzbenoLice;
	}

	public double getVrednostUgovora() {
		return vrednostUgovora;
	}

	public void setVrednostUgovora(double vrednostUgovora) {
		this.vrednostUgovora = vrednostUgovora;
	}

	public int getTrajanjeUgovora() {
		return trajanjeUgovora;
	}

	public void setTrajanjeUgovora(int trajanjeUgovora) {
		this.trajanjeUgovora = trajanjeUgovora;
	}

	public boolean isLuksuzan() {
		return luksuzan;
	}

	public void setLuksuzan(boolean luskuzan) {
		if (vrednostUgovora > 10000) {
			this.luksuzan = true;
		} else {
			this.luksuzan = false;
		}
	}
	
	// =====================================================================================

	@Override
	public String toString() {
		return (isLuksuzan()? "Luksuzan " : "") + "Ugovor (vrednost=" + vrednostUgovora + 
				", trajanje=" + trajanjeUgovora + " godina)" +
				"\nFizicko lice= \t" + fizickoLice + 
				"\nSluzbeno lice= \t" + sluzbenoLice;
	}
}
