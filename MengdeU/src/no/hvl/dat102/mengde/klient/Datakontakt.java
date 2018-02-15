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
		if (finnMedlemsIndeks(person.getNavn()) == -1) {
			tab[antall] = person;
			antall++;
		}
	}

	public int finnMedlemsIndeks (String medlemsNavn) {
		for (int i = 0; i < antall; i++) {
			if (tab[i] != null) {
				if (tab[i].getNavn().toLowerCase().equals(medlemsNavn.toLowerCase())) {
					return i;
				}
			}
		}

		return -1;
	}
	public int finnPartnerFor(String medlemsNavn) {

		int index = finnMedlemsIndeks(medlemsNavn); //søker etter medlem i tab

		if (index == -1) {
			return -1;
		}
		for (int i = 0; i < this.antall; i++) {
			if (tab[i] != null) {
				if ((i != index) && (tab[i].getHobbyer().equals(tab[index].getHobbyer())) && (tab[i].getStatusIndeks() == -1)) {
					tab[i].setStatusIndeks(index);
					tab[index].setStatusIndeks(i);
					return i;
				}
			}

		}
		return -1;
	}

	public void tilbakestillStatusIndeks(String medlemsNavn) {
		int index = finnMedlemsIndeks(medlemsNavn);

		if (index != -1) {
			int partner = tab[index].getStatusIndeks();
			if (partner != -1) {
				tab[partner].setStatusIndeks(-1);
				tab[index].setStatusIndeks(-1);
			}
		}
	}
	public Medlem getMedlem(String navn) {
		return this.tab[finnMedlemsIndeks(navn)];
	}
	public void skrivUtHobbyer() {
		for (Medlem i : tab) {
			System.out.println(i.getHobbyer());
		}
	}
	public void skrivUtPar() {

		Medlem[] hjelpeTab = new Medlem[antall];
		for (int i = 0; i < antall; i++) {
			hjelpeTab[i] = this.tab[i];
		}
		for (int i = 0; i < antall; i++) {
			if (hjelpeTab[i] != null) {
				int resultat = hjelpeTab[i].getStatusIndeks();
				if (resultat != -1) {
					System.out.println(hjelpeTab[i].getNavn() + "| " + hjelpeTab[resultat].getNavn());
					hjelpeTab[i] = null;
					hjelpeTab[resultat] = null;
				}
			}
		}

	}
	public Medlem getMedlemByIndex(int index) {
		if (index != -1) {
			return this.tab[index];
		}
		return null;
	}
	public boolean harPartner(String medlem) {
		if (tab[finnMedlemsIndeks(medlem)].getStatusIndeks() != -1) {
			return true;
		}
		return false;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < antall; i++) {
			if (this.tab[i] != null) {
				s += tab[i].toString();
			}
		}
		return s;
	}

}
