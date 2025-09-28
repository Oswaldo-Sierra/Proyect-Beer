package com.edu.uptc.handlingBeer.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.model.Beer;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceBeer;

class HandlingPersistenceBeerTestSerializate {
	private HandlingPersistenceBeer hPB = new HandlingPersistenceBeer();
	
	@Test
	void test() {
		this.scenerieOne();

		this.hPB.dumpFile(ETypeFile.SER);

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
		this.hPB.loadFile(ETypeFile.SER);
		assertEquals(001, 
				this.hPB.getListBeer().get(0).getSerialNumber());
		assertNotNull(this.hPB.getListBeer().get(2));
		assertEquals("Corona",this.hPB.getListBeer().get(1).getBrand());
	}
}
