package com.edu.uptc.handlingBeer.gui;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelNorthMainWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel lblTitleMainWindow;
	private JButton btnFindBy;
	
	public PanelNorthMainWindow() {
		this.lblTitleMainWindow = new JLabel("ADMINISTRACIÓN DE CONTACTOS");
		Font actualFont = this.lblTitleMainWindow.getFont();
		Font fontTitle = new Font(actualFont.getName(), Font.BOLD, 24);
		
		this.btnFindBy = new JButton("Buscar por:");
		this.lblTitleMainWindow.setBorder(new EmptyBorder(0, 0, 0, 80));
		this.lblTitleMainWindow.setFont(fontTitle);
		this.setLayout(new FlowLayout());
		this.add(this.lblTitleMainWindow);
		this.add(btnFindBy);
	}
}
