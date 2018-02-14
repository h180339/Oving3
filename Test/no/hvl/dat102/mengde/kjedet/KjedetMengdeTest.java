package no.hvl.dat102.mengde.kjedet;

import static org.junit.Assert.*;



import no.hvl.dat102.mengde.adt.MengdeADT;

import no.hvl.dat102.mengde.tabell.TabellMengde;
import org.junit.Before;
import org.junit.Test;

public class KjedetMengdeTest {

	private Integer e0 = 0;
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;

	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;

	private MengdeADT<Integer> m4;
	private MengdeADT<Integer> m5;

	@Before
	public void setup() {
		m1 = new KjedetMengde();
		m2 = new KjedetMengde();

		m4 = new TabellMengde();
		m5 = new TabellMengde();


	}

	@org.junit.Test
	public void equals() {
		/*

		assertEquals(true, m1.equals(m2));
		assertEquals(true, m4.equals(m5));

		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);

		m2.leggTil(e1);
		m2.leggTil(e2);
		m2.leggTil(e0);

		m4.leggTil(e0);
		m4.leggTil(e1);
		m4.leggTil(e2);

		m5.leggTil(e1);
		m5.leggTil(e2);
		m5.leggTil(e0);

		assertEquals(true , m1.equals(m2));

		assertEquals(true , m4.equals(m5));

		m2.leggTil(e4);

		m5.leggTil(e4);

		assertEquals(false , m1.equals(m2));

		assertEquals(false , m4.equals(m5));

		 */
	}

	@org.junit.Test
	public void fjern() {

		/*
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);

		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);

		m1.fjern(e0);
		m2.fjern(e4);
		Integer tall = 2;

		assertEquals(tall, m1.fjern(e2));

*/

	}

	@org.junit.Test
	public void union() {
/*
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);

		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);

		MengdeADT<Integer> m3 = new KjedetMengde<>();

		m3.leggTil(e0);
		m3.leggTil(e1);
		m3.leggTil(e2);
		m3.leggTil(e3);
		m3.leggTil(e4);
		m3.leggTil(e5);


		assertEquals(true, m1.union(m2).equals(m3));
*/
		m4.leggTil(e0);
		m4.leggTil(e1);
		m4.leggTil(e2);

		m5.leggTil(e3);
		m5.leggTil(e4);
		m5.leggTil(e5);

		MengdeADT<Integer> m6 = new TabellMengde();

		m6.leggTil(e0);
		m6.leggTil(e1);
		m6.leggTil(e2);
		m6.leggTil(e3);
		m6.leggTil(e4);
		m6.leggTil(e5);

		assertEquals(true, m4.union(m5).equals(m6));

	}

	@Test
	public void snitt() {
/*
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);

		m2.leggTil(e3);
		m2.leggTil(e2);
		m2.leggTil(e5);

		MengdeADT<Integer> m3 = new KjedetMengde<>();
		m3.leggTil(e2);

		assertEquals(true, m1.snitt(m2).equals(m3));
*/
	}

	@Test
	public void differens() {
		/*

		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);

		m2.leggTil(e2);

		MengdeADT<Integer> m3 = new KjedetMengde<>();
		m3.leggTil(e0);
		m3.leggTil(e1);

		*/

	}

}