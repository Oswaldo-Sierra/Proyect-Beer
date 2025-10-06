package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PanelRightLoginWindow extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblUserName;
	private StyledTextField inputUserName;
	private JLabel lblPassword;
	private StyledTextField inputPassword;
	private JButton btforgetPassword;
	private JButton buttonLogin;
	private JButton buttonRegister;
	private JLabel lbMessageError1;
	private JPanel panelSeparator1;
	private JPanel panelSeparator2;
	private JPanel panelSeparator3;
	private LoginWindow loginWindow;

	public PanelRightLoginWindow(LoginWindow loginWindow) {
		this.loginWindow = loginWindow;
		this.initComponents();
		this.addComponents();

	}

	private void addComponents() {
		this.add(lblTitle);
		this.add(lblUserName);
		this.add(inputUserName);
		this.add(panelSeparator1);
		this.add(lblPassword);
		this.add(inputPassword);
		this.add(btforgetPassword);
		this.add(panelSeparator2);
		this.add(buttonLogin);
		this.add(lbMessageError1);
		this.add(panelSeparator3);
		this.add(buttonRegister);

	}

	private void initComponents() {
		setUpScreen();
		initializeComponents();

	}

	private void initializeComponents() {
		this.lblTitle = new JLabel("USER LOGIN");
		this.lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblUserName = new JLabel("Nombre de usuario:");
		this.inputUserName = new StyledTextField(Boolean.FALSE);
		this.lblPassword = new JLabel("Contraseña:");
		this.inputPassword = new StyledTextField(Boolean.TRUE);
		
		this.btforgetPassword = new JButton("Olvido su contraseña");
		this.btforgetPassword.setBorderPainted(false);
		this.btforgetPassword.setContentAreaFilled(false);
		this.btforgetPassword.setActionCommand(HandlingEventsLoginWindow.FORGET_PASSWORD);
		this.btforgetPassword.addActionListener(this.loginWindow.getHandlingEventsLoginWindow());
		this.btforgetPassword.setHorizontalAlignment(SwingConstants.RIGHT);

		this.buttonLogin = new JButton("Aceptar");
		this.buttonLogin.setBackground(GUIUtils.getPrincipalColor());
		this.buttonLogin.setFocusable(false);
		this.buttonLogin.setBorder(new LineBorder(GUIUtils.getPrincipalColor()));
		this.buttonLogin.setActionCommand(HandlingEventsLoginWindow.VALIDATE_LOGIN);
		this.buttonLogin.addActionListener(this.loginWindow.getHandlingEventsLoginWindow());

		this.buttonRegister = new JButton("Crea tu cuenta");
		this.buttonRegister.setBorderPainted(false);
		this.buttonRegister.setContentAreaFilled(false);
		this.buttonRegister.setActionCommand(HandlingEventsLoginWindow.CREATE_ACCOUNT);
		this.buttonRegister.addActionListener(this.loginWindow.getHandlingEventsLoginWindow());

		this.lbMessageError1 = new JLabel();
		this.lbMessageError1.setForeground(Color.RED);
		this.lbMessageError1.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbMessageError1.setVisible(false);

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
		setBorder(new EmptyBorder(0, 15, 0, 15));

	}

	public void setInputUserName(StyledTextField inputUserName) {
		this.inputUserName = inputUserName;
	}

	public StyledTextField getInputUserName() {
		return inputUserName;
	}

	public StyledTextField getInputPassword() {
		return inputPassword;
	}

	public JLabel getLblMessageError1() {
		return lbMessageError1;
	}

	public void setLblMessageError1(JLabel lblMessageError1) {
		this.lbMessageError1 = lblMessageError1;
	}

	public void setInputPassword(StyledTextField inputPassword) {
		this.inputPassword = inputPassword;
	}

}
