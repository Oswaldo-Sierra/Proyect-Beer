package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelRightRecoverPasswordWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private  JLabel lbTitle;
	private JLabel lblUserName;
	private StyledTextField inputUserName;
	private JLabel lblPassword;
	private StyledTextField inputnewPassword;
	private JLabel lblConfirmPassword;
	private StyledTextField inputConfirmnewPassword;
	private JButton btnBack;
	private JButton btnAcept;
	private JPanel panelSeparator1;
	private JPanel panelSeparator2;
	private JPanel panelSeparator3;
	private JLabel lblMessageError;
	private LoginWindow loginWindow;
	
	public PanelRightRecoverPasswordWindow(LoginWindow loginWindow) {
		this.loginWindow = loginWindow;
		this.initComponents();
		this.addComponents();
	}

	
	private void addComponents() {
		this.add(lbTitle);
		this.add(lblUserName);
		this.add(inputUserName);
		//this.add(panelSeparator1);
		this.add(lblPassword);
		this.add(inputnewPassword);
		this.add(lblConfirmPassword);
		this.add(inputConfirmnewPassword);
		this.add(panelSeparator2);
		this.add(btnAcept);
		this.add(lblMessageError);
		this.add(panelSeparator3);
		this.add(btnBack);

		
	}


	private void initComponents() {
		setUpScreen();
		initializeComponents();
	}


	private void initializeComponents() {
		this.lbTitle = new JLabel("Recover Password");
		this.lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblUserName= new JLabel("Nombre de usuario:");
		this.inputUserName = new StyledTextField(Boolean.FALSE);
		this.lblPassword = new JLabel("Nueva Contraseña");
		this.inputnewPassword = new StyledTextField(Boolean.TRUE);
		this.lblConfirmPassword = new JLabel("Confirme su nueva contraseña");
		this.inputConfirmnewPassword = new StyledTextField(Boolean.TRUE);
		this.btnAcept = new JButton("Aceptar");
		this.btnAcept.setBackground(GUIUtils.getPrincipalcolor());
		this.btnAcept.setForeground(Color.WHITE);
		this.btnAcept.setFocusable(false);
		this.btnAcept.setActionCommand(HandlingEventsLoginWindow.VALIDATE_FORGET_PASSWORD);
		this.btnAcept.addActionListener(this.loginWindow.getHandlingEventsLoginWindow());
		this.btnBack = new JButton("Volver atras");
		this.btnBack.setActionCommand(HandlingEventsLoginWindow.GET_BACK);
		this.btnBack.addActionListener(this.loginWindow.getHandlingEventsLoginWindow());
		
		this.lblMessageError = new JLabel();
		this.lblMessageError.setForeground(Color.RED);
		this.lblMessageError.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblMessageError.setVisible(false);
		
		this.panelSeparator1 = new JPanel();
		this.panelSeparator1.setBackground(Color.WHITE);
		this.panelSeparator2 = new JPanel();
		this.panelSeparator2.setBackground(Color.WHITE);
		this.panelSeparator3 = new JPanel();
		this.panelSeparator3.setBackground(Color.WHITE);
	}


	private void setUpScreen() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(484, 70));
		setLayout(new GridLayout(12, 1));
		setBorder(new EmptyBorder(0,15,0,15));
	}


	public JLabel getLbTitle() {
		return lbTitle;
	}


	public void setLbTitle(JLabel lbTitle) {
		this.lbTitle = lbTitle;
	}


	public JLabel getLblUserName() {
		return lblUserName;
	}


	public void setLblUserName(JLabel lblUserName) {
		this.lblUserName = lblUserName;
	}


	public StyledTextField getInputUserName() {
		return inputUserName;
	}


	public void setInputUserName(StyledTextField inputUserName) {
		this.inputUserName = inputUserName;
	}


	public JLabel getLblPassword() {
		return lblPassword;
	}


	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}


	public StyledTextField getInputnewPassword() {
		return inputnewPassword;
	}


	public void setInputnewPassword(StyledTextField inputPassword) {
		this.inputnewPassword = inputPassword;
	}


	public JLabel getLblConfirmPassword() {
		return lblConfirmPassword;
	}


	public void setLblConfirmPassword(JLabel lblConfirmPassword) {
		this.lblConfirmPassword = lblConfirmPassword;
	}


	public StyledTextField getInputConfirmNewPassword() {
		return inputConfirmnewPassword;
	}


	public void setInputConfirmNewPassword(StyledTextField inputConfirmPassword) {
		this.inputConfirmnewPassword = inputConfirmPassword;
	}


	public JButton getBtnBack() {
		return btnBack;
	}


	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}


	public JButton getBtnAcept() {
		return btnAcept;
	}


	public void setBtnAcept(JButton btnAcept) {
		this.btnAcept = btnAcept;
	}


	public JLabel getLblMessageError() {
		return lblMessageError;
	}


	public void setLblMessageError(JLabel lblMessageError) {
		this.lblMessageError = lblMessageError;
	}
	
	
	


}
