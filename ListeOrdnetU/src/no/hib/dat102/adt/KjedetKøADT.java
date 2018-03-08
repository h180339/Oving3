package no.hib.dat102.adt;

import no.hib.dat102.exceptions.TomKøException;

public interface KjedetKøADT<T> {

	void push(T element);

	T pop() throws TomKøException;

	T peek() throws TomKøException;

	boolean erTom();

	int antall();


}
