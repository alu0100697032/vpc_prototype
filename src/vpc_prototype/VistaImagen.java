package vpc_prototype;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaImagen extends JInternalFrame{

	private JPanel imagenGris;
	
	public VistaImagen(ArrayList<ArrayList<Integer>> imagen){
		setSize(imagen.size(), imagen.get(0).size());
		setClosable(true);
		setResizable(true);
		
		imagenGris = new JPanel();
		imagenGris.setSize(imagen.size(), imagen.get(0).size());

		//etiquetaImagen.setIcon(new ImageIcon(imagen));
		//add(etiquetaImagen);
		add(imagenGris);
		setVisible(true);
	}

	public JPanel getImagenGris() {
		return imagenGris;
	}

	public void setImagenGris(JPanel imagenGris) {
		this.imagenGris = imagenGris;
	}
}
