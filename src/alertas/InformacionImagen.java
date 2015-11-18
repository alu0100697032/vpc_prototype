package alertas;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.omg.Messaging.SyncScopeHelper;

import Clases.Imagen;

public class InformacionImagen extends JDialog {

	public InformacionImagen(Imagen imagen) {
		setResizable(false);
		JOptionPane.showMessageDialog(this, imagen.informacionImagen(), "Informacion de la imagen",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
