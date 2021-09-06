package fudbalskiKlub;

import java.util.ArrayList;

public class FudbalskiKlub implements IFudbalskiKlub {

	// Atribut brojZaposlenih definise ukupno broj zaposlenih (broj fudbalera i
	// trener)
	// Atribut godisnjiIzdaci predstavljaju ukupne izdatke na nivou GODINE
	// koje fudbalski klub daje na fudbalere i trenere

	private String naziv;
	private Trener trener;
	private ArrayList<Fudbaler> fudbaleri;
	private int brojZaposlenih;
	private int brojTrofeja;
	private double godisnjiIzdaci;

	// full konstruktor. brojZaposlenih i godisnjiIzdaci se posebno racuna u
	// konstruktoru
	public FudbalskiKlub(String naziv, Trener trener, ArrayList<Fudbaler> fudbaleri, int brojTrofeja) {
		super();
		this.naziv = naziv;
		this.trener = trener;
		this.fudbaleri = fudbaleri;
		this.brojTrofeja = brojTrofeja;

		this.brojZaposlenih = 1;
		this.godisnjiIzdaci = trener.getGodisnjaZarada();
		if (fudbaleri != null) { // moze da se desi da tek naknadno dodamo fudbalere
			// Atribut brojZaposlenih definise ukupno broj zaposlenih (broj fudbalera i
			// trener)
			this.brojZaposlenih += fudbaleri.size();

			// Atribut godisnjiIzdaci predstavljaju ukupne izdatke na nivou GODINE
			// koje fudbalski klub daje na fudbalere i trenere
			for (Fudbaler f : fudbaleri) {
				this.godisnjiIzdaci += f.getGodisnjaZarada();
			}
		}
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Trener getTrener() {
		return trener;
	}

	public void setTrener(Trener trener) {
		this.trener = trener;
	}

	public ArrayList<Fudbaler> getFudbaleri() {
		return fudbaleri;
	}

	public void setFudbaleri(ArrayList<Fudbaler> fudbaleri) {
		this.fudbaleri = fudbaleri;
	}

	public int getBrojZaposlenih() {
		return brojZaposlenih;
	}

	public void setBrojZaposlenih() {
		this.brojZaposlenih = fudbaleri.size() + 1;
	}

	public int getBrojTrofeja() {
		return brojTrofeja;
	}

	public void setBrojTrofeja(int brojTrofeja) {
		this.brojTrofeja = brojTrofeja;
	}

	public double getGodisnjiIzdaci() {
		return godisnjiIzdaci;
	}

	public void setGodisnjiIzdaci() {
		this.godisnjiIzdaci = trener.getGodisnjaZarada();
		for (Fudbaler f : fudbaleri) {
			this.godisnjiIzdaci += f.getGodisnjaZarada();
		}
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Fudbalski klub '" + naziv + "'\n============================\n");
		sb.append("Broj zaposlenih = " + brojZaposlenih + " , Broj trofeja = " + brojTrofeja + " , Godisnji izdaci = "
				+ godisnjiIzdaci + "\n");
		sb.append("Trener: " + trener.toString() + "\n");
		if (fudbaleri != null) {
			int count = 1;
			sb.append("Fudbaleri : \n-----------\n");
			for (Fudbaler f : fudbaleri) {
				sb.append(count + " : " + f.toString() + "\n");
				count++;
			}
		}
		return sb.toString();
	}

	@Override
	public Fudbaler najskupljiFudbaler() {
		// vraca fudbalera sa najvecom godisnjom zaradom

		Fudbaler res = null;
		double maxZarada = 0;
		for (Fudbaler f : this.fudbaleri) {
			if (f.getGodisnjaZarada() > maxZarada) {
				maxZarada = f.getGodisnjaZarada();
				res = f;
			}
		}
		return res;
	}

	@Override
	public Fudbaler najNeEfikasnijiFudbaler() {
		// vraca fudbalera sa najmanjom produktivnoscu odnosno sa najmanjim brojem
		// golova i asistencija

		Fudbaler res = null;
		int minGolova = Integer.MAX_VALUE;
		for (Fudbaler f : this.fudbaleri) {
			if (f.getBrojGolovaIAsistencija() < minGolova) {
				minGolova = f.getBrojGolovaIAsistencija();
				res = f;
			}
		}
		return res;
	}

	@Override
	public int brojFudbaleraNaPoziciji(String pozicija) {
		// vraca broj fudbalera koje klub ima na zadatoj poziciji

		int res = 0;
		for (Fudbaler f : this.fudbaleri) {
			if (f.getPozicija().equalsIgnoreCase(pozicija)) {
				res++;
			}
		}
		return res;
	}

	@Override
	public Fudbaler najJeftinijiFudbalerRezerva() {
		// vraca fudbalera koji ima najmanju platu a rezerva je

		Fudbaler res = null;
		double minPlata = Double.MAX_VALUE;
		for (Fudbaler f : fudbaleri) {
			if (f.isRezerva() && f.getGodisnjaZarada() < minPlata) {
				minPlata = f.getGodisnjaZarada();
				res = f;
			}
		}
		return res;
	}

}
