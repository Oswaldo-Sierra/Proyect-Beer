package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.edu.uptc.handlingBeer.enums.EAplicationMode;

public class FindBeerWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panelMiddel;
	private JPanel panelNorth;
	private JPanel panelSouth;
	private JComboBox<String> comboBoxAttributes;
	private JLabel jTitle;
	private JLabel jbAttributes;
	private JLabel lbvalue;
	private StyledTextField inputValue;
	private JButton btnback;
	private JButton btnSearch;
	private MainWindow mainWindow;
	private EAplicationMode eAplicationMode = EAplicationMode.BEER_MANAGEMENT;

	public FindBeerWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.initComponents();
		this.addComponents();
	}

	private void initComponents() {
		setUpScreen();
		initializeComponents();

	}

	private void addComponents() {
		/** Añadir comomentes a los paneles */
		addComopentsPanels();
		/** Se añaden al frame */
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelMiddel, BorderLayout.CENTER);
		this.add(panelSouth, BorderLayout.SOUTH);

	}

	private void addComopentsPanels() {
		// Componete panel norte
		this.panelNorth.add(jTitle, SwingConstants.CENTER);
		// Comonente panel centro
		this.panelMiddel.add(jbAttributes);
		this.panelMiddel.add(comboBoxAttributes);
		this.panelMiddel.add(lbvalue);
		this.panelMiddel.add(inputValue);
		// Comente panel sur
		this.panelSouth.add(btnback);
		this.panelSouth.add(btnSearch);

	}

	private void initializeComponents() {
		// paneles
		initializePanels();
		// Componentes
		initializeComoponetsPanels();

		updateForMode(eAplicationMode);
	}

	private void initializePanels() {
		/** Panel del norte */
		this.panelNorth = new JPanel();
		this.panelNorth.setLayout(new FlowLayout());
		this.panelNorth.setBackground(Color.WHITE);

		/** Panel del centro */
		this.panelMiddel = new JPanel();
		this.panelMiddel.setLayout(new GridLayout(5, 1));
		this.panelMiddel.setBorder(new EmptyBorder(0, 50, 0, 50));
		this.panelMiddel.setBackground(Color.WHITE);

		/** Panel del abajo */
		this.panelSouth = new JPanel();
		this.panelSouth.setLayout(new FlowLayout());
		this.panelSouth.setBackground(Color.WHITE);
	}

	private void initializeComoponetsPanels() {
		/** Componentes panel norte */
		this.jTitle = new JLabel("Buscar por Atributo");
		this.jTitle.setBorder(new EmptyBorder(10, 0, 50, 0));
		this.jTitle.setFont(new Font("Times Roman", Font.BOLD, 25));

		/** Comoponentes panel centro */
		this.jbAttributes = new JLabel("Atributo a buscar");
		String options[] = new String[] { "" };
		this.comboBoxAttributes = new JComboBox<String>(options);
		this.lbvalue = new JLabel("Ingrese el valor:");
		this.inputValue = new StyledTextField(Boolean.FALSE);
		/** Componentes panel sur */
		this.btnback = new JButton("Volver");
		this.btnback.setBackground(GUIUtils.getPrincipalColor());
		this.btnback.setFocusable(false);
		this.btnSearch = new JButton("Buscar");
		this.btnSearch.setBackground(GUIUtils.getPrincipalColor());
		this.btnSearch.setFocusable(false);
	}


	public void updateForMode(EAplicationMode mode) {
		this.eAplicationMode = mode;

		clearActionListeners(btnback);
		clearActionListeners(btnSearch);
		if (EAplicationMode.BEER_MANAGEMENT.equals(mode)) {
			searchBeer();
			
		} 
		if (EAplicationMode.SALES_MANAGEMENT.equals(mode)) {
			searchSale();
			
		}
	}
	private void searchBeer() {
		String options[] = new String[] { "Numero de serie", "Marca", "Tipo", "Grado de alcohol por volumen",
				"Amargor de la cerveza", " Provedor ", " Precio ", " Cantidad disponible " };
		this.comboBoxAttributes.setModel(new DefaultComboBoxModel<>(options));
		btnback.setActionCommand(HandlingEventsMainWindow.HIDE_WINDOW_FIND_BEER);
		btnback.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.btnSearch.setActionCommand(HandlingEventsMainWindow.FIND_BEER_BY_ATTRIBUTE);
		this.btnSearch.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		
	}
	
	private void searchSale() {
		String options[] = new String[] { "Id de la venta", "Serial de la cerveza", "Numero de cervezas vendidas",
				"Precio total", "Fecha de la venta(DD/MM/YYYY)", "Nombre de Usuario", "Nombre cliente" };
		this.comboBoxAttributes.setModel(new DefaultComboBoxModel<>(options));
		btnback.setActionCommand(HandlingEventsMainWindow.HIDE_WINDOW_FIND_SALES);
		btnback.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		this.btnSearch.setActionCommand(HandlingEventsMainWindow.FIND_SALES_BY_ATTRIBUTE);
		this.btnSearch.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
	}


	private void clearActionListeners(JButton button) {
	    for (ActionListener listener : button.getActionListeners()) {
	        button.removeActionListener(listener);
	    }
	}

	private void setUpScreen() {
		/** Caracterizticas del frame */
		setSize(600, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

	}

	public void resetFrom() {
		this.inputValue.setText("");
		this.comboBoxAttributes.setSelectedIndex(0);
	}

	public JPanel getPanelMiddel() {
		return panelMiddel;
	}

	public void setPanelMiddel(JPanel panelMiddel) {
		this.panelMiddel = panelMiddel;
	}

	public JPanel getPanelNorth() {
		return panelNorth;
	}

	public void setPanelNorth(JPanel panelNorth) {
		this.panelNorth = panelNorth;
	}

	public JPanel getPanelSouth() {
		return panelSouth;
	}

	public void setPanelSouth(JPanel panelSouth) {
		this.panelSouth = panelSouth;
	}

	public JComboBox<String> getComboBoxAttributes() {
		return comboBoxAttributes;
	}

	public void setComboBoxAttributes(JComboBox<String> comboBoxAttributes) {
		this.comboBoxAttributes = comboBoxAttributes;
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

	public JLabel getJLValue() {
		return lbvalue;
	}

	public void setJLValue(JLabel jbnose) {
		this.lbvalue = jbnose;
	}

	public StyledTextField getInputValue() {
		return inputValue;
	}

	public void setInputValue(StyledTextField inputValue) {
		this.inputValue = inputValue;
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
