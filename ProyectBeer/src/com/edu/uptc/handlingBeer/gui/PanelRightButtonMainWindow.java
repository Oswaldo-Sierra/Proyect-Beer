package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelRightButtonMainWindow extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton acully;
	private JButton showMore;
	private JButton delate;
	private MainWindow mainWindow;

	public PanelRightButtonMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.initComponets();
		this.addComponents();
	}

	

	private void addComponents() {
		this.add(showMore);
		this.add(acully);
		this.add(delate);
		
	}
	
	private void initComponets() {
		setUpScreen();
		initializeComponents();
		
	}

	private void initializeComponents() {
		//primer boton
		this.showMore = new JButton("Ver mas");
		this.showMore.setActionCommand(HandlingEventsMainWindow.SEE_MORE_BEER);
		this.showMore.addActionListener(mainWindow.getHandlingEventsMainWindow());
		//segundo boton
		this.acully = new JButton("Actualizar");
		this.acully.setActionCommand(HandlingEventsMainWindow.UDATE_BEER);
		this.acully.addActionListener(mainWindow.getHandlingEventsMainWindow());
		//tercer boton
		this.delate = new JButton("Eliminar");
		this.delate.setActionCommand(HandlingEventsMainWindow.DELETE_BEER);
		this.delate.addActionListener(mainWindow.getHandlingEventsMainWindow());
		
	}


	private void setUpScreen() {
		setLayout(new GridLayout(14, 1));
		setBorder(new EmptyBorder(200, 5, 20, 15));
		setBackground(Color.WHITE);
		
	}



	public JButton getAcully() {
		return acully;
	}

	public void setAcully(JButton acully) {
		this.acully = acully;
	}

	public JButton getShowMore() {
		return showMore;
	}

	public void setShowMore(JButton showMore) {
		this.showMore = showMore;
	}

	public JButton getDelate() {
		return delate;
	}

	public void setDelate(JButton delate) {
		this.delate = delate;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

}
