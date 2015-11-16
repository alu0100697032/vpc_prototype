package Dibujables;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class DibujaHistograma extends JPanel{
	/*
	 * Atributos
	 */
	private HashMap<Integer, Integer> histograma;
	/*
	 * Constructor	
	 */
	public DibujaHistograma(HashMap<Integer, Integer> histogramaImagen){
		
		setHistograma(histogramaImagen);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (Entry<Integer, Integer> entry : histograma.entrySet()) {
		    dataset.setValue(entry.getValue(), "Histograma imagen...", entry.getKey());
		}
		
		JFreeChart chart = ChartFactory.createBarChart
		        ("Histograma","Nivel de Gris", "Número de pixeles",
		        dataset, PlotOrientation.VERTICAL, true,true, false);
        
        ChartPanel chartPanel = new ChartPanel(chart);
		add(chartPanel);
		
        setVisible(true);
	}
	
	/**
	 * @return the histograma
	 */
	public HashMap<Integer, Integer> getHistograma() {
		return histograma;
	}
	/**
	 * @param histograma the histograma to set
	 */
	public void setHistograma(HashMap<Integer, Integer> histograma) {
		this.histograma = histograma;
	}

}
