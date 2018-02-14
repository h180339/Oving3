package no.hvl.dat102.mengde.klient;

public class Datakontakt {

	private Medlem[] tab;
	private int antall;

	public Datakontakt() {
		this.antall = 0;
		this.tab = new Medlem[10];
	}
	private void utvidKapasitet() {
		Medlem [] hjelpetabell = new Medlem[2 * tab.length];
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}
	public void LeggTilMedlem(Medlem person) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = person;
		antall++;
	}

	public int finnMedlemsIndeks (String medlemsNavn) {
		for (int i = 0; i < antall; i++) {
			if (tab[i].getNavn() == medlemsNavn) {
				return i;
			}
		}
		return -1;
	}

}
