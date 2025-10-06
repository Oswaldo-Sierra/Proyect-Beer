package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelSouthAddbeer extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnBack;
	private JButton btnAcept;
	private MainWindow mainWindow;

	public PanelSouthAddbeer(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.initComponets();
		this.addComponents();
	}

	private void addComponents() {
		this.add(btnBack);
		this.add(btnAcept);

	}

	private void initComponets() {
		setUpScreen();
		initializeComponents();

	}

	private void initializeComponents() {
		this.btnBack = new JButton("Volver atras");
		this.btnBack.setBackground(GUIUtils.getPrincipalColor());
		this.btnBack.setActionCommand(HandlingEventsAddWindow.GET_BACK);
		this.btnBack.setFocusable(false);
		this.btnBack.addActionListener(new HandlingEventsAddWindow(this.mainWindow));
		this.btnAcept = new JButton("Aceptar");
		this.btnAcept.setBackground(GUIUtils.getPrincipalColor());
		this.btnAcept.setFocusable(false);
		this.btnAcept.setActionCommand(HandlingEventsAddWindow.ADD_BEER);
		this.btnAcept.addActionListener(new HandlingEventsAddWindow(this.mainWindow));

	}

	private void setUpScreen() {
		setLayout(new FlowLayout());
		setBorder(new EmptyBorder(0, 0, 10, 0));
		setBackground(Color.WHITE);
	}

}
