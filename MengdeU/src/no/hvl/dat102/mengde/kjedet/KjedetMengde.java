package no.hvl.dat102.mengde.kjedet;

import no.hvl.dat102.mengde.adt.*;

//********************************************************************
//Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (!erTom()) {
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = start.getElement();
				start = start.getNeste();
			} else {
				forgjenger = start;
				for (int nr = 2; nr < valg; nr++) {
					forgjenger = forgjenger.getNeste();
				}
				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
			}
			antall--;
		} // if
		return resultat;
	}//

	@Override
	public T fjern(T element) {

		T resultat = null;
		LinearNode<T> forgjenger = this.start;
		LinearNode<T> denne = forgjenger.getNeste();

		if (forgjenger.getElement().equals(element)) { //sjekker første element
			resultat = forgjenger.getElement();
			this.start = forgjenger.getNeste();
			antall --;
			return resultat;
		}
		forgjenger = denne;
		denne = denne.getNeste();

		for (int i = 0; i < antall - 1; i++) {
			if (forgjenger.getElement().equals(element)) {
				resultat = forgjenger.getElement();
				forgjenger.setNeste(denne.getNeste());
				antall--;
				return resultat;
			}
			forgjenger = denne;
			denne = denne.getNeste();
		}



		return resultat;
	}//

	

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		T element = null;

		/*
		 * Fyll ut
		 */
		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new KjedetMengde<T>();
		T element;
		/* Fyll ut...
		 * 
			if (this.inneholder(element))		 
				((KjedetMengde<T>) snittM).settInn(element);
		*/
		return snittM;
	}

	

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<T>();
		T element;
		/*Fyll ut
		 * 
		 */
		
		return differensM;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {

		if (antall() != m2.antall()) { //sjekker først om det er like mange elementer i mengdene
			return false;
		}
		Iterator<T> oppramser = m2.oppramser();

		if (!this.start.equals(oppramser.next())) { //sjekker første elementet
			return false;
		}
		while (oppramser.hasNext()) {
			if (!this.start.getNeste().equals(oppramser.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {

		return antall;
	}

	@Override
	public Iterator<T> oppramser() {

		return new KjedetIterator<T>(start);
	}
	
	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		return erUnderMengde;
	}
	
	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

}// class
