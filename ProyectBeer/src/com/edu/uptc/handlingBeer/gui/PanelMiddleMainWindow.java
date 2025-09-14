package com.edu.uptc.handlingBeer.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class PanelMiddleMainWindow extends JPanel {

	private static final long serialVersionUID = 1L;

	private DefaultTableModel dtm;
	private JTable table;
	private MainWindow mainWindow;

	public PanelMiddleMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		setLayout(new GridLayout(1, 1));
		setBorder(new EmptyBorder(40, 10, 10, 10));
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
				" Origen " };
		dtm = new DefaultTableModel(titles, 0);
		table = new JTable(dtm);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting() && table.getSelectedRow() != 1) {
					int fila = table.getSelectedRow();
					//String nombre = table.getValueAt(fila,0).toString();
					//System.out.println("Se selecciono: " + nombre);
					
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
	
	

}
