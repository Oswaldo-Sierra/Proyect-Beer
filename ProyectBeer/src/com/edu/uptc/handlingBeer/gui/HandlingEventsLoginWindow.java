package com.edu.uptc.handlingBeer.gui;

import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.model.*;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceUser;

public class HandlingEventsLoginWindow implements ActionListener {

	// Constantes para los comandos
	public static final String VALIDATE_LOGIN = "VALIDATE_LOGIN";
	public static final String FORGET_PASSWORD = "FORGET_PASSWORD";
	public static final String CREATE_ACCOUNT = "CREATE_ACCOUNT";
	public static final String VALIDATE_SIGNUP = "VALIDATE_SIGNUP";
	public static final String VALIDATE_FORGET_PASSWORD = "VALIDATE_FORGET_PASSWORD";
	public static final String GET_BACK = "GET_BACK";

	private final LoginWindow loginWindow;
	private final HandlingPersistenceUser persistenceUser;

	public HandlingEventsLoginWindow(LoginWindow loginWindow) {
		this.loginWindow = loginWindow;
		this.persistenceUser = new HandlingPersistenceUser();
		this.persistenceUser.loadFile(ETypeFile.SER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case VALIDATE_LOGIN:
			validateLogin();
			break;
		case FORGET_PASSWORD:
			showPanelForgetPassword();
			break;
		case CREATE_ACCOUNT:
			showPanelSignUp();
			break;
		case VALIDATE_SIGNUP:
			validateSignUp();
			break;
		case VALIDATE_FORGET_PASSWORD:
			validateForgetPassword();
			break;
		case GET_BACK:
			showPanelLogin();
			break;
		}
	}

	/**
	 * Valida las credenciales de inicio de sesión
	 */
	private void validateLogin() {
		InfoSesion.clear();
		String username = loginWindow.getPanelRightLoginWindow().getInputUserName().getTextValue();
		String password = loginWindow.getPanelRightLoginWindow().getInputPassword().getTextValue();

		if (username.isEmpty() || password.isEmpty()) {
			showError(loginWindow.getPanelRightLoginWindow().getLblMessageError1(),
					"Por favor complete todos los campos.");
			return;
		}

		if (Boolean.TRUE.equals(persistenceUser.findUserByUsernamePassword(username, password))) {
			Window ventana = SwingUtilities.getWindowAncestor(loginWindow.getPanelRightLoginWindow());
			if (ventana != null) {
				InfoSesion.setUserName(username);
				InfoSesion.setPasswordUser(password);
				ventana.setVisible(false);
				loginWindow.getMainWindow().setVisible(true);
			}
		} else {
			showError(loginWindow.getPanelRightLoginWindow().getLblMessageError1(),
					"El usuario no se encuentra registrado.");
		}
	}

	/**
	 * Valida el registro de un nuevo usuario
	 */
	private void validateSignUp() {
		String username = this.loginWindow.getPanelRightSignuUpWindow().getInputUserName().getTextValue();
		String password = this.loginWindow.getPanelRightSignuUpWindow().getInputPassword().getTextValue();
		String confirmPassword = loginWindow.getPanelRightSignuUpWindow().getInputConfirmPassword().getTextValue();

		if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
			showError(this.loginWindow.getPanelRightSignuUpWindow().getLblMessageError(),
					"Por favor complete todos los campos.");
			return;
		}

		if (!password.equals(confirmPassword)) {
			showError(this.loginWindow.getPanelRightSignuUpWindow().getLblMessageError(), "La contraseña no coincide.");
			return;
		}

		if (Boolean.TRUE.equals(persistenceUser.findUserByUsernamePassword(username, password))) {
			showError(this.loginWindow.getPanelRightSignuUpWindow().getLblMessageError(),
					"El usuario ya se encuentra registrado.");
			return;
		}

		// Registro exitoso
		Window ventana = SwingUtilities.getWindowAncestor(this.loginWindow.getPanelRightSignuUpWindow());
		if (ventana != null) {
			ventana.setVisible(false);

			User user = new User(username, password);
			persistenceUser.addUser(user);
			persistenceUser.dumpFile(ETypeFile.SER);
			InfoSesion.setUserName(username);
			InfoSesion.setPasswordUser(password);
			loginWindow.getMainWindow().setVisible(true);
		}
	}

	/**
	 * Valida la nueva contraseña
	 */

	private void validateForgetPassword() {
		String username = this.loginWindow.getPanelRightRecoverPasswordWindow().getInputUserName().getTextValue();
		String newPassword = this.loginWindow.getPanelRightRecoverPasswordWindow().getInputnewPassword().getTextValue();
		String confirmNewPassword = loginWindow.getPanelRightRecoverPasswordWindow().getInputConfirmNewPassword()
				.getTextValue();

		if (username.isEmpty() || newPassword.isEmpty() || confirmNewPassword.isEmpty()) {
			showError(this.loginWindow.getPanelRightRecoverPasswordWindow().getLblMessageError(),
					"Por favor complete todos los campos.");
			return;
		}

		if (!newPassword.equals(confirmNewPassword)) {
			showError(this.loginWindow.getPanelRightRecoverPasswordWindow().getLblMessageError(), "La contraseña no coincide.");
			return;
		}
		
		if (Boolean.FALSE.equals(persistenceUser.findUserByUsername(username))) {
			showError(this.loginWindow.getPanelRightRecoverPasswordWindow().getLblMessageError(),
					"El usuario no se encuentra registrado.");
			return;
		}

		if (this.persistenceUser.findUserByUsername(username)) {
			// Registro exitoso
			Window ventana = SwingUtilities.getWindowAncestor(this.loginWindow.getPanelRightRecoverPasswordWindow());
			if (ventana != null) {
				ventana.setVisible(false);
				for (User user : this.persistenceUser.getListusers()) {
					if (user.getNameUser().equals(username)) {
						user.setPassword(newPassword);
						break;
					}
				}
				InfoSesion.setUserName(username);
				InfoSesion.setPasswordUser(newPassword);
				this.persistenceUser.dumpFile(ETypeFile.SER);
				this.loginWindow.getMainWindow().setVisible(true);
			}
		} else {
			showError(this.loginWindow.getPanelRightRecoverPasswordWindow().getLblMessageError(),
					"El usuario no se encuentra registrado.");
		}

	}

	/**
	 * Muestra el panel de inicio de sesión
	 */
	private void showPanelLogin() {
		clearSignUpPanel();
		clearRecoverPasswordPanel();
		this.loginWindow.getPanelRightRecoverPasswordWindow().setVisible(false);
		this.loginWindow.getPanelRightSignuUpWindow().setVisible(false);
		this.loginWindow.getPanelRightLoginWindow().setVisible(true);
	}

	/**
	 * Muestra el panel de registro
	 */
	private void showPanelSignUp() {
		clearLoginPanel();
		this.loginWindow.getPanelRightLoginWindow().setVisible(false);
		this.loginWindow.add(loginWindow.getPanelRightSignuUpWindow(), BorderLayout.EAST);
		this.loginWindow.getPanelRightSignuUpWindow().setVisible(true);
	}

	/**
	 * Muestra el panel de recuperar contraseña
	 */
	private void showPanelForgetPassword() {
		clearLoginPanel();
		this.loginWindow.getPanelRightLoginWindow().setVisible(false);
		this.loginWindow.add(this.loginWindow.getPanelRightRecoverPasswordWindow(), BorderLayout.EAST);
		this.loginWindow.getPanelRightRecoverPasswordWindow().setVisible(true);
	}

	/**
	 * Limpia el panel de login
	 */
	private void clearLoginPanel() {
		loginWindow.getPanelRightLoginWindow().getInputUserName().setText("");
		loginWindow.getPanelRightLoginWindow().getInputPassword().setText("");
		loginWindow.getPanelRightLoginWindow().getLblMessageError1().setVisible(false);
	}

	/**
	 * Limpia el panel de registro
	 */
	private void clearSignUpPanel() {
		loginWindow.getPanelRightSignuUpWindow().getInputUserName().setText("");
		loginWindow.getPanelRightSignuUpWindow().getInputPassword().setText("");
		loginWindow.getPanelRightSignuUpWindow().getInputConfirmPassword().setText("");
		loginWindow.getPanelRightSignuUpWindow().getLblMessageError().setVisible(false);
	}

	/**
	 * Limpia el panel de recuperar contraseña
	 */
	private void clearRecoverPasswordPanel() {
		loginWindow.getPanelRightRecoverPasswordWindow().getInputUserName().setText("");
		loginWindow.getPanelRightRecoverPasswordWindow().getInputnewPassword().setText("");
		loginWindow.getPanelRightRecoverPasswordWindow().getInputConfirmNewPassword().setText("");
		loginWindow.getPanelRightRecoverPasswordWindow().getLblMessageError().setVisible(false);
	}

	/**
	 * Método auxiliar para mostrar mensajes de error
	 */
	private void showError(JLabel label, String message) {
		label.setText(message);
		label.setVisible(true);
	}

}
