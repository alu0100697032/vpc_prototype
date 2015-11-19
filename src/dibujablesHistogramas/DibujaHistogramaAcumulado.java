package dibujablesHistogramas;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class DibujaHistogramaAcumulado extends JPanel{

	/*
	 * Atributos
	 */
	private HashMap<Integer, Integer> histograma;
	/*
	 * Constructor	
	 */
	public DibujaHistogramaAcumulado(HashMap<Integer, Integer> histogramaAcumuladoImagen){
		
		setHistograma(histogramaAcumuladoImagen);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (Entry<Integer, Integer> entry : histograma.entrySet()) {
		    dataset.setValue(entry.getValue(), "Histograma imagen...", entry.getKey());
		}
		
		JFreeChart chart = ChartFactory.createBarChart
		        ("Histograma Acumulado","Nivel de Gris", "Número de pixeles",
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
