package com.edu.uptc.handlingBeer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.edu.uptc.handlingBeer.enums.EAplicationMode;
import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.model.Beer;
import com.edu.uptc.handlingBeer.model.SalesOfBeer;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceBeer;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceSalesOfBeer;

public class HandlingEventsMainWindow implements ActionListener {

	// probar cambios de tabla
	public static final String SHOW_BEER_TABLE = "SHOW_BEER_TABLE";
	public static final String SHOW_SALES_TABLE = "SHOW_SALES_TABLE";

	// Acciones del primer menu y submenu
	public static final String ADD_BEER = "ADD_BEER";
	public static final String SHOW_BEER_BY_BRAND_WINDOW = "SHOW_BEER_BY_BRAND_WINDOW";
	public static final String FIND_BEER_BY_BRAND = "FIND_BEER_BY_BRAND";
	// acciones de ventas
	public static final String ADD_SALE = "ADD_SALE";
	// Acciones de importar Cervezas
	public static final String LOAD_BEER_PLAIN = "LOAD_BEER_PLAIN";
	public static final String LOAD_BEER_CSV = "LOAD_BEER_CSV";
	public static final String LOAD_BEER_XML = "LOAD_BEER_XML";
	public static final String LOAD_BEER_JSON = "LOAD_BEER_JSON";
	public static final String LOAD_BER_SERIALIZATE = "LOAD_BER_SERIALIZATE";

	// Acciones de exportar Cervezas
	public static final String EXPORT_BEER_FILE_PLAIN = "EXPORT_BEER_FILE_PLAIN";
	public static final String EXPORT_BEER_CSV = "EXPORT_BEER_CSV";
	public static final String EXPORT_BEER_XML = "EXPORT_BEER_XML";
	public static final String EXPORT_BEER_JSON = "EXPORT_BEER_JSON";
	public static final String EXPORT_BEER_SERIALIZATE = "EXPORT_BEER_SERIALIZATE";

	// Acciones de importar ventas
	public static final String LOAD_SALE_PLAIN = "LOAD_SALE_PLAIN";
	public static final String LOAD_SALE_CSV = "LOAD_SALE_CSV";
	public static final String LOAD_SALE_XML = "LOAD_SALE_XML";
	public static final String LOAD_SALE_JSON = "LOAD_SALE_JSON";
	public static final String LOAD_SALE_SERIALIZATE = "LOAD_SALE_SERIALIZATE";

	// Acciones de exportar ventas
	public static final String EXPORT_SALE_FILE_PLAIN = "EXPORT_SALE_FILE_PLAIN";
	public static final String EXPORT_SALE_CSV = "EXPORT_SALE_CSV";
	public static final String EXPORT_SALE_XML = "EXPORT_SALE_XML";
	public static final String EXPORT_SALE_JSON = "EXPORT_SALE_JSON";
	public static final String EXPORT_SALE_SERIALIZATE = "EXPORT_SALE_SERIALIZATE";

	// Botones de panelRight
	public static final String SEE_MORE_BEER = "SEE_MORE_BEER";
	public static final String UDATE_BEER = "UDATE_BEER";
	public static final String DELETE_BEER = "DELETE_BEER";

	public static final String SEE_MORE_SALES = "SEE_MORE_SALES";
	public static final String UDATE_SALES = "UDATE_SALES";
	public static final String DELETE_SALES = "DELETE_SALES";

	// Botones de panelSouth
	public static final String SORT_TABLE_BEER = "SORT_TABLE_BEER";
	public static final String SORT_TABLE_SALES = "SORT_TABLE_SALES";

	// botone de busqueda por atributo
	public static final String SHOW_WINDOW_SEARCH = "SHOW_WINDOW_SEARCH";

	public static final String HIDE_WINDOW_FIND_BEER = "HIDE_WINDOW_FIND_BEER";
	public static final String FIND_BEER_BY_ATTRIBUTE = "FIND_BEER_BY_ATTRIBUTE";

	public static final String HIDE_WINDOW_FIND_SALES = "HIDE_WINDOW_FIND_SALES";
	public static final String FIND_SALES_BY_ATTRIBUTE = "FIND_SALES_BY_ATTRIBUTE";

	public static final String CHANGE_USERNAME = "CHANGE_USERNAME";
	public static final String CHANGE_PASSWORD = "CHANGE_PASSWORD";
	public static final String DELETE_ACCOUNT = "DELETE_ACCOUNT";
	public static final String LOG_OUT = "LOG_OUT";
	private boolean ascendingOrder = true;

	private EAplicationMode aplicationMode = EAplicationMode.BEER_MANAGEMENT;

	private MainWindow mainWindow;
	private HandlingEventsUser handlingEventsUser;

	public HandlingEventsMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.handlingEventsUser = new HandlingEventsUser(mainWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case SHOW_BEER_TABLE:
			this.aplicationMode = EAplicationMode.BEER_MANAGEMENT;
			switchToMode(aplicationMode);
			break;
		case SHOW_SALES_TABLE:
			this.aplicationMode = EAplicationMode.SALES_MANAGEMENT;
			switchToMode(aplicationMode);
			break;

		// menu 1 y submenu
		case ADD_BEER:
			this.aplicationMode = EAplicationMode.BEER_MANAGEMENT;
			switchToMode(aplicationMode);
			this.mainWindow.getAddBeerWindow().setVisible(true);
			break;
		case SHOW_BEER_BY_BRAND_WINDOW:
			switchToMode(EAplicationMode.BEER_MANAGEMENT);
			this.mainWindow.getShowBeerbyBrandWindow().setVisible(true);
			break;
		case FIND_BEER_BY_BRAND:
			this.findBeerbybrand();
			break;

		// Acciones de menu de venta
		case ADD_SALE:
			this.aplicationMode = EAplicationMode.SALES_MANAGEMENT;
			switchToMode(aplicationMode);
			String op[] = this.mainWindow.getHandlingPersistenceBeer().comboBoxValues();
			this.mainWindow.getAddSalesOfBeerWindow().getPanelMiddelAddSalesWindow().getComboBoxBrandSerial()
					.setModel(new DefaultComboBoxModel<String>(op));
			this.mainWindow.getAddSalesOfBeerWindow().setVisible(true);
			break;

		// Importar Cervezas
		case LOAD_BEER_PLAIN:
			this.loadInfoTableBeer(ETypeFile.FILE_PLAIN);
			break;
		case LOAD_BEER_CSV:
			this.loadInfoTableBeer(ETypeFile.CSV);
			break;
		case LOAD_BEER_XML:
			this.loadInfoTableBeer(ETypeFile.XML);
			break;
		case LOAD_BEER_JSON:
			this.loadInfoTableBeer(ETypeFile.JSON);
			break;
		case LOAD_BER_SERIALIZATE:
			this.loadInfoTableBeer(ETypeFile.SER);
			break;
		// Exportar cervezas
		case EXPORT_BEER_FILE_PLAIN:
			exportData(ETypeFile.FILE_PLAIN, "Archivos de texto (.txt)", "txt");
			break;
		case EXPORT_BEER_CSV:
			exportData(ETypeFile.CSV, "Archivos de CSV (.csv)", "csv");
			break;
		case EXPORT_BEER_XML:
			exportData(ETypeFile.XML, "Archivos de XML (.XMl)", "XMl");
			break;
		case EXPORT_BEER_JSON:
			exportData(ETypeFile.JSON, "Archivos de JSON (.JSON)", "JSON");
			break;
		case EXPORT_BEER_SERIALIZATE:
			exportData(ETypeFile.SER, "Archivos de serializado (.SER)", "SER");
			break;
		// Importar Ventas
		case LOAD_SALE_PLAIN:
			this.loadInfoTableSalesOfBeer(ETypeFile.FILE_PLAIN);
			break;
		case LOAD_SALE_CSV:
			this.loadInfoTableSalesOfBeer(ETypeFile.CSV);
			break;
		case LOAD_SALE_XML:
			this.loadInfoTableSalesOfBeer(ETypeFile.XML);
			break;
		case LOAD_SALE_JSON:
			this.loadInfoTableSalesOfBeer(ETypeFile.JSON);
			break;
		case LOAD_SALE_SERIALIZATE:
			this.loadInfoTableSalesOfBeer(ETypeFile.SER);
			break;
		// Exportar Sales
		case EXPORT_SALE_FILE_PLAIN:
			exportData(ETypeFile.FILE_PLAIN, "Archivos de texto (.txt)", "txt");
			break;
		case EXPORT_SALE_CSV:
			exportData(ETypeFile.CSV, "Archivos de CSV (.csv)", "csv");
			break;
		case EXPORT_SALE_XML:
			exportData(ETypeFile.XML, "Archivos de XML (.XMl)", "XMl");
			break;
		case EXPORT_SALE_JSON:
			exportData(ETypeFile.JSON, "Archivos de JSON (.JSON)", "JSON");
			break;
		case EXPORT_SALE_SERIALIZATE:
			exportData(ETypeFile.SER, "Archivos de serializado (.SER)", "SER");
			break;

		// botones del PanelRight
		case SEE_MORE_BEER: // Mostrar mas cervezas
			this.mainWindow.getAddBeerWindow().setVisible(true);
			break;
		case DELETE_BEER: // Elimiar una cerveza
			this.deleteBeer();
			break;
		case UDATE_BEER: // Actualizar cerveza
			this.upateBeer();
			break;

		case SEE_MORE_SALES: // Mostra mas ventas
			this.mainWindow.getAddSalesOfBeerWindow().setVisible(true);
			break;
		case UDATE_SALES: // Actualizar venta
			this.updateSale();
			break;
		case DELETE_SALES: // eliminar ventas
			this.deleteSales();
			break;

		// Botones del panelsouth
		case SORT_TABLE_BEER:
			this.sortTableBeer();
			break;
		case SORT_TABLE_SALES:
			this.sortTableSales();
			break;

		// botones de buscar por:
		case SHOW_WINDOW_SEARCH: //
			this.mainWindow.getFindBeerWindow().setVisible(true);
			break;
		case HIDE_WINDOW_FIND_BEER:
			this.clearInfoWindowFind();

			break;
		case FIND_BEER_BY_ATTRIBUTE:
			this.findBeerbyAtribute();
			break;
		case HIDE_WINDOW_FIND_SALES:
			this.clearInfoWindowFind();
			break;
		case FIND_SALES_BY_ATTRIBUTE:
			this.findSalesbyAtribute();
			break;

		// usuario
		case CHANGE_USERNAME:
			this.handlingEventsUser.changeUsername();
			break;
		case CHANGE_PASSWORD:
			this.handlingEventsUser.changePassword();
			break;
		case DELETE_ACCOUNT:
			this.handlingEventsUser.deleteAccount();
			break;
		case LOG_OUT:
			this.handlingEventsUser.logOut();
			break;
		}

	}

	private void sortTableBeer() {
		List<Beer> beers = this.mainWindow.getHandlingPersistenceBeer().getListBeer();

		if (ascendingOrder) {
			beers.sort((b1, b2) -> b1.getSerialNumber() - b2.getSerialNumber());
		} else {
			beers.sort((b1, b2) -> b2.getSerialNumber() - b1.getSerialNumber());
		}

		this.clearTable();
		// Agregar filas ordenadas
		beers.forEach(beer -> {
			Object[] row = new Object[] { beer.getSerialNumber(), beer.getBrand(), beer.getType(), beer.getABV(),
					beer.getIBU(), beer.getProvider(), beer.getPrice(), beer.getQuantity() };
			this.mainWindow.getPanelMiddleMainWindow().addRow(row);
		});
		ascendingOrder = false;
	}

	private void sortTableSales() {
		List<SalesOfBeer> sales = this.mainWindow.getHandlingPersistenceSalesOfBeer().getListSalesOfBeer();

		if (ascendingOrder) {
			sales.sort((s1, s2) -> s1.getSalesID() -s2.getSalesID());
		} else {
			sales.sort((s1, s2) -> s2.getSalesID() -s1.getSalesID());
		}

		this.clearTable();
		// Agregar filas ordenadas
		sales.forEach(sale -> {
			Object[] row = new Object[] { sale.getSalesID(), sale.getNumberSerialOfBeer(), sale.getNumberOfBeersSold(),
					sale.getPriceTotal(), String.valueOf(sale.getDateOfSale()), sale.getUserName(),
					sale.getCustomerName() };
			this.mainWindow.getPanelMiddleMainWindow().addRow(row);
		});
		ascendingOrder = false;
	}
	


	private void findSalesbyAtribute() {
		int index = mainWindow.getFindBeerWindow().getComboBoxAttributes().getSelectedIndex();
		String value = mainWindow.getFindBeerWindow().getInputValue().getTextValue();

		SalesOfBeer salesOfBeer = this.mainWindow.getHandlingPersistenceSalesOfBeer().findSalesByIndex(index, value);
		if (salesOfBeer != null) {
			this.clearTable();
			Object[] row = new Object[] { salesOfBeer.getSalesID(), salesOfBeer.getNumberSerialOfBeer(),
					salesOfBeer.getNumberOfBeersSold(), salesOfBeer.getPriceTotal(),
					String.valueOf(salesOfBeer.getDateOfSale()), salesOfBeer.getUserName(),
					salesOfBeer.getCustomerName() };

			this.mainWindow.getPanelMiddleMainWindow().addRow(row);
			JOptionPane.showMessageDialog(null, "Venta encontrada");
			this.mainWindow.getFindBeerWindow().resetFrom();
			this.mainWindow.getFindBeerWindow().setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Venta no encontrada");
		}

	}

	private void clearInfoWindowFind() {
		this.mainWindow.getFindBeerWindow().resetFrom();
		this.mainWindow.getShowBeerbyBrandWindow().getComboBoxBrands().setSelectedIndex(0);
		this.mainWindow.getFindBeerWindow().setVisible(false);
		this.mainWindow.getShowBeerbyBrandWindow().setVisible(false);

	}

	public void switchToMode(EAplicationMode mode) {
		this.mainWindow.getPanelMiddleMainWindow().setupTableForMode(mode);

		this.mainWindow.getPanelNorthMainWindow().setupForMode(mode);

		this.mainWindow.getPanelRightButtonMainWindow().setupForMode(mode);

		this.mainWindow.getOptionsBar().updateForMode(mode);

		this.mainWindow.getFindBeerWindow().updateForMode(mode);
		
		this.mainWindow.getPanelSouthMainWindow().updateForMode(mode);

		this.mainWindow.getPanelRightButtonMainWindow().setVisible(false);

		// System.out.println("Cambio al modo:" + mode);

	}

	private void upateBeer() {
		int file = this.mainWindow.getPanelMiddleMainWindow().getTable().getSelectedRow();

		try {
			String serialNumber = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 0).toString();
			String brand = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 1).toString();
			String type = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 2).toString();
			String ABV = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 3).toString();
			String IBU = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 4).toString();
			String provider = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 5).toString();
			String price = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 6).toString();
			String quantity = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 7).toString();

			// --Validaciones--
			int serial = Integer.parseInt(serialNumber);
			int price_b = Integer.parseInt(price);
			if (price_b <= 0) {
				JOptionPane.showMessageDialog(null, "El Precio de cervezas debe ser mayor a 0");
				return;
			}

			int quantity_b = Integer.parseInt(quantity);
			if (quantity_b < 0) {
				JOptionPane.showMessageDialog(null, "La cantidad  no puede ser negativa");
				return;
			}

			Beer beerudate = new Beer(serial, brand, type, ABV, IBU, provider, price_b, quantity_b);
			boolean updated = this.mainWindow.getHandlingPersistenceBeer().updateBeer(beerudate);
			if (updated) {
				this.flushDataBeer();
				JOptionPane.showMessageDialog(null, "Cerveza actualizada correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo actualizar la cerveza. Verifica el número de serie.");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error: los campos numéricos contienen valores inválidos.");
		}

	}

	private void updateSale() {
		int fila = this.mainWindow.getPanelMiddleMainWindow().getTable().getSelectedRow();

		if (fila == -1) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar una venta primero.");
			return;
		}

		try {
			String salesId = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(fila, 0).toString();
			String numberSerialOfBeer = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(fila, 1)
					.toString();
			String numberOfBeersSold = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(fila, 2)
					.toString();
			String priceTotal = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(fila, 3).toString();
			String dateOfSale = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(fila, 4).toString();
			String userName = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(fila, 5).toString();
			String customerName = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(fila, 6).toString();

			// --- VALIDACIONES ---
			int id = Integer.parseInt(salesId);
			int serialBeer = Integer.parseInt(numberSerialOfBeer);

			int beersSold = Integer.parseInt(numberOfBeersSold);
			if (beersSold <= 0) {
				JOptionPane.showMessageDialog(null, "El número de cervezas debe ser mayor a 0.");
				return;
			}

			double totalPrice = Double.parseDouble(priceTotal);
			if (totalPrice < 0) {
				JOptionPane.showMessageDialog(null, "El precio total no puede ser negativo.");
				return;
			}

			LocalDate fechaVenta;
			try {
				fechaVenta = LocalDate.parse(dateOfSale, SalesOfBeer.formatter);
				if (fechaVenta.isAfter(LocalDate.now())) {
					JOptionPane.showMessageDialog(null, "La fecha no puede ser futura.");
					return;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Formato de fecha inválido.");
				return;
			}

			SalesOfBeer salesOfBeerUpdate = new SalesOfBeer(id, serialBeer, beersSold, totalPrice, dateOfSale, userName,
					customerName);

			boolean updated = this.mainWindow.getHandlingPersistenceSalesOfBeer().updateSale(salesOfBeerUpdate);

			if (updated) {
				this.flushDataSaleOfBeer();
				JOptionPane.showMessageDialog(null, "Venta actualizada correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo actualizar la venta. Verifica el ID.");
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error: los campos numéricos contienen valores inválidos.");
		}
	}

	private void deleteSales() {
		int option = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar esta Venta", "Confirmacion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (option == JOptionPane.YES_OPTION) {
			int SalesSelected = Integer.parseInt(HandlingPersistenceSalesOfBeer.ID_SALE_SELECTED);
			this.mainWindow.getHandlingPersistenceSalesOfBeer().deleteBeer(SalesSelected);
			this.flushDataSaleOfBeer();
			this.loadInfoTableSalesOfBeer(ETypeFile.CSV);
		}

	}

	private void findBeerbybrand() {
		int index = this.mainWindow.getShowBeerbyBrandWindow().getComboBoxBrands().getSelectedIndex();

		List<Beer> listAxu = this.mainWindow.getHandlingPersistenceBeer().findBeersByBrand(index);
		if (listAxu.size() > 0) {
			this.clearTable();
			for (Beer beer : listAxu) {
				Object[] row = new Object[] { beer.getSerialNumber(), beer.getBrand(), beer.getType(), beer.getABV(),
						beer.getIBU(), beer.getProvider(), beer.getPrice(), beer.getQuantity() };
				this.mainWindow.getPanelMiddleMainWindow().addRow(row);
			}
			JOptionPane.showMessageDialog(null, "Las Cervezas la marca seleccionada son:");
			this.mainWindow.getShowBeerbyBrandWindow().getComboBoxBrands().setSelectedIndex(0);
			this.mainWindow.getShowBeerbyBrandWindow().setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "No existen cervezas con esa marca");
		}
	}

	private void findBeerbyAtribute() {
		int index = mainWindow.getFindBeerWindow().getComboBoxAttributes().getSelectedIndex();
		String value = mainWindow.getFindBeerWindow().getInputValue().getTextValue();

		Beer beer = mainWindow.getHandlingPersistenceBeer().findBeerbyIndex(index, value);
		if (beer != null) {
			this.clearTable();
			Object[] row = new Object[] { beer.getSerialNumber(), beer.getBrand(), beer.getType(), beer.getABV(),
					beer.getIBU(), beer.getProvider(), beer.getPrice(), beer.getQuantity() };
			this.mainWindow.getPanelMiddleMainWindow().addRow(row);
			JOptionPane.showMessageDialog(null, "Cerveza encontrada");
			this.mainWindow.getFindBeerWindow().resetFrom();
			this.mainWindow.getFindBeerWindow().setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Cerveza no encontrada");
		}
	}

	private void deleteBeer() {
		int option = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar esta Cerveza", "Confirmacion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (option == JOptionPane.YES_OPTION) {
			int beerSelected = Integer.parseInt(HandlingPersistenceBeer.SERIALNUMBER_BEER_SELECTED);
			this.mainWindow.getHandlingPersistenceBeer().deleteBeer(beerSelected);
			this.flushDataBeer();
			this.loadInfoTableBeer(ETypeFile.CSV);
		}

	}

	private void exportData(ETypeFile typeFile, String description, String extension) {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filterFile = new FileNameExtensionFilter(description, extension);
		fileChooser.setFileFilter(filterFile);

		int result = fileChooser.showDialog(null, "Exportar archivo " + description);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();

			// Si el usuario no escribe la extensión, la añadimos
			String filePath = selectedFile.getAbsolutePath();
			if (!filePath.endsWith("." + extension)) {
				filePath += "." + extension;
			}

			if (EAplicationMode.BEER_MANAGEMENT.equals(aplicationMode)) {
				this.mainWindow.getHandlingPersistenceBeer().exportFile(typeFile, filePath);
				JOptionPane.showMessageDialog(null, "Archivo exportado correctamente: " + filePath);
			}

			if (EAplicationMode.SALES_MANAGEMENT.equals(aplicationMode)) {
				this.mainWindow.getHandlingPersistenceSalesOfBeer().exportFile(typeFile, filePath);
				JOptionPane.showMessageDialog(null, "Archivo exportado correctamente: " + filePath);
			}

		}
	}

	private void flushDataBeer() {
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.FILE_PLAIN);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.CSV);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.XML);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.JSON);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.SER);
	}

	private void flushDataSaleOfBeer() {
		this.mainWindow.getHandlingPersistenceSalesOfBeer().dumpFile(ETypeFile.FILE_PLAIN);
		this.mainWindow.getHandlingPersistenceSalesOfBeer().dumpFile(ETypeFile.CSV);
		this.mainWindow.getHandlingPersistenceSalesOfBeer().dumpFile(ETypeFile.XML);
		this.mainWindow.getHandlingPersistenceSalesOfBeer().dumpFile(ETypeFile.JSON);
		this.mainWindow.getHandlingPersistenceSalesOfBeer().dumpFile(ETypeFile.SER);
	}

	/** Metodos que carga la info depenciendo del archivo */
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

	private void loadInfoTableBeer(ETypeFile eTypeFile) {
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
