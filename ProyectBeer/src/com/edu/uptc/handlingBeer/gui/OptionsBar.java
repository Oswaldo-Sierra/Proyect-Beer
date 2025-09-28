package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class OptionsBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	/** Definicion de los menus */
	private JMenu optUserAdministrator;  
	private JMenu optBeerAdministrator;
	private JMenu optSalesOfBeerAdministrator;
	private JMenu optImport;
	private JMenu optExport;
	private JMenu optReport;

	/**Submenu de administra ventas*/
	private JMenuItem optCreateSaleOfBeer;
	private JMenuItem optDisplaySalesTable;
	private JMenuItem optFindSalesOfBeerByBrand;
	
	/** Submenu de Amdinistra Usuario*/
	private JMenuItem optChangeName;
	private JMenuItem optChangePassword;
	private JMenuItem optDeleteAccount;
	private JMenuItem optCloseSession;
	
	/** submenu del administrar cerveza */
	private JMenuItem optCreateBeer;
	private JMenuItem optUpdateBeer;
	private JMenuItem optFindBeerByBrand;

	/** Submenu de importar */
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

		this.initComponets();
		this.addComponents();
	}

	private void addComponents() {
		//Se añade un nuevo menu y submenu
		this.optUserAdministrator.add(optChangeName);
		this.optUserAdministrator.add(optChangePassword);
		this.optUserAdministrator.add(optDeleteAccount);
		this.optUserAdministrator.add(optCloseSession);
		//Se añade un nuevo menu y submenu
		this.optSalesOfBeerAdministrator.add(optCreateSaleOfBeer);
		this.optSalesOfBeerAdministrator.add(optDisplaySalesTable);
		this.optSalesOfBeerAdministrator.add(optFindSalesOfBeerByBrand);
		//Se añade un nuevo menu y submenu
		this.optBeerAdministrator.add(optCreateBeer);
		this.optBeerAdministrator.add(optUpdateBeer);
		this.optBeerAdministrator.add(optFindBeerByBrand);
		//Se añade un nuevo menu y submenu
		this.optImport.add(optImportPlain);
		this.optImport.add(optImportCSV);
		this.optImport.add(optImportJSON);
		this.optImport.add(optImportXML);
		this.optImport.add(optImportSER);
		//Se añade un nuevo menu y submenu
		this.optExport.add(optExportPlain);
		this.optExport.add(optExportCSV);
		this.optExport.add(optExportJSON);
		this.optExport.add(optExportXML);
		this.optExport.add(optExportSER);

		this.add(optUserAdministrator);
		this.add(optBeerAdministrator);
		this.add(optSalesOfBeerAdministrator);
		this.add(optImport);
		this.add(optExport);
		this.add(optReport);		
	}

	private void initComponets() {
		initializeComponents();
		//Configuracion de pantalla
		setUpScreen();
	}

	

	private void initializeComponents() {
		//nuevo menu y submenu
		initializeComponentsMenu6();
		//nuevo menu y submenu
		initializeComponentsMenu5();
		//Segundo menu y submennu
		initializeComponentsMenu1();
		//Tercero menu y  submenu
		initializeComponentsMenu2();
		//Cuarto menu y submenu
		initializeComponentsMenu3();
		//Quinto menu y submenu 
		initializeComponentsMenu4();
		
	}
	
	private void initializeComponentsMenu6() {
		this.optSalesOfBeerAdministrator = new JMenu("Administrar Ventas de Cerveza");
		this.optCreateSaleOfBeer = new JMenuItem("Crear nueva venta");
		//evento
		this.optFindSalesOfBeerByBrand = new JMenuItem("Buscar Venta de cerveza por Marca");
		//evento
		this.optDisplaySalesTable = new JMenuItem("Mostrar tabla de ventas");
		//evento
		
	}

	private void initializeComponentsMenu5() {
		this.optUserAdministrator = new JMenu("Administra Usuario");
		this.optChangeName = new JMenuItem("Cambiar nombre");
		//evento
		this.optChangePassword = new JMenuItem("Cambiar contraseña");
		//evento
		this.optDeleteAccount = new JMenuItem("Eliminar cuenta");
		//evento
		this.optCloseSession = new JMenuItem("Cerrar Secion");
		
	}

	private void initializeComponentsMenu1() {
		this.optBeerAdministrator = new JMenu("Administrar Cerveza");
		this.optCreateBeer = new JMenuItem("Crear Cerveza");
		this.optCreateBeer.setActionCommand(HandlingEventsMainWindow.ADD_BEER);
		this.optCreateBeer.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optUpdateBeer = new JMenuItem("Actualizar Cerveza");
		//evento
		this.optFindBeerByBrand = new JMenuItem("Ver Cervezas por Marca");
		this.optFindBeerByBrand.setActionCommand(HandlingEventsMainWindow.SHOW_BEER_BY_BRAND_WINDOW);
		this.optFindBeerByBrand.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
	}
	
	private void initializeComponentsMenu2() {
		this.optImport = new JMenu("Importar");
		this.optImportPlain = new JMenuItem("Archivo plano");
		this.optImportPlain.setActionCommand(HandlingEventsMainWindow.LOAD_BEER_PLAIN);
		this.optImportPlain.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optImportCSV = new JMenuItem("CSV");
		this.optImportCSV.setActionCommand(HandlingEventsMainWindow.LOAD_BEER_CSV);
		this.optImportCSV.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optImportJSON = new JMenuItem("JSON");
		this.optImportJSON.setActionCommand(HandlingEventsMainWindow.LOAD_BEER_JSON);
		this.optImportJSON.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optImportXML = new JMenuItem("XML");
		this.optImportXML.setActionCommand(HandlingEventsMainWindow.LOAD_BEER_XML);
		this.optImportXML.addActionListener(mainWindow.getHandlingEventsMainWindow());
		this.optImportSER = new JMenuItem("SER");
		this.optImportSER.setActionCommand(HandlingEventsMainWindow.LOAD_BER_SERIALIZATE);
		this.optImportSER.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
	}
	
	private void initializeComponentsMenu3() {
		this.optExport = new JMenu("Exportar");
		this.optExportPlain = new JMenuItem("Plano");
		this.optExportPlain.setActionCommand(HandlingEventsMainWindow.EXPORT_BEER_FILE_PLAIN);
		this.optExportPlain.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optExportCSV = new JMenuItem("CSV");
		this.optExportCSV.setActionCommand(HandlingEventsMainWindow.EXPORT_BEER_CSV);
		this.optExportCSV.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optExportJSON = new JMenuItem("JSON");
		this.optExportJSON.setActionCommand(HandlingEventsMainWindow.EXPORT_BEER_JSON);
		this.optExportJSON.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optExportXML = new JMenuItem("XML");
		this.optExportXML.setActionCommand(HandlingEventsMainWindow.EXPORT_BEER_XML);
		this.optExportXML.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optExportSER = new JMenuItem("SER");
		this.optExportSER.setActionCommand(HandlingEventsMainWindow.EXPORT_BEER_SERIALIZATE);
		this.optExportSER.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
	}
	
	private void initializeComponentsMenu4() {
		this.optReport = new JMenu("Reportes");
	}
	
	private void setUpScreen() {
		//this.setBackground(Color.GRAY);
		
	}
}