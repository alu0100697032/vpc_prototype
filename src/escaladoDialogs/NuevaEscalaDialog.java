/**
 * File name:NuevaEscalaDialog.java
 * Package name: escaladoDialogs
 * Proyect name: vpc
 */
package escaladoDialogs;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.ConjuntoImagenes;
import clases.Imagen;
import dibujablesImagen.DibujaImagenInstanciable;
import dibujablesImagen.DibujaInternalFrameImagen;
import menuBar.DibujaMenuBar;
import statusBar.DibujaPanelEstado;

@SuppressWarnings("serial")
public class NuevaEscalaDialog extends JDialog {

	/**
	 * Constructor: NuevaEscalaDialog
	 */
	public NuevaEscalaDialog(Imagen imagen, ArrayList<DibujaInternalFrameImagen> imagenesAbiertas,
			DibujaMenuBar barraMenu, JDesktopPane grupoInternalFrames, DibujaPanelEstado panelEstado,
			ConjuntoImagenes conjuntoImagenes, int tecnica) {
		setResizable(false);
		JPanel nuevaEscalaJPanel = new JPanel();
		nuevaEscalaJPanel.setLayout(new BoxLayout(nuevaEscalaJPanel, BoxLayout.PAGE_AXIS));

		JLabel infoLabel = new JLabel("Porcentaje nueva imagen");
		JLabel anchoLabel = new JLabel("Ancho");
		JTextField anchoTexField = new JTextField("100");
		JLabel altoLabel = new JLabel("Alto");
		JTextField altoTexField = new JTextField("100");

		nuevaEscalaJPanel.add(infoLabel);
		nuevaEscalaJPanel.add(anchoLabel);
		nuevaEscalaJPanel.add(anchoTexField);
		nuevaEscalaJPanel.add(altoLabel);
		nuevaEscalaJPanel.add(altoTexField);

		Object[] opciones = { "Aceptar", "Cancelar" };
		int opcion = JOptionPane.showOptionDialog(this, nuevaEscalaJPanel, "Nueva escala", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == JOptionPane.YES_OPTION) {
			Imagen imagenEscalada = null;
			if (tecnica == 0) {// vmp
				imagenEscalada = new Imagen(imagen.escalarVMP(Float.parseFloat(anchoTexField.getText())/(float)100,
						Float.parseFloat(altoTexField.getText())/(float)100));
				
			} else if (tecnica == 1) {// bilinear
				imagenEscalada = new Imagen(imagen.escalarBilineal(Float.parseFloat(anchoTexField.getText())/(float)100,
						Float.parseFloat(altoTexField.getText())/(float)100));
			}
			conjuntoImagenes.addImagen(imagenEscalada);
			DibujaImagenInstanciable dibujaImagen = new DibujaImagenInstanciable(imagenEscalada, imagenesAbiertas, barraMenu,
					grupoInternalFrames, panelEstado, conjuntoImagenes);
			DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(dibujaImagen);
			imagenesAbiertas.add(dibujaInternalFrameImagen);
			grupoInternalFrames.add(dibujaInternalFrameImagen);
		}
	}

}
