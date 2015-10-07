package vpc_prototype;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class VistaImagen extends JInternalFrame{

	private JLabel etiquetaImagen;
	
	public VistaImagen(BufferedImage imagen){
		setSize(imagen.getWidth(), imagen.getHeight());
		setClosable(true);
		setResizable(true);
		
		etiquetaImagen = new JLabel();
		etiquetaImagen.setIcon(new ImageIcon(imagen));
		add(etiquetaImagen);
		
		setVisible(true);
	}

	public JLabel getEtiquetaImagen() {
		return etiquetaImagen;
	}

	public void setEtiquetaImagen(JLabel etiquetaImagen) {
		this.etiquetaImagen = etiquetaImagen;
	}
}
