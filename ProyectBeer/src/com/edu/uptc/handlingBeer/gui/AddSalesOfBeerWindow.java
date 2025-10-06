package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddSalesOfBeerWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private PanelSouthAddSale panelSouthAddSale;
	private JPanel panelNorthAddBeer;
	private JLabel jlTitle;
	private PanelMiddelAddSaleWindow panelMiddelAddSalesWindow;
	private MainWindow mainWindow;

	public AddSalesOfBeerWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.initComponets();
		this.addComponents();
	}

	private void addComponents() {
		addComponentsPanelNorth();
		this.add(panelNorthAddBeer, BorderLayout.NORTH);
		this.add(panelMiddelAddSalesWindow, BorderLayout.CENTER);
		this.add(panelSouthAddSale, BorderLayout.SOUTH);

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
		this.panelMiddelAddSalesWindow = new PanelMiddelAddSaleWindow();
		this.panelSouthAddSale = new PanelSouthAddSale(this.mainWindow);

	}

	private void initializeTitle() {
		this.jlTitle = new JLabel("Agregar Venta");
		Font fontaxu = jlTitle.getFont();
		Font fontTitle = new Font(fontaxu.getName(), Font.BOLD, 24);
		this.jlTitle.setFont(fontTitle);
		this.jlTitle.setBorder(new EmptyBorder(15, 0, 15, 0));
	}

	private void setUpScreen() {
		// TODO Auto-generated method stub
		/** Tamaño */
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
	}

	public JLabel getJlTitle() {
		return jlTitle;
	}

	public void setJlTitle(JLabel jlTitle) {
		this.jlTitle = jlTitle;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public PanelSouthAddSale getPanelSouthAddSale() {
		return panelSouthAddSale;
	}

	public void setPanelSouthAddSale(PanelSouthAddSale panelSouthAddSale) {
		this.panelSouthAddSale = panelSouthAddSale;
	}

	public JPanel getPanelNorthAddBeer() {
		return panelNorthAddBeer;
	}

	public void setPanelNorthAddBeer(JPanel panelNorthAddBeer) {
		this.panelNorthAddBeer = panelNorthAddBeer;
	}

	public PanelMiddelAddSaleWindow getPanelMiddelAddSalesWindow() {
		return panelMiddelAddSalesWindow;
	}

	public void setPanelMiddelAddSalesWindow(PanelMiddelAddSaleWindow panelMiddelAddSalesWindow) {
		this.panelMiddelAddSalesWindow = panelMiddelAddSalesWindow;
	}

	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		AddSalesOfBeerWindow addBeer = new AddSalesOfBeerWindow(mainWindow);
		addBeer.setVisible(true);
	}

}
