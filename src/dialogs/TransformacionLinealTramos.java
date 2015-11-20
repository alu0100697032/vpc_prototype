package dialogs;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransformacionLinealTramos extends JDialog {

	/**
	 * Atributos
	 */

	protected ArrayList<JTextField> coordenadasTramos;
	protected JPanel tramosCoordenadas;
	protected ArrayList<JLabel> jLabelCoordenadasTramos;

	public TransformacionLinealTramos(int numeroTramos) {
		setResizable(false);
		tramosCoordenadas = new JPanel();
		Object[] opciones = { "Aceptar", "Cancelar" };
		int opcion = JOptionPane.showOptionDialog(this, tramosCoordenadas,
				"Transformacion lineal por tramos", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == JOptionPane.YES_OPTION) {

		}
	}
}
