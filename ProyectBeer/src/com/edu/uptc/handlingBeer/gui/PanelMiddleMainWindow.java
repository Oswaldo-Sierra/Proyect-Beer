package com.edu.uptc.handlingBeer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.edu.uptc.handlingBeer.enums.EAplicationMode;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceBeer;
import com.edu.uptc.handlingBeer.persistence.HandlingPersistenceSalesOfBeer;

public class PanelMiddleMainWindow extends JPanel {

	private static final long serialVersionUID = 1L;

	private DefaultTableModel dtm;
	private JTable table;
	private MainWindow mainWindow;
	private EAplicationMode currentMode = EAplicationMode.BEER_MANAGEMENT; // por defecto

	public PanelMiddleMainWindow(MainWindow mainWindow) {
		setLayout(new GridLayout(1, 1));
		setBorder(new EmptyBorder(40, 10, 10, 10));
		setBackground(Color.WHITE);
		this.mainWindow = mainWindow;
		buildComponents();
		addcComponents();
	}

	private void addcComponents() {
		JScrollPane scroll = new JScrollPane(table);
		scroll.getViewport().setBackground(Color.WHITE);
		this.add(scroll);
	}

	private void buildComponents() {
		setupTableForMode(EAplicationMode.BEER_MANAGEMENT); // inicia en modo cervezas
	}

	public void setupTableForMode(EAplicationMode mode) {
		this.currentMode = mode;

		String[] titles;
		if (mode == EAplicationMode.BEER_MANAGEMENT) {
			titles = new String[] { "Numero serial", "Marca", "Tipo", "Grado de alcohol(ABV)", "Amargor(IBU)",
					"Proveedor", "Precio", "Cantidad Disponible" };
		} else { // SALES_MANAGEMENT
			titles = new String[] { "ID Venta", "Nuemro Serial Cerveza", "Cervezas vendidas", "Total", "Fecha",
					"Usuario", "Cliente" };
		}	

		dtm = new DefaultTableModel(titles, 0);

		if (table == null) {
			table = new JTable(dtm);
			table.setBackground(Color.WHITE);
			table.setSelectionBackground(GUIUtils.getPrincipalColor());
			table.setSelectionForeground(GUIUtils.getNeutralColor());
			table.setShowGrid(false);
			table.setIntercellSpacing(new Dimension(0, 0));
			
			table.getTableHeader().setBackground(GUIUtils.getComplementaryColor());
			table.getTableHeader().setForeground(Color.WHITE);
			
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		} else {
			table.setModel(dtm);
		}

		// listener según el modo
		if (mode == EAplicationMode.BEER_MANAGEMENT) {
			table.getSelectionModel().addListSelectionListener(e -> {
				if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
					int fila = table.getSelectedRow();
					String serialNumber = table.getValueAt(fila, 0).toString();
					HandlingPersistenceBeer.SERIALNUMBER_BEER_SELECTED = serialNumber;
					mainWindow.getPanelRightButtonMainWindow().setVisible(true);
				}
			});
		} else if (mode == EAplicationMode.SALES_MANAGEMENT) {
			table.getSelectionModel().addListSelectionListener(e -> {
				if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
					int fila = table.getSelectedRow();
					String saleId = table.getValueAt(fila, 0).toString();
					HandlingPersistenceSalesOfBeer.ID_SALE_SELECTED = saleId;
					mainWindow.getPanelRightButtonMainWindow().setVisible(true);
				}
			});
		}

		revalidate();
		repaint();
	}

	public void addRow(Object[] row) {
		dtm.addRow(row);
	}

	public EAplicationMode getCurrentMode() {
		return currentMode;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}
}
