package vpc_prototype;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VistaApp extends JFrame{
	
	private JMenuBar barraMenu;
	private JMenu menuArchivo;
	private JMenuItem menuItemAbrirImagen;
	private ArrayList<VistaImagen> imagenesAbiertas;
	
	public VistaApp(){
		
		/*Propiedades de la ventana*/
		setTitle("Photoshop prototype");
		setLayout(null);
		setMinimumSize(new Dimension(600, 400));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		imagenesAbiertas = new ArrayList<VistaImagen>();
		
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		menuArchivo = new JMenu("Archivo");
		menuItemAbrirImagen = new JMenuItem("Abrir Imagen");
		menuArchivo.add(menuItemAbrirImagen);
		
		barraMenu.add(menuArchivo);
		
		setVisible(true);
	}
	
	public void addVentanaImagen(ModeloImagen modeloImagen){
		VistaImagen imagen = new VistaImagen(modeloImagen.getImagenGris());
		imagenesAbiertas.add(imagen);
		add(imagen);
	}
	
	/*GETTER AND SETTER*/
	public JMenuBar getBarraMenu() {
		return barraMenu;
	}
	public void setBarraMenu(JMenuBar barraMenu) {
		this.barraMenu = barraMenu;
	}

	public JMenu getMenuArchivo() {
		return menuArchivo;
	}

	public void setMenuArchivo(JMenu menuArchivo) {
		this.menuArchivo = menuArchivo;
	}

	public JMenuItem getMenuItemAbrirImagen() {
		return menuItemAbrirImagen;
	}

	public void setMenuItemAbrirImagen(JMenuItem menuItemAbrirImagen) {
		this.menuItemAbrirImagen = menuItemAbrirImagen;
	}

}
