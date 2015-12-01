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

public class TransformacionLinealTramosDialog extends JDialog {
	/**
	 * Atributos
	 */
	protected ArrayList<JTextField> JTextFieldscoordenadasTramos;
	protected JPanel JPaneltramosCoordenadas;
	protected ArrayList<JLabel> jLabelCoordenadasTramos;
	/**
	 * Constructor: TransformacionLinealTramos
	 */
	public TransformacionLinealTramosDialog(Imagen imagen, ArrayList<DibujaInternalFrameImagen> imagenesAbiertas,
			DibujaBarraMenu barraMenu, JDesktopPane grupoInternalFrames, DibujaPanelEstado panelEstado,
			ConjuntoImagenes conjuntoImagenes, int numeroTramos) {
		setResizable(false);
		JPaneltramosCoordenadas = new JPanel();
		JPaneltramosCoordenadas.setLayout(new BoxLayout(JPaneltramosCoordenadas, BoxLayout.PAGE_AXIS));
		jLabelCoordenadasTramos = new ArrayList<>();
		JTextFieldscoordenadasTramos = new ArrayList<>();
		for(int i = 0; i <= numeroTramos; i++) {
			JPaneltramosCoordenadas.add(new JLabel("Coordenada " + (i)));
			JTextField textFieldx = new JTextField();
			JTextField textFieldy = new JTextField();
			JTextFieldscoordenadasTramos.add(textFieldx);
			JTextFieldscoordenadasTramos.add(textFieldy);
			JPaneltramosCoordenadas.add(textFieldx);
			JPaneltramosCoordenadas.add(textFieldy);
		}
		accion(imagen,imagenesAbiertas,barraMenu,grupoInternalFrames,panelEstado,conjuntoImagenes);
	}
	/**
	 * accion
	 */
	public void accion(Imagen imagen, ArrayList<DibujaInternalFrameImagen> imagenesAbiertas,
			DibujaBarraMenu barraMenu, JDesktopPane grupoInternalFrames, DibujaPanelEstado panelEstado,
			ConjuntoImagenes conjuntoImagenes) {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int opcion = JOptionPane.showOptionDialog(this, JPaneltramosCoordenadas,
				"Coordenadas", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == JOptionPane.YES_OPTION) {
			ArrayList<Integer> coordenadas = new ArrayList<>();
			for(int i = 0; i < JTextFieldscoordenadasTramos.size(); i++) {
				coordenadas.add(Integer.parseInt(JTextFieldscoordenadasTramos.get(i).getText()));
			}
			Imagen imagenClonada = imagen.clone();
			imagenClonada.ajusteLinealTramos(coordenadas);
			conjuntoImagenes.addImagen(imagenClonada);
			DibujaImagenInstanciable dibujaImagen = new DibujaImagenInstanciable(imagenClonada, imagenesAbiertas, barraMenu,
					grupoInternalFrames, panelEstado, conjuntoImagenes);
			DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(dibujaImagen);
			imagenesAbiertas.add(dibujaInternalFrameImagen);
			grupoInternalFrames.add(dibujaInternalFrameImagen);
		}
	}
}
