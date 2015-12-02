package dibujablesHistogramas;

import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;

public class DibujaInternalFrameHistogramaAbsoluto extends JInternalFrame{
	
	private DibujaHistogramaAbsoluto dibujaHistograma;

	public DibujaInternalFrameHistogramaAbsoluto(DibujaHistogramaAbsoluto histograma){
		setDibujaHistograma(histograma);
		add(dibujaHistograma);
		pack();
		setClosable(true);
		setResizable(true);
		setVisible(true);
	}

	/**
	 * @return the dibujaHistograma
	 */
	public DibujaHistogramaAbsoluto getDibujaHistograma() {
		return dibujaHistograma;
	}

	/**
	 * @param dibujaHistograma the dibujaHistograma to set
	 */
	public void setDibujaHistograma(DibujaHistogramaAbsoluto dibujaHistograma) {
		this.dibujaHistograma = dibujaHistograma;
	}
}
