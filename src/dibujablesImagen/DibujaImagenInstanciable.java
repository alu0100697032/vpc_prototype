/**
 * File name:DibujaImagenInstanciable.java
 * Package name: dibujablesImagen
 * Proyect name: vpc
 */
package dibujablesImagen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JDesktopPane;

import clases.ConjuntoImagenes;
import clases.Imagen;
import menuBar.DibujaBarraMenu;
import statusBar.DibujaPanelEstado;

public class DibujaImagenInstanciable extends DibujaImagen implements MouseMotionListener{

	/**
	 * Atributos
	 */
	private MouseListener mouselistener;
	/** Constructor: DibujaImagenInstanciable
	 */
	public DibujaImagenInstanciable(Imagen img, ArrayList<DibujaInternalFrameImagen> imagenesAbiertas,
			DibujaBarraMenu barraMenu, JDesktopPane grupoInternalFrames, DibujaPanelEstado pEstado,
			ConjuntoImagenes conjuntoImagenes) {
		super(img, imagenesAbiertas, barraMenu, grupoInternalFrames, pEstado, conjuntoImagenes);
		// TODO Auto-generated constructor stub
		addMouseMotionListener(this);
		mouselistener = (new MouseAdapter() {

			public void mousePressed(MouseEvent e) { // cuando se presiona el
														// mouse
				inicioArrastre = new Point(e.getX(), e.getY());
				finalArrastre = inicioArrastre;
				repaint();
			}

			public void mouseReleased(MouseEvent e) { // cuando se deja de
														// presionar el mouse
				rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY());
				Imagen subImagen = new Imagen(imagen.subImagen(inicioArrastre, e.getPoint()),
						"subImagen_" + imagen.getNombreImagen(), imagen.getExtensionImagen());
				conjuntoImagenes.addImagen(subImagen);
				DibujaImagenInstanciable dibujaImagen = new DibujaImagenInstanciable(subImagen, imagenesAbiertas, barraMenu,
						grupoInternalFrames, panelEstado, conjuntoImagenes);
				DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(dibujaImagen);
				imagenesAbiertas.add(dibujaInternalFrameImagen);
				grupoInternalFrames.add(dibujaInternalFrameImagen);
				inicioArrastre = null;
				finalArrastre = null;
				repaint();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) { // cuando se esta
														// arrastrando el mouse
				finalArrastre = new Point(e.getX(), e.getY());
				repaint();
			}
		});
	}
	/**
	 * habilitarSeleccionRegionInteres
	 */
	public void habilitarSeleccionRegionInteres() {
		addMouseListener(mouselistener);
	}
	/**
	 * deshabilitarSeleccionRegionInteres
	 */
	public void deshabilitarSeleccionRegionInteres() {
		removeMouseListener(mouselistener);
	}
	/**
	 * paint
	 */
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		if (inicioArrastre != null && finalArrastre != null) {
			rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, finalArrastre.x, finalArrastre.y);
			g2.draw(rectangulo);
		}
	}

	/**
	 * crearRectangulo
	 */
	private Rectangle2D.Float crearRectangulo(int x1, int y1, int x2, int y2) {
		return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.
	 * MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent evento) {
		// TODO Auto-generated method stub
		panelEstado.getCoordenadasColor().setText("X = " + evento.getX() + " Y = " + evento.getY() + " Nivel de gris = "
				+ imagen.getNivelGrisPixel(evento.getX(), evento.getY()));
	}

	/**
	 * @return the mouselistener
	 */
	public MouseListener getMouselistener() {
		return mouselistener;
	}

	/**
	 * @param mouselistener the mouselistener to set
	 */
	public void setMouselistener(MouseListener mouselistener) {
		this.mouselistener = mouselistener;
	}
}
