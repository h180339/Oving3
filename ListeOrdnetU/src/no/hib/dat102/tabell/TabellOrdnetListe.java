package no.hib.dat102.tabell;

import no.hib.dat102.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	
	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		T resultat = null;
		resultat = liste[bak];
		bak--;
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		T resultat = null;
		resultat = liste[0];
		for(int i = 0; i < bak; i++) {
			liste[i] = liste [i+1];
		}
		bak--;
		return resultat;
	}

     @Override
	public T foerste() {
		T resultat = null;
		if (!erTom()){
			resultat = liste[0];
		}
		return resultat;
	}

	@Override
	public T siste() {
		T resultat = null;
		if(!erTom()) {
			resultat = liste[bak];
		}
		
	return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		//Sjekk om liste er full
		if (liste.length == bak) {
			utvid();
		}

		//Finn riktig plass å sette elementet, øker index til elementet er mindre eller lik element i tabell
		int index = 0;
		while(element.compareTo(liste[index]) > 0) {
			index++;
		}
		//Flytter alle elementene 1 plass bakover
		for(int i = bak; i >= index; i--) {
			liste[bak+1] = liste[i];
		}
		liste[index] = element;
		bak++;
	}

	
	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		int index = finn(element);
		if(index < 0) {
			return null;
		} else {
			for(int i = index; i < bak; i++) {
				liste[i] = liste[i+1];
			}
		}
		return element;
		
	}		

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		for(int j = 0; j < bak; j++) {
			if(el.compareTo(liste[j]) == 0) {
				return j;
			}
		}
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}


	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Object[liste.length * 2]);

		for (int i = 0; i < liste.length; i++){
			hjelpeTabell[i] = liste[i];
		}
		
		liste = hjelpeTabell;
	}

}