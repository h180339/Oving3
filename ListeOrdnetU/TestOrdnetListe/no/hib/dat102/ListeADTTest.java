package no.hib.dat102;
import static org.junit.Assert.*;

import no.hib.dat102.tabell.TabellOrdnetListe;
import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.kjedet.KjedetOrdnetListe;

public class ListeADTTest {

	/**
	 * Test av KjedetOrdnetListeADT med heltall.
	 *
	 * @author Ole Olsen
	 */
	private KjedetOrdnetListe<Integer> liste;
	private TabellOrdnetListe<Integer> tab;

	// Test data
	private Integer e0 = 57;
	private Integer e1 = 69;
	private Integer e2 = 100;
	private Integer e3 = 111;
	private Integer e4 = 156;
	private Integer e5 = 198;

	/**
	 * Opprett en tom liste for hver test.
	 *
	 * @throws Exception exception
	 */
	@Before
	public final void setup() throws Exception {
		liste = new KjedetOrdnetListe<Integer>();
		tab = new TabellOrdnetListe<Integer>();
	}



	/**
	 * Tester om en ny liste er tom.
	 */

	@Test
	public final void nyListeErTom() {
		assertTrue(liste.erTom());
		assertTrue(tab.erTom());
	}

	/**
	 * Tester leggTil og fjern.
	 */

	@Test
	public final void leggTilOgFjern() {
		liste.leggTil(e3);
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e4);
		liste.leggTil(e5);
		liste.leggTil(e0);
		assertEquals(e5, liste.fjern(e5));
		assertEquals(e4, liste.fjern(e4));
		assertEquals(e3, liste.fjern(e3));
		assertEquals(e2, liste.fjern(e2));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e0, liste.fjern(e0));

		tab.leggTil(e3);
		tab.leggTil(e1);
		tab.leggTil(e2);
		tab.leggTil(e5);
		tab.leggTil(e0);
		tab.leggTil(e4);

		assertEquals(e3, tab.fjern(e3));
		assertEquals(e2, tab.fjern(e2));
		assertEquals(e4, tab.fjern(e4));
		assertEquals(e1, tab.fjern(e1));
		assertEquals(e0, tab.fjern(e0));
	}

	/**
	 * Tester ordning ikke-avtagende
	 *
	 */

	@Test
	public final void viseOrdnetIkkeAvtagende() {
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e5);
		liste.leggTil(e0);
		liste.leggTil(e4);
		liste.leggTil(e3);
		assertEquals(e0, liste.fjernFoerste());
		assertEquals(e1, liste.fjernFoerste());
		assertEquals(e2, liste.fjernFoerste());
		assertEquals(e3, liste.fjernFoerste());
		assertEquals(e4, liste.fjernFoerste());
		assertEquals(e5, liste.fjernFoerste());


		tab.leggTil(e1);
		tab.leggTil(e2);
		tab.leggTil(e5);
		tab.leggTil(e0);
		tab.leggTil(e4);
		tab.leggTil(e3);
		assertEquals(e0, tab.fjernFoerste());
		assertEquals(e1, tab.fjernFoerste());
		assertEquals(e2, tab.fjernFoerste());
		assertEquals(e3, tab.fjernFoerste());
		assertEquals(e4, tab.fjernFoerste());
		assertEquals(e5, tab.fjernFoerste());
	}


	@Test
	public final void viseOrdnetIkkeØkende() {

		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e5);
		liste.leggTil(e0);
		liste.leggTil(e4);
		liste.leggTil(e3);
		assertEquals(e5, liste.fjernSiste());
		assertEquals(e4, liste.fjernSiste());
		assertEquals(e3, liste.fjernSiste());
		assertEquals(e2, liste.fjernSiste());
		assertEquals(e1, liste.fjernSiste());
		assertEquals(e0, liste.fjernSiste());

		tab.leggTil(e1);
		tab.leggTil(e2);
		tab.leggTil(e5);
		tab.leggTil(e0);
		tab.leggTil(e4);
		tab.leggTil(e3);
		assertEquals(e5, tab.fjernSiste());
		assertEquals(e4, tab.fjernSiste());
		assertEquals(e3, tab.fjernSiste());
		assertEquals(e2, tab.fjernSiste());
		assertEquals(e1, tab.fjernSiste());
		assertEquals(e0, tab.fjernSiste());
	}


	/**
	 * Tester leggTil og fjern med like verdier.
	 */

	@Test
	public final void leggTilOgfjernMedDuplikater() {
		//... Fyll ut med � legge til passende elementer
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e0);
		liste.leggTil(e4);
		liste.leggTil(e3);

		assertEquals(e0, liste.fjern(e0));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e4, liste.fjern(e4));
		liste.leggTil(e1);
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e2, liste.fjern(e2));
		assertEquals(e3, liste.fjern(e3));

		tab.leggTil(e1);
		tab.leggTil(e2);
		tab.leggTil(e0);
		tab.leggTil(e4);
		tab.leggTil(e3);


		assertEquals(e0, tab.fjern(e0));
		assertEquals(e1, tab.fjern(e1));
		assertEquals(e4, tab.fjern(e4));
		tab.leggTil(e1);
		assertEquals(e1, tab.fjern(e1));
		assertEquals(e2, tab.fjern(e2));
		assertEquals(e3, tab.fjern(e3));

	}

	/**
	 * Tester leggTil og inneholder
	 */

	@Test
	public final void leggTilOgInnholder() {
		liste.leggTil(e2);
		liste.leggTil(e1);
		liste.leggTil(e4);
		liste.leggTil(e0);
		liste.leggTil(e3);

		assertTrue(liste.inneholder(e0));
		assertTrue(liste.inneholder(e1));
		assertTrue(liste.inneholder(e2));
		assertTrue(liste.inneholder(e3));
		assertTrue(liste.inneholder(e4));
		assertFalse(liste.inneholder(e5));

		tab.leggTil(e2);
		tab.leggTil(e1);
		tab.leggTil(e4);
		tab.leggTil(e0);
		tab.leggTil(e3);

		assertTrue(tab.inneholder(e0));
		assertTrue(tab.inneholder(e1));
		assertTrue(tab.inneholder(e2));
		assertTrue(tab.inneholder(e3));
		assertTrue(tab.inneholder(e4));
		assertFalse(tab.inneholder(e5));

	}

	/**
	 * Tester om listen med verdier ikke er tom.
	 */

	@Test
	public final void erIkkeTom() {
		liste.leggTil(e1);
		liste.leggTil(e3);
		liste.leggTil(e2);
		liste.leggTil(e4);
		liste.leggTil(e5);
		assertFalse(liste.erTom());

		tab.leggTil(e1);
		tab.leggTil(e3);
		tab.leggTil(e2);
		tab.leggTil(e4);
		tab.leggTil(e5);
		assertFalse(tab.erTom());
	}


	/**
	 * Tester om leggTil-fjern p� en tom liste gir en tom liste.
	 */

	@Test
	public final void leggTilFjernErTom() {
		//...Fyll ut. Legg inn elementer og fjern de
		liste.leggTil(e3);
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e4);
		liste.leggTil(e5);
		liste.leggTil(e0);
		assertEquals(e5, liste.fjern(e5));
		assertEquals(e4, liste.fjern(e4));
		assertEquals(e3, liste.fjern(e3));
		assertEquals(e2, liste.fjern(e2));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e0, liste.fjern(e0));
		assertTrue(liste.erTom());

		tab.leggTil(e3);
		tab.leggTil(e1);
		tab.leggTil(e2);
		tab.leggTil(e4);
		tab.leggTil(e5);
		tab.leggTil(e0);
		assertEquals(e5, tab.fjern(e5));
		assertEquals(e4, tab.fjern(e4));
		assertEquals(e3, tab.fjern(e3));
		assertEquals(e2, tab.fjern(e2));
		assertEquals(e1, tab.fjern(e1));
		assertEquals(e0, tab.fjern(e0));
		assertTrue(tab.erTom());


	}

	/**
	 * Pr�ver � ta ut et element fra en tom liste.
	 */

	@Test
	public final void fjernFraTomListe() {
		assertNull("Fjerne fra tom liste", liste.fjern(e4));
		assertNull("Fjerne fra tom liste", tab.fjern(e4));
	}


}

