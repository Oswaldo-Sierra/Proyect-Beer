package com.edu.uptc.handlingBeer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.model.SalesOfBeer;

public class HandlingEventsAddSalesWindow implements ActionListener {
	public static final String GET_BACK = "GET_BACK";
	public static final String ADD_SALES = "ADD_BEER";
	private MainWindow mainWindow;

	public HandlingEventsAddSalesWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case GET_BACK:
			this.clearDate();
			this.mainWindow.getAddSalesOfBeerWindow().setVisible(false);
			break;
		case ADD_SALES:
			this.addSale();
			break;
		default:

		}

	}

	private void addSale() {
		int id = this.mainWindow.getHandlingPersistenceSalesOfBeer().generateIDSale();
		String selected = (String) this.mainWindow.getAddSalesOfBeerWindow().getPanelMiddelAddSalesWindow()
				.getComboBoxBrandSerial().getSelectedItem();

		int serialBeer = Integer.parseInt(selected.split("-")[1]);
		String numberSold = this.mainWindow.getAddSalesOfBeerWindow().getPanelMiddelAddSalesWindow().getInptNumberSold()
				.getTextValue();

		if (!this.mainWindow.getHandlingPersistenceBeer().numberSoldBeer(serialBeer, Integer.parseInt(numberSold))) {
			JOptionPane.showMessageDialog(null, "Error, Cantidad de cervezas insuficinetes");
			this.clearDate();
			this.mainWindow.getAddSalesOfBeerWindow().setVisible(false);
			return;

		}

		int pricebase = this.mainWindow.getHandlingPersistenceBeer().priceBeer(serialBeer);
		int price = Integer.parseInt(numberSold) * pricebase;
		LocalDate date = LocalDate.now();
		String userName = InfoSesion.getUserName(); 
		String customerName = this.mainWindow.getAddSalesOfBeerWindow().getPanelMiddelAddSalesWindow()
				.getInptNameCustomer().getTextValue();

		SalesOfBeer salesOfBeer = new SalesOfBeer(id, serialBeer, Integer.parseInt(numberSold), price,
				date.format(SalesOfBeer.formatter), userName, customerName);
		if (this.mainWindow.getHandlingPersistenceSalesOfBeer().addSalesOfBeer(salesOfBeer)) {
			this.flushData();
			this.clearDate();
			this.flushDataBeer();

			JOptionPane.showMessageDialog(null, "Se agrego nueva Venta");
			this.mainWindow.getAddBeerWindow().setVisible(false);
			this.loadInfoTableSalesOfBeer(ETypeFile.CSV);
		} else {
			JOptionPane.showMessageDialog(null, "La Venta ya existe");
		}
	}

	private void clearDate() {
		this.mainWindow.getAddSalesOfBeerWindow().getPanelMiddelAddSalesWindow().getComboBoxBrandSerial()
				.setSelectedIndex(0);
		this.mainWindow.getAddSalesOfBeerWindow().getPanelMiddelAddSalesWindow().getInptNumberSold().setText("");
		this.mainWindow.getAddSalesOfBeerWindow().getPanelMiddelAddSalesWindow().getInptNameCustomer().setText("");

	}

	private void flushData() {
		this.mainWindow.getHandlingPersistenceSalesOfBeer().dumpFile(ETypeFile.FILE_PLAIN);
		this.mainWindow.getHandlingPersistenceSalesOfBeer().dumpFile(ETypeFile.CSV);
		this.mainWindow.getHandlingPersistenceSalesOfBeer().dumpFile(ETypeFile.XML);
		this.mainWindow.getHandlingPersistenceSalesOfBeer().dumpFile(ETypeFile.JSON);
		this.mainWindow.getHandlingPersistenceSalesOfBeer().dumpFile(ETypeFile.SER);

	}

	private void flushDataBeer() {
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.FILE_PLAIN);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.CSV);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.XML);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.JSON);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.SER);
	}

	private void loadInfoTableSalesOfBeer(ETypeFile eTypeFile) {
		this.mainWindow.getHandlingPersistenceSalesOfBeer().setListSalesOfBeer(new ArrayList<>());
		this.mainWindow.getHandlingPersistenceSalesOfBeer().loadFile(eTypeFile);
		this.clearTable();
		this.mainWindow.getHandlingPersistenceSalesOfBeer().getListSalesOfBeer().forEach(sale -> {
			Object[] row = new Object[] { sale.getSalesID(), sale.getNumberSerialOfBeer(), sale.getNumberOfBeersSold(),
					sale.getPriceTotal(), String.valueOf(sale.getDateOfSale()), sale.getUserName(),
					sale.getCustomerName() };
			this.mainWindow.getPanelMiddleMainWindow().addRow(row);
		});
	}

	private void clearTable() {
		for (int i = (this.mainWindow.getPanelMiddleMainWindow().getDtm().getRowCount() - 1); i >= 0; i--) {
			this.mainWindow.getPanelMiddleMainWindow().getDtm().removeRow(i);

		}
	}

}
