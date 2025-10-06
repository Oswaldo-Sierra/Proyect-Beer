package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.edu.uptc.handlingBeer.enums.EAplicationMode;

public class PanelRightButtonMainWindow extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton acully;
	private JButton showMore;
	private JButton delete;
	private JPanel panelSeparator1;
	private JPanel panelSeparator2;
	private MainWindow mainWindow;
	private EAplicationMode aplicationMode = EAplicationMode.BEER_MANAGEMENT;

	public PanelRightButtonMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.initComponets();
		this.addComponents();
	}

	private void addComponents() {
		this.add(showMore);
		this.add(panelSeparator1);
		this.add(acully);
		this.add(panelSeparator2);
		this.add(delete);

	}

	private void initComponets() {
		setUpScreen();
		initializeComponents();
		setupForMode(aplicationMode);
	}

	private void initializeComponents() {
		// primer botón
		this.showMore = new JButton("Ver más");
		this.showMore.setBackground(GUIUtils.getPrincipalColor());
		this.showMore.setFocusable(false);
		

		// segundo botón
		this.acully = new JButton("Actualizar");
		this.acully.setBackground(GUIUtils.getPrincipalColor());
		this.acully.setFocusable(false);
		

		// tercer botón
		this.delete = new JButton("Eliminar");
		this.delete.setBackground(GUIUtils.getPrincipalColor());
		this.delete.setFocusable(false);
		

		this.panelSeparator1 = new JPanel();
		this.panelSeparator1.setBackground(Color.WHITE);
		this.panelSeparator2 = new JPanel();
		this.panelSeparator2.setBackground(Color.WHITE);
	}

	public void setupForMode(EAplicationMode mode) {
		this.aplicationMode = mode;

		// limpiar listeners viejos
		clearActionListeners(showMore);
		clearActionListeners(acully);
		clearActionListeners(delete);

		if (EAplicationMode.BEER_MANAGEMENT.equals(mode)) {
			// acciones de los botones por el modo
			this.showMore.setActionCommand(HandlingEventsMainWindow.SEE_MORE_BEER);
			this.showMore.addActionListener(mainWindow.getHandlingEventsMainWindow());
			this.acully.setActionCommand(HandlingEventsMainWindow.UDATE_BEER);
			this.acully.addActionListener(mainWindow.getHandlingEventsMainWindow());
			this.delete.setActionCommand(HandlingEventsMainWindow.DELETE_BEER);
			this.delete.addActionListener(mainWindow.getHandlingEventsMainWindow());
		}
		if (EAplicationMode.SALES_MANAGEMENT.equals(mode)) {
			this.showMore.setActionCommand(HandlingEventsMainWindow.SEE_MORE_SALES);
			this.showMore.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
			this.acully.setActionCommand(HandlingEventsMainWindow.UDATE_SALES);
			this.acully.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
			this.delete.setActionCommand(HandlingEventsMainWindow.DELETE_SALES);
			this.delete.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		}
	}

	private void clearActionListeners(JButton button) {
		for (var listener : button.getActionListeners()) {
			button.removeActionListener(listener);
		}
	}

	private void setUpScreen() {
		setLayout(new GridLayout(14, 1));
		setBorder(new EmptyBorder(200, 5, 20, 15));
		setBackground(Color.WHITE);

	}

	public JButton getAcully() {
		return acully;
	}

	public void setAcully(JButton acully) {
		this.acully = acully;
	}

	public JButton getShowMore() {
		return showMore;
	}

	public void setShowMore(JButton showMore) {
		this.showMore = showMore;
	}

	public JButton getDelate() {
		return delete;
	}

	public void setDelate(JButton delate) {
		this.delete = delate;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

}
