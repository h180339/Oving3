package no.hib.dat102.exceptions;


public class TomKøException extends RuntimeException {
	public TomKøException (String samling) {
		super ("" + samling + " er tom.");
	}
}
