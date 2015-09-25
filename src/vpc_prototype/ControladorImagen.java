package vpc_prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorImagen implements ActionListener{

	private VistaApp vistaApp;
	private ModeloImagen modeloImagen;
	
	public ControladorImagen(){
		vistaApp = new VistaApp();
		vistaApp.getMenuItemAbrirImagen().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(vistaApp.getMenuItemAbrirImagen() == e.getSource()){
			modeloImagen = new ModeloImagen();
			VistaImagen vistaImagen = new VistaImagen(modeloImagen.getImagen());
			vistaApp.add(vistaImagen);
		}
	}

}
