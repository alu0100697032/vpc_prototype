package dibujablesImagen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import clases.ConjuntoImagenes;
import clases.Imagen;
import menuBar.DibujaMenuBar;
import statusBar.DibujaPanelEstado;

public class DibujaImagen extends JLabel{

	/**
	 * Atributos
	 */
	protected DibujaPanelEstado panelEstado;
	protected Imagen imagen;
	protected Point inicioArrastre;
	protected Point finalArrastre;
	protected Shape rectangulo;

	/**
	 * Constructor: DibujaImagen
	 */
	public DibujaImagen(Imagen img, ArrayList<DibujaInternalFrameImagen> imagenesAbiertas, DibujaMenuBar barraMenu,
			JDesktopPane grupoInternalFrames, DibujaPanelEstado pEstado, ConjuntoImagenes conjuntoImagenes) {

		setPanelEstado(pEstado);

		setImagen(img);
		setSize(imagen.getImagen().getWidth(), imagen.getImagen().getHeight());
		setIcon(new ImageIcon(imagen.getImagen()));
		setVisible(true);
	}

	/**
	 * @return the panelEstado
	 */
	public DibujaPanelEstado getPanelEstado() {
		return panelEstado;
	}

	/**
	 * @param panelEstado
	 *            the panelEstado to set
	 */
	public void setPanelEstado(DibujaPanelEstado panelEstado) {
		this.panelEstado = panelEstado;
	}

	/**
	 * @return the imagen
	 */
	public Imagen getImagen() {
		return imagen;
	}

	/**
	 * @param imagen
	 *            the imagen to set
	 */
	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the puntoInicial
	 */
	public Point getPuntoInicial() {
		return inicioArrastre;
	}

	/**
	 * @param puntoInicial
	 *            the puntoInicial to set
	 */
	public void setPuntoInicial(Point puntoInicial) {
		this.inicioArrastre = puntoInicial;
	}

	/**
	 * @return the finalArrastre
	 */
	public Point getFinalArrastre() {
		return finalArrastre;
	}

	/**
	 * @param finalArrastre
	 *            the finalArrastre to set
	 */
	public void setFinalArrastre(Point finalArrastre) {
		this.finalArrastre = finalArrastre;
	}
}
