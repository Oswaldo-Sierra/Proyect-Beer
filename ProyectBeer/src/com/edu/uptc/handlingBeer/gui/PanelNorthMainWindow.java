package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
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
	private MainWindow mainWindow;
	
	public PanelNorthMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.initComponets();
		this.addComponents();
	}

	
	
	private void addComponents() {
		this.add(this.lblTitleMainWindow);
		this.add(btnFindBy);
		
	}
	
	private void initComponets() {
		setUpScreen();
		initializeComponents();
		
	}

	private void initializeComponents() {
		this.lblTitleMainWindow = new JLabel("ADMINISTRACIÓN DE CERVEZAS");
		Font actualFont = this.lblTitleMainWindow.getFont();
		Font fontTitle = new Font(actualFont.getName(), Font.BOLD, 24);
		this.lblTitleMainWindow.setBorder(new EmptyBorder(0, 0, 0, 80));
		this.lblTitleMainWindow.setFont(fontTitle);
		
		this.btnFindBy = new JButton("Buscar por:");
		this.btnFindBy.setActionCommand(HandlingEventsMainWindow.SHOW_WINDOW_SEARCH_BEER);
		this.btnFindBy.addActionListener(this.mainWindow.getHandlingEventsMainWindow());;
		
	}

	private void setUpScreen() {
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
	}

	
	
	
}
