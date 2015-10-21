package Dibujables;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class DibujaImagen extends JInternalFrame {

	private JLabel pintarImagenGris;

	public DibujaImagen(BufferedImage imagen) {
		setSize(imagen.getWidth(), imagen.getHeight());
		setClosable(true);
		setResizable(true);

		setPintarImagenGris(new JLabel());
		getPintarImagenGris().setIcon(new ImageIcon(imagen));
		add(getPintarImagenGris());
		setVisible(true);
	}

	public JLabel getPintarImagenGris() {
		return pintarImagenGris;
	}

	public void setPintarImagenGris(JLabel imagenGris) {
		this.pintarImagenGris = imagenGris;
	}
}
