package Kompozicija;

import java.util.Arrays;

public class Banka {

	// Atribut ukupnaVrednostUgovora treba da se dobija na osnovu podataka iz niza u
	// okviru konstruktora.

	private Ugovor[] nizUgovora;
	private String nazivBanke;
	private double ukupnaVrednostUgovora;

	// =====================================================================================
	
	// full constructor
	public Banka(Ugovor[] nizUgovora, String nazivBanke) {

		// Atribut ukupnaVrednostUgovora treba da se dobija na osnovu podataka iz niza u
		// okviru konstruktora.

		super();
		this.nizUgovora = nizUgovora;
		this.nazivBanke = nazivBanke;

		if (nizUgovora != null) {
			// varijanta sa stream-ovima i lambda izrazima
			double ukupnaVrednostUgovora = Arrays.stream(nizUgovora)
						.filter((Ugovor u) -> u != null) // ako su clanovi niza ugovora vec definisani onda ce se njihova vrednost uzeti u obzir
						.map(ugovor -> ugovor.getVrednostUgovora())
						.reduce(0.0, (medjuzbir, vredUgovora) -> medjuzbir + vredUgovora);
			// 	.reduce(0.0, (zbir, ugovor) -> zbir + ugovor.getVrednostUgovora(), Double::sum);
			this.ukupnaVrednostUgovora = ukupnaVrednostUgovora;

			// klasicna varijanta sa for-each petljom
//			double ukupnaVrednostUgovora = 0;
//			for (Ugovor u : nizUgovora) {
//				if (u != null) { // ako su clanovi niza ugovora vec definisani onda ce se njihova vrednost uzeti u obzir
//					ukupnaVrednostUgovora += u.getVrednostUgovora();
//				}
//			}
//			this.ukupnaVrednostUgovora = ukupnaVrednostUgovora;
		}
	}

	// =====================================================================================
	
	public Ugovor[] getNizUgovora() {
		return nizUgovora;
	}

	public void setNizUgovora(Ugovor[] nizUgovora) {
		this.nizUgovora = nizUgovora;
	}

	public String getNazivBanke() {
		return nazivBanke;
	}

	public void setNazivBanke(String nazivBanke) {
		this.nazivBanke = nazivBanke;
	}

	public double getUkupnaVrednostUgovora() {
		return ukupnaVrednostUgovora;
	}

	public void setUkupnaVrednostUgovora() {
		if (this.nizUgovora != null) {
			// varijanta sa primitive stream-ovima i lambda izrazima
			double ukupnaVrednostUgovora = Arrays.stream(nizUgovora)
					.filter((Ugovor u) -> u != null)
					.mapToDouble(ugovor -> ugovor.getVrednostUgovora())
//					.peek(System.out::println)
					.sum();
			this.ukupnaVrednostUgovora = ukupnaVrednostUgovora;

			// klasicna varijanta sa for-each petljom
//			double ukupnaVrednostUgovora = 0;
//			for (Ugovor u : nizUgovora) {
//				if (u != null) { // ako su clanovi niza ugovora vec definisani onda ce se njihova vrednost uzeti
//									// u obzir
//					ukupnaVrednostUgovora += u.getVrednostUgovora();
//				}
//			}
//			this.ukupnaVrednostUgovora = ukupnaVrednostUgovora;
		}
	}
	
	// =====================================================================================

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Banka " + nazivBanke + " (ukupnaVrednostUgovora= " + ukupnaVrednostUgovora + ")\n");
		if (nizUgovora != null) {
			if (nizUgovora[0] != null) {
				sb.append("Spisak ugovora:\n===============\n");
			}
			int count = 1;
			for (Ugovor u : nizUgovora) {
				if (u != null) {
					sb.append(count + " : " + u + "\n\n");
					count++;
				}
			}
		}
		return sb.toString();
	}
	
	// =====================================================================================
	
	public Ugovor najvrednijiUgovor() {		
		// metoda koja vraæa/ispisuje najvredniji ugovor banke
		
		Ugovor najvrednijiUgovor = null;
		double maxValue = 0;
		
		for (Ugovor u : nizUgovora) {
			if (u != null) {
				if (u.getVrednostUgovora() > maxValue) {
					najvrednijiUgovor = u;
					maxValue = u.getVrednostUgovora();
				}
			}
		}
		return najvrednijiUgovor;
	}

	// =====================================================================================
	
	public double prosecnoTrajanjeUgovora() {		
		// metoda koja vraæa proseènu vrednost trajanja svih ugovora
		
		return Arrays.stream(this.nizUgovora)
				.filter(ugovor -> ugovor != null)
				.mapToDouble(ugovor -> ugovor.getTrajanjeUgovora())
				.average()
				.getAsDouble();
	}
	
	// =====================================================================================
	
	public int brojLuksuznihUgovora() {		
		// metoda koja vraæa broj ugovora koji su luksuzni
		
		return (int) Arrays.stream(this.nizUgovora)
					.filter(ugovor -> ugovor != null)
					.filter(ugovor -> ugovor.isLuksuzan())
					.count();
	}
	
	// =====================================================================================
	
	public Ugovor najManjeVredanLuskuzanUgovor() {		
		// metoda koja vraæa luksuzan ugovor sa najmanjom vrednošæu
		
		Ugovor najmanjeVredanLuksuzniUgovor = null;
		double minValue = Double.MAX_VALUE;
		
		for (Ugovor u : nizUgovora) {
			if (u != null) {
				if (u.isLuksuzan() && u.getVrednostUgovora() < minValue) {
					minValue = u.getVrednostUgovora();
					najmanjeVredanLuksuzniUgovor = u;
				}
			}
		}
		return najmanjeVredanLuksuzniUgovor;
	}
	
	// =====================================================================================
	
	public int brojUgovora40() {		
		// metoda koja vraæa broj, koji prebrojava ugovore gde fizièko lice ima starost veæu od 40 godina
		
		return (int) Arrays.stream(this.nizUgovora)
				.filter(ugovor -> ugovor != null)
				.filter(ugovor -> ugovor.getFizickoLice().getBrojGodina() > 40)
				.count();
	}
}
