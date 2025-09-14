package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class LoginWindow extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private PanelLeftLoginWindow leftLogginWindow;
	private PanelRightLoginWindow panelRightLoginWindow;

	public LoginWindow() {
		this.initComponets();
		this.addComponents();

	}

	private void initComponets() {
		setUpScreen();
		initializeComponents();

	}

	private void addComponents() {
		/** Se añaden los componentes al frame */
		this.add(leftLogginWindow, BorderLayout.WEST);
		this.add(panelRightLoginWindow, BorderLayout.EAST);

	}

	private void initializeComponents() {
		/** Se inicializan los comonentes */
		this.leftLogginWindow = new PanelLeftLoginWindow();
		this.panelRightLoginWindow = new PanelRightLoginWindow();

	}

	private void setUpScreen() {
		/** Tamoño de la ventana */
		setSize(800, 400);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		
		setResizable(false);

	}

	public PanelLeftLoginWindow getLeftLogginWindow() {
		return leftLogginWindow;
	}

	public void setLeftLogginWindow(PanelLeftLoginWindow leftLogginWindow) {
		this.leftLogginWindow = leftLogginWindow;
	}

	public PanelRightLoginWindow getRithLogginWindow() {
		return panelRightLoginWindow;
	}

	public void setRithLogginWindow(PanelRightLoginWindow rithLogginWindow) {
		this.panelRightLoginWindow = rithLogginWindow;
	}
	
	public static void main(String[] args) {
		LoginWindow logginWindow = new LoginWindow();
		logginWindow.setVisible(true);
	}

}
