package karticeZaPoene;

import java.util.ArrayList;
import java.util.Random;

public class Korisnik {
	
	private int poeniPre; // ovde se upisuje koliko poena ima Korisnik, tj koliko je sakupio do sad - to vi izmislite
	private ArrayList<Kartica> kartice;
	
	// prazan konstruktor
	public Korisnik() {
		this.kartice = new ArrayList<Kartica>();
		// prilikom instanciranja Korisnika, polje do sada osvojenih poena poeniPre popunjavam sa random [0-100]
		Random rnd = new Random();
		this.poeniPre = rnd.nextInt(101);
	}

	public int getPoeniPre() {
		return poeniPre;
	}

	public void setPoeniPre(int poeniPre) {
		this.poeniPre = poeniPre;
	}

	public ArrayList<Kartica> getKartice() {
		return kartice;
	}

	public void setKartice(ArrayList<Kartica> kartice) {
		this.kartice = kartice;
	}
	
	public int ukupnoZaradjenihPoena(ArrayList<Kartica> kartice) {
		// vraæa ukupno poena na svim karticama
		
		int ukBrojPoena = 0;
		for (Kartica card : kartice) {
			ukBrojPoena += card.izracunajBrojPoena(card);
//			System.out.println("Card ID=" + card.getId() + " >>> " + card.izracunajBrojPoena(card) + " poena");
		}
		return ukBrojPoena;
	}
	
	public void ukupnoPoenaPreIsaZaradom(int poeniPre, int ukupnoZaradjenihPoena) {
		//  ispisuje koliko sada ukupno Korisnik ima poena
		
		int zaradjenihPoena = this.ukupnoZaradjenihPoena(this.kartice);
		System.out.println("Do sada je imao : " + poeniPre + " poena");
		System.out.println("Sa dodatnih : " + zaradjenihPoena + " poena");
		int ukPoena = poeniPre + zaradjenihPoena;
		System.out.println("Sada ima ukupno : " + ukPoena + " poena!");
	}
	
}
