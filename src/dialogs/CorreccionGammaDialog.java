/**
 * File name:CorreccionGamma.java
 * Package name: dialogs
 * Proyect name: vpc
 */
package dialogs;

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
import menuBar.DibujaBarraMenu;
import statusBar.DibujaPanelEstado;

public class CorreccionGammaDialog extends JDialog{
	/**
	 * Atributos
	 */
	private JPanel JPanelGamma;
	private JLabel JLabelValorY;
	private JTextField JTextFieldValorY;
	/**
	 * Constructor: CorreccionGamma
	 */
	public CorreccionGammaDialog(Imagen imagen, ArrayList<DibujaInternalFrameImagen> imagenesAbiertas,
			DibujaBarraMenu barraMenu, JDesktopPane grupoInternalFrames, DibujaPanelEstado panelEstado,
			ConjuntoImagenes conjuntoImagenes) {
		setResizable(false);
		JPanelGamma = new JPanel();
		JPanelGamma.setLayout(new BoxLayout(JPanelGamma, BoxLayout.PAGE_AXIS));
		JLabelValorY = new JLabel("Valor de Y");
		JTextFieldValorY = new JTextField("0.51");
		JPanelGamma.add(JLabelValorY);
		JPanelGamma.add(JTextFieldValorY);
		accion(imagen,imagenesAbiertas,barraMenu,grupoInternalFrames,panelEstado,conjuntoImagenes, JTextFieldValorY);
	}
	/**
	 * accion
	 */
	public void accion(Imagen imagen, ArrayList<DibujaInternalFrameImagen> imagenesAbiertas,
			DibujaBarraMenu barraMenu, JDesktopPane grupoInternalFrames, DibujaPanelEstado panelEstado,
			ConjuntoImagenes conjuntoImagenes, JTextField valorY) {
		
		Object[] opciones = { "Aceptar", "Cancelar" };
		int opcion = JOptionPane.showOptionDialog(this, JPanelGamma,
				"Cooreccion Gamma", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == JOptionPane.YES_OPTION) {
			Imagen imagenClonada = imagen.clone();
			imagenClonada.correccionGamma(Double.parseDouble(valorY.getText()));
			conjuntoImagenes.addImagen(imagenClonada);
			DibujaImagenInstanciable dibujaImagen = new DibujaImagenInstanciable(imagenClonada, imagenesAbiertas, barraMenu,
					grupoInternalFrames, panelEstado, conjuntoImagenes);
			DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(dibujaImagen);
			imagenesAbiertas.add(dibujaInternalFrameImagen);
			grupoInternalFrames.add(dibujaInternalFrameImagen);
		}
	}
}
