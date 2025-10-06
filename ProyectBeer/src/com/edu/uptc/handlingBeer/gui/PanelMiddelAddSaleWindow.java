package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelMiddelAddSaleWindow extends JPanel {
private static final long serialVersionUID = 1L;
	
	/** Etiquetas para que el usuario sepa que debe ingresar*/
	private JLabel jlBrandSerial;
	private JLabel jlNumberSold;
	private JLabel jlNameCustomer;
	
	private JComboBox<String> comboBoxBrandSerial;
	private StyledTextField inptNumberSold;
	private StyledTextField inptNameCustomer;


	public PanelMiddelAddSaleWindow() {
		this.initComponets();
		this.addComponents();

	}

	private void addComponents() {
		this.add(jlBrandSerial);
		this.add(comboBoxBrandSerial);
		this.add(jlNumberSold);
		this.add(inptNumberSold);
		this.add(jlNameCustomer);
		this.add(inptNameCustomer);
	}

	private void initComponets() {
		setUpScreen();
		initializeComponents();

	}

	private void initializeComponents() {
		this.jlBrandSerial = new JLabel("Marca-serial");
		String[] brandsSerial = {""};
		this.comboBoxBrandSerial = new JComboBox<String>(brandsSerial);
		this.jlNumberSold = new JLabel("Numero de cerveza a vender");
		this.inptNumberSold = new StyledTextField(Boolean.FALSE);
		this.jlNameCustomer = new JLabel("Nombre del Comprador");
		this.inptNameCustomer = new StyledTextField(Boolean.FALSE);
	}
	


	private void setUpScreen() {
		setLayout(new GridLayout(6, 1));
		setBorder(new EmptyBorder(0, 20, 15, 20));
		setBackground(Color.WHITE);

	}

	public JLabel getJlBrandSerial() {
		return jlBrandSerial;
	}

	public void setJlBrandSerial(JLabel jlBrandSerial) {
		this.jlBrandSerial = jlBrandSerial;
	}

	public JLabel getJlNumberSold() {
		return jlNumberSold;
	}

	public void setJlNumberSold(JLabel jlNumberSold) {
		this.jlNumberSold = jlNumberSold;
	}

	public JLabel getJlNameCustomer() {
		return jlNameCustomer;
	}

	public void setJlNameCustomer(JLabel jlNameCustomer) {
		this.jlNameCustomer = jlNameCustomer;
	}

	public JComboBox<String> getComboBoxBrandSerial() {
		return comboBoxBrandSerial;
	}

	public void setComboBoxBranSerial(JComboBox<String> comboBoxBrandSerial) {
		this.comboBoxBrandSerial = comboBoxBrandSerial;
	}

	public StyledTextField getInptNumberSold() {
		return inptNumberSold;
	}

	public void setInptNumberSold(StyledTextField inptNumberSold) {
		this.inptNumberSold = inptNumberSold;
	}

	public StyledTextField getInptNameCustomer() {
		return inptNameCustomer;
	}

	public void setInptNameCustomer(StyledTextField inptNameCustomer) {
		this.inptNameCustomer = inptNameCustomer;
	}
	
	

}
