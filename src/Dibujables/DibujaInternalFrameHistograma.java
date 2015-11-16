package Dibujables;

import javax.swing.JInternalFrame;

public class DibujaInternalFrameHistograma extends JInternalFrame{
	
	private DibujaHistograma dibujaHistograma;

	public DibujaInternalFrameHistograma(DibujaHistograma histograma){
		setDibujaHistograma(histograma);
		//setSize(dibujaHistograma.getWidth(), dibujaHistograma.getHeight());
		add(dibujaHistograma);
		pack();
		setClosable(true);
		setResizable(true);
		setVisible(true);
	}

	/**
	 * @return the dibujaHistograma
	 */
	public DibujaHistograma getDibujaHistograma() {
		return dibujaHistograma;
	}

	/**
	 * @param dibujaHistograma the dibujaHistograma to set
	 */
	public void setDibujaHistograma(DibujaHistograma dibujaHistograma) {
		this.dibujaHistograma = dibujaHistograma;
	}
}
