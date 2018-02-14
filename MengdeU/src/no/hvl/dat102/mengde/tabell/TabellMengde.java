package no.hvl.dat102.mengde.tabell;

import no.hvl.dat102.mengde.adt.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return this.antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) {

		T svar = null;

		for (int i = 0; i < antall; i++) {
			if (element == tab[i]) {
				svar = this.tab[i];
				tab[i] = tab[antall];
				antall--;
			}
		}


		return svar;
	}

	@Override
	
	public MengdeADT<T> union(MengdeADT<T> m2) {

		TabellMengde<T> hjelper = new TabellMengde<>();

		Iterator<T> teller = m2.oppramser();
		Iterator<T> teller2 = this.oppramser();


		HashMap kart = new HashMap();

		while (teller2.hasNext()) {
			kart.put(teller2.next(), true);
		}
		while (teller.hasNext()) {
			kart.put(teller.next(), true);
		}
		Object [] foo = kart.keySet().toArray();

		hjelper.erstattTab((T[])foo);

		MengdeADT<T> begge = hjelper;

		return begge;
	}//

	public void erstattTab (T[] bar) {
		this.tab = bar;
		this.antall = bar.length;
	}
	
	

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new TabellMengde<T>();

		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			T foo = teller.next();
			if (inneholder(foo)) {
				snittM.leggTil(foo);
			}
		}

		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();

		Iterator<T> teller = this.oppramser();
		Iterator<T> teller2 = m2.oppramser();
		T teller2El = null;
		while(teller.hasNext()) {
			T tellerEl = teller.next();
			if (teller2.hasNext()) {
				teller2El = teller2.next();
			}
			if (tellerEl != teller2El) {
				differensM.leggTil(tellerEl);
				System.out.println(tellerEl);
			}
		}

		return differensM;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {


		if (antall() != m2.antall()) { //sjekker først om det er like mange elementer i mengdene
			return false;
		}
		if (this.antall == 0 && m2.antall() == 0 ) {
			return true;
		}
		Iterator <T> oppram = m2.oppramser();
		while(oppram.hasNext()) {
			if (!inneholder(oppram.next())) {
				return false;
			}
		}

		return true;
	}


	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}
	

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		return false;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}
	public String toString() {
		String ut = "";
		Iterator<T> oppramser = this.oppramser();
		while (oppramser.hasNext()) {
			ut += oppramser.next() + "\n";
		}
		return ut;
	}


}// c