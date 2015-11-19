package dibujablesImagen;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class DibujaInternalFrameImagen extends JInternalFrame{
	/*
	 * Atributos
	 */
	private DibujaImagenInstanciable dibujaImagenInstanciable;

	/*
	 * Constructor
	 */
	public DibujaInternalFrameImagen(DibujaImagenInstanciable img){
		
		setDibujaImagenInstanciable(img);
		setSize(dibujaImagenInstanciable.getWidth(), dibujaImagenInstanciable.getHeight());
		
		JPanel contentPane = new JPanel();
		contentPane.setSize(img.getWidth(), img.getHeight());
		setContentPane(new JPanel());
		
		add(dibujaImagenInstanciable);
		
		setClosable(true);
		setResizable(true);
		setVisible(true);
	}
	/**
	 * @return the imagen
	 */
	public DibujaImagenInstanciable getDibujaImagenInstanciable() {
		return dibujaImagenInstanciable;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setDibujaImagenInstanciable(DibujaImagenInstanciable imagen) {
		this.dibujaImagenInstanciable = imagen;
	}
}
