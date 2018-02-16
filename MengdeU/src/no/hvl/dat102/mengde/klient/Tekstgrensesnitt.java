package no.hvl.dat102.mengde.klient;

import java.util.Scanner;

public class Tekstgrensesnitt {

	private Datakontakt data;

	public Tekstgrensesnitt() {

		this.data = new Datakontakt();
	}

	public void run() {

		Medlem m1 = new Medlem("Eirik");
		Medlem m2 = new Medlem("Ørjan");
		Medlem m3 = new Medlem("Joakim");
		Medlem m4 = new Medlem("Catherine Zeta Jones");

		m1.leggTilHobby("være best");
		m1.leggTilHobby("forbli best");

		m2.leggTilHobby("gitting gud");
		m3.leggTilHobby("gitting gud");

		m4.leggTilHobby("være best");
		m4.leggTilHobby("forbli best");

		data.LeggTilMedlem(m1);
		data.LeggTilMedlem(m2);
		data.LeggTilMedlem(m3);
		data.LeggTilMedlem(m4);

		Scanner scan = new Scanner(System.in);
		boolean avslutt = false;
		while (!avslutt) {
			System.out.println("Meny");
			System.out.println("1 - Legg til medlem");
			System.out.println("2 - Skriv hobby liste for medlem");
			System.out.println("3 - Skriv ut liste over par");
			System.out.println("4 - Finn partner til medlem");
			System.out.println("5 - Fjern partnerskap til medlem");
			System.out.println("6 - Har medlem partner :");
			System.out.println("7 - Skriv ut liste :");

			System.out.println("0 - avslutt program");

			int svar = Integer.parseInt(scan.nextLine());
			String delstreg;

			switch (svar) {
				case 1: //LEGG TIL MEDLEM
					System.out.print("Gi Navn: ");
					delstreg = scan.nextLine();
					Medlem medlem1 = new Medlem(delstreg);
					System.out.println("Gi hobby :");
					delstreg = scan.nextLine();
					if (!delstreg.equals("")) {
						medlem1.leggTilHobby(delstreg);
					}
					data.LeggTilMedlem(medlem1);
					break;
				case 2:
					System.out.print("Gi navn til medlem: ");
					delstreg = scan.nextLine();
					if (!data.getMedlem(delstreg).getHobbyer().toString().equals("")) {
						System.out.print(data.getMedlem(delstreg).getHobbyer());
					}else {
						System.out.println("Har ingen hobbyer");
					}

					break;
				case 3:
					data.skrivUtPar();
					break;
				case 4:
					System.out.println("Gi medlems navn: ");
					delstreg = scan.nextLine();
					System.out.println(data.getMedlemByIndex(data.finnPartnerFor(delstreg)));
					break;
				case 5://fjern partnerskap
					System.out.println("Gi medlems navn: ");
					delstreg = scan.nextLine();
					data.tilbakestillStatusIndeks(delstreg);
					break;
				case 6:
					System.out.println("Gi medlems navn: ");
					delstreg = scan.nextLine();
					String utskrift = "nei";
					if (data.getMedlem(delstreg).getStatusIndeks() != -1) {
						utskrift = "ja";
					}
					System.out.println(utskrift);
					break;
				case 7:
					System.out.println(data.toString());
					break;

				case 0:
					avslutt = true;
			}
		}
	}

}
