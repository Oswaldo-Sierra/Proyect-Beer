package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceBeer;

public class PanelMiddleMainWindow extends JPanel {

	private static final long serialVersionUID = 1L;

	private DefaultTableModel dtm;
	private JTable table;
	private MainWindow mainWindow;

	public PanelMiddleMainWindow(MainWindow mainWindow) {
		setLayout(new GridLayout(1, 1));
		setBorder(new EmptyBorder(40, 10, 10, 10));
		setBackground(Color.WHITE);
		this.mainWindow = mainWindow;
		this.buildComponents();
		this.addcComponents();
	}

	public void addRow(Object[] row) {
		dtm.addRow(row);

	}

	private void addcComponents() {
		this.add(new JScrollPane(table));
	}

		
	private void buildComponents() {
		String[] titles = { " Numero serial ", " Marca ", " Tipo ", " Grado de alcohol(ABV) ", " Amargor(IBU) ",
				" Provedor " , " Precio " , " Cantidad Disponible " };
		dtm = new DefaultTableModel(titles, 0);
		table = new JTable(dtm);
		table.setBackground(Color.WHITE);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
					int fila = table.getSelectedRow();
					String serialNumber = table.getValueAt(fila, 0).toString();
					//System.out.println("Se obtuvo el Numero de serie a eliminar : " + serialNumber);
					HandlingPersistenceBeer.SERIALNUMBER_BEER_SELECTED = serialNumber;
					mainWindow.getPanelRightButtonMainWindow().setVisible(true);

				}

			}
		});

	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(String[] titles) {
		dtm = new DefaultTableModel(titles, 0);
		this.table.setModel(dtm);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}
	
	

}
