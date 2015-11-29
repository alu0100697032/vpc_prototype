package dialogs;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.omg.Messaging.SyncScopeHelper;

import clases.Imagen;

public class InformacionImagenDialog extends JDialog {

	public InformacionImagenDialog(Imagen imagen) {
		setResizable(false);
		JOptionPane.showMessageDialog(this, imagen.informacionImagen(), "Informacion de la imagen",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
