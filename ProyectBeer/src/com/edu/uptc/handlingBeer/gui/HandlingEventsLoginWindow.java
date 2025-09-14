package com.edu.uptc.handlingBeer.gui;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.edu.uptc.handlingBeer.enums.ETypeFile;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceUser;

public class HandlingEventsLoginWindow implements ActionListener {

	public static final String VALIDATE_LOGIN = "VALIDATE_LOGIN";
	public PanelRightLoginWindow panelRightLoginWindow;
	private HandlingPersistenceUser handlingPersistenceUser;

	public HandlingEventsLoginWindow(PanelRightLoginWindow panelRightLoginWindow) {
		this.panelRightLoginWindow = panelRightLoginWindow;
		this.handlingPersistenceUser = new HandlingPersistenceUser();
		this.handlingPersistenceUser.loadFile(ETypeFile.SER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case VALIDATE_LOGIN:
			String nameuser = this.panelRightLoginWindow.getInputUserName();
			String password = this.panelRightLoginWindow.getInputPassword();

			if (Boolean.TRUE.equals(this.handlingPersistenceUser.findUserByUsernamePassword(nameuser, password))) {
				Window ventana = SwingUtilities.getWindowAncestor(this.panelRightLoginWindow);
				if (ventana != null) {
					/* Oculta la vista del login */
					ventana.setVisible(false);

					/* Muestra la vista principal */
					this.panelRightLoginWindow.getMainWindow().setVisible(true);
					this.panelRightLoginWindow.getLblMessageError().setVisible(false);
				}
			} else {
				this.panelRightLoginWindow.getLblMessageError().setVisible(true);
			}
			break;

		default:
			break;
		}

	}

}
