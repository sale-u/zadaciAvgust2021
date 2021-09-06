package Student;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*	1. 	Kreiranje studenta
 * 		public Student(String ime, String prezime)
 *	2. 	Izmenu i èitanje atributa
 *		geteri i seteri
 *	3. 	Upisivanje, poništavanje, izmenu i èitanje ocene na osnovu naziva predmeta
 *		public boolean upisPredmetaIocene(String predmet, int ocena)
 *		public boolean ponistavanjePredmeta(String predmet)
 *		public boolean izmenaOceneNaPredmetu(String predmet, int ocena)
 *		public int citanjeOceneNaOsnovuPredmeta(String predmet)
 *	4. 	Ispis svih ocena
 *		public String tabelaPolozenihPredmeta()
 *	5. 	Ispis podataka o studentu
 *		public String toString()
 *	6. 	Raèunanje proseka -> prosek automatski racuna samo prilikom prikazivanja podataka o studentu
 *		public double racunProseka()
 *	7. 	Ispis svih predmeta gde je student ostvario ocenu veæu od zadate
		public void ispisiPredmeteSaOcenomVecomOd(int ocena)
 *	8. 	Pretraga I ispis svih predmeta (kao i imena i prezimena) èiji naziv poèinje sa zadatim unetim nazivom
 *		public void ispisiPredmeteSaPocetkomNaziva(String pocetakNaziva)
 *		public static void ispisiStudenteSaPocetkomImenaPrezimena(String pocetakImenaPrezimena) -> u Test.java
 */

public class Student {

	// broj indeksa se automatski generise za svakog novog studenta pocev od broja 1
	// Lista polozenih predmeta i lista ocena su objedinjene u jednu HashMap listu
	// Prosek se posebno racuna (u startu je -1)

	static int brojac = 0; // static brojac za generisanje br.indexa za svakog novog studenta
	private int brojIndeksa;
	private String ime;
	private String prezime;
	private Map<String, Integer> polozeniPredmetiIocene;
	private double prosek;	// racuna se u metodi racunProseka() i automatski ispisuje u toString()

	// ===================================================================================

	// full konstruktor. validacija imena, prezimena
	public Student(String ime, String prezime) {
		super();
		if (!this.validImePrezime(ime)) {
			throw (new IllegalArgumentException("Ime nije validno!"));
		} else {
			this.ime = ime;
		}
		if (!this.validImePrezime(prezime)) {
			throw (new IllegalArgumentException("Prezime nije validno!"));
		} else {
			this.prezime = prezime;
		}
		this.polozeniPredmetiIocene = new HashMap<>();
		this.prosek = -1;
		this.brojIndeksa = ++brojac;
	}

	// ===================================================================================

	public int getBrojIndeksa() {
		return brojIndeksa;
	}

	// broj indexa se automatski dodeljuje
//	public void setBrojIndeksa(int brojIndeksa) {
//		this.brojIndeksa = brojIndeksa;
//	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		if (!this.validImePrezime(ime)) {
			System.out.println("Ime nije validno!");
		} else {
			this.ime = ime;
		}
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		if (!this.validImePrezime(prezime)) {
			System.out.println("Prezime nije validno!");
		} else {
			this.prezime = prezime;
		}
	}

	public Map<String, Integer> getPolozeniPredmetiIocene() {
		return polozeniPredmetiIocene;
	}

	public void setPolozeniPredmetiIocene(Map<String, Integer> polozeniPredmetiIocene) {
		this.polozeniPredmetiIocene = polozeniPredmetiIocene;
	}

	public double getProsek() {
		return prosek;
	}

	public void setProsek(double prosek) {
		this.prosek = prosek;
	}

	// ===================================================================================

	@Override
	public String toString() {
		
		// vraca String sa svim podacima o studentu, listi polozenih ispita i prosek
		
		StringBuilder sb = new StringBuilder();
		sb.append("Student " + ime + " " + prezime + " (br.indeksa = " + brojIndeksa + ")\n");
		String temp = this.tabelaPolozenihPredmeta();
		if (!temp.equals("")) {
			sb.append(temp);
			// trenutni prosek
			sb.append("=".repeat(40) + "\n");
			sb.append(String.format("Ostvareni prosek : %.2f\n", this.racunProseka()));
		} else {
			sb.append("*** Student nema nista polozeno ***\n");
		}
		return sb.toString();
	}

	// ===================================================================================
	
	public String tabelaPolozenihPredmeta() {
		
		// Vraca tabelu polozenih ispita i ostvarenih ocena
		
		StringBuilder sb = new StringBuilder();
		if (!polozeniPredmetiIocene.isEmpty()) {
			sb.append(String.format("%-35s%5s\n", "Predmet", "Ocena"));
			sb.append("=".repeat(40) + "\n");
			
			// privremeni TreeMap radi sortiranja po key=predmetu pre generisanja tabele
			Map<String, Integer> tempTreeMap = new TreeMap<String, Integer>(polozeniPredmetiIocene);
			for (Map.Entry<String, Integer> predmet : tempTreeMap.entrySet()) {
				sb.append(String.format("%-35s%3d\n", predmet.getKey(), predmet.getValue()));
			}
		}
		return sb.toString();
	}

	// =========================private helper metode ====================================
	// ============================== Validatori =========================================

	private boolean validBrojaIndeksa(int indeks) {
		return indeks > 0;
	}

	private boolean validImePrezime(String zaProveru) {
		// poèinje velikim slovom i ne sadrži brojeve
		// za validaciju koristim Regular Expressions
		if (zaProveru == null) {
			return false;
		}
		// prvo veliko slovo, i nema brojeve
		String regex = "[A-Z][a-z]*";
		return zaProveru.matches(regex);
	}

	private boolean validOcena(int ocena) {
		// ocena izmedju 6 i 10
		if (ocena >= 6 && ocena <= 10) {
			return true;
		} else {
			System.out.println("GRESKA *** Ocena mora biti izmedju 6 i 10 !");
		}
		return false;
	}
	
	private boolean isListaPredmetaPrazna() {
		if (polozeniPredmetiIocene.isEmpty()) {
			System.out.println("GRESKA *** Lista predmeta je prazna!");
			return true;
		}
		return false;
	}
	

	// ===================================================================================
	// === Upisivanje, poništavanje, izmenu i èitanje ocene na osnovu naziva predmeta ====

	public boolean upisPredmetaIocene(String predmet, int ocena) {

		if (!polozeniPredmetiIocene.containsKey(predmet)) { // HashMap ne sadrzi ovaj predmet pa moze da se doda
			if (validOcena(ocena)) {
				polozeniPredmetiIocene.put(predmet, ocena); // ocena je validirana pa se upisuje par predmet-ocena
				return true;
			}
		} else { // predmet vec postoji u HashMapi. Mora se nova ocena staviti drugom metodom
			System.out.println("GRESKA *** Student je vec polagao predmet '" + predmet
					+ "' -> koristite drugu metodu za izmenu ocene!");
		}
		return false;
	}

	public boolean izmenaOceneNaPredmetu(String predmet, int ocena) {

		if (!isListaPredmetaPrazna()) {
			if (polozeniPredmetiIocene.containsKey(predmet)) {
				if (validOcena(ocena)) {
					polozeniPredmetiIocene.replace(predmet, ocena);
					return true;
				}
			} else {
				System.out.println(
						"GRESKA *** Ne mozete izmeniti ocenu jer student nije polagao predmet '" + predmet + "'");
			}
		}
		return false;
	}

	public boolean ponistavanjePredmeta(String predmet) {
		if (!isListaPredmetaPrazna()) {
			if (polozeniPredmetiIocene.containsKey(predmet)) {
				polozeniPredmetiIocene.remove(predmet);
				return true;
			} else {
				System.out.println(
						"Polaganje predmeta '" + predmet + "' nije moguce ponistiti jer ga student nije ni polagao");
			}
		}
		return false;
	}

	public int citanjeOceneNaOsnovuPredmeta(String predmet) {
		
		// vraca -1 ako nije uspeo da nadje predmet ili je lista prazna
		
		if (!isListaPredmetaPrazna()) {
			if (polozeniPredmetiIocene.containsKey(predmet)) {
				return polozeniPredmetiIocene.get(predmet);
			} else {
				System.out.println("GRESKA *** Student nije polagao predmet '" + predmet + "'");
			}
		}
		return -1;
	}

	
	// ===================================================================================
	// ============================ OSTALO ===============================================
	
	public double racunProseka() {
		
		// vraca -1 ako je lista polozenih predmeta prazna
		
		if (!isListaPredmetaPrazna()) {
			// ocene su u HashMap polozeniPredmetiIocene zapisane kao values
			int sum = polozeniPredmetiIocene.values().stream()
					.reduce(0, (zbir, ocena) -> zbir + ocena);
//			int sum = polozeniPredmetiIocene.values().stream().mapToInt(x -> x).sum(); // drugi nacin
			double prosek = (double) sum / polozeniPredmetiIocene.size();
			setProsek(prosek);	// prosek upisujemo kao atribut Studenta
			return prosek;
		}
		return -1;
	}

	public void ispisiPredmeteSaOcenomVecomOd(int ocena) {
		
		if (!isListaPredmetaPrazna()) {
			for (Map.Entry<String, Integer> stavka : polozeniPredmetiIocene.entrySet()) {
				if (stavka.getValue() > ocena) {
					System.out.printf("%-35s%3d\n", stavka.getKey(), stavka.getValue());
				}
			}
		}
	}
	
	public void ispisiPredmeteSaPocetkomNaziva(String pocetakNaziva) {
		
		if (!isListaPredmetaPrazna()) {
			
			polozeniPredmetiIocene.entrySet().stream()
				.filter(stavka -> stavka.getKey().toUpperCase().startsWith(pocetakNaziva.toUpperCase()))
				.forEach(stavka -> System.out.printf("%-35s%3d\n", stavka.getKey(), stavka.getValue()));
		}
	}

}
