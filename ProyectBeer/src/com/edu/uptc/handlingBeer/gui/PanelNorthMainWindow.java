package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.edu.uptc.handlingBeer.enums.EAplicationMode;

public class PanelNorthMainWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblTitleMainWindow;
	private JButton btnFindBy;
	private MainWindow mainWindow;
	private EAplicationMode aplicationMode = EAplicationMode.BEER_MANAGEMENT;

	public PanelNorthMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.initComponets();
		this.addComponents();
	}

	private void addComponents() {
		this.add(this.lblTitleMainWindow);
		this.add(btnFindBy);

	}

	private void initComponets() {
		setUpScreen();
		initializeComponents();
		setupForMode(aplicationMode);
	}

	private void initializeComponents() {
		this.lblTitleMainWindow = new JLabel();
		Font actualFont = this.lblTitleMainWindow.getFont();
		Font fontTitle = new Font(actualFont.getName(), Font.BOLD, 24);
		this.lblTitleMainWindow.setBorder(new EmptyBorder(0, 0, 0, 80));
		this.lblTitleMainWindow.setFont(fontTitle);
		this.lblTitleMainWindow.setForeground(GUIUtils.getNeutralColor());
		this.btnFindBy = new JButton();
		this.btnFindBy.setBackground(GUIUtils.getPrincipalColor());
		this.btnFindBy.setFocusable(false);
	}

	public void setupForMode(EAplicationMode mode) {
		this.aplicationMode = mode;

		if (EAplicationMode.BEER_MANAGEMENT.equals(mode)) {
			this.lblTitleMainWindow.setText("ADMINISTRACIÓN DE CERVEZAS");
			this.btnFindBy.setText("Buscar Cerveza por: ");
			this.btnFindBy.setActionCommand(HandlingEventsMainWindow.SHOW_WINDOW_SEARCH);
			this.btnFindBy.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		}
		if (EAplicationMode.SALES_MANAGEMENT.equals(mode)) {
			this.lblTitleMainWindow.setText("ADMINISTRACIÓN DE VENTAS DE CERVEZAS");
			this.btnFindBy.setText("Buscar Venta por: ");
			this.btnFindBy.setActionCommand(HandlingEventsMainWindow.SHOW_WINDOW_SEARCH);
			this.btnFindBy.addActionListener(this.mainWindow.getHandlingEventsMainWindow());
		}
	}

	private void setUpScreen() {
		setBorder(new EmptyBorder(20,0,0,0));
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
	}

}
