package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private OptionsBar optionsBar;
	private PanelNorthMainWindow panelNorthMainWindow;
	private PanelMiddleMainWindow panelMiddleMainWindow;
	private PanelButtonMainWindow panelButtonMainWindow;
	private PanelRightButtonMainWindow panelRightButtonMainWindow;

	private AddBeer addBeer;
	/* Clase que va a manejar los eventos de todos los paneles */
	private HandlingEventsMainWindow handlingEventsMainWindow;

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

	}

	/** Metodo que inicializa los comoponentes. */
	private void initializeComponents() {
		this.handlingEventsMainWindow = new HandlingEventsMainWindow(this);
		this.optionsBar = new OptionsBar(this);
		panelNorthMainWindow = new PanelNorthMainWindow();
		panelMiddleMainWindow = new PanelMiddleMainWindow(this);
		panelButtonMainWindow = new PanelButtonMainWindow();
		panelRightButtonMainWindow = new PanelRightButtonMainWindow(this);
		this.panelRightButtonMainWindow.setVisible(false);

		this.addBeer = new AddBeer();
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

	public AddBeer getAddBeer() {
		return addBeer;
	}

	public void setAddBeer(AddBeer addBeer) {
		this.addBeer = addBeer;
	}

	public HandlingEventsMainWindow getHandlingEventsMainWindow() {
		return handlingEventsMainWindow;
	}

	public void setHandlingEventsMainWindow(HandlingEventsMainWindow handlingEventsMainWindow) {
		this.handlingEventsMainWindow = handlingEventsMainWindow;
	}

	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}

}
