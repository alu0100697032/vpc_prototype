package vpc_prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorImagen implements ActionListener {

	private VistaApp vistaApp;
	private ArrayList<ModeloImagen> listaModeloImagen;

	public ControladorImagen() {
		vistaApp = new VistaApp();
		vistaApp.getMenuItemAbrirImagen().addActionListener(this);
		vistaApp.getMenuItemGuardarImagen().addActionListener(this);
		listaModeloImagen = new ArrayList<ModeloImagen>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (vistaApp.getMenuItemAbrirImagen() == e.getSource()) {
			ModeloImagen modeloImagen = new ModeloImagen();
			listaModeloImagen.add(modeloImagen);
			vistaApp.addVentanaImagen(modeloImagen);
		}
		if (vistaApp.getMenuItemGuardarImagen() == e.getSource()) {
			vistaApp.guardarImagen(listaModeloImagen);
		}
	}

}
