package dialogs;

import java.awt.Adjustable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import clases.ConjuntoImagenes;
import clases.Imagen;
import dibujablesImagen.DibujaImagen;
import dibujablesImagen.DibujaImagenInstanciable;
import dibujablesImagen.DibujaInternalFrameImagen;
import menuBar.DibujaMenuBar;
import statusBar.DibujaPanelEstado;

public class CambiarBrilloContrasteDialog extends JDialog {

	/*
	 * Atributos
	 */
	private JPanel nivelesBrilloContraste;
	protected JScrollBar nivelBrilloScrollbar;
	protected JScrollBar nivelContrasteScrollbar;
	protected JLabel mostrarNivelBrillo;
	protected JLabel mostrarNivelContraste;

	/*
	 * Constructor
	 */
	public CambiarBrilloContrasteDialog(Imagen imagen, ArrayList<DibujaInternalFrameImagen> imagenesAbiertas,
			DibujaMenuBar barraMenu, JDesktopPane grupoInternalFrames, DibujaPanelEstado panelEstado,
			ConjuntoImagenes conjuntoImagenes) {

		setResizable(false);

		nivelesBrilloContraste = new JPanel();
		nivelesBrilloContraste.setLayout(new BoxLayout(nivelesBrilloContraste, BoxLayout.PAGE_AXIS));

		nivelBrilloScrollbar = new JScrollBar(Adjustable.HORIZONTAL, imagen.getBrillo(), 0, 0, 255);
		nivelBrilloScrollbar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent ae) {
				mostrarNivelBrillo.setText("Brillo: " + ae.getValue());
			}
		});

		mostrarNivelBrillo = new JLabel("Brillo: " + nivelBrilloScrollbar.getValue());
		nivelesBrilloContraste.add(mostrarNivelBrillo);

		nivelesBrilloContraste.add(nivelBrilloScrollbar);

		nivelContrasteScrollbar = new JScrollBar(Adjustable.HORIZONTAL, imagen.getContraste(), 0, 0, 127);
		nivelContrasteScrollbar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent ae) {
				mostrarNivelContraste.setText("Contraste: " + ae.getValue());
			}
		});

		mostrarNivelContraste = new JLabel("Contraste: " + nivelContrasteScrollbar.getValue());
		nivelesBrilloContraste.add(mostrarNivelContraste);

		nivelesBrilloContraste.add(nivelContrasteScrollbar);

		Object[] opciones = { "Aceptar", "Cancelar" };
		int opcion = JOptionPane.showOptionDialog(this, nivelesBrilloContraste, "Brillo y Contraste",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == JOptionPane.YES_OPTION) {
			Imagen imagenClonada = imagen.clone();
			imagenClonada.ajustarBrilloContraste(nivelBrilloScrollbar.getValue(), nivelContrasteScrollbar.getValue());
			conjuntoImagenes.addImagen(imagenClonada);
			DibujaImagenInstanciable dibujaImagen = new DibujaImagenInstanciable(imagenClonada, imagenesAbiertas, barraMenu,
					grupoInternalFrames, panelEstado, conjuntoImagenes);
			DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(dibujaImagen);
			imagenesAbiertas.add(dibujaInternalFrameImagen);
			grupoInternalFrames.add(dibujaInternalFrameImagen);
		}
		accion();
	}
	/**
	 * accion
	 */
	public void accion() {
		
	}

	/**
	 * @return the nivelesBrilloContraste
	 */
	public JPanel getNivelesBrilloContraste() {
		return nivelesBrilloContraste;
	}

	/**
	 * @param nivelesBrilloContraste
	 *            the nivelesBrilloContraste to set
	 */
	public void setNivelesBrilloContraste(JPanel nivelesBrilloContraste) {
		this.nivelesBrilloContraste = nivelesBrilloContraste;
	}

	/**
	 * @return the nivelBrilloScrollBar
	 */
	public JScrollBar getNivelBrilloScrollBar() {
		return nivelBrilloScrollbar;
	}

	/**
	 * @param nivelBrilloScrollBar
	 *            the nivelBrilloScrollBar to set
	 */
	public void setNivelBrilloScrollBar(JScrollBar nivelBrilloScrollBar) {
		this.nivelBrilloScrollbar = nivelBrilloScrollBar;
	}

	/**
	 * @return the nivelContrasteScrollbar
	 */
	public JScrollBar getNivelContrasteScrollbar() {
		return nivelContrasteScrollbar;
	}

	/**
	 * @param nivelContrasteScrollbar
	 *            the nivelContrasteScrollbar to set
	 */
	public void setNivelContrasteScrollbar(JScrollBar nivelContrasteScrollbar) {
		this.nivelContrasteScrollbar = nivelContrasteScrollbar;
	}

	/**
	 * @return the mostrarNivelContraste
	 */
	public JLabel getMostrarNivelContraste() {
		return mostrarNivelContraste;
	}

	/**
	 * @param mostrarNivelContraste
	 *            the mostrarNivelContraste to set
	 */
	public void setMostrarNivelContraste(JLabel mostrarNivelContraste) {
		this.mostrarNivelContraste = mostrarNivelContraste;
	}

	/**
	 * @return the mostrarNivelBrillo
	 */
	public JLabel getMostrarNivelBrillo() {
		return mostrarNivelBrillo;
	}

	/**
	 * @param mostrarNivelBrillo
	 *            the mostrarNivelBrillo to set
	 */
	public void setMostrarNivelBrillo(JLabel mostrarNivelBrillo) {
		this.mostrarNivelBrillo = mostrarNivelBrillo;
	}
}
