package com.edu.uptc.handlingBeer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.model.Beer;

public class HandlingEventsAddWindow implements ActionListener {
	public static final String GET_BACK = "GET_BACK";
	public static final String ADD_BEER = "ADD_BEER";

	private MainWindow mainWindow;

	public HandlingEventsAddWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case GET_BACK:
			this.clearDate();
			this.mainWindow.getAddBeerWindow().setVisible(false);
			break;
		case ADD_BEER:
			this.addBeer();
			break;
		default:
			break;
		}
	}

	private void addBeer() {
		try {
			int index1 = this.mainWindow.getAddBeerWindow().getPanelMiddeladdBeerWindow().getComboBoxBrands()
					.getSelectedIndex();

			int index2 = this.mainWindow.getAddBeerWindow().getPanelMiddeladdBeerWindow().getComboBoxType()
					.getSelectedIndex();
			
			int index3 = this.mainWindow.getAddBeerWindow().getPanelMiddeladdBeerWindow().getComboBoxIBU()
					.getSelectedIndex();

			int serialNumber = this.mainWindow.getHandlingPersistenceBeer().generateSerialNumber();
			String brand = this.mainWindow.getHandlingPersistenceBeer().findBrandbyIndex(index1);
			String type = this.mainWindow.getHandlingPersistenceBeer().findtypebyIndex(index2);
			String iBU = this.mainWindow.getHandlingPersistenceBeer().findyIBUIndex(index3);
			String aBV = this.mainWindow.getAddBeerWindow().getPanelMiddeladdBeerWindow().getInptABV()
					.getTextValue();
			String proveder = this.mainWindow.getAddBeerWindow().getPanelMiddeladdBeerWindow().getInptProvider()
					.getTextValue();
			String price = this.mainWindow.getAddBeerWindow().getPanelMiddeladdBeerWindow().getInptPrice()
					.getTextValue();
			String quantitty = this.mainWindow.getAddBeerWindow().getPanelMiddeladdBeerWindow().getInptQuantity()
					.getTextValue();
			/** Se crea un objeto beer */
			Beer beer = new Beer(serialNumber, brand, type, aBV, iBU, proveder, Integer.parseInt(price),
					Integer.parseInt(quantitty));
			/** Validad que no exista otro */
			if (this.mainWindow.getHandlingPersistenceBeer().addBeers(beer)) {
			this.flushData();
			this.clearDate();

			JOptionPane.showMessageDialog(null, "Se agrego nueva cerveza");
			this.mainWindow.getAddBeerWindow().setVisible(false);
			this.loadInfoTable(ETypeFile.FILE_PLAIN);
			}else {
				JOptionPane.showMessageDialog(null, "La Cerveza ya existe");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El precio y la cantidad deben ser números enteros", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	private void flushData() {
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.FILE_PLAIN);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.CSV);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.XML);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.JSON);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.SER);

	}

	private void clearDate() {

	}

	private void loadInfoTable(ETypeFile eTypeFile) {
		this.mainWindow.getHandlingPersistenceBeer().setListBeer(new ArrayList<>());
		this.mainWindow.getHandlingPersistenceBeer().loadFile(eTypeFile);
		this.clearTable();
		this.mainWindow.getHandlingPersistenceBeer().getListBeer().forEach(beer -> {
			Object[] row = new Object[] { beer.getSerialNumber(), beer.getBrand(), beer.getType(), beer.getABV(),
					beer.getIBU(), beer.getProvider(), beer.getPrice(), beer.getQuantity() };
			this.mainWindow.getPanelMiddleMainWindow().addRow(row);
		});
	}

	private void clearTable() {
		for (int i = (this.mainWindow.getPanelMiddleMainWindow().getDtm().getRowCount() - 1); i >= 0; i--) {
			this.mainWindow.getPanelMiddleMainWindow().getDtm().removeRow(i);

		}
	}

}
