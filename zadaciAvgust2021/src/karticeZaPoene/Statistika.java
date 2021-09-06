package karticeZaPoene;

import java.util.ArrayList;

public class Statistika {
	
	public static double racunajLitre(ArrayList<Kartica > kartice) {
		// za unetu listu Kartica raèuna ukupno sipanih litara.
		
		double ukSipanihLitara = 0;
		for (Kartica card : kartice) {
			ukSipanihLitara += card.getSipanoLitara();
		}
	return ukSipanihLitara;
	}
	
	public static int extraPoeni(Korisnik korisnik) {
		// za unetu listu Kartica raèuna extra poene tj, ukoliko je Korisnik dobio više od 100 poena 
		// dodaje mu se još 20%.
		
		int extraPoeni = 0;
		ArrayList<Kartica> listaKartica = korisnik.getKartice();
		int brPoena = korisnik.ukupnoZaradjenihPoena(listaKartica);
		if (brPoena > 100) {
			extraPoeni = (int) (Math.floor(brPoena * 0.2));	// zaokruzuje na donju int vrednost
		}
		
		return extraPoeni;
	}
	
	public static void poeniKartice(String pan, ArrayList<Kartica > kartice) {
		// ispisuje koliko poena je dobila kartica tako što joj se unese pan.
		
		Kartica nadjenaKartica = null;

		for (Kartica card : kartice) {
			if (card.getPan().equals(pan)) {
				nadjenaKartica = card;
				break;
			}
		}
		if (nadjenaKartica != null) {
			nadjenaKartica.ispisiKarticu();
			System.out.println(" i ima " + nadjenaKartica.izracunajBrojPoena(nadjenaKartica) + " poena");
		} else {
			System.out.println("Ne postoji kartica sa unetim PANom!");
		}
	}
	

}
