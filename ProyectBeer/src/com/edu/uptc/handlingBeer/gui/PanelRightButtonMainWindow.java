package com.edu.uptc.handlingBeer.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelRightButtonMainWindow extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton acully;
	private JButton showMore;
	private JButton delate;

	/*
	 * public PanelRightButtonMainWindow() { setLayout(new BoxLayout(this,
	 * BoxLayout.Y_AXIS)); setBorder(new EmptyBorder(10,10,10,10));
	 * 
	 * this.a = new JButton("A"); this.b = new JButton("B");
	 * 
	 * a.setAlignmentX(Component.CENTER_ALIGNMENT);
	 * b.setAlignmentX(Component.CENTER_ALIGNMENT);
	 * 
	 * // Ajustar tamaños a.setMaximumSize(new Dimension(80, 30));
	 * b.setMaximumSize(new Dimension(80, 30));
	 * 
	 * add(Box.createVerticalGlue()); // empuja hacia abajo add(a);
	 * add(Box.createRigidArea(new Dimension(0, 10))); // espacio entre botones
	 * add(b); add(Box.createVerticalGlue()); // empuja desde abajo }
	 */

	public PanelRightButtonMainWindow(MainWindow mainWindow) {
		setLayout(new GridLayout(14,1));
		setBorder(new EmptyBorder(200,5,20,15));
		
		this.showMore = new JButton("Ver mas");
		this.acully = new JButton("Actualizar");
		this.delate = new JButton("Eliminar");
		
		this.add(showMore);
		this.add(acully);
		this.add(delate);
	}

}
