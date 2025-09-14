package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddBeer extends JFrame{
	private static final long serialVersionUID = 1L;
	private PanelSouthAddbeer panelSouthAddbeer;
	private JLabel jlTitle;
	private PanelAddBeerWindow panelAddBeerWindow;
	public AddBeer() {
		/** Tamaño */
		setSize(600,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		

		
		this.panelSouthAddbeer = new PanelSouthAddbeer();
		
		
		JPanel panelAxu = new JPanel();
		
		this.jlTitle = new JLabel("Agregar Cerveza");
		Font fontaxu = jlTitle.getFont();
		Font fontTitle = new Font(fontaxu.getName() ,Font.BOLD ,24);
		this.jlTitle.setFont(fontTitle);
		this.jlTitle.setBorder(new EmptyBorder(15,0,15,0));
		
		panelAxu.add(this.jlTitle);
		panelAxu.setBackground(Color.WHITE);
		
		this.panelAddBeerWindow = new PanelAddBeerWindow();
		
		
		this.add(panelSouthAddbeer , BorderLayout.SOUTH);
		this.add(panelAxu, BorderLayout.NORTH);
		this.add(panelAddBeerWindow,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		AddBeer addBeer = new AddBeer();
		addBeer.setVisible(true);
	}

}
