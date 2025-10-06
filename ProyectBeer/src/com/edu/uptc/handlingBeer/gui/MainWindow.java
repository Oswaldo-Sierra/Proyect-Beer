package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceBeer;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceSalesOfBeer;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private OptionsBar optionsBar;
	private PanelNorthMainWindow panelNorthMainWindow;
	private PanelMiddleMainWindow panelMiddleMainWindow;
	private PanelSouthMainWindow panelSouthMainWindow;
	private PanelRightButtonMainWindow panelRightButtonMainWindow;

	/** Definimos pantalla auxiliar */
	private AddBeerWindow addBeerWindow;
	private AddSalesOfBeerWindow addSalesOfBeerWindow;
	private ShowBeerbyBrandWindow showBeerbyBrandWindow;
	private FindBeerWindow findBeerWindow;
	private ChangeUserComponents changeUserComponents;

	/* Clase que va a manejar los eventos de todos los paneles */
	private HandlingEventsMainWindow handlingEventsMainWindow;
	private HandlingKeyEventsMainWindow handlingKeyEventsMainWindow;

	private HandlingPersistenceBeer handlingPersistenceBeer;
	private HandlingPersistenceSalesOfBeer handlingPersistenceSalesOfBeer;

	public MainWindow() {
		this.initComponets();
		this.addCompenents();
	}

	private void addCompenents() {
		this.add(panelNorthMainWindow, BorderLayout.NORTH);
		this.add(panelMiddleMainWindow, BorderLayout.CENTER);
		this.add(panelSouthMainWindow, BorderLayout.SOUTH);
		this.add(panelRightButtonMainWindow, BorderLayout.EAST);
		this.setJMenuBar(optionsBar);
	}

	private void initComponets() {
		setUpScreen();
		initializeComponents();

	}

	/** Metodo que define al caracterizticas del frame. */
	private void setUpScreen() {
		setSize(1024, 680);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);

	}

	/** Metodo que inicializa los comoponentes. */
	private void initializeComponents() {
		this.handlingEventsMainWindow = new HandlingEventsMainWindow(this);
		this.handlingKeyEventsMainWindow = new HandlingKeyEventsMainWindow(this);
		this.handlingPersistenceBeer = new HandlingPersistenceBeer();
		this.handlingPersistenceBeer.loadFile(ETypeFile.FILE_PLAIN);
		this.handlingPersistenceSalesOfBeer = new HandlingPersistenceSalesOfBeer();
		this.handlingPersistenceSalesOfBeer.loadFile(ETypeFile.FILE_PLAIN);

		this.optionsBar = new OptionsBar(this);
		this.panelNorthMainWindow = new PanelNorthMainWindow(this);
		this.panelMiddleMainWindow = new PanelMiddleMainWindow(this);
		this.panelSouthMainWindow = new PanelSouthMainWindow(this);
		this.panelRightButtonMainWindow = new PanelRightButtonMainWindow(this);
		this.panelRightButtonMainWindow.setVisible(false);

		this.addBeerWindow = new AddBeerWindow(this);
		this.changeUserComponents = new ChangeUserComponents();
		this.addSalesOfBeerWindow = new AddSalesOfBeerWindow(this);
		this.showBeerbyBrandWindow = new ShowBeerbyBrandWindow(this);
		this.findBeerWindow = new FindBeerWindow(this);
	}

	public OptionsBar getOptionsBar() {
		return optionsBar;
	}

	public void setOptionsBar(OptionsBar optionsBar) {
		this.optionsBar = optionsBar;
	}

	public PanelNorthMainWindow getPanelNorthMainWindow() {
		return panelNorthMainWindow;
	}

	public void setPanelNorthMainWindow(PanelNorthMainWindow panelNorthMainWindow) {
		this.panelNorthMainWindow = panelNorthMainWindow;
	}

	public PanelMiddleMainWindow getPanelMiddleMainWindow() {
		return panelMiddleMainWindow;
	}

	public void setPanelMiddleMainWindow(PanelMiddleMainWindow panelMiddleMainWindow) {
		this.panelMiddleMainWindow = panelMiddleMainWindow;
	}

	

	public PanelSouthMainWindow getPanelSouthMainWindow() {
		return panelSouthMainWindow;
	}

	public void setPanelSouthMainWindow(PanelSouthMainWindow panelSouthMainWindow) {
		this.panelSouthMainWindow = panelSouthMainWindow;
	}

	public PanelRightButtonMainWindow getPanelRightButtonMainWindow() {
		return panelRightButtonMainWindow;
	}

	public void setPanelRightButtonMainWindow(PanelRightButtonMainWindow panelRightButtonMainWindow) {
		this.panelRightButtonMainWindow = panelRightButtonMainWindow;
	}

	public AddBeerWindow getAddBeerWindow() {
		return addBeerWindow;
	}

	public void setAddBeerWindow(AddBeerWindow addBeerWindow) {
		this.addBeerWindow = addBeerWindow;
	}

	public HandlingEventsMainWindow getHandlingEventsMainWindow() {
		return handlingEventsMainWindow;
	}

	public void setHandlingEventsMainWindow(HandlingEventsMainWindow handlingEventsMainWindow) {
		this.handlingEventsMainWindow = handlingEventsMainWindow;
	}

	public HandlingPersistenceBeer getHandlingPersistenceBeer() {
		return handlingPersistenceBeer;
	}

	public void setHandlingPersistenceBeer(HandlingPersistenceBeer handlingPersistenceBeer) {
		this.handlingPersistenceBeer = handlingPersistenceBeer;
	}

	public FindBeerWindow getFindBeerWindow() {
		return findBeerWindow;
	}

	public void setFindBeerWindow(FindBeerWindow findBeerWindow) {
		this.findBeerWindow = findBeerWindow;
	}

	public ShowBeerbyBrandWindow getShowBeerbyBrandWindow() {
		return showBeerbyBrandWindow;
	}

	public void setShowBeerbyBrandWindow(ShowBeerbyBrandWindow showBeerbyBrandWindow) {
		this.showBeerbyBrandWindow = showBeerbyBrandWindow;
	}

	public HandlingPersistenceSalesOfBeer getHandlingPersistenceSalesOfBeer() {
		return handlingPersistenceSalesOfBeer;
	}

	public void setHandlingPersistenceSalesOfBeer(HandlingPersistenceSalesOfBeer handlingPersistenceSalesOfBeer) {
		this.handlingPersistenceSalesOfBeer = handlingPersistenceSalesOfBeer;
	}

	public AddSalesOfBeerWindow getAddSalesOfBeerWindow() {
		return addSalesOfBeerWindow;
	}

	public void setAddSalesOfBeerWindow(AddSalesOfBeerWindow addSalesOfBeerWindow) {
		this.addSalesOfBeerWindow = addSalesOfBeerWindow;
	}

	public ChangeUserComponents getChangeUserComponents() {
		return changeUserComponents;
	}

	public void setChangeUserComponents(ChangeUserComponents changeUserComponents) {
		this.changeUserComponents = changeUserComponents;
	}

	public HandlingKeyEventsMainWindow getHandlingKeyEventsMainWindow() {
		return handlingKeyEventsMainWindow;
	}

	public void setHandlingKeyEventsMainWindow(HandlingKeyEventsMainWindow handlingKeyEventsMainWindow) {
		this.handlingKeyEventsMainWindow = handlingKeyEventsMainWindow;
	}

	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}

}
