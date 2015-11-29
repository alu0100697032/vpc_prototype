package dialogs;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransformacionLinealTramosDialog extends JDialog {
	/**
	 * Atributos
	 */
	protected ArrayList<JTextField> JTextFieldscoordenadasTramos;
	protected JPanel JPaneltramosCoordenadas;
	protected ArrayList<JLabel> jLabelCoordenadasTramos;
	/**
	 * Constructor: TransformacionLinealTramos
	 */
	public TransformacionLinealTramosDialog(int numeroTramos) {
		setResizable(false);
		JPaneltramosCoordenadas = new JPanel();
		JPaneltramosCoordenadas.setLayout(new BoxLayout(JPaneltramosCoordenadas, BoxLayout.PAGE_AXIS));
		jLabelCoordenadasTramos = new ArrayList<>();
		JTextFieldscoordenadasTramos = new ArrayList<>();
		for(int i = 0; i < numeroTramos - 1; i++) {
			JPaneltramosCoordenadas.add(new JLabel("Tramo: " + (i+1)));
			JTextField textFieldx = new JTextField();
			JTextField textFieldy = new JTextField();
			JTextFieldscoordenadasTramos.add(textFieldx);
			JTextFieldscoordenadasTramos.add(textFieldy);
			JPaneltramosCoordenadas.add(textFieldx);
			JPaneltramosCoordenadas.add(textFieldy);
		}
		accion();
	}
	/**
	 * accion
	 */
	public void accion() {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int opcion = JOptionPane.showOptionDialog(this, JPaneltramosCoordenadas,
				"Coordenadas", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == JOptionPane.YES_OPTION) {

		}
	}
}
