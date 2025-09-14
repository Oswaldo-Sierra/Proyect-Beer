package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelSouthAddbeer extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnBack;
	private JButton btnAcept;
	
	public PanelSouthAddbeer() {
		setLayout(new FlowLayout());
		setBorder(new EmptyBorder(0,0,50,0));
		setBackground(Color.WHITE);
		
		this.btnBack = new JButton("Volver atras");
		this.btnAcept = new JButton("Aceptar");
		
		this.add(btnBack);
		this.add(btnAcept);
		
	}

}
