package com.edu.uptc.handlingBeer.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.model.User;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceUser;

class HandlingPersistenceUserTest {
private HandlingPersistenceUser hPU = new HandlingPersistenceUser();
	
	@Test
	void test() {
		this.scenerieOne();

		this.hPU.dumpFile(ETypeFile.SER);

	}

	
	@Test
	void test2() {
		this.scenerietwo();
		assertEquals(2,
				this.hPU.getListusers().size());

	}
	
	public void scenerieOne() {
		/** Simulacion de que la persona ingrese datos */
		User user = new User("Juan", "123");
		User user2 = new User("harold", "123");
		User user3 = new User("Juan", "123");

		/** Se guarda en la lista */
		this.hPU.addUser(user);
		this.hPU.addUser(user2);
		this.hPU.addUser(user3);
		
		assertEquals(this.hPU.getListusers().size(), 2);
	}
	

	public void scenerietwo() {
		/** Simulacion de que la persona cerro la app */
		this.hPU.setListusers(new ArrayList<>());

		assertTrue(this.hPU.getListusers().isEmpty());

		/** Simulacion de que la persona volvio ejecutar el programa. */
		this.hPU.loadFile(ETypeFile.SER);

		assertEquals("Juan", 
				this.hPU.getListusers().get(0).getNameUser());
		assertEquals(2,
				this.hPU.getListusers().size());
		//assertNotNull(this.hPB.getListBeer().get(3));
		//assertEquals("Corona",this.hPB.getListBeer().get(1).getBrand());
	}

}
