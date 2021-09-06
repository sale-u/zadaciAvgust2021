package fudbalskiKlub;

import java.util.HashSet;
import java.util.Iterator;

public class PremierLiga extends PremierLigaKonf {

	private String sponzor;
	private HashSet<FudbalskiKlub> klubovi; // obicno koristim ArrayList, ali da probamo i sa HashSet

	// Atributi: brojKlubova, brojIgraca kao i brojTrenera, popuniti na osnovu
	// kolekcije klubova.
	private int brojKlubova;
	private int brojIgraca;
	private int brojTrenera;

	// full konstruktor. brojKlubova, brojIgraca kao i brojTrenera se racunaju
	public PremierLiga(String sponzor, HashSet<FudbalskiKlub> klubovi) {
		super();
		this.sponzor = sponzor;
		this.klubovi = klubovi;

		if (klubovi != null) {
			this.brojKlubova = klubovi.size();
			for (FudbalskiKlub fk : klubovi) {
				this.brojIgraca += fk.getFudbaleri().size();
				this.brojTrenera++;
			}
		}
	}

	public String getSponzor() {
		return sponzor;
	}

	public void setSponzor(String sponzor) {
		this.sponzor = sponzor;
	}

	public HashSet<FudbalskiKlub> getKlubovi() {
		return klubovi;
	}

	public void setKlubovi(HashSet<FudbalskiKlub> klubovi) {
		this.klubovi = klubovi;
	}

	public int getBrojKlubova() {
		return brojKlubova;
	}

	public void setBrojKlubova() {
		this.brojKlubova = klubovi.size();
	}

	public int getBrojIgraca() {
		return brojIgraca;
	}

	public void setBrojIgraca() {
		this.brojIgraca = 0;
		for (FudbalskiKlub fk : klubovi) {
			this.brojIgraca += fk.getFudbaleri().size();
		}
	}

	public int getBrojTrenera() {
		return brojTrenera;
	}

	public void setBrojTrenera() {
		this.brojTrenera = klubovi.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Premier Liga\n============\n");
		sb.append("Sponzor = " + sponzor + " , Broj klubova = " + this.getBrojKlubova());
		sb.append(" , Broj igraca = " + this.getBrojIgraca() + " , Broj trenera = " + this.getBrojTrenera() + "\n");
		if (klubovi != null) {
			sb.append("Spisak klubova : \n----------------\n");
			int count = 1;
			Iterator<FudbalskiKlub> iter = klubovi.iterator();
			while (iter.hasNext()) {
				sb.append(count + " : " + iter.next().getNaziv() + "\n");
				count++;
			}
		}
		return sb.toString();
	}

	@Override
	public FudbalskiKlub klubSaNajviseZaposlenih() {
		// vraca klub sa najvise zaposlenih
		
		FudbalskiKlub res = null;
		int maxZaposlenih = 0;
		for (FudbalskiKlub fk : klubovi) {
			if (fk.getBrojZaposlenih() > maxZaposlenih) {
				maxZaposlenih = fk.getBrojZaposlenih();
				res = fk;
			}
		}
		return res;
	}

	@Override
	public double prosecnaIzdaciKluba() {
		// vraca se prosek izdataka klubova na zaposlene
		
		if (klubovi == null) {
			return 0;
		}
		double sum = 0;
		for (FudbalskiKlub fk : klubovi) {
			sum += fk.getGodisnjiIzdaci();
		}
		return sum / klubovi.size();
	}

	@Override
	public Fudbaler najskupljiFudbalerLige(FudbalskiKlub[] klubGdeIgraNajskuplji) {
		// vraca fudbalera koji ima najvecu platu i ispisuje i njegov klub
		// da bi vratio i F.klub kome pripada, dodao sam ulazni parametar niz sa jednim elementom koji je u pocetku null
		
		Fudbaler res = null;
		FudbalskiKlub fkGdeIgraNajskupljiFudbaler = null;
		double maxPlata = 0;
		Iterator<FudbalskiKlub> iter = klubovi.iterator();
		while (iter.hasNext()) {
			FudbalskiKlub fk = iter.next();
			for (Fudbaler f : fk.getFudbaleri()) {
				if (f.getGodisnjaZarada() > maxPlata) {
					maxPlata = f.getGodisnjaZarada();
					res = f;
					fkGdeIgraNajskupljiFudbaler = fk;
				}
			}
		}
		klubGdeIgraNajskuplji[0] = fkGdeIgraNajskupljiFudbaler;
		return res;
	}

	@Override
	public int brojIgracaSponzoraLige() {
		// vraca broj koliko fudbalera ima istog sponzora kao i liga
		
		String sponzorLige = this.getSponzor();
		int res = 0;
		Iterator<FudbalskiKlub> iter = klubovi.iterator();
		while (iter.hasNext()) {
			FudbalskiKlub fk = iter.next();
			for (Fudbaler f : fk.getFudbaleri()) {
				if (f.getSponzor().equalsIgnoreCase(sponzorLige)) {
					res++;
				}
			}
		}
		return res;
	}

}
