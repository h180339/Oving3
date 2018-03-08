package no.hib.dat102.listeklient;

import no.hib.dat102.tabell.TabellOrdnetListe;

import java.util.Scanner;

public class OrdnetTabellKlient {

	public static void main(String[] args) {

		int antall = 0;
		int i = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hvor mange personer vil du ha inn?");
		antall = Integer.parseInt(scanner.nextLine());
		TabellOrdnetListe liste = new TabellOrdnetListe(antall);

		while(i < antall) {
			System.out.println("Skriv inn Fornavn");
			String fornavn = scanner.nextLine();
			System.out.println("Skriv inn Etternavn:");
			String etternavn = scanner.nextLine();
			System.out.println("Skriv inn fødselsår:");
			int fødselsår = Integer.parseInt(scanner.nextLine());

			Person p = new Person(fornavn,etternavn,fødselsår);
			liste.leggTil(p);

			i++;
		}
		while(!liste.erTom()) {
			System.out.println(liste.fjernFoerste());
		}
	}

}
