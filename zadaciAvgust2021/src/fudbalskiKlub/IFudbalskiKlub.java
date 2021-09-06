package fudbalskiKlub;

public interface IFudbalskiKlub {
	
	public Fudbaler najskupljiFudbaler();
	// vraca fudbalera sa najvecom godisnjom zaradom
	
	public Fudbaler najNeEfikasnijiFudbaler();
	// vraca fudbalera sa najmanjom produktivnoscu odnosno sa najmanjim brojem golova i asistencija
	
	public int brojFudbaleraNaPoziciji(String pozicija); 
	// vraca  broj fudbalera koje klub ima na zadatoj poziciji
	
	public Fudbaler najJeftinijiFudbalerRezerva();
	// vraca fudbalera koji ima najmanju platu a rezerva je

}
