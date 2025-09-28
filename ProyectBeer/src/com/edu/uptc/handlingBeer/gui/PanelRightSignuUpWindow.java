package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelRightSignuUpWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private  JLabel lbTitle;
	private JLabel lblUserName;
	private StyledTextField inputUserName;
	private JLabel lblPassword;
	private StyledTextField inputPassword;
	private JLabel lblConfirmPassword;
	private StyledTextField inputConfirmPassword;
	private JButton btnBack;
	private JButton btnAcept;
	private JPanel panelSeparator1;
	private JPanel panelSeparator2;
	private JPanel panelSeparator3;
	private JLabel lblMessageError;
	private LoginWindow loginWindow;

	
	
	public PanelRightSignuUpWindow(LoginWindow loginWindow) {
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
		this.add(inputPassword);
		this.add(lblConfirmPassword);
		this.add(inputConfirmPassword);
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
		this.lbTitle = new JLabel("Sign Up");
		this.lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblUserName= new JLabel("Nombre de usuario:");
		this.inputUserName = new StyledTextField(Boolean.FALSE);
		this.lblPassword = new JLabel("Contraseña");
		this.inputPassword = new StyledTextField(Boolean.TRUE);
		this.lblConfirmPassword = new JLabel("Confirme su contraseña");
		this.inputConfirmPassword = new StyledTextField(Boolean.TRUE);
		this.btnAcept = new JButton("Aceptar");
		this.btnAcept.setBackground(GUIUtils.getPrincipalcolor());
		this.btnAcept.setForeground(Color.WHITE);
		this.btnAcept.setFocusable(false);
		this.btnAcept.setActionCommand(HandlingEventsLoginWindow.VALIDATE_SIGNUP);
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


	public StyledTextField getInputPassword() {
		return inputPassword;
	}


	public void setInputPassword(StyledTextField inputPassword) {
		this.inputPassword = inputPassword;
	}


	public JLabel getLblConfirmPassword() {
		return lblConfirmPassword;
	}


	public void setLblConfirmPassword(JLabel lblConfirmPassword) {
		this.lblConfirmPassword = lblConfirmPassword;
	}


	public StyledTextField getInputConfirmPassword() {
		return inputConfirmPassword;
	}


	public void setInputConfirmPassword(StyledTextField inputConfirmPassword) {
		this.inputConfirmPassword = inputConfirmPassword;
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


	public JPanel getPanelSeparator1() {
		return panelSeparator1;
	}


	public void setPanelSeparator1(JPanel panelSeparator1) {
		this.panelSeparator1 = panelSeparator1;
	}


	public JPanel getPanelSeparator2() {
		return panelSeparator2;
	}


	public void setPanelSeparator2(JPanel panelSeparator2) {
		this.panelSeparator2 = panelSeparator2;
	}


	public JPanel getPanelSeparator3() {
		return panelSeparator3;
	}


	public void setPanelSeparator3(JPanel panelSeparator3) {
		this.panelSeparator3 = panelSeparator3;
	}


	public JLabel getLblMessageError() {
		return lblMessageError;
	}


	public void setLblMessageError(JLabel lblMessageError) {
		this.lblMessageError = lblMessageError;
	}


	public LoginWindow getLoginWindow() {
		return loginWindow;
	}


	public void setLoginWindow(LoginWindow loginWindow) {
		this.loginWindow = loginWindow;
	}

	

}
