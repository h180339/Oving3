package no.hib.dat102.listeklient;


	public class Person implements Comparable<Person>{
		private String for_navn;
		private String etter_navn;
		private int foedsels_aar;
		
		Person(String fornavn, String etternavn, int foedselsaar){
			this.for_navn = fornavn;
			this.etter_navn = etternavn;
			this.foedsels_aar = foedselsaar;
		}
		
	public String getFor_navn() {
			return for_navn;
		}

		public void setFor_navn(String for_navn) {
			this.for_navn = for_navn;
		}

		public String getEtter_navn() {
			return etter_navn;
		}

		public void setEtter_navn(String etter_navn) {
			this.etter_navn = etter_navn;
		}

		public int getFoedsels_aar() {
			return foedsels_aar;
		}

		public void setFoedsels_aar(int foedsels_aar) {
			this.foedsels_aar = foedsels_aar;
		}
		
		public String toString() {
			return "Fornavn: " + getFor_navn() + "\n" + "Etternacn: " + getEtter_navn() + "\n"
					+ "fødselsår: " + getFoedsels_aar() + "\n";
		}

	@Override
	public int compareTo(Person denAndre) {
		final int før = -1;
		final int lik = 0;
		final int etter = 1;
		int resultat = 0;
		if (foedsels_aar < denAndre.getFoedsels_aar()) {
			return resultat = før;
		} else if (this.foedsels_aar == denAndre.getFoedsels_aar()) {
			int sammenligning = this.etter_navn.compareTo(denAndre.etter_navn);
			if (sammenligning == lik) {
				sammenligning = this.for_navn.compareTo(denAndre.for_navn);
			}
			resultat = sammenligning;
		} else {
			resultat = etter;
		}
		return resultat;
	}
}

