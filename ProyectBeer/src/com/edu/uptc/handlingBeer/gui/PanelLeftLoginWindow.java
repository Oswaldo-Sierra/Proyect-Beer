package com.edu.uptc.handlingBeer.gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelLeftLoginWindow extends JPanel{

	private static  long serialVersionUID = 1L;
	private JLabel lbImage;
	
	public PanelLeftLoginWindow() {
		setPreferredSize(new Dimension(300 ,getHeight()));
		setBackground(GUIUtils.getPrincipalcolor());
		
		this.lbImage = new JLabel();
		this.lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		//this.lbImage.setIcon(new ImageIcon("resources/img/Vectors/login.png"));
		ImageIcon originalIcon = new ImageIcon("resources/img/Vectors/login.png");
		Image scaledImage = originalIcon.getImage().getScaledInstance(300, 580, java.awt.Image.SCALE_SMOOTH);
		lbImage.setIcon(new ImageIcon(scaledImage));
		this.add(lbImage);
	}
	
	
}