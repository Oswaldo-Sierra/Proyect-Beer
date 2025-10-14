package com.edu.uptc.handlingBeer.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

public class GraficoTorta extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public GraficoTorta() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<String>();
        dataset.setValue("Categor�a A", 40);
        dataset.setValue("Categor�a B", 25);
        dataset.setValue("Categor�a C", 20); 
        dataset.setValue("Categor�a D", 15);
        JFreeChart chart = ChartFactory.createPieChart(
                "Ejemplo de Diagrama de Torta",
                dataset,
                true,
                true,
                false
        );
        ChartPanel panel = new ChartPanel(chart);
        add(panel);
    }

    public static void main(String[] args) {
    	GraficoTorta ejemplo = new GraficoTorta();
        ejemplo.setSize(800, 600);
        ejemplo.setLocationRelativeTo(null);
        ejemplo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ejemplo.setVisible(true);
    }
}
