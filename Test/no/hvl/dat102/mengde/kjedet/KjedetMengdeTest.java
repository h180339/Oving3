package no.hvl.dat102.mengde.kjedet;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import no.hvl.dat102.mengde.adt.MengdeADT;
import org.junit.Before;



public class KjedetMengdeTest {

	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;

	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;

	@Before
	public void setup() {
		m1 = new KjedetMengde<>();
		m2 = new KjedetMengde<>();



	}


	@org.junit.Test
	public void fjern() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);

		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);

		m1.fjern(e0);
		m2.fjern(e4);
		m1.fjern(e2);


	}

	@org.junit.Test
	public void equals() {

		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);

		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);

		assertEquals(m1.equals(m2), true);

		m2.leggTil(e4);

		assertEquals(m1.equals(m2), false);

	}
}