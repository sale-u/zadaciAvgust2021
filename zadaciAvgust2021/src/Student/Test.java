package Student;

import java.util.ArrayList;

public class Test {
	
	private static ArrayList<Student> studenti = new ArrayList<>();	// lista studenata

	public static void main(String[] args) {

		
		System.out.println("1. Kreiranje studenta ...\n");
		Student s1 = new Student("Laza", "Lazic");

		System.out.println("3.1 Upisivanje polozenih predmeta ....\n");
		s1.upisPredmetaIocene("Osnovi programiranja", 9);
		s1.upisPredmetaIocene("Osnovi elektronike", 8);
		s1.upisPredmetaIocene("Clipper jezik", 7);
		s1.upisPredmetaIocene("Fortran jezik", 8);
		s1.upisPredmetaIocene("Asembler", 8);
		System.out.println(s1);

		if (s1.izmenaOceneNaPredmetu("Asembler", 9)) {
			System.out.println("3.3 Promenjena ocena na Asembleru ...\n");
			System.out.println(s1.tabelaPolozenihPredmeta());
		}

		if (s1.ponistavanjePredmeta("Asembler")) {
			System.out.println("3.2 Uklonjen predmet Asembler ....\n");
			System.out.println(s1.tabelaPolozenihPredmeta());
		}

		System.out.println("Dodat predmet Basic ....\n");
		s1.upisPredmetaIocene("Basic", 10);
		int ocena = s1.citanjeOceneNaOsnovuPredmeta("Basic");
		if (ocena != -1) {
			System.out.println("3.4 Iz predmeta Basic ima ocenu " + ocena + "\n");
		}
		
		System.out.println("4. Ispis svih ocena....\n");
		System.out.println(s1.tabelaPolozenihPredmeta());
		
		System.out.println("5. Ispis podataka o studentu ...\n");
		System.out.println(s1);
		
		System.out.println("6. Racunanje proseka....\n");
		if (s1.racunProseka() != -1) {
			System.out.printf("Prosek ocena je %.2f\n\n", s1.getProsek());
		}
		
		System.out.println("7. Ispis predmeta sa ocenom vecom od 8 ....\n");
		s1.ispisiPredmeteSaOcenomVecomOd(8);
		
		System.out.println("\n8.1 Ispis svih predmeta koji pocinju sa 'Osnovi' .... \n");
		s1.ispisiPredmeteSaPocetkomNaziva("OsnoVi");
		
		System.out.println("\n >>>>> Dodavanje jos studenata <<<<<< ...\n");
		Student s2 = new Student("Lazar", "Markovic");
		s2.upisPredmetaIocene("Osnovi elektronike", 10);
		s2.upisPredmetaIocene("Basic", 7);
		s2.upisPredmetaIocene("Osnovi programiranja", 8);
		System.out.println(s2);
		
		Student s3 = new Student("Marko", "Lazic");
		s3.upisPredmetaIocene("Osnovi elektronike", 6);
		s3.upisPredmetaIocene("Basic", 9);
		s3.upisPredmetaIocene("Osnovi programiranja", 9);
		System.out.println(s3);
		
		studenti.add(s1);
		studenti.add(s2);
		studenti.add(s3);
		
		System.out.println("\n8.1 Ispis svih studenata cija imena ili prezimena pocinju sa 'laz' .... \n");
		ispisiStudenteSaPocetkomImenaPrezimena("laz");
		

	}
	
	// =======================================================================================
	
	public static void ispisiStudenteSaPocetkomImenaPrezimena(String pocetakImenaPrezimena) {
		
		// ignore case
		
		if (!studenti.isEmpty()) {
			for (Student s : studenti) {
				if (s.getIme().toUpperCase().startsWith(pocetakImenaPrezimena.toUpperCase())
						|| s.getPrezime().toUpperCase().startsWith(pocetakImenaPrezimena.toUpperCase())) {
					System.out.println(s);
				}
			}
		}
	}
	

}
