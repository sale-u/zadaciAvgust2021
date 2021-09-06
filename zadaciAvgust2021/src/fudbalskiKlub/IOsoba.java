package fudbalskiKlub;

public interface IOsoba {

	public boolean validacijaJmbg(String jmbg);	
	// jmbg mora imati tacno 13 cifara -> morao sam dodati ulazni String parametar zbog validacije u konstruktoru
	
	public boolean validacijaAdrese(String adresa);	
	// adresa mora imati bar jedan broj i taj broj MORA biti na mestu poslednje reci.
	// morao sam dodati ulazni String parametar zbog validacije u konstruktoru
}
