package fudbalskiKlub;

import java.util.ArrayList;
import java.util.HashSet;

public class Test {

	public static void main(String[] args) {

//		Osoba o1 = new Osoba("Sasa", "Ucek", "1234567890123", "Brankova ulica 13-15");
//		System.out.println(o1);
//		System.out.println();
		
		Fudbaler f1 = new Fudbaler("Mica", "Micic", "3210987654321", "Mice Micica 10", 1100, 3, "Comtrade", false, 10, "napadac");
		Fudbaler f2 = new Fudbaler("Pera", "Peric", "1234567890321", "Pere perica 13", 500, 1, "Comtrade", false, 1, "odbrana");
		Fudbaler f3 = new Fudbaler("Mile", "Milic", "0987654321000", "Mile Milica 45", 800, 2, "Comtrade", false, 0, "golman");
		Fudbaler f4 = new Fudbaler("Marko", "Markovic", "1235678904123", "Markova 56", 300, 1, "Comtrade", true, 1, "odbrana");

		
		Trener t1 = new Trener("Trener", "Treneric", "0123456789123", "Trenera Trenerica 7", 30000, "Comtrade", 25, 16);
//		System.out.println(t1);
		
		System.out.println();
		ArrayList<Fudbaler> igraciPartizan = new ArrayList<>();
		igraciPartizan.add(f1);
		igraciPartizan.add(f2);
		igraciPartizan.add(f3);
		igraciPartizan.add(f4);
		FudbalskiKlub partizan = new FudbalskiKlub("Partizan", t1, igraciPartizan, 5);
		System.out.println(partizan);
		
		System.out.println("\nNajskuplji fudbaler kluba " + partizan.getNaziv() + " je:");
		System.out.println(partizan.najskupljiFudbaler());
		System.out.println("\nNajneefikasniji fudbaler kluba " + partizan.getNaziv() + " je:");
		System.out.println(partizan.najNeEfikasnijiFudbaler());
		String pozicija = "odbrana";
		System.out.print("\nBroj fudbalera na poziciji " + pozicija + " u klubu " + partizan.getNaziv() + " je ");
		System.out.println(partizan.brojFudbaleraNaPoziciji("odbrana"));
		System.out.println("\nNajjeftiniji fudbaler kluba " + partizan.getNaziv() + " koji je rezerva je:");
		System.out.println(partizan.najJeftinijiFudbalerRezerva());
		
		System.out.println();
		Trener t2 = new Trener("Mita", "Mitic", "1234567890567", "Mite Mitica 1", 35000, "NIS", 20, 15);
//		System.out.println(t2);
		
		FudbalskiKlub crvZvezda = new FudbalskiKlub("Crvena Zvezda", t2, null, 6); // naknadno dodajemo fudbalere
		ArrayList<Fudbaler> igraciCZ = new ArrayList<>();
		igraciCZ.add(new Fudbaler("Pera", "Peric", "0123456789321", "Periceva 2", 1000, 5, "NIS", false, 10, "napad"));
		igraciCZ.add(new Fudbaler("Nenad", "Nedic", "0123456789312", "Nediceva 16-18", 800, 4, "NIS", false, 2, "odbrana"));
		igraciCZ.add(new Fudbaler("Voja", "Vojic", "0123456789322", "Vojina 45", 700, 3, "NIS", false, 0, "golman"));
		igraciCZ.add(new Fudbaler("Mitar", "Miric", "1111111111111", "Miriceva 101", 300, 1, "NIS", true, 2, "odbrana"));
		igraciCZ.add(new Fudbaler("Sasa", "Sasic", "2222222222222", "Sasiceva 10", 900, 5, "NIS", false, 8, "napad"));
		crvZvezda.setFudbaleri(igraciCZ); 	// naknadno dodati igraci
		crvZvezda.setBrojZaposlenih();		// naknadno izracunato
		crvZvezda.setGodisnjiIzdaci();		// naknadno izracunato
		System.out.println(crvZvezda);
		System.out.println();
		
		System.out.println("\nNajskuplji fudbaler kluba " + crvZvezda.getNaziv() + " je:");
		System.out.println(crvZvezda.najskupljiFudbaler());
		System.out.println("\nNajneefikasniji fudbaler kluba " + crvZvezda.getNaziv() + " je:");
		System.out.println(crvZvezda.najNeEfikasnijiFudbaler());
		pozicija = "odbrana";
		System.out.print("\nBroj fudbalera na poziciji " + pozicija + " u klubu " + crvZvezda.getNaziv() + " je ");
		System.out.println(crvZvezda.brojFudbaleraNaPoziciji("odbrana"));
		System.out.println("\nNajjeftiniji fudbaler kluba " + crvZvezda.getNaziv() + " koji je rezerva je:");
		System.out.println(crvZvezda.najJeftinijiFudbalerRezerva());
		System.out.println();
		
		
		PremierLiga pl = new PremierLiga("NIS", null);
		HashSet<FudbalskiKlub> spisakKlubova = new HashSet<>();
		spisakKlubova.add(partizan);
		spisakKlubova.add(crvZvezda);
		pl.setKlubovi(spisakKlubova);	// naknadno dodati klubovi
		pl.setBrojKlubova();			// naknadno izracunato
		pl.setBrojIgraca();				// naknadno izracunato
		pl.setBrojTrenera();			// naknadno izracunato
		System.out.println(pl);
		
		System.out.println("Klub sa najvise zaposlenih je " + pl.klubSaNajviseZaposlenih().getNaziv());
		System.out.println("\nProsek izdataka klubova na zaposlene : " + pl.prosecnaIzdaciKluba());
		
		// da bi vratio i F.klub kome pripada, dodao sam ulazni parametar niz sa jednim elementom koji je u pocetku null
		FudbalskiKlub[] klubGdeIgraNajskuplji = new FudbalskiKlub[1]; // jedini element bi bio F.klub gde igra najskuplji fudbaler
		Fudbaler najskuplji = pl.najskupljiFudbalerLige(klubGdeIgraNajskuplji);
		System.out.println("\nNajskuplji fudbaler lige igra u klubu " + klubGdeIgraNajskuplji[0].getNaziv() + " i on je :");
		System.out.println(najskuplji);
		
		String sponzorLige = pl.getSponzor();
		System.out.println("\nBroj igraca kojima je sponzor isti kao i sponzor lige ('" + sponzorLige + "') je " + pl.brojIgracaSponzoraLige());

	}

}
