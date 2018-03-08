package no.hib.dat102.kø;

import no.hib.dat102.adt.KjedetKøADT;
import no.hib.dat102.exceptions.TomKøException;

public class KjedetKø<T> implements KjedetKøADT<T> {

	private LinearNode<T> start;
	private int antall;

	public KjedetKø() {
		this.start = null;
		this.antall = 0;
	}

	public void push(T element) {

		LinearNode<T> nyStart = new LinearNode<T>(element);

		nyStart.setNeste(start);
		this.start = nyStart;

		antall++;

	}

	@Override
	public T pop() throws TomKøException {

		if (erTom()) {
			throw new TomKøException("Stabel");
		}

		LinearNode<T> gStart = this.start;
		T foo = gStart.getElement();

		this.start = gStart.getNeste();
		antall--;
		return foo;
	}

	@Override
	public T peek() {
		if (erTom()) {
			throw new TomKøException("Stabel");
		}

		return this.start.getElement();
	}

	@Override
	public int antall() {
		return this.antall;
	}

	public boolean slett(T element) throws TomKøException {

		LinearNode<T> forrige = this.start;
		LinearNode<T> denne = forrige.getNeste();

		if (element.equals(forrige.getElement())) {
			pop();
		}
		for (int i = 0; i < antall - 1; i++) {

			if (element.equals(denne.getElement())) {
				forrige.setNeste(denne.getNeste());
				antall--;
				return true;
			}

			forrige = denne;
			denne = denne.getNeste();
		}
		return false;

	}

	@Override
	public String toString() {
		String s = "";
		if (antall == 0) {
			return null;
		}

		LinearNode<T> denne = start;
		s += denne.toString() + "\n";

		for (int i = 0; i < antall - 1; i++) {
			denne = denne.getNeste();
			s += denne.toString() + "\n";
		}
		return s;
	}

	public LinearNode<T> getStart() {
		return this.start;
	}

	@Override
	public boolean erTom() {
		if (this.start == null) {
			return true;
		}
		return false;
	}
}
