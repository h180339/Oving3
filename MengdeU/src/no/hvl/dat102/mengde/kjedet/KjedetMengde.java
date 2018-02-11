package no.hvl.dat102.mengde.kjedet;

import no.hvl.dat102.mengde.adt.*;

//********************************************************************
//Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start,slutt;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (erTom()) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			slutt = node;
			antall++;

		}
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
				if (resultat == slutt.getElement()) {
					forgjenger.setNeste(null);
				}else {
					forgjenger.setNeste(denne.getNeste());
				}

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

		Iterator<T> teller = m2.oppramser();
		Iterator<T> teller2 = this.oppramser();

		HashMap kart = new HashMap();

		while (teller2.hasNext()) {
			kart.put(teller2.next(), true);
		}
		while (teller.hasNext()) {
			kart.put(teller.next(), true);
		}
		for (Object nokkel: kart.keySet()) {
			begge.leggTil((T)nokkel);
		}

		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {

		MengdeADT<T> snittM = new KjedetMengde();
		Iterator<T> teller = m2.oppramser();
		LinearNode<T> aktuell = start;

		while(teller.hasNext()) {
			T element = teller.next();
			if (aktuell.getElement() == element) {
				snittM.leggTil(element);
			}
		}

		return snittM;
	}

	

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<T>();
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

		LinearNode<T> denne;
		while (oppramser.hasNext()) {
			if (!inneholder(oppramser.next())) {
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
