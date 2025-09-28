package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.edu.uptc.handlingBeer.enums.ETypeFile;

public class PanelMiddeladdBeerWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/** Etiquetas para que el usuario sepa que debe ingresar*/
	private JLabel jlbrand;
	private JLabel jltype;
	private JLabel jlABV;
	private JLabel jlIBU;
	private JLabel jlProvider;
	private JLabel jlPrice;
	private JLabel jlQuantity;

	private JComboBox<String> comboBoxBrands;
	//private StyledTextField inptbrand;
	private JComboBox<String> comboBoxType;
	private StyledTextField inptABV;
	private JComboBox<String> comboBoxIBU;
	private StyledTextField inptProvider;
	private StyledTextField inptPrice;
	private StyledTextField inptQuantity;

	public PanelMiddeladdBeerWindow() {
		this.initComponets();
		this.addComponents();

	}

	private void addComponents() {
		this.add(jlbrand);
		this.add(comboBoxBrands);
		this.add(jltype);
		this.add(comboBoxType);
		this.add(jlABV);
		this.add(inptABV);
		this.add(jlIBU);
		this.add(comboBoxIBU);
		this.add(jlProvider);
		this.add(inptProvider);
		this.add(jlPrice);
		this.add(inptPrice);
		this.add(jlQuantity);
		this.add(inptQuantity);
		
	}

	private void initComponets() {
		setUpScreen();
		initializeComponents();

	}

	private void initializeComponents() {
		this.jlbrand = new JLabel("Marca de la cerveza");
		String[] brands = {"Poker","Aguilla" ,"Costeña" ,"Corona","Guinness","Budweiser"};
		this.comboBoxBrands = new JComboBox<String>(brands);
		this.jltype = new JLabel("Tipo");
		String[] types = {"Lager","Pilsner" ,"Stout"};
		this.comboBoxType = new JComboBox<>(types);
		this.jlABV = new JLabel("Grado de alcohol por volumen");
		this.inptABV = new StyledTextField(Boolean.FALSE);
		this.jlIBU = new JLabel("Amargor de la cerveza");
		String[] IBU = {"muy baja","baja" ,"media" ,"alta","muy alta"};
		this.comboBoxIBU = new JComboBox<String>(IBU);
		this.jlProvider = new JLabel("Provedor");
		this.inptProvider = new StyledTextField(Boolean.FALSE);
		this.jlPrice = new JLabel("Precio por unidad");
		this.inptPrice = new StyledTextField(Boolean.FALSE);
		this.jlQuantity = new JLabel("Cantidad ingresada");
		this.inptQuantity = new StyledTextField(Boolean.FALSE);
		
	}
	


	private void setUpScreen() {
		setLayout(new GridLayout(14, 1));
		setBorder(new EmptyBorder(0, 20, 15, 20));
		setBackground(Color.WHITE);

	}

	public JLabel getJlbrand() {
		return jlbrand;
	}

	public void setJlbrand(JLabel jlbrand) {
		this.jlbrand = jlbrand;
	}

	public JLabel getJltype() {
		return jltype;
	}

	public void setJltype(JLabel jltype) {
		this.jltype = jltype;
	}

	public JLabel getJlABV() {
		return jlABV;
	}

	public void setJlABV(JLabel jlABV) {
		this.jlABV = jlABV;
	}

	public JLabel getJlIBU() {
		return jlIBU;
	}

	public void setJlIBU(JLabel jlIBU) {
		this.jlIBU = jlIBU;
	}

	public JLabel getJlProvider() {
		return jlProvider;
	}

	public void setJlProvider(JLabel jlProvider) {
		this.jlProvider = jlProvider;
	}

	public JLabel getJlPrice() {
		return jlPrice;
	}

	public void setJlPrice(JLabel jlPrice) {
		this.jlPrice = jlPrice;
	}

	public JLabel getJlQuantity() {
		return jlQuantity;
	}

	public void setJlQuantity(JLabel jlQuantity) {
		this.jlQuantity = jlQuantity;
	}

	public JComboBox<String> getComboBoxBrands() {
		return comboBoxBrands;
	}

	public void setComboBoxBrands(JComboBox<String> comboBoxBrands) {
		this.comboBoxBrands = comboBoxBrands;
	}


	public JComboBox<String> getComboBoxType() {
		return comboBoxType;
	}

	public void setComboBoxType(JComboBox<String> comboBoxType) {
		this.comboBoxType = comboBoxType;
	}

	public StyledTextField getInptABV() {
		return inptABV;
	}

	public void setInptABV(StyledTextField inptABV) {
		this.inptABV = inptABV;
	}

	public JComboBox<String> getComboBoxIBU() {
		return comboBoxIBU;
	}

	public void setComboBoxIBU(JComboBox<String> comboBoxIBU) {
		this.comboBoxIBU = comboBoxIBU;
	}

	public StyledTextField getInptProvider() {
		return inptProvider;
	}

	public void setInptProvider(StyledTextField inptProvider) {
		this.inptProvider = inptProvider;
	}

	public StyledTextField getInptPrice() {
		return inptPrice;
	}

	public void setInptPrice(StyledTextField inptPrice) {
		this.inptPrice = inptPrice;
	}

	public StyledTextField getInptQuantity() {
		return inptQuantity;
	}

	public void setInptQuantity(StyledTextField inptQuantity) {
		this.inptQuantity = inptQuantity;
	}
	
	

	

}
