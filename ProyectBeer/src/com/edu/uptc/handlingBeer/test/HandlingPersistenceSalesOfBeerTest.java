package com.edu.uptc.handlingBeer.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.model.SalesOfBeer;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceSalesOfBeer;

class HandlingPersistenceSalesOfBeerTest {
	private HandlingPersistenceSalesOfBeer persistenceSalesOfBeer = new HandlingPersistenceSalesOfBeer();

	@Test
	void test() {
		this.scenerieOne();
		this.scenerieOne_2();
	}

	@Test
	void test2() {
		this.scenerieTwo();
		this.scenerieTwo_2();

	}

	@Test
	void test3() {
		this.scenerieTheere();
		this.scenerieTheere_2();
	}

	@Test
	void test4() {
		sceneriesFour();
		scenerieFour_2();
	}

	@Test
	void test5() {
		scenerieFive();
		scenerieFive_2();

	}

	private void info() {
		/** Simulacion de que la persona ingrese datos */
		SalesOfBeer salesOfBeer1 = new SalesOfBeer(001, 002, 20, 100000.0, "01/10/2025", "Juan", "Jairo");
		SalesOfBeer salesOfBeer2 = new SalesOfBeer(001, 002, 20, 100000.0, "09/09/2025", "Juan", "Jairo");
		SalesOfBeer salesOfBeer3 = new SalesOfBeer(002, 002, 20, 100000.0, "09/09/2025", "Juan", "Jairo");
		SalesOfBeer salesOfBeer4 = new SalesOfBeer(003, 002, 20, 100000.0, "09/09/2025", "Juan", "Jairo");
		/** Se guarda en la lista */
		this.persistenceSalesOfBeer.addSalesOfBeer(salesOfBeer1);
		this.persistenceSalesOfBeer.addSalesOfBeer(salesOfBeer2);
		this.persistenceSalesOfBeer.addSalesOfBeer(salesOfBeer3);
		this.persistenceSalesOfBeer.addSalesOfBeer(salesOfBeer4);
	}

	public void scenerieOne() {
		this.info();
		assertEquals(3, this.persistenceSalesOfBeer.getListSalesOfBeer().size());

		this.persistenceSalesOfBeer.dumpFile(ETypeFile.FILE_PLAIN);
	}

	public void scenerieOne_2() {
		/** Simulacion de que la persona cerro la app */
		this.persistenceSalesOfBeer.setListSalesOfBeer(new ArrayList<>());

		assertTrue(this.persistenceSalesOfBeer.getListSalesOfBeer().isEmpty());

		/** Simulacion de que la persona volvio ejecutar el programa. */
		this.persistenceSalesOfBeer.loadFile(ETypeFile.FILE_PLAIN);
		assertEquals(001, this.persistenceSalesOfBeer.getListSalesOfBeer().get(0).getSalesID());
	}

	
	public void scenerieTwo() {
		this.info();

		assertEquals(3, this.persistenceSalesOfBeer.getListSalesOfBeer().size());

		this.persistenceSalesOfBeer.dumpFile(ETypeFile.CSV);
	}

	public void scenerieTwo_2() {
		/** Simulacion de que la persona cerro la app */
		this.persistenceSalesOfBeer.setListSalesOfBeer(new ArrayList<>());

		assertTrue(this.persistenceSalesOfBeer.getListSalesOfBeer().isEmpty());

		/** Simulacion de que la persona volvio ejecutar el programa. */
		this.persistenceSalesOfBeer.loadFile(ETypeFile.CSV);
		assertEquals(001, this.persistenceSalesOfBeer.getListSalesOfBeer().get(0).getSalesID());
	}

	public void scenerieTheere() {
		this.info();

		assertEquals(3, this.persistenceSalesOfBeer.getListSalesOfBeer().size());

		this.persistenceSalesOfBeer.dumpFile(ETypeFile.JSON);

	}

	public void scenerieTheere_2() {
		/** Simulacion de que la persona cerro la app */
		this.persistenceSalesOfBeer.setListSalesOfBeer(new ArrayList<>());

		assertTrue(this.persistenceSalesOfBeer.getListSalesOfBeer().isEmpty());

		/** Simulacion de que la persona volvio ejecutar el programa. */
		this.persistenceSalesOfBeer.loadFile(ETypeFile.JSON);
		assertEquals(001, this.persistenceSalesOfBeer.getListSalesOfBeer().get(0).getSalesID());
	}

	public void sceneriesFour() {
		this.info();

		assertEquals(3, this.persistenceSalesOfBeer.getListSalesOfBeer().size());

		this.persistenceSalesOfBeer.dumpFile(ETypeFile.XML);

	}

	public void scenerieFour_2() {
		/** Simulacion de que la persona cerro la app */
		this.persistenceSalesOfBeer.setListSalesOfBeer(new ArrayList<>());

		assertTrue(this.persistenceSalesOfBeer.getListSalesOfBeer().isEmpty());

		/** Simulacion de que la persona volvio ejecutar el programa. */
		this.persistenceSalesOfBeer.loadFile(ETypeFile.XML);
		assertEquals(001, this.persistenceSalesOfBeer.getListSalesOfBeer().get(0).getSalesID());
	}

	public void scenerieFive() {
		this.info();

		assertEquals(3, this.persistenceSalesOfBeer.getListSalesOfBeer().size());

		this.persistenceSalesOfBeer.dumpFile(ETypeFile.SER);

	}

	public void scenerieFive_2() {
		/** Simulacion de que la persona cerro la app */
		this.persistenceSalesOfBeer.setListSalesOfBeer(new ArrayList<>());

		assertTrue(this.persistenceSalesOfBeer.getListSalesOfBeer().isEmpty());

		/** Simulacion de que la persona volvio ejecutar el programa. */
		this.persistenceSalesOfBeer.loadFile(ETypeFile.SER);
		assertEquals(001, this.persistenceSalesOfBeer.getListSalesOfBeer().get(0).getSalesID());
	}
}
