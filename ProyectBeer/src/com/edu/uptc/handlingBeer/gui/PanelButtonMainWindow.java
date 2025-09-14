package com.edu.uptc.handlingBeer.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelButtonMainWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton btnSortTable;
	private JButton btnClearTable;
	
	
	public PanelButtonMainWindow() {
		setLayout(new FlowLayout());
		setBorder(new EmptyBorder(0,0,20,0));
		//setPreferredSize(new Dimension(200,100));
		this.btnSortTable = new JButton("Ordenar tabla");
		this.btnClearTable = new JButton("Limpiar Registro repetidos");
		this.btnClearTable.setFocusable(false);
		this.btnSortTable.setFocusable(false);
		
		this.add(btnSortTable);
		this.add(btnClearTable);
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
