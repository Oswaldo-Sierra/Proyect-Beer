package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelAddBeerWindow extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel jlserialNumber;
	private JLabel jlbrand;
	private JLabel jltype;
	private JLabel jlABV;
	private JLabel jlIBU;
	private JLabel jlorigin;
	
	private StyledTextField inptSerialNumber;
	private StyledTextField inptbrand;
	private StyledTextField inptType;
	private StyledTextField inptABV;
	private StyledTextField inptIBU;
	private StyledTextField inptOrigin;
	
	public PanelAddBeerWindow() {
		setLayout(new GridLayout(12,1));
		setBorder(new EmptyBorder(0,15,50,15));
		setBackground(Color.WHITE);
		this.jlserialNumber = new JLabel("Numero de serie");
		this.jlbrand = new JLabel("Marca de la cerveza");
		this.jltype = new JLabel("Tipo");
		this.jlABV = new JLabel("Grado de alcohol por volumen");
		this.jlIBU = new JLabel("Amargor de la cerveza");
		this.jlorigin = new JLabel("Origen");
		
		this.inptSerialNumber = new StyledTextField(Boolean.FALSE);
		this.inptbrand = new StyledTextField(Boolean.FALSE);
		this.inptType = new StyledTextField(Boolean.FALSE);
		this.inptABV = new StyledTextField(Boolean.FALSE);
		this.inptIBU = new StyledTextField(Boolean.FALSE);
		this.inptOrigin = new StyledTextField(Boolean.FALSE);
		
		this.add(this.jlserialNumber);
		this.add(this.inptSerialNumber);
		this.add(this.jlbrand);
		this.add(this.inptbrand);
		this.add(this.jltype);
		this.add(this.inptType);
		this.add(this.jlABV);
		this.add(this.inptABV);
		this.add(this.jlIBU);
		this.add(this.inptIBU);
		this.add(this.jlorigin);
		this.add(this.inptOrigin);
		
	}

}
