package no.hvl.dat102.mengde.klient;

public class MedlemKlient {

	public static void main(String [] args) {

		Medlem m1 = new Medlem("Eirik");
		Medlem m2 = new Medlem("Ørjan");
		Medlem m3 = new Medlem("Joakim");

		m1.leggTilHobby("være best");
		m1.leggTilHobby("forbli best");
		m2.leggTilHobby("gitting gud");
		m3.leggTilHobby("spise sjoko");

		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}
}
