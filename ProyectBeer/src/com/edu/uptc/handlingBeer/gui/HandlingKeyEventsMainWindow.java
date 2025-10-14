package com.edu.uptc.handlingBeer.gui;

import javax.swing.*;

import com.edu.uptc.handlingBeer.enums.EAplicationMode;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class HandlingKeyEventsMainWindow {
	private Timer cancelTimer;

	private MainWindow mainWindow;

	// Estado temporal: qué tipo de carga se seleccionó (P=plano, J=JSON, X=XML)
	private String pendingLoadMode = null;

	public HandlingKeyEventsMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		registerKeyBindings(mainWindow.getRootPane());
	}

	private void registerKeyBindings(JComponent component) {
		// ====== Selección de modo de carga ======
		registerAction(component, "LOAD_MODE_PLAIN", KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK),
				new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pendingLoadMode = "PLAIN";
						startCancelTimer();
					}
				});

		registerAction(component, "LOAD_MODE_JSON", KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK),
				new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						pendingLoadMode = "JSON";
						startCancelTimer();
					}
				});

		registerAction(component, "LOAD_MODE_XML",
				KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK),
				new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("XML presionado");
						pendingLoadMode = "XML";
						startCancelTimer();
					}
				});

		// Exportar información (Ctrl+U+1)
				registerAction(component, "EXPORT_OBJECT_1", KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK),
						new AbstractAction() {
							@Override
							public void actionPerformed(ActionEvent e) {
								pendingLoadMode = "Export";
								startCancelTimer();
//								mainWindow.getHandlingEventsMainWindow().actionPerformed(new ActionEvent(mainWindow,
//										ActionEvent.ACTION_PERFORMED, HandlingEventsMainWindow.EXPORT_SALE_CSV));
							}
						});
				
		// ====== Selección del objeto destino (1 o 2) ======
		registerAction(component, "SELECT_OBJECT_1", KeyStroke.getKeyStroke(KeyEvent.VK_1, 0), new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executePendingLoad(1);
			}
		});

		registerAction(component, "SELECT_OBJECT_2", KeyStroke.getKeyStroke(KeyEvent.VK_2, 0), new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executePendingLoad(2);
			}
		});

		
	}

	/**
	 * Ejecuta la acción pendiente de carga cuando el usuario selecciona objeto 1 o
	 * 2
	 */
	private void executePendingLoad(int objectIndex) {
		if (pendingLoadMode == null) {
			return;
		}

		System.out.println(pendingLoadMode);
		String actionCommand = null;
		switch (pendingLoadMode) {
		case "PLAIN":
			if (objectIndex == 1) {
				this.mainWindow.getHandlingEventsMainWindow().switchToMode(EAplicationMode.BEER_MANAGEMENT);
				actionCommand = HandlingEventsMainWindow.LOAD_BEER_PLAIN;
			} else {
				this.mainWindow.getHandlingEventsMainWindow().switchToMode(EAplicationMode.SALES_MANAGEMENT);
				actionCommand = HandlingEventsMainWindow.LOAD_SALE_PLAIN;
			}
			break;
		case "JSON":
			if (objectIndex == 1) {
				this.mainWindow.getHandlingEventsMainWindow().switchToMode(EAplicationMode.BEER_MANAGEMENT);
				actionCommand = HandlingEventsMainWindow.LOAD_BEER_JSON;
			} else {
				this.mainWindow.getHandlingEventsMainWindow().switchToMode(EAplicationMode.SALES_MANAGEMENT);
				actionCommand = HandlingEventsMainWindow.LOAD_SALE_JSON;
			}
			break;
		case "XML":
			if (objectIndex == 1) {
				this.mainWindow.getHandlingEventsMainWindow().switchToMode(EAplicationMode.BEER_MANAGEMENT);
				actionCommand = HandlingEventsMainWindow.LOAD_BEER_XML;
			} else {
				this.mainWindow.getHandlingEventsMainWindow().switchToMode(EAplicationMode.SALES_MANAGEMENT);
				actionCommand = HandlingEventsMainWindow.LOAD_SALE_XML;
			}
			break;
		case "Export":
			if (objectIndex == 1) {
				this.mainWindow.getHandlingEventsMainWindow().switchToMode(EAplicationMode.BEER_MANAGEMENT);
				actionCommand = HandlingEventsMainWindow.EXPORT_BEER_CSV;
			} else {
				this.mainWindow.getHandlingEventsMainWindow().switchToMode(EAplicationMode.SALES_MANAGEMENT);
				actionCommand = HandlingEventsMainWindow.EXPORT_SALE_CSV;
			}
			break;
			
		}

		if (actionCommand != null) {
			mainWindow.getHandlingEventsMainWindow()
					.actionPerformed(new ActionEvent(mainWindow, ActionEvent.ACTION_PERFORMED, actionCommand));
		}

		// limpiar estado después de ejecutar
		pendingLoadMode = null;
	}

	/**
	 * Registra una acción personalizada
	 */
	private void registerAction(JComponent component, String name, KeyStroke keyStroke, AbstractAction action) {
		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, name);
		component.getActionMap().put(name, action);
	}

	/**
	 * Temporizador en caso de que no se precione la combinacion un 1s
	 */
	private void startCancelTimer() {
		if (cancelTimer != null) {
			cancelTimer.stop();
		}
		cancelTimer = new Timer(3000, e -> {
			pendingLoadMode = null;

		});
		cancelTimer.setRepeats(false);
		cancelTimer.start();
	}

}
