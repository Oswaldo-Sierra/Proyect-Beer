package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.edu.uptc.handlingBeer.enums.ETypeChange;

public class ChangeUserComponents extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panelNorth;
	private JPanel panelMiddel;
	private JPanel panelSouth;

	private JLabel jTitle;
	private JLabel jlnewValue;
	private StyledTextField inputnewValue;
	private JLabel jlConfirmationValue;
	private StyledTextField inputConfirmationValue;
	private JLabel lbMessageError1;
	private JButton btnback;
	private JButton btnAccept;
	private ETypeChange eTypeChange = ETypeChange.USERNAME;

	public ChangeUserComponents() {
		this.initComponents();
		this.addComponents();
	}

	private void initComponents() {
		setUpScreen();
		initializeComponents();

	}

	private void addComponents() {
		/** Añadir comomentes a los paneles */
		addComopentsPanels();
		/** Se añaden al frame */
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelMiddel, BorderLayout.CENTER);
		this.add(panelSouth, BorderLayout.SOUTH);

	}

	private void addComopentsPanels() {
		// Componete panel norte
		this.panelNorth.add(jTitle, SwingConstants.CENTER);
		// Comonente panel centro
		this.panelMiddel.add(jlnewValue);
		this.panelMiddel.add(inputnewValue);
		this.panelMiddel.add(jlConfirmationValue);
		this.panelMiddel.add(inputConfirmationValue);
		this.panelMiddel.add(lbMessageError1);
		// Comente panel sur
		this.panelSouth.add(btnback);
		this.panelSouth.add(btnAccept);

	}

	private void initializeComponents() {
		// paneles
		initializePanels();
		// Componentes
		initializeComoponetsPanels();

		updateForMode(eTypeChange);
	}

	private void initializePanels() {
		/** Panel del norte */
		this.panelNorth = new JPanel();
		this.panelNorth.setLayout(new FlowLayout());
		this.panelNorth.setBackground(Color.WHITE);

		/** Panel del centro */
		this.panelMiddel = new JPanel();
		this.panelMiddel.setLayout(new GridLayout(6, 1));
		this.panelMiddel.setBorder(new EmptyBorder(0, 50, 0, 50));
		this.panelMiddel.setBackground(Color.WHITE);

		/** Panel del abajo */
		this.panelSouth = new JPanel();
		this.panelSouth.setLayout(new FlowLayout());
		this.panelSouth.setBackground(Color.WHITE);
	}

	private void initializeComoponetsPanels() {
		/** Componentes panel norte */
		this.jTitle = new JLabel("");
		this.jTitle.setBorder(new EmptyBorder(10, 0, 50, 0));
		this.jTitle.setFont(new Font("Times Roman", Font.BOLD, 25));

		/** Comoponentes panel centro */
		this.jlnewValue = new JLabel("");
		this.inputnewValue = new StyledTextField(Boolean.FALSE);
		this.jlConfirmationValue = new JLabel("");
		this.inputConfirmationValue = new StyledTextField(Boolean.FALSE);
		this.lbMessageError1 = new JLabel();
		this.lbMessageError1.setForeground(Color.RED);
		this.lbMessageError1.setHorizontalAlignment(SwingConstants.CENTER);
		// this.lbMessageError1.setVisible(false);
		/** Componentes panel sur */
		this.btnback = new JButton("Volver");

		this.btnAccept = new JButton("Aceptar");

	}

	public void updateForMode(ETypeChange mode) {
		this.eTypeChange = mode;

		clearActionListeners(btnback);
		clearActionListeners(btnAccept);
		
		if (ETypeChange.USERNAME.equals(mode)) {
			ChangeUsername();

		}
		if (ETypeChange.USERPASSWORD.equals(mode)) {
			ChangePassword();

		}
	}

	private void ChangeUsername() {
		this.jTitle.setText("Cambiar nombre de usuario");
		this.jlnewValue.setText("Nuevo nombre de Usuario");
		this.jlConfirmationValue.setText("Comfirme el Nombre de usuario");
		this.btnAccept.setBackground(GUIUtils.getPrincipalColor());
		this.btnAccept.setFocusable(false);
		this.btnback.setBackground(GUIUtils.getPrincipalColor());
		this.btnback.setFocusable(false);

	}

	private void ChangePassword() {
		this.jTitle.setText("Cambiar Contraseña de usuario");
		this.jlnewValue.setText("Nueva Contraseña de Usuario");
		this.jlConfirmationValue.setText("Comfirme la Constraseña de usuario");
		this.btnAccept.setBackground(GUIUtils.getPrincipalColor());
		this.btnAccept.setFocusable(false);
		this.btnback.setBackground(GUIUtils.getPrincipalColor());
		this.btnback.setFocusable(false);
	}

	private void clearActionListeners(JButton button) {
		for (ActionListener listener : button.getActionListeners()) {
			button.removeActionListener(listener);
		}
	}

	private void setUpScreen() {
		/** Caracterizticas del frame */
		setSize(600, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

	}

	public void resetFrom() {
		this.inputnewValue.setText("");
		this.inputConfirmationValue.setText("");
		this.dispose();
	}

	public JLabel getjTitle() {
		return jTitle;
	}

	public void setjTitle(JLabel jTitle) {
		this.jTitle = jTitle;
	}

	public JLabel getJlnewValue() {
		return jlnewValue;
	}

	public void setJlnewValue(JLabel jlnewValue) {
		this.jlnewValue = jlnewValue;
	}

	public StyledTextField getInputnewValue() {
		return inputnewValue;
	}

	public void setInputnewValue(StyledTextField inputnewValue) {
		this.inputnewValue = inputnewValue;
	}

	public JLabel getJlConfirmationValue() {
		return jlConfirmationValue;
	}

	public void setJlConfirmationValue(JLabel jlConfirmationValue) {
		this.jlConfirmationValue = jlConfirmationValue;
	}

	public StyledTextField getInputConfirmationValue() {
		return inputConfirmationValue;
	}

	public void setInputConfirmationValue(StyledTextField inputConfirmationValue) {
		this.inputConfirmationValue = inputConfirmationValue;
	}

	public JLabel getLbMessageError1() {
		return lbMessageError1;
	}

	public void setLbMessageError1(JLabel lbMessageError1) {
		this.lbMessageError1 = lbMessageError1;
	}

	public JButton getBtnback() {
		return btnback;
	}

	public void setBtnback(JButton btnback) {
		this.btnback = btnback;
	}

	public JButton getBtnAccept() {
		return btnAccept;
	}

	public void setBtnAccept(JButton btnAccept) {
		this.btnAccept = btnAccept;
	}

	public ETypeChange geteTypeChange() {
		return eTypeChange;
	}

	public void seteTypeChange(ETypeChange eTypeChange) {
		this.eTypeChange = eTypeChange;
	}

}
