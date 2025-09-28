package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelButtonMainWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnSortTable;
	private JButton btnClearTable;
	
	
	public PanelButtonMainWindow() {
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
		
	}

	private void initializeComponents() {
		this.btnSortTable = new JButton("Ordenar tabla");
		this.btnClearTable = new JButton("Limpiar Registro repetidos");
		this.btnClearTable.setFocusable(false);
		this.btnSortTable.setFocusable(false);
		
	}


	private void setUpScreen() {
		setLayout(new FlowLayout());
		setBorder(new EmptyBorder(0,0,20,0));
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
