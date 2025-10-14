package com.edu.uptc.handlingBeer.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.Color;

import javax.swing.*;

public class ReportsWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private DefaultPieDataset<String> dataset = new DefaultPieDataset<String>();
	private JFreeChart chart = null;
	private ChartPanel panel = null;
	private MainWindow mainWindow;

	public ReportsWindow(MainWindow mainWindow) {
		this.mainWindow =  mainWindow;
		this.initComponents();
		this.addComoponents();
	}

	private void addComoponents() {
		this.add(panel);

	}

	private void initComponents() {
		setUpScreen();
		initializeComponents();

	}

	private void initializeComponents() {
		this.chart = ChartFactory.createPieChart("Marca de Cervezas", dataset, true, true, false);
		this.panel = new ChartPanel(chart);

	}

	private void setUpScreen() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);

	}
	
	

	public DefaultPieDataset<String> getDataset() {
		return dataset;
	}

	public void setDataset(DefaultPieDataset<String> dataset) {
		this.dataset = dataset;
	}

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public ChartPanel getPanel() {
		return panel;
	}

	public void setPanel(ChartPanel panel) {
		this.panel = panel;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		ReportsWindow reportsWindow = new ReportsWindow(mainWindow);
		reportsWindow.setVisible(true);
	}
	
	

}
