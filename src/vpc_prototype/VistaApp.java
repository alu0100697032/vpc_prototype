package vpc_prototype;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VistaApp extends JFrame {

	private JMenuBar barraMenu;
	private JMenu menuArchivo;
	private JMenuItem menuItemAbrirImagen;
	private JMenuItem menuItemGuardarImagen;
	private ArrayList<VistaImagen> imagenesAbiertas;

	public VistaApp() {

		/* Propiedades de la ventana */
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

	/*
	 * Añadir una nueva ventana con su imagen
	 */

	public void addVentanaImagen(ModeloImagen modeloImagen) {
		VistaImagen imagen = new VistaImagen(modeloImagen.getImagen());
		imagenesAbiertas.add(imagen);
		add(imagen);
	}

	/*
	 * Guardar imagen seleccionada
	 */

	public void guardarImagen(ArrayList<ModeloImagen> modeloImagen) throws IOException {
		for (int i = 0; i < imagenesAbiertas.size(); i++) {
			if (imagenesAbiertas.get(i).isSelected()) {
				/*File file = new File("theimage.png");
				ImageIO.write(modeloImagen.get(i).getImagen(), modeloImagen
						.get(i).getExtensionIMagen(), file);*/
				
			}
		}
	}

	/* GETTER AND SETTER */
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

	public JMenuItem getMenuItemGuardarImagen() {
		return menuItemGuardarImagen;
	}

	public void setMenuItemGuardarImagen(JMenuItem menuItemGuardarImagen) {
		this.menuItemGuardarImagen = menuItemGuardarImagen;
	}

}
