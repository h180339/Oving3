package no.hvl.dat102.mengde.klient;

public class MedlemKlient {

	public static void main(String [] args) {

		Medlem m1 = new Medlem("Eirik");
		Medlem m2 = new Medlem("Ørjan");
		Medlem m3 = new Medlem("Joakim");
		Medlem m4 = new Medlem("Catherine Zeta Jones");

		m1.leggTilHobby("være best");
		m1.leggTilHobby("forbli best");

		m2.leggTilHobby("gitting gud");
		m3.leggTilHobby("spise sjoko");

		m4.leggTilHobby("være best");
		m4.leggTilHobby("forbli best");

		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		System.out.println(m4);

		Datakontakt d1 = new Datakontakt();

		d1.LeggTilMedlem(m1);
		d1.LeggTilMedlem(m2);
		d1.LeggTilMedlem(m3);
		d1.LeggTilMedlem(m4);




	}
}
