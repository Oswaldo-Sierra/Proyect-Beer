package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddBeerWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private PanelSouthAddbeer panelSouthAddbeer;
	private JPanel panelNorthAddBeer;
	private JLabel jlTitle;
	private PanelMiddeladdBeerWindow panelMiddeladdBeerWindow;
	private MainWindow mainWindow;
	
	
	public AddBeerWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.initComponets();
		this.addComponents();	
	}
	
	
	
	private void addComponents() {
		addComponentsPanelNorth();
		this.add(panelNorthAddBeer, BorderLayout.NORTH);
		this.add(panelMiddeladdBeerWindow,BorderLayout.CENTER);
		this.add(panelSouthAddbeer , BorderLayout.SOUTH);
		
	}



	private void addComponentsPanelNorth() {
		this.panelNorthAddBeer.add(jlTitle);
	}



	private void initComponets() {
		setUpScreen();
		initializeComponents();
		
	}



	private void initializeComponents() {
		this.panelNorthAddBeer = new JPanel();
		initializeTitle();
		this.panelNorthAddBeer.setBackground(Color.WHITE);
		this.panelMiddeladdBeerWindow = new PanelMiddeladdBeerWindow();
		this.panelSouthAddbeer = new PanelSouthAddbeer(this.mainWindow);
		
	}



	private void initializeTitle() {
		this.jlTitle = new JLabel("Agregar Cerveza");
		Font fontaxu = jlTitle.getFont();
		Font fontTitle = new Font(fontaxu.getName() ,Font.BOLD ,24);
		this.jlTitle.setFont(fontTitle);
		this.jlTitle.setBorder(new EmptyBorder(15,0,15,0));
	}



	private void setUpScreen() {
		// TODO Auto-generated method stub
		/** Tamaño */
		setSize(600,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
	}



	public PanelSouthAddbeer getPanelSouthAddbeer() {
		return panelSouthAddbeer;
	}



	public void setPanelSouthAddbeer(PanelSouthAddbeer panelSouthAddbeer) {
		this.panelSouthAddbeer = panelSouthAddbeer;
	}



	public JPanel getPanelNorthAddBeer() {
		return panelNorthAddBeer;
	}



	public void setPanelNorthAddBeer(JPanel panelNorthAddBeer) {
		this.panelNorthAddBeer = panelNorthAddBeer;
	}



	public JLabel getJlTitle() {
		return jlTitle;
	}



	public void setJlTitle(JLabel jlTitle) {
		this.jlTitle = jlTitle;
	}



	public PanelMiddeladdBeerWindow getPanelMiddeladdBeerWindow() {
		return panelMiddeladdBeerWindow;
	}



	public void setPanelMiddeladdBeerWindow(PanelMiddeladdBeerWindow panelMiddeladdBeerWindow) {
		this.panelMiddeladdBeerWindow = panelMiddeladdBeerWindow;
	}



	public MainWindow getMainWindow() {
		return mainWindow;
	}



	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}



	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		AddBeerWindow addBeer = new AddBeerWindow(mainWindow);
		addBeer.setVisible(true);
	}

}
