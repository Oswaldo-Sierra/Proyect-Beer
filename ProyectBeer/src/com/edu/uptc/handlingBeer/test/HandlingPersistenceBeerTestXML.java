package com.edu.uptc.handlingBeer.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.model.Beer;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceBeer;

class HandlingPersistenceBeerTestXML {
	
	private HandlingPersistenceBeer hPB = new HandlingPersistenceBeer();
	
	@Test
	void test() {
		this.scenerieOne();

		this.hPB.dumpFile(ETypeFile.XML);

	}

	
	@Test
	void test2() {
		this.scenerietwo();
		assertEquals(4,
				this.hPB.getListBeer().size());

	}
	
	public void scenerieOne() {
		/** Simulacion de que la persona ingrese datos */
		Beer beer = new Beer("SN-20250813-0001", "Corona", "Large", "4.5%", "Rubia", "Mexico");
		Beer beer2 = new Beer("SN-20250813-0002", "Corona", "Large", "4.8%", "Rubia", "Mexico");
		Beer beer3 = new Beer("SN-20250813-0003", "Corona", "Large", "4.5%", "Rubia", "Mexico");
		Beer beer4 = new Beer("SN-20250813-0004", "Andina", "Cerverza de trigo", "3.0%", "Rubia", "Colombia");

		/** Se guarda en la lista */
		this.hPB.addBeers(beer);
		this.hPB.addBeers(beer2);
		this.hPB.addBeers(beer3);
		this.hPB.addBeers(beer4);
	}
	

	public void scenerietwo() {
		/** Simulacion de que la persona cerro la app */
		this.hPB.setListBeer(new ArrayList<>());

		assertTrue(this.hPB.getListBeer().isEmpty());

		/** Simulacion de que la persona volvio ejecutar el programa. */
		this.hPB.loadFile(ETypeFile.XML);
		assertEquals("SN-20250813-0001", 
				this.hPB.getListBeer().get(0).getSerialNumber());
		assertNotNull(this.hPB.getListBeer().get(3));
		assertEquals("Corona",this.hPB.getListBeer().get(1).getBrand());
	}


}
