package com.edu.uptc.handlingBeer.gui;

import java.awt.Window;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.edu.uptc.handlingBeer.enums.ETypeChange;
import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceUser;

public class HandlingEventsUser {
	private MainWindow mainWindow;
	private HandlingPersistenceUser persistenceUser;
	private ChangeUserComponents changeUserComponents;

	public HandlingEventsUser(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.persistenceUser = new HandlingPersistenceUser();
		this.persistenceUser.loadFile(ETypeFile.SER);
		this.changeUserComponents = new ChangeUserComponents();
	}

	public void changeUsername() {
		// proceso de datos
		this.changeUserComponents.updateForMode(ETypeChange.USERNAME);

		this.changeUserComponents.getBtnAccept().addActionListener(e -> processChangeUsername());
		this.changeUserComponents.getBtnback().addActionListener(e -> changeUserComponents.resetFrom());

		this.changeUserComponents.setVisible(true);
	}

	public void changePassword() {
		this.changeUserComponents.updateForMode(ETypeChange.USERPASSWORD);

		this.changeUserComponents.getBtnAccept().addActionListener(e -> processChangePassword());
		this.changeUserComponents.getBtnback().addActionListener(e -> changeUserComponents.resetFrom());

		this.changeUserComponents.setVisible(true);
	}

	public void deleteAccount() {
		int option = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar esta cuenta?", "Confirmación",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (option == JOptionPane.YES_OPTION) {
			String username = InfoSesion.getUserName();
			if (this.persistenceUser.deleteUser(username)) {
				InfoSesion.clear();
				this.persistenceUser.dumpFile(ETypeFile.SER);
				Window ventana = SwingUtilities.getWindowAncestor(mainWindow.getPanelMiddleMainWindow());
				if (ventana != null)
					ventana.dispose();

				JOptionPane.showMessageDialog(null, "Cuenta eliminada");
				new LoginWindow().setVisible(true);
			}
		}
	}

	public void logOut() {
		InfoSesion.clear();
		Window ventana = SwingUtilities.getWindowAncestor(mainWindow.getPanelMiddleMainWindow());
		if (ventana != null)
			ventana.dispose();

		new LoginWindow().setVisible(true);
	}

	private void processChangeUsername() {
		String newUsername = changeUserComponents.getInputnewValue().getTextValue();
		String confirmUsername = changeUserComponents.getInputConfirmationValue().getTextValue();

		if (newUsername.isEmpty() || confirmUsername.isEmpty()) {
			changeUserComponents.getLbMessageError1().setText("Los campos no pueden estar vacíos");
			return;
		}
		if (!newUsername.equals(confirmUsername)) {
			changeUserComponents.getLbMessageError1().setText("Los nombres no coinciden");
			return;
		}

		String oldUsername = InfoSesion.getUserName();
		if (persistenceUser.updateUsername(oldUsername, newUsername)) {
			InfoSesion.setUserName(newUsername);
			persistenceUser.dumpFile(ETypeFile.SER);
			JOptionPane.showMessageDialog(changeUserComponents, "Nombre de usuario cambiado con éxito");
			this.changeUserComponents.resetFrom();
			changeUserComponents.dispose();
		} else {
			JOptionPane.showMessageDialog(changeUserComponents, "Nombre de Usuario en Uso", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void processChangePassword() {
		String newPassword = changeUserComponents.getInputnewValue().getTextValue();
		String confirmPassword = changeUserComponents.getInputConfirmationValue().getTextValue();

		if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
			changeUserComponents.getLbMessageError1().setText("Los campos no pueden estar vacíos");
			return;
		}
		if (!newPassword.equals(confirmPassword)) {
			changeUserComponents.getLbMessageError1().setText("Las contraseñas no coinciden");
			return;
		}

		// Guardar en la persistencia
		String username = InfoSesion.getUserName();
		if (persistenceUser.updatePassword(username, newPassword)) {
			InfoSesion.setPasswordUser(newPassword);
			persistenceUser.dumpFile(ETypeFile.SER);
			JOptionPane.showMessageDialog(changeUserComponents, "Contraseña cambiada con éxito");
			this.changeUserComponents.resetFrom();
		} else {
			JOptionPane.showMessageDialog(changeUserComponents, "No se pudo actualizar la contraseña", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
