package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ShowBeerbyBrandWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panelNorth;
	private JPanel panelMiddel;
	private JPanel panelSouth;
	private JComboBox<String> comboBoxBrands;
	private JLabel jTitle;
	private JLabel jbAttributes;
	private JButton btnback;
	private JButton btnSearch;
	private MainWindow mainWindow;

	public ShowBeerbyBrandWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.initComponents();
		this.addComponents();
	}

	private void initComponents() {
		setUpScreen();
		initializeComponents();

	}

	private void addComponents() {
		/** Añadir comomentes a los paneles*/
		addComopentsPanels();
		/** Se añaden al frame */
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelMiddel, BorderLayout.CENTER);
		this.add(panelSouth, BorderLayout.SOUTH);

	}

	private void addComopentsPanels() {
		//Componete panel norte
		this.panelNorth.add(jTitle, SwingConstants.CENTER);
		//Comonente panel centro		
		this.panelMiddel.add(jbAttributes);
		this.panelMiddel.add(comboBoxBrands);
		//Comente panel sur
		this.panelSouth.add(btnback);
		this.panelSouth.add(btnSearch);
		
	}

	
	private void initializeComponents() {
		// paneles
		initializePanels();
		// Componentes
		initializeComoponetsPanels();

	}

	private void initializeComoponetsPanels() {
		/** Componentes panel norte */
		this.jTitle = new JLabel("Mostrar cervezas por Marca");
		this.jTitle.setBorder(new EmptyBorder(10, 0, 50, 0));
		this.jTitle.setFont(new Font("Times Roman", Font.BOLD, 25));

		/** Comoponentes panel centro*/
		this.jbAttributes = new JLabel("Selecione la marca a buscar");
		String[] brands = {"Poker","Aguilla" ,"Costeña" ,"Corona","Guinness","Budweiser"};
		this.comboBoxBrands = new JComboBox<String>(brands);
		/** Componentes panel sur*/
		this.btnback = new JButton("Volver");
		this.btnback.setBackground(GUIUtils.getPrincipalColor());
		this.btnback.setFocusable(false);
		btnback.setActionCommand(HandlingEventsMainWindow.HIDE_WINDOW_FIND_BEER);
		btnback.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.btnSearch = new JButton("Buscar");
		this.btnSearch.setBackground(GUIUtils.getPrincipalColor());
		this.btnSearch.setFocusable(false);
		this.btnSearch.setActionCommand(HandlingEventsMainWindow.FIND_BEER_BY_BRAND);
		this.btnSearch.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
	}
	

	private void initializePanels() {
		/** Panel del norte */
		this.panelNorth = new JPanel();
		this.panelNorth.setLayout(new FlowLayout());
		this.panelNorth.setBackground(Color.WHITE);

		/** Panel del centro */
		this.panelMiddel = new JPanel();
		this.panelMiddel.setLayout(new GridLayout(3,1));
		this.panelMiddel.setBorder(new EmptyBorder(0, 15, 0, 15));
		this.panelMiddel.setBackground(Color.WHITE);

		/** Panel del abajo */
		this.panelSouth = new JPanel();
		this.panelSouth.setLayout(new FlowLayout());
		this.panelSouth.setBorder(new EmptyBorder(15, 0, 15, 0));
		this.panelSouth.setBackground(Color.WHITE);
	}

	private void setUpScreen() {
		/** Caracterizticas del frame */
		setSize(500, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

	}
	
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		ShowBeerbyBrandWindow beerbyBrandWindow = new ShowBeerbyBrandWindow(mainWindow);
		beerbyBrandWindow.setVisible(true);
		
	}

	public JPanel getPanelNorth() {
		return panelNorth;
	}

	public void setPanelNorth(JPanel panelNorth) {
		this.panelNorth = panelNorth;
	}

	public JPanel getPanelMiddel() {
		return panelMiddel;
	}

	public void setPanelMiddel(JPanel panelMiddel) {
		this.panelMiddel = panelMiddel;
	}

	public JPanel getPanelSouth() {
		return panelSouth;
	}

	public void setPanelSouth(JPanel panelSouth) {
		this.panelSouth = panelSouth;
	}

	public JComboBox<String> getComboBoxBrands() {
		return comboBoxBrands;
	}

	public void setComboBoxBrands(JComboBox<String> comboBoxBrands) {
		this.comboBoxBrands = comboBoxBrands;
	}

	public JLabel getjTitle() {
		return jTitle;
	}

	public void setjTitle(JLabel jTitle) {
		this.jTitle = jTitle;
	}

	public JLabel getJbAttributes() {
		return jbAttributes;
	}

	public void setJbAttributes(JLabel jbAttributes) {
		this.jbAttributes = jbAttributes;
	}

	public JButton getBtnback() {
		return btnback;
	}

	public void setBtnback(JButton btnback) {
		this.btnback = btnback;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
}
