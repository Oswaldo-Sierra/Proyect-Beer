package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.edu.uptc.handlingBeer.enums.EAplicationMode;

public class PanelSouthMainWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnSortTable;
	private JButton btnClearTable;
	private MainWindow mainWindow;
	private EAplicationMode aplicationMode = EAplicationMode.BEER_MANAGEMENT;

	public PanelSouthMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.initComponets();
		this.addComponents();
	}

	private void addComponents() {
		this.add(btnSortTable);
		this.add(btnClearTable);

	}

	private void initComponets() {
		setUpScreen();
		initializeComponents();
		updateForMode(aplicationMode);
	}

	private void initializeComponents() {
		this.btnSortTable = new JButton("Ordenar tabla");
		this.btnSortTable.setBackground(GUIUtils.getPrincipalColor());

		this.btnSortTable.setFocusable(false);
		this.btnClearTable = new JButton("Limpiar Registro repetidos");
		this.btnClearTable.setBackground(GUIUtils.getPrincipalColor());
		this.btnClearTable.setFocusable(false);
	}

	public void updateForMode(EAplicationMode mode) {
		this.aplicationMode = mode;

		if (EAplicationMode.BEER_MANAGEMENT.equals(mode)) {
			this.btnSortTable.setActionCommand(HandlingEventsMainWindow.SORT_TABLE_BEER);
			this.btnSortTable.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		}
		if (EAplicationMode.SALES_MANAGEMENT.equals(mode)) {
			this.btnSortTable.setActionCommand(HandlingEventsMainWindow.SORT_TABLE_SALES);
			this.btnSortTable.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		}
	}

	private void setUpScreen() {
		setLayout(new FlowLayout());
		setBorder(new EmptyBorder(0, 0, 20, 0));
		setBackground(Color.WHITE);
	}

	public JButton getBtnSortTable() {
		return btnSortTable;
	}

	public void setBtnSortTable(JButton btnSortTable) {
		this.btnSortTable = btnSortTable;
	}

	public JButton getBtnClearTable() {
		return btnClearTable;
	}

	public void setBtnClearTable(JButton btnClearTable) {
		this.btnClearTable = btnClearTable;
	}

}
