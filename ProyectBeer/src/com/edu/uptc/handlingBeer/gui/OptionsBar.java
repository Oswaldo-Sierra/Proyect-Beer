package com.edu.uptc.handlingBeer.gui;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class OptionsBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	/** Definicion de los menus*/
	private JMenu optmenuHandligBeer;
	private JMenu optImport;
	private JMenu optExport;
	private JMenu optReport;
	
	
	/** submenu del administrar cerveza*/
	private JMenuItem optCreateBeer;
	private JMenuItem optUpdateBeer;
	private JMenuItem optFindBeerBySerialNumeber;
	
	/** Submenu de importar*/
	private JMenuItem optImportPlain;
	private JMenuItem optImportCSV;
	private JMenuItem optImportJSON;
	private JMenuItem optImportXML;
	private JMenuItem optImportSER;
	
	/** Submenu de Exportar */
	private JMenuItem optExportPlain;
	private JMenuItem optExportCSV;
	private JMenuItem optExportJSON;
	private JMenuItem optExportXML;
	private JMenuItem optExportSER;
	
	private MainWindow mainWindow;
	
		
	public OptionsBar(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		menuHandligBeer();
		importMenu();
		exportMenu();
		
		this.optReport = new JMenu("Reportes");
		
		this.add(optImport);
		this.add(optExport);
		this.add(optReport);
		
	}
	
	private void menuHandligBeer() {
		this.optmenuHandligBeer = new JMenu("Administrar Cerveza");
		
		this.optCreateBeer = new JMenuItem("Crear Cerveza");
		this.optCreateBeer.setActionCommand(HandlingEventsMainWindow.ADD_BEER);
		this.optCreateBeer.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		
		this.optUpdateBeer = new JMenuItem("Actualizar Cerveza");
		this.optFindBeerBySerialNumeber = new JMenuItem("Ver Cervezas por Numero de serial");
		
		this.optmenuHandligBeer.add(optCreateBeer);
		this.optmenuHandligBeer.add(optUpdateBeer);
		this.optmenuHandligBeer.add(optFindBeerBySerialNumeber);
		this.add(optmenuHandligBeer);
	}
	
	private void importMenu() {
		this.optImport = new JMenu("Importar");
		
		this.optImportPlain = new JMenuItem("Archivo plano");
		this.optImportPlain.setActionCommand(HandlingEventsMainWindow.LOAD_CONTACT_PLAIN);
		this.optImportPlain.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optImportCSV = new JMenuItem("CSV");
		this.optImportJSON = new JMenuItem("JSON");
		this.optImportXML = new JMenuItem("XML");
		this.optImportXML.setActionCommand(HandlingEventsMainWindow.LOAD_BEER_XML);
		this.optImportXML.addActionListener(mainWindow.getHandlingEventsMainWindow());
		this.optImportSER = new JMenuItem("SER");
		
		this.optImport.add(optImportPlain);
		this.optImport.add(optImportCSV);
		this.optImport.add(optImportJSON);
		this.optImport.add(optImportXML);
		this.optImport.add(optImportSER);
	}
	
	private void exportMenu() {
		this.optExport = new JMenu("Exportar");
		
		this.optExportPlain = new JMenuItem("Plano");
		this.optExportCSV = new JMenuItem("CSV");
		this.optExportJSON = new JMenuItem("JSON");
		this.optExportXML = new JMenuItem("XML");
		this.optExportSER = new JMenuItem("SER");
		
		this.optExport.add(optExportPlain);
		this.optExport.add(optExportCSV);
		this.optExport.add(optExportJSON);
		this.optExport.add(optExportXML);
		this.optExport.add(optExportSER);
		
	}
}