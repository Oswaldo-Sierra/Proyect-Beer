package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class LoginWindow extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private PanelLeftLoginWindow leftLogginWindow;
	private PanelRightLoginWindow panelRightLoginWindow;
	private PanelRightSignuUpWindow panelRightSignuUpWindow;
	private PanelRightRecoverPasswordWindow panelRightRecoverPasswordWindow;

	private HandlingEventsLoginWindow handlingEventsLoginWindow;
	private MainWindow mainWindow;

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
		this.mainWindow = new MainWindow();
		this.handlingEventsLoginWindow = new HandlingEventsLoginWindow(this);
		this.leftLogginWindow = new PanelLeftLoginWindow();
		this.panelRightLoginWindow = new PanelRightLoginWindow(this);
		this.panelRightSignuUpWindow = new PanelRightSignuUpWindow(this);
		this.panelRightRecoverPasswordWindow = new PanelRightRecoverPasswordWindow(this);

	}

	private void setUpScreen() {
		/** Tamoño de la ventana */
		setSize(800, 600);

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
	
	
	public PanelRightLoginWindow getPanelRightLoginWindow() {
		return panelRightLoginWindow;
	}

	public void setPanelRightLoginWindow(PanelRightLoginWindow panelRightLoginWindow) {
		this.panelRightLoginWindow = panelRightLoginWindow;
	}

	public PanelRightSignuUpWindow getPanelRightSignuUpWindow() {
		return panelRightSignuUpWindow;
	}

	public void setPanelRightSignuUpWindow(PanelRightSignuUpWindow panelRightSignuUpWindow) {
		this.panelRightSignuUpWindow = panelRightSignuUpWindow;
	}
	
	public HandlingEventsLoginWindow getHandlingEventsLoginWindow() {
		return handlingEventsLoginWindow;
	}
	
	public PanelRightRecoverPasswordWindow getPanelRightRecoverPasswordWindow() {
		return panelRightRecoverPasswordWindow;
	}

	public void setPanelRightRecoverPasswordWindow(PanelRightRecoverPasswordWindow panelRightRecoverPasswordWindow) {
		this.panelRightRecoverPasswordWindow = panelRightRecoverPasswordWindow;
	}


	public void setHandlingEventsLoginWindow(HandlingEventsLoginWindow handlingEventsLoginWindow) {
		this.handlingEventsLoginWindow = handlingEventsLoginWindow;
	}
	

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public static void main(String[] args) {
		LoginWindow logginWindow = new LoginWindow();
		logginWindow.setVisible(true);
	}

}
