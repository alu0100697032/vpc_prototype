package Dibujables;

import javax.swing.JInternalFrame;

public class DibujaInternalFrameImagen extends JInternalFrame{
	/*
	 * Atributos
	 */
	private DibujaImagen dibujaImagen;

	/*
	 * Constructor
	 */
	public DibujaInternalFrameImagen(DibujaImagen img){
		
		setDibujaImagen(img);
		setSize(dibujaImagen.getWidth(), dibujaImagen.getHeight());
		add(dibujaImagen);
		
		setClosable(true);
		setResizable(false);
		setVisible(true);
	}
	/**
	 * @return the imagen
	 */
	public DibujaImagen getDibujaImagen() {
		return dibujaImagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setDibujaImagen(DibujaImagen imagen) {
		this.dibujaImagen = imagen;
	}
}
