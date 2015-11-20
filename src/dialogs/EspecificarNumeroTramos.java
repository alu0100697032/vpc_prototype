package dialogs;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EspecificarNumeroTramos extends JDialog {

	private JTextField numeroTramosEspecificados;
	private JPanel contenedor;

	public EspecificarNumeroTramos() {
		setResizable(false);

		contenedor = new JPanel();
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));

		numeroTramosEspecificados = new JTextField("1");

		contenedor.add(numeroTramosEspecificados);
		accion();

	}

	public void accion() {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int opcion = JOptionPane.showOptionDialog(this, contenedor,
				"Transformacion lineal por tramos", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == JOptionPane.YES_OPTION) {
			TransformacionLinealTramos transformacionLinealTramosJDialog = new TransformacionLinealTramos(
					Integer.parseInt(numeroTramosEspecificados.getText()));
		}
	}
}
