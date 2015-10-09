package vpc_prototype;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class VistaImagen extends JInternalFrame{

	private JLabel pintarImagenGris;

	public VistaImagen(BufferedImage imagen){
		setSize(imagen.getWidth(), imagen.getHeight());
		setClosable(true);
		setResizable(true);

		pintarImagenGris = new JLabel();
		pintarImagenGris.setIcon(new ImageIcon(imagen));
		add(pintarImagenGris);
		setVisible(true);
	}

	public JLabel getImagenGris() {
		return pintarImagenGris;
	}

	public void setImagenGris(JLabel imagenGris) {
		this.pintarImagenGris = imagenGris;
	}
}
