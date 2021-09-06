package fudbalskiKlub;

public abstract class PremierLigaKonf {
	
	public abstract FudbalskiKlub klubSaNajviseZaposlenih(); 
	// vraca klub sa najvise zaposlenih
	
	public abstract double prosecnaIzdaciKluba(); 
	// vraca se prosek izdataka klubova na zaposlene
	
	public abstract Fudbaler najskupljiFudbalerLige(FudbalskiKlub[] klubGdeIgraNajskuplji); 
	// vraca fudbalera koji ima najvecu platu i ispisuje i njegov klub
	// da bi vratio i F.klub kome pripada, dodao sam ulazni parametar niz sa jednim elementom koji je u pocetku null
	
	public abstract int brojIgracaSponzoraLige(); 
	// vraca broj koliko fudbalera ima istog sponzora kao i liga

}
