package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceBeer;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private OptionsBar optionsBar;
	private PanelNorthMainWindow panelNorthMainWindow;
	private PanelMiddleMainWindow panelMiddleMainWindow;
	private PanelButtonMainWindow panelButtonMainWindow;
	private PanelRightButtonMainWindow panelRightButtonMainWindow;

	/** Definimos pantalla auxiliar*/
	private AddBeerWindow addBeerWindow;
	private ShowBeerbyBrandWindow showBeerbyBrandWindow;
	private FindBeerWindow findBeerWindow;
	
	/* Clase que va a manejar los eventos de todos los paneles */
	private HandlingEventsMainWindow handlingEventsMainWindow;
	
	private HandlingPersistenceBeer handlingPersistenceBeer;

	public MainWindow() {
		this.initComponets();
		this.addCompenents();
	}

	private void addCompenents() {
		this.add(panelNorthMainWindow, BorderLayout.NORTH);
		this.add(panelMiddleMainWindow, BorderLayout.CENTER);
		this.add(panelButtonMainWindow, BorderLayout.SOUTH);
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
		//setBackground(Color.WHITE);

	}

	/** Metodo que inicializa los comoponentes. */
	private void initializeComponents() {
		this.handlingEventsMainWindow = new HandlingEventsMainWindow(this);
		this.handlingPersistenceBeer = new HandlingPersistenceBeer();
		this.handlingPersistenceBeer.loadFile(ETypeFile.FILE_PLAIN);
		
		this.optionsBar = new OptionsBar(this);
		this.panelNorthMainWindow = new PanelNorthMainWindow(this);
		this.panelMiddleMainWindow = new PanelMiddleMainWindow(this);
		this.panelButtonMainWindow = new PanelButtonMainWindow();
		this.panelRightButtonMainWindow = new PanelRightButtonMainWindow(this);
		this.panelRightButtonMainWindow.setVisible(false);
		
		this.addBeerWindow = new AddBeerWindow(this);
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

	public PanelButtonMainWindow getPanelButtonMainWindow() {
		return panelButtonMainWindow;
	}

	public void setPanelButtonMainWindow(PanelButtonMainWindow panelButtonMainWindow) {
		this.panelButtonMainWindow = panelButtonMainWindow;
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

	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}

}
