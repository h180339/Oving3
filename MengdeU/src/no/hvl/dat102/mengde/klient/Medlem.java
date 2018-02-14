package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Medlem {

	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;

	public Medlem (String navn) {
		this.navn = navn;
		hobbyer = new TabellMengde<>();
	}

	public void setStatusIndeks(int index) {
		this.statusIndeks = index;
	}
	public String getNavn() {
		return this.navn;
	}
	public void leggTilHobby(String hobby) {
		Hobby h1 = new Hobby(hobby);
		hobbyer.leggTil(h1);
	}

	public MengdeADT<Hobby> getHobbyer() {
		return this.hobbyer;
	}

	public boolean passerTil(Medlem medlem2) {
		return this.getHobbyer().equals(medlem2.getHobbyer());
	}

	public String toString() {
		return this.navn + " Hobby: " + hobbyer.toString();
	}

}
