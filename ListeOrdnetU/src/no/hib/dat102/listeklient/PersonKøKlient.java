package no.hib.dat102.listeklient;

import java.util.Scanner;

import no.hib.dat102.kø.KjedetKø;
import no.hib.dat102.kø.SirkulærKø;
import no.hib.dat102.tabell.TabellOrdnetListe;

public class PersonKøKlient {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int antall = 0;
		int i = 0;
		Scanner input1 = new Scanner(System.in);
		System.out.println("Hvor mange personer vil du ha inn?");
		antall = Integer.parseInt(input1.nextLine());
		SirkulærKø Skø = new SirkulærKø(antall);
		KjedetKø Kø = new KjedetKø();

		while (i < antall) {
			System.out.println("Skriv inn Fornavn");
			String fornavn = input1.nextLine();
			System.out.println("Skriv inn Etternavn:");
			String etternavn = input1.nextLine();
			System.out.println("Skriv inn fødselsår:");
			int fødselsår = Integer.parseInt(input1.nextLine());
			

			Person p = new Person(fornavn, etternavn, fødselsår);
			Skø.enqueue(p);
			Kø.push(p);

			i++;
		}
		System.out.println("----SirkulærKø----");
		while (!Skø.isEmpty()) {
			System.out.println(Skø.dequeue());
		}
		System.out.println();
		System.out.println("----kjedetKø----");
		while (!Kø.erTom()) {
			System.out.println(Kø.pop());

		}

	}

}
