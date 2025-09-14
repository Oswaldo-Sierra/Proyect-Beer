package com.edu.uptc.handlingBeer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceBeer;

public class HandlingEventsMainWindow implements ActionListener {

	public static final String LOAD_CONTACT_PLAIN = "LOAD_CONTACT_PLAIN";
	public static final String LOAD_BEER_XML = "LOAD_BEER_XML";
	public static final String ADD_BEER = "ADD_BEER";
	
	private HandlingPersistenceBeer handlingPersistenceBeer;
	private MainWindow mainWindow;
	//private AddBeer addBeer;

	public HandlingEventsMainWindow(MainWindow mainWindow) {
		this.handlingPersistenceBeer = new HandlingPersistenceBeer();
		//this.addBeer = new AddBeer();
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case LOAD_CONTACT_PLAIN:
			this.loadInfoTable(ETypeFile.FILE_PLAIN);
			break;
		case LOAD_BEER_XML:
			this.loadInfoTable(ETypeFile.XML);
			break;
		case ADD_BEER:
			this.mainWindow.getAddBeer().setVisible(true);;
		default:
			break;
		}

	}
	
	

	private void loadInfoTable(ETypeFile eTypeFile) {
		handlingPersistenceBeer.setListBeer(new ArrayList<>());
		handlingPersistenceBeer.loadFile(eTypeFile);
		this.clearTable();
		handlingPersistenceBeer.getListBeer().forEach(beer -> {
			Object[] row = new Object[] { beer.getSerialNumber(), beer.getBrand(), beer.getType(), beer.getABV(),
					beer.getIBU(), beer.getOrigin() };
			this.mainWindow.getPanelMiddleMainWindow().addRow(row);
		});
	}

	private void clearTable() {
		for (int i = (this.mainWindow.getPanelMiddleMainWindow().getDtm().getRowCount() - 1); i >= 0; i--) {
			this.mainWindow.getPanelMiddleMainWindow().getDtm().removeRow(i);

		}
	}

}
