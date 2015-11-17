package alertas;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Clases.Imagen;

public class InformacionImagen extends JDialog {

	public InformacionImagen(Imagen imagen){
		setTitle("Informacion de la imagen");
		setResizable(false);
		JOptionPane.showMessageDialog(
				this, imagen.informacionImagen());
	}
}
