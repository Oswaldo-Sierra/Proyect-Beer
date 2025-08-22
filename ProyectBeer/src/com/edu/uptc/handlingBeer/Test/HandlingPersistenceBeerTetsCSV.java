package com.edu.uptc.handlingBeer.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.edu.uptc.handlingBeer.Enums.ETypeFile;
import com.edu.uptc.handlingBeer.Persistence.HandlingPersistenceBeer;
import com.edu.uptc.handlingBeer.model.Beer;

class HandlingPersistenceBeerTetsCSV {
	
	private HandlingPersistenceBeer hPB = new HandlingPersistenceBeer();


	@Test
	void test() {
		scenerieOne();
		this.hPB.loadFile(ETypeFile.CSV);
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

}
