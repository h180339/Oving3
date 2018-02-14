package no.hvl.dat102.mengde.klient;

public class Hobby {

	private String hobbyNavn;

	public Hobby (String hobby) {
		this.hobbyNavn = hobby;

	}
	public String toString() {
		return "<" + this.hobbyNavn + "> ";
	}
	public String getHobbyNavn () {
		return this.hobbyNavn;
	}
	public boolean equals(Object hobby2) {
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));

	}
}
