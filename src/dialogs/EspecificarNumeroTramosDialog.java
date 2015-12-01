package dialogs;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.ConjuntoImagenes;
import clases.Imagen;
import dibujablesImagen.DibujaInternalFrameImagen;
import menuBar.DibujaBarraMenu;
import statusBar.DibujaPanelEstado;

public class EspecificarNumeroTramosDialog extends JDialog {

	private JTextField numeroTramosEspecificados;
	private JPanel contenedor;

	public EspecificarNumeroTramosDialog(Imagen imagen, ArrayList<DibujaInternalFrameImagen> imagenesAbiertas,
			DibujaBarraMenu barraMenu, JDesktopPane grupoInternalFrames, DibujaPanelEstado panelEstado,
			ConjuntoImagenes conjuntoImagenes) {
		setResizable(false);
		contenedor = new JPanel();
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));

		numeroTramosEspecificados = new JTextField("2");

		contenedor.add(numeroTramosEspecificados);
		accion(imagen, imagenesAbiertas, barraMenu, grupoInternalFrames, panelEstado, conjuntoImagenes);

	}

	public void accion(Imagen imagen, ArrayList<DibujaInternalFrameImagen> imagenesAbiertas, DibujaBarraMenu barraMenu,
			JDesktopPane grupoInternalFrames, DibujaPanelEstado panelEstado, ConjuntoImagenes conjuntoImagenes) {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int opcion = JOptionPane.showOptionDialog(this, contenedor, "Número de tramos", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == JOptionPane.YES_OPTION) {
			TransformacionLinealTramosDialog transformacionLinealTramosJDialog = new TransformacionLinealTramosDialog(
					imagen, imagenesAbiertas, barraMenu, grupoInternalFrames, panelEstado, conjuntoImagenes,
					Integer.parseInt(numeroTramosEspecificados.getText()));
		}
	}
}
