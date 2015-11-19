package dibujablesImagen;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

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
		
		JPanel contentPane = new JPanel();
		contentPane.setSize(img.getWidth(), img.getHeight());
		setContentPane(new JPanel());
		
		add(dibujaImagen);
		
		setClosable(true);
		setResizable(true);
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
