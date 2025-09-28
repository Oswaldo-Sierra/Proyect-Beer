package com.edu.uptc.handlingBeer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.model.Beer;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceBeer;

public class HandlingEventsMainWindow implements ActionListener {

	// Acciones del primer menu y submenu
	public static final String ADD_BEER = "ADD_BEER";
	public static final String SHOW_BEER_BY_BRAND_WINDOW = "SHOW_BEER_BY_BRAND_WINDOW";
	public static final String FIND_BEER_BY_BRAND = "FIND_BEER_BY_BRAND";

	// Accion del segundo menu y sus respectivos submenus
	public static final String LOAD_BEER_PLAIN = "LOAD_BEER_PLAIN";
	public static final String LOAD_BEER_CSV = "LOAD_BEER_CSV";
	public static final String LOAD_BEER_XML = "LOAD_BEER_XML";
	public static final String LOAD_BEER_JSON = "LOAD_BEER_JSON";
	public static final String LOAD_BER_SERIALIZATE = "LOAD_BER_SERIALIZATE";

	// Accion del tercer menu y sus respectivos submenus
	public static final String EXPORT_BEER_FILE_PLAIN = "EXPORT_BEER_FILE_PLAIN";
	public static final String EXPORT_BEER_CSV = "EXPORT_BEER_CSV";
	public static final String EXPORT_BEER_XML = "EXPORT_BEER_XML";
	public static final String EXPORT_BEER_JSON = "EXPORT_BEER_JSON";
	public static final String EXPORT_BEER_SERIALIZATE = "EXPORT_BEER_SERIALIZATE";

	// Botones de panelRight
	public static final String SEE_MORE_BEER = "SEE_MORE_BEER";
	public static final String UDATE_BEER = "UDATE_BEER";
	public static final String DELETE_BEER = "DELETE_BEER";

	// botone de busqueda por atributo
	public static final String SHOW_WINDOW_SEARCH_BEER = "SHOW_WINDOW_SEARCH_BEER";
	public static final String HIDE_WINDOW_FIND_BEER = "HIDE_WINDOW_FIND_BEER";
	public static final String FIND_BEER_BY_ATTRIBUTE = "FIND_BEER_BY_ATTRIBUTE";

	private MainWindow mainWindow;

	public HandlingEventsMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		// menu 1 y submenu
		case ADD_BEER:
			this.mainWindow.getAddBeerWindow().setVisible(true);
			break;
		case SHOW_BEER_BY_BRAND_WINDOW:
			this.mainWindow.getShowBeerbyBrandWindow().setVisible(true);
			break;
		case FIND_BEER_BY_BRAND:
			this.findBeerbybrand();
			break;
		// menu 2
		// Cargue de archivos planos a la tabla
		case LOAD_BEER_PLAIN:
			this.loadInfoTable(ETypeFile.FILE_PLAIN);
			break;
		case LOAD_BEER_CSV:
			this.loadInfoTable(ETypeFile.CSV);
			break;
		case LOAD_BEER_XML:
			this.loadInfoTable(ETypeFile.XML);
			break;
		case LOAD_BEER_JSON:
			this.loadInfoTable(ETypeFile.JSON);
			break;
		case LOAD_BER_SERIALIZATE:
			this.loadInfoTable(ETypeFile.SER);
			break;
		// menu 3
		// exporte de los distintos archivos
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

		// botones de buscar por:
		case SHOW_WINDOW_SEARCH_BEER: //
			this.mainWindow.getFindBeerWindow().setVisible(true);
			break;
		case HIDE_WINDOW_FIND_BEER:
			this.mainWindow.getFindBeerWindow().resetFrom();
			this.mainWindow.getShowBeerbyBrandWindow().getComboBoxBrands().setSelectedIndex(0);
			this.mainWindow.getFindBeerWindow().setVisible(false);
			this.mainWindow.getShowBeerbyBrandWindow().setVisible(false);
			break;
		case FIND_BEER_BY_ATTRIBUTE:
			this.findBeerbyAtribute();
			break;
		}

	}

	private void findBeerbybrand() {
		int index = this.mainWindow.getShowBeerbyBrandWindow().getComboBoxBrands().getSelectedIndex();

		List<Beer> listAxu = this.mainWindow.getHandlingPersistenceBeer().findBeersByBrand(index);
		if (listAxu.size() > 0) {
			this.clearTable();
			for (Beer beer : listAxu) {
				Object[] row = new Object[] { beer.getSerialNumber(), beer.getBrand(), beer.getType(), beer.getABV(),
						beer.getIBU(), beer.getProvider(), beer.getPrice(), beer.getQuantity()};
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
		String value = mainWindow.getFindBeerWindow().getInputValue().getText();

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

	private void upateBeer() {
		int file = this.mainWindow.getPanelMiddleMainWindow().getTable().getSelectedRow();
		String serialNumber = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 0).toString();
		String brand = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 1).toString();
		String type = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 2).toString();
		String ABV = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 3).toString();
		String IBU = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 4).toString();
		String provider = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 5).toString();
		String price = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 5).toString();
		String quantity = this.mainWindow.getPanelMiddleMainWindow().getTable().getValueAt(file, 5).toString();

		Beer beerudate = new Beer(Integer.parseInt(serialNumber), brand,type, ABV, IBU, provider,
				Integer.parseInt(price), Integer.parseInt(quantity));
		boolean updated = this.mainWindow.getHandlingPersistenceBeer().updateBeer(beerudate);
		if (updated) {
			this.flushData();
			JOptionPane.showMessageDialog(null, "Cerveza actualizada correctamente.");
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo actualizar la cerveza. Verifica el número de serie.");
		}

	}

	private void deleteBeer() {
		int option = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar esta Cerveza", "Confirmacion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (option == JOptionPane.YES_OPTION) {
			int beerSelected = Integer.parseInt(HandlingPersistenceBeer.SERIALNUMBER_BEER_SELECTED);
			this.mainWindow.getHandlingPersistenceBeer().deleteBeer(beerSelected);
			this.flushData();
			this.loadInfoTable(ETypeFile.CSV);
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

			this.mainWindow.getHandlingPersistenceBeer().exportFile(typeFile, filePath);
			JOptionPane.showMessageDialog(null, "Archivo exportado correctamente: " + filePath);
		}
	}

	private void flushData() {
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.FILE_PLAIN);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.CSV);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.XML);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.JSON);
		this.mainWindow.getHandlingPersistenceBeer().dumpFile(ETypeFile.SER);

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
