/**
 * File name:SeleccionarUmbralDialog.java
 * Package name: dialogs
 * Proyect name: vpc
 */
package dialogs;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Imagen;

public class SeleccionarUmbralDialog extends JDialog {
	/**
	 * Atributos
	 */
	private JPanel JPanelUmbral;
	private JLabel JLabelValorUmbral;
	private JTextField JTextFieldValorUmbral;

	/**
	 * Constructor: SeleccionarUmbralDialog
	 */
	public SeleccionarUmbralDialog(Imagen imagen) {
		setResizable(false);
		JPanelUmbral = new JPanel();
		JPanelUmbral.setLayout(new BoxLayout(JPanelUmbral, BoxLayout.PAGE_AXIS));
		JLabelValorUmbral = new JLabel("Umbral");
		JTextFieldValorUmbral = new JTextField("10");
		JPanelUmbral.add(JLabelValorUmbral);
		JPanelUmbral.add(JTextFieldValorUmbral);
		accion(imagen);
	}

	/**
	 * accion
	 */
	public void accion(Imagen imagen) {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int opcion = JOptionPane.showOptionDialog(this, JPanelUmbral, "Seleccionar Umbral", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == JOptionPane.YES_OPTION) {
			imagen.repintarMapaCambios(Integer.parseInt(JTextFieldValorUmbral.getText()));
		}
	}
}
