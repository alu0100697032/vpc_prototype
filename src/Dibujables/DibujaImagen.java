package Dibujables;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DibujaImagen extends JLabel implements MouseMotionListener {

	/*
	 * Atributos
	 */
	private DibujaPanelEstado panelEstado;
	private BufferedImage imagen;

	/*
	 * Constructor
	 */
	public DibujaImagen(BufferedImage img, DibujaPanelEstado pEstado) {

		setPanelEstado(pEstado);
		setImagen(img);
		setSize(imagen.getWidth(), imagen.getHeight());
		setIcon(new ImageIcon(imagen));
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
		Color colorGris = new Color(imagen.getRGB(evento.getX(), evento.getY()));
		panelEstado.getCoordenadasColor().setText("X = " + evento.getX() + " Y = " + evento.getY() + " Nivel de gris = "
				+ colorGris.getBlue());
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
	public BufferedImage getImagen() {
		return imagen;
	}

	/**
	 * @param imagen
	 *            the imagen to set
	 */
	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}
}
