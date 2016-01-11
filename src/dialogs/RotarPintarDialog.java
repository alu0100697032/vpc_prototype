/**
 * File name:RotacionDialog.java
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
import menuBar.DibujaMenuBar;
import statusBar.DibujaPanelEstado;

public class RotarPintarDialog extends JDialog{
	/**
	 * Atributos
	 */
	public RotarPintarDialog(Imagen imagen, ArrayList<DibujaInternalFrameImagen> imagenesAbiertas,
			DibujaMenuBar barraMenu, JDesktopPane grupoInternalFrames, DibujaPanelEstado panelEstado,
			ConjuntoImagenes conjuntoImagenes) {
		setResizable(false);
		JPanel JPanelGrados = new JPanel();
		JPanelGrados.setLayout(new BoxLayout(JPanelGrados, BoxLayout.PAGE_AXIS));
		JLabel JLabelValorGrados = new JLabel("Grados");
		JTextField JTextFieldValorGrados = new JTextField("90");
		JPanelGrados.add(JLabelValorGrados);
		JPanelGrados.add(JTextFieldValorGrados);
		
		Object[] opciones = { "Aceptar", "Cancelar" };
		int opcion = JOptionPane.showOptionDialog(this, JPanelGrados,
				"Rotar y pintar", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == JOptionPane.YES_OPTION) {
			Imagen imagenRotada = new Imagen(imagen.rotarPintar(Integer.parseInt(JTextFieldValorGrados.getText())));
			conjuntoImagenes.addImagen(imagenRotada);
			DibujaImagenInstanciable dibujaImagen = new DibujaImagenInstanciable(imagenRotada, imagenesAbiertas, barraMenu,
					grupoInternalFrames, panelEstado, conjuntoImagenes);
			DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(dibujaImagen);
			imagenesAbiertas.add(dibujaInternalFrameImagen);
			grupoInternalFrames.add(dibujaInternalFrameImagen);
		}
	}
}
