package com.edu.uptc.handlingBeer.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.model.Beer;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceBeer;

class HandlingPersitenceBeerTestTXT {

	private HandlingPersistenceBeer hPB = new HandlingPersistenceBeer();
	
	@Test
	void test() {
		this.scenerieOne();

		this.hPB.dumpFile(ETypeFile.FILE_PLAIN);

	}

	
	@Test
	void test2() {
		this.scenerietwo();
		assertEquals(3,
				this.hPB.getListBeer().size());

	}
	
	public void scenerieOne() {
		/** Simulacion de que la persona ingrese datos */
		Beer beer1 = new Beer(001, "Poker", "Large", "4,8", "Bajo", "Bavaria", 2000, 20);
		Beer beer2 = new Beer(001, "Poker", "Large", "4,8", "Bajo", "Bavaria", 2000, 20);
		Beer beer3 = new Beer(002, "Aguila", "Large", "4,8", "Bajo", "Bavaria", 2000, 20);
		Beer beer4 = new Beer(003, "Guinnes", "Large", "4,8", "Bajo", "Bavaria", 2000, 20);
		/** Se guarda en la lista */
		this.hPB.addBeers(beer1);
		this.hPB.addBeers(beer2);
		this.hPB.addBeers(beer3);
		this.hPB.addBeers(beer4);
	}
	

	public void scenerietwo() {
		/** Simulacion de que la persona cerro la app */
		this.hPB.setListBeer(new ArrayList<>());

		assertTrue(this.hPB.getListBeer().isEmpty());

		/** Simulacion de que la persona volvio ejecutar el programa. */
		this.hPB.loadFile(ETypeFile.FILE_PLAIN);
	}
	
	

	/*@Test
	void test3() {
		scenerieThreee();
	}

	@Test
	void test4() {
		scenerieFour();
	}

	@Test
	void test5() {
		scenerieFive();
		this.hPB.loadFile(ETypeFile.FILE_PLAIN);

	}*/


	
//	public void scenerieThreee() {
//		/**
//		 * Simulacion de que se encuentre la cerveza y que se busque una que no este
//		 * registrada.
//		 */
//		Beer beer = new Beer("SN-20250813-0001", "Corona", "Large", "4.5%", "Alto", "Mexico");
//		
//
//		this.hPB.addBeers(beer);
//
//		assertNotNull(this.hPB.findBeerBySerialNumber("SN-20250814-0001"));
//		assertNull(this.hPB.findBeerBySerialNumber("SN-20250814-1000"));
//	}
//
//	public void scenerieFour() {
//		/** Simulacion de archivo plano vacio */
//		this.hPB.setListBeer(new ArrayList<Beer>());
//		this.hPB.dumpFile(ETypeFile.FILE_PLAIN);
//
//		/** Simulacion de que carga el archivo vacio */
//		this.hPB.loadFile(ETypeFile.FILE_PLAIN);
//		assertTrue(this.hPB.getListBeer().isEmpty());
//	}
//
//	public void scenerieFive() {
//		/**
//		 * Simulacion de agreagrar otro elemento al archivo plano con otros ya
//		 * existentes y que se guarden.
//		 */
//		this.hPB.loadFile(ETypeFile.FILE_PLAIN);
//
//		Beer beer = new Beer("SN-20250813-0001", "Corona", "Large", "4.5%", "Alto", "Mexico");
//		this.hPB.addBeers(beer);
//
//		this.hPB.dumpFile(ETypeFile.FILE_PLAIN);
//		this.hPB.setListBeer(new ArrayList<Beer>());
//
//	}

}




