package dibujablesHistogramas;

import javax.swing.JInternalFrame;

public class DibujaInternalFrameHistogramaAcumulado extends JInternalFrame{
	
	private DibujaHistogramaAcumulado dibujaHistogramaAcumulado;

	public DibujaInternalFrameHistogramaAcumulado(DibujaHistogramaAcumulado histograma){
		setDibujaHistogramaAcumulado(histograma);
		add(dibujaHistogramaAcumulado);
		pack();
		setClosable(true);
		setResizable(true);
		setVisible(true);
	}

	/**
	 * @return the dibujaHistograma
	 */
	public DibujaHistogramaAcumulado getDibujaHistograma() {
		return dibujaHistogramaAcumulado;
	}

	/**
	 * @param dibujaHistograma the dibujaHistograma to set
	 */
	public void setDibujaHistogramaAcumulado(DibujaHistogramaAcumulado dibujaHistograma) {
		this.dibujaHistogramaAcumulado = dibujaHistograma;
	}
}
