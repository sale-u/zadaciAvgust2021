package karticeZaPoene;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Kartica karticaNormal = new Kartica();
		karticaNormal.setId(1);
		karticaNormal.setPan("123-456");
		karticaNormal.setTipKartice(1);
		karticaNormal.setSipanoLitara(20.5);
		
		Kartica karticaGold = new Kartica(2, "789-000", 30.7, 2);
		
		Korisnik pera = new Korisnik();
		// podatak poeniPre se automatski racuna kao random u konstruktoru
		ArrayList<Kartica> kartice = new ArrayList<Kartica>();
		kartice.add(karticaNormal);
		kartice.add(karticaGold);
		pera.setKartice(kartice);
		
		int ukupnoZaradjenihPoena = pera.ukupnoZaradjenihPoena(kartice);
		pera.ukupnoPoenaPreIsaZaradom(pera.getPoeniPre(), ukupnoZaradjenihPoena); // stampa trazene podatke
		
		System.out.println();
		System.out.println("Ukupno sipanih litara (po svim karticama) : " + Statistika.racunajLitre(kartice));
		System.out.println("Extra poena : " + Statistika.extraPoeni(pera));
				
		System.out.println();
		String unetPan = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("Unesite PAN kartice : ");
		unetPan = scanner.nextLine();
		Statistika.poeniKartice(unetPan, kartice);
		scanner.close();

	}

}
