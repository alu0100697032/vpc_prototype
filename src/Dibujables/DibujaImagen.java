package Dibujables;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import VentanaPrincipal.DibujaPanelEstado;
import Clases.Imagen;

public class DibujaImagen extends JLabel implements MouseMotionListener {

	/*
	 * Atributos
	 */
	private DibujaPanelEstado panelEstado;
	private Imagen imagen;

	/*
	 * Constructor
	 */
	public DibujaImagen(Imagen img, DibujaPanelEstado pEstado) {

		setPanelEstado(pEstado);
		
		setImagen(img);
		setSize(imagen.getImagen().getWidth(), imagen.getImagen().getHeight());
		setIcon(new ImageIcon(imagen.getImagen()));
		addMouseMotionListener(this);

		setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent evento) {
		// TODO Auto-generated method stub
		Color colorGris = new Color(imagen.getImagen().getRGB(evento.getX(),
				evento.getY()));
		panelEstado.getCoordenadasColor()
				.setText(
						"X = "
								+ evento.getX()
								+ " Y = "
								+ evento.getY()
								+ " Nivel de gris = "
								+ imagen.getNivelGrisPixel(evento.getX(), evento.getY()));
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
}
