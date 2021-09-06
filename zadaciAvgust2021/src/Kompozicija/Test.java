package Kompozicija;

public class Test {

	public static void main(String[] args) {

		
		// fizicka lica (klijenti)
		Osoba o1 = new Osoba("Sasa", "Ucek", "Brankova 13-15", "0123456789123", 56);
//		System.out.println(o1);
		Osoba o2 = new Osoba("Mika", "Mikic", "Mikina 1", "0123456789321", 45);
//		System.out.println(o2);
		Osoba o3 = new Osoba("Pera", "Peric", "Perina 12", "0123456789322", 35);
//		System.out.println(o3);
		Osoba o4 = new Osoba("Maksa", "Maksic", "Maksina 112", "0123456798322", 25);
		
		// sluzbeno lice
		Osoba s1 = new Osoba("Cica", "Cicic", "Cicina 15", "0987654321123", 30);
//		System.out.println(s1);
		
		
		Ugovor u1 = new Ugovor(o1, s1, 100000, 30);
		System.out.println("\n" + u1);
		Ugovor u2 = new Ugovor(o2, s1, 50000, 10);
		System.out.println("\n" + u2);
		Ugovor u3 = new Ugovor(o3, s1, 10000, 1);
		System.out.println("\n" + u3);
		Ugovor u4 = new Ugovor(o4, s1, 12000, 1);
		System.out.println("\n" + u4);
		
		
		Ugovor[] ugovori = new Ugovor[10];
		ugovori[0] = u1;
		ugovori[1] = u2;
		ugovori[2] = u3;
		ugovori[3] = u4;
		Banka b1 = new Banka(ugovori, "Beobanka");
		System.out.println("\n" + b1);
		
		System.out.println("Najvredniji ugovor banke " + b1.getNazivBanke() + " je :");
		System.out.println(b1.najvrednijiUgovor());
		
		System.out.println("\nProsecno vreme trajanja ugovora u banci " + b1.getNazivBanke() + " je : " + 
							String.format("%.2f", b1.prosecnoTrajanjeUgovora()) + " godina");
		
		System.out.println("\nBroj luksuznih ugovora u banci " + b1.getNazivBanke() + " je : " +
							b1.brojLuksuznihUgovora());
		
		System.out.println("\nNajmanje vredan luksuzan ugovor u banci " + b1.getNazivBanke() + " je :");
		System.out.println(b1.najManjeVredanLuskuzanUgovor());
		
		System.out.println("\nBroj ugovora u banci " + b1.getNazivBanke() + " gde fizicko lice ima preko 40 godina je : " +
				b1.brojUgovora40());
	}
}
