package no.hvl.dat102.mengde.klient;

import java.util.Scanner;

public class Tekstgrensesnitt {

	private Datakontakt data;

	public Tekstgrensesnitt(Datakontakt data) {
		this.data = data;
	}

	public void run() {

		Scanner scan = new Scanner(System.in);
		boolean avslutt = false;
		while (!avslutt) {
			System.out.println("Meny");
			System.out.println("1 - Legg til medlem");
			System.out.println("2 - Skriv hobby liste for medlem");
			System.out.println("3 - Skriv par liste");
			System.out.println("4 - Finn partner til medlem");
			System.out.println("5 - Fjern partnerskap til medlem");

			System.out.println("0 - avslutt program");

			int svar = Integer.parseInt(scan.nextLine());
			String delstreg;

			switch (svar) {
				case 1:
					System.out.print("Gi Navn: ");
					delstreg = scan.nextLine();
					Medlem m1 = new Medlem(delstreg);
					data.LeggTilMedlem(m1);
					break;
				case 2:
					System.out.print("Gi navn til medlem: ");
					delstreg = scan.nextLine();
					System.out.println(data.finnMedlemsIndeks(delstreg));;
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;

				case 0:
					avslutt = true;

			}




		}
	}

}
