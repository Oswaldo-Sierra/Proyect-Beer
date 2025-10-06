package com.edu.uptc.handlingBeer.gui;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.edu.uptc.handlingBeer.enums.EAplicationMode;

public class OptionsBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	/** Definicion de los menus */
	private JMenu optUserAdministrator;
	private JMenu optBeerAdministrator;
	private JMenu optSalesOfBeerAdministrator;
	private JMenu optImport;
	private JMenu optExport;
	private JMenu optReport;

	/** Submenu de administra ventas */
	private JMenuItem optCreateSaleOfBeer;
	private JMenuItem optDisplaySalesTable;

	/** Submenu de Amdinistra Usuario */
	private JMenuItem optChangeName;
	private JMenuItem optChangePassword;
	private JMenuItem optDeleteAccount;
	private JMenuItem optCloseSession;

	/** submenu del administrar cerveza */
	private JMenuItem optCreateBeer;
	private JMenuItem optDisplayBeerTable;
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

	private EAplicationMode aplicationMode = EAplicationMode.BEER_MANAGEMENT;
	private MainWindow mainWindow;

	public OptionsBar(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		this.initComponets();
		this.addComponents();
	}

	private void addComponents() {
		// Se añade un nuevo menu y submenu
		this.optUserAdministrator.add(optChangeName);
		this.optUserAdministrator.add(optChangePassword);
		this.optUserAdministrator.add(optDeleteAccount);
		this.optUserAdministrator.add(optCloseSession);
		// Se añade un nuevo menu y submenu
		this.optSalesOfBeerAdministrator.add(optCreateSaleOfBeer);
		this.optSalesOfBeerAdministrator.add(optDisplaySalesTable);
		// Se añade un nuevo menu y submenu
		this.optBeerAdministrator.add(optCreateBeer);
		this.optBeerAdministrator.add(optDisplayBeerTable);
		this.optBeerAdministrator.add(optFindBeerByBrand);
		// Se añade un nuevo menu y submenu

		// Se añade un nuevo menu y submenu

		this.add(optUserAdministrator);
		this.add(optBeerAdministrator);
		this.add(optSalesOfBeerAdministrator);
		this.add(optImport);
		this.add(optExport);
		this.add(optReport);
	}

	private void initComponets() {
		initializeComponents();
		// Configuracion de pantalla
		setUpScreen();
	}

	private void initializeComponents() {

		// nuevo menu y submenu
		initializeComponentsMenu6();
		// nuevo menu y submenu
		initializeComponentsMenu5();
		// Segundo menu y submennu
		initializeComponentsMenu1();
		// Quinto menu y submenu
		initializeComponentsMenu4();

		this.optImport = new JMenu();
		this.optExport = new JMenu();
		this.updateForMode(aplicationMode);

	}

	private void initializeComponentsMenu5() {
		this.optUserAdministrator = new JMenu("Administra Usuario");
		this.optUserAdministrator.setIcon(new ImageIcon("resources/img/icons/AdminUser.png"));
		this.optUserAdministrator.setForeground(GUIUtils.getNeutralColor());
		this.optChangeName = new JMenuItem("Cambiar nombre");
		this.optChangeName.setIcon(new ImageIcon("resources/img/icons/ChangeUserName.png"));
		this.optChangeName.setActionCommand(HandlingEventsMainWindow.CHANGE_USERNAME);
		this.optChangeName.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optChangePassword = new JMenuItem("Cambiar contraseña");
		this.optChangePassword.setIcon(new ImageIcon("resources/img/icons/ChangePassword.png"));
		this.optChangePassword.setActionCommand(HandlingEventsMainWindow.CHANGE_PASSWORD);
		this.optChangePassword.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optDeleteAccount = new JMenuItem("Eliminar cuenta");
		this.optDeleteAccount.setIcon(new ImageIcon("resources/img/icons/deleteAccount.png"));
		this.optDeleteAccount.setActionCommand(HandlingEventsMainWindow.DELETE_ACCOUNT);
		this.optDeleteAccount.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optCloseSession = new JMenuItem("Cerrar sesión");
		this.optCloseSession.setActionCommand(HandlingEventsMainWindow.LOG_OUT);
		this.optCloseSession.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optCloseSession.setIcon(new ImageIcon("resources/img/icons/closeSesion.png"));
	}

	private void initializeComponentsMenu1() {
		this.optBeerAdministrator = new JMenu("Administrar Cerveza");
		this.optBeerAdministrator.setIcon(new ImageIcon("resources/img/icons/AdminBeer.png"));
		this.optBeerAdministrator.setForeground(GUIUtils.getNeutralColor());
		this.optCreateBeer = new JMenuItem("Agregar Cerveza");
		this.optCreateBeer.setIcon(new ImageIcon("resources/img/icons/AddBeer.png"));
		this.optCreateBeer.setActionCommand(HandlingEventsMainWindow.ADD_BEER);
		this.optCreateBeer.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optDisplayBeerTable = new JMenuItem("Mostrar tabla de Cerveza");
		this.optDisplayBeerTable.setActionCommand(HandlingEventsMainWindow.SHOW_BEER_TABLE);
		this.optDisplayBeerTable.setIcon(new ImageIcon("resources/img/icons/tableBeer.png"));
		this.optDisplayBeerTable.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optFindBeerByBrand = new JMenuItem("Ver Cervezas por Marca");
		this.optFindBeerByBrand.setIcon(new ImageIcon("resources/img/icons/BeerBybrand.png"));
		this.optFindBeerByBrand.setActionCommand(HandlingEventsMainWindow.SHOW_BEER_BY_BRAND_WINDOW);
		this.optFindBeerByBrand.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
	}

	private void initializeComponentsMenu6() {
		this.optSalesOfBeerAdministrator = new JMenu("Administrar Ventas de Cerveza");
		this.optSalesOfBeerAdministrator.setIcon(new ImageIcon("resources/img/icons/AdminSaleOfBeer.png"));
		this.optSalesOfBeerAdministrator.setForeground(GUIUtils.getNeutralColor());
		this.optCreateSaleOfBeer = new JMenuItem("Crear venta");
		this.optCreateSaleOfBeer.setIcon(new ImageIcon("resources/img/icons/addSales.png"));
		this.optCreateSaleOfBeer.setActionCommand(HandlingEventsMainWindow.ADD_SALE);
		this.optCreateSaleOfBeer.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optDisplaySalesTable = new JMenuItem("Mostrar tabla de Ventas");
		this.optDisplaySalesTable.setActionCommand(HandlingEventsMainWindow.SHOW_SALES_TABLE);
		this.optDisplaySalesTable.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.optDisplaySalesTable.setIcon(new ImageIcon("resources/img/icons/tableSale.png"));

	}

	public void updateForMode(EAplicationMode mode) {
		this.aplicationMode = mode;
		// Limpiar ítems previos
		optImport.removeAll();
		optExport.removeAll();

		if (mode == EAplicationMode.BEER_MANAGEMENT) {
			importBeer();
			exportBeer();

		} else if (mode == EAplicationMode.SALES_MANAGEMENT) {
			importSalesOfBeer();
			exportSaleOfBeer();
		}

		revalidate();
		repaint();
	}

	private void importBeer() {
		this.optImport.setText("Importar Cervezas");
		this.optImport.setIcon(new ImageIcon("resources/img/icons/load.png"));
		this.optImport.setForeground(GUIUtils.getNeutralColor()); // ← color letra menú

		this.optImportPlain = new JMenuItem("Archivo plano");
		this.optImportPlain.setIcon(new ImageIcon("resources/img/icons/filePlain.png"));
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

		this.optImportPlain.setIcon(new ImageIcon("resources/img/icons/filePlain.png"));
		this.optImportCSV.setIcon(new ImageIcon("resources/img/icons/fileExcel.png"));
		this.optImportJSON.setIcon(new ImageIcon("resources/img/icons/fileJSON.png"));
		this.optImportXML.setIcon(new ImageIcon("resources/img/icons/fileXML.png"));
		this.optImportSER.setIcon(new ImageIcon("resources/img/icons/fileSer.png"));

		this.optImport.add(optImportPlain);
		this.optImport.add(optImportCSV);
		this.optImport.add(optImportJSON);
		this.optImport.add(optImportXML);
		this.optImport.add(optImportSER);
	}

	private void exportBeer() {
		this.optExport.setText("Exportar Cervezas");
		this.optExport.setForeground(GUIUtils.getNeutralColor()); // ← color letra menú
		this.optExport.setIcon(new ImageIcon("resources/img/icons/dump.png"));

		this.optExportPlain = new JMenuItem("Archivo Plano");
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

		this.optExportPlain.setIcon(new ImageIcon("resources/img/icons/filePlain.png"));
		this.optExportCSV.setIcon(new ImageIcon("resources/img/icons/fileExcel.png"));
		this.optExportJSON.setIcon(new ImageIcon("resources/img/icons/fileJSON.png"));
		this.optExportXML.setIcon(new ImageIcon("resources/img/icons/fileXML.png"));
		this.optExportSER.setIcon(new ImageIcon("resources/img/icons/fileSer.png"));

		this.optExport.add(optExportPlain);
		this.optExport.add(optExportCSV);
		this.optExport.add(optExportJSON);
		this.optExport.add(optExportXML);
		this.optExport.add(optExportSER);
	}

	private void importSalesOfBeer() {
		this.optImport.setText("Importar Ventas");
		this.optImport.setForeground(GUIUtils.getNeutralColor()); // ← color letra menú

		this.optImportPlain = new JMenuItem("Archivo plano");
		this.optImportPlain.setActionCommand(HandlingEventsMainWindow.LOAD_SALE_PLAIN);
		this.optImportPlain.addActionListener(this.mainWindow.getHandlingEventsMainWindow());

		this.optImportCSV = new JMenuItem("CSV");
		this.optImportCSV.setActionCommand(HandlingEventsMainWindow.LOAD_SALE_CSV);
		this.optImportCSV.addActionListener(this.mainWindow.getHandlingEventsMainWindow());

		this.optImportJSON = new JMenuItem("JSON");
		this.optImportJSON.setActionCommand(HandlingEventsMainWindow.LOAD_SALE_JSON);
		this.optImportJSON.addActionListener(this.mainWindow.getHandlingEventsMainWindow());

		this.optImportXML = new JMenuItem("XML");
		this.optImportXML.setActionCommand(HandlingEventsMainWindow.LOAD_SALE_XML);
		this.optImportXML.addActionListener(mainWindow.getHandlingEventsMainWindow());

		this.optImportSER = new JMenuItem("SER");
		this.optImportSER.setActionCommand(HandlingEventsMainWindow.LOAD_SALE_SERIALIZATE);
		this.optImportSER.addActionListener(this.mainWindow.getHandlingEventsMainWindow());

		this.optImportPlain.setIcon(new ImageIcon("resources/img/icons/filePlain.png"));
		this.optImportCSV.setIcon(new ImageIcon("resources/img/icons/fileExcel.png"));
		this.optImportJSON.setIcon(new ImageIcon("resources/img/icons/fileJSON.png"));
		this.optImportXML.setIcon(new ImageIcon("resources/img/icons/fileXML.png"));
		this.optImportSER.setIcon(new ImageIcon("resources/img/icons/fileSer.png"));

		this.optImport.add(optImportPlain);
		this.optImport.add(optImportCSV);
		this.optImport.add(optImportJSON);
		this.optImport.add(optImportXML);
		this.optImport.add(optImportSER);
	}

	private void exportSaleOfBeer() {
		this.optExport.setText("Exportar Cervezas");
		this.optExport.setIcon(new ImageIcon("resources/img/icons/dump.png"));
		this.optExport.setForeground(GUIUtils.getNeutralColor()); // ← color letra menú

		this.optExportPlain = new JMenuItem("Plano");
		this.optExportPlain.setActionCommand(HandlingEventsMainWindow.EXPORT_SALE_FILE_PLAIN);
		this.optExportPlain.addActionListener(this.mainWindow.getHandlingEventsMainWindow());

		this.optExportCSV = new JMenuItem("CSV");
		this.optExportCSV.setActionCommand(HandlingEventsMainWindow.EXPORT_SALE_CSV);
		this.optExportCSV.addActionListener(this.mainWindow.getHandlingEventsMainWindow());

		this.optExportJSON = new JMenuItem("JSON");
		this.optExportJSON.setActionCommand(HandlingEventsMainWindow.EXPORT_SALE_JSON);
		this.optExportJSON.addActionListener(this.mainWindow.getHandlingEventsMainWindow());

		this.optExportXML = new JMenuItem("XML");
		this.optExportXML.setActionCommand(HandlingEventsMainWindow.EXPORT_SALE_XML);
		this.optExportXML.addActionListener(this.mainWindow.getHandlingEventsMainWindow());

		this.optExportSER = new JMenuItem("SER");
		this.optExportSER.setActionCommand(HandlingEventsMainWindow.EXPORT_SALE_SERIALIZATE);
		this.optExportSER.addActionListener(this.mainWindow.getHandlingEventsMainWindow());

		this.optExportPlain.setIcon(new ImageIcon("resources/img/icons/filePlain.png"));
		this.optExportCSV.setIcon(new ImageIcon("resources/img/icons/fileExcel.png"));
		this.optExportJSON.setIcon(new ImageIcon("resources/img/icons/fileJSON.png"));
		this.optExportXML.setIcon(new ImageIcon("resources/img/icons/fileXML.png"));
		this.optExportSER.setIcon(new ImageIcon("resources/img/icons/fileSer.png"));

		this.optExport.add(optExportPlain);
		this.optExport.add(optExportCSV);
		this.optExport.add(optExportJSON);
		this.optExport.add(optExportXML);
		this.optExport.add(optExportSER);
	}

	private void initializeComponentsMenu4() {
		this.optReport = new JMenu("Informes");
		this.optReport.setIcon(new ImageIcon("resources/img/icons/reports.png"));
	}

	private void setUpScreen() {
//		this.setBackground(GUIUtils.getPrincipalColor());
//		this.setForeground(GUIUtils.getNeutralColor());
	}
}