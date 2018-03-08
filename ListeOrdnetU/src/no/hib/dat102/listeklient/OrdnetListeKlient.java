package no.hib.dat102.listeklient;

import no.hib.dat102.tabell.TabellOrdnetListe;

import java.util.Scanner;

public class OrdnetListeKlient {

	int antall = 0;
	int i = 0;

	Scanner scanner = new Scanner(System.in);

	do {
		System.out.println("Hvor mange personer vil du ha inn?");
		antall = Integer.parseInt(scanner.nextLine());
		TabellOrdnetListe liste = new TabellOrdnetListe(antall);
	} while (i <= antall) {

	}

}
