package no.hib.dat102.listeklient;


	public class Person implements Comparable<Person>{
		private String fornavn;
		private String etternavn;
		private int foedselsaar;
		
		Person(String fornavn, String etternavn, int foedselsaar){
			this.fornavn = fornavn;
			this.etternavn = etternavn;
			this.foedselsaar = foedselsaar;
		}
		
	public String getFornavn() {
			return fornavn;
		}

		public void setFornavn(String for_navn) {
			this.fornavn = for_navn;
		}

		public String getEtternavn() {
			return etternavn;
		}

		public void setEtternavn(String etter_navn) {
			this.etternavn = etter_navn;
		}

		public int getFoedselsaar() {
			return foedselsaar;
		}

		public void setFoedselsaar(int foedsels_aar) {
			this.foedselsaar = foedsels_aar;
		}
		
		public String toString() {
			return "Fornavn: " + fornavn + "\n" + "Etternavn: " + etternavn + "\n"
					+ "fødselsår: " + foedselsaar;
		}

	@Override
	public int compareTo(Person denAndre) {
		final int før = -1;
		final int lik = 0;
		final int etter = 1;
		int resultat = 0;
		if (denAndre != null && foedselsaar < denAndre.getFoedselsaar()) {
			resultat = før;
		} else if (this.foedselsaar == denAndre.getFoedselsaar()) {
			int sammenligning = this.etternavn.compareTo(denAndre.etternavn);
			if (sammenligning == lik) {
				sammenligning = this.fornavn.compareTo(denAndre.fornavn);
			}
			resultat = sammenligning;
		} else {
			resultat = etter;
		}
		return resultat;
	}
}

