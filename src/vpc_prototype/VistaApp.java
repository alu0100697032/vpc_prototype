package vpc_prototype;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VistaApp extends JFrame {

	/*
	 * Atributos 
	 */
	private ArrayList<VistaImagen> imagenesAbiertas;
	private JMenuBar barraMenu;
	
	private JMenu menuArchivo;
	private JMenuItem menuItemAbrirImagen;
	private JMenuItem menuItemGuardarImagen;
	
	private JMenu menuEditar;
	private JMenuItem menuItemCrearCopia;
	
	/*
	 * Constructor
	 */
	
	public VistaApp() {

		/* Propiedades de la ventana */
		setTitle("Photoshop prototype");
		setLayout(null);
		setMinimumSize(new Dimension(600, 400));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		imagenesAbiertas = new ArrayList<VistaImagen>();

		//MenuBar
		
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);

		/*
		 * Pestañas del menu
		 */
		
		//Archivo
		
		menuArchivo = new JMenu("Archivo");
		
		menuItemAbrirImagen = new JMenuItem("Abrir Imagen");
		menuItemGuardarImagen = new JMenuItem("Guardar Como...");
		menuArchivo.add(menuItemAbrirImagen);
		menuArchivo.add(menuItemGuardarImagen);
		
		barraMenu.add(menuArchivo);

		//Editar
		
		menuEditar = new JMenu("Editar");
		
		menuItemCrearCopia = new JMenuItem("Crear Copia");
		menuEditar.add(menuItemCrearCopia);
		
		barraMenu.add(menuEditar);
		
		setVisible(true);
	}

	/*
	 * AÃ±adir una nueva ventana con su imagen
	 */

	public void addVentanaImagen(ModeloImagen modeloImagen) {
		VistaImagen imagen = new VistaImagen(modeloImagen.getImagen());
		imagenesAbiertas.add(imagen);
		add(imagen);
	}

	/*
	 * Guardar imagen seleccionada
	 */

	// al cerrar ventanas se eliminan imagenesAbiertas pero no de la lista
	// modeloImagen con lo cual se pierde la referencia verdadera(probar)
	public void guardarImagen(ArrayList<ModeloImagen> modeloImagen) {
		for (int i = 0; i < imagenesAbiertas.size(); i++) {
			if (imagenesAbiertas.get(i).isSelected()) {
				File saveFile = new File("imagen." + modeloImagen.get(i).getExtensionImagen());
				JFileChooser chooser = new JFileChooser();
				chooser.setSelectedFile(saveFile);
				int rval = chooser.showSaveDialog(this);
				if (rval == JFileChooser.APPROVE_OPTION) {
					saveFile = chooser.getSelectedFile();
					try {
						ImageIO.write(modeloImagen.get(i).getImagen(), modeloImagen.get(i).getExtensionImagen(),
								saveFile);
					} catch (IOException ex) {
					}
				}
			}
		}
	}

	/*
	 * Crear copia
	 */
	
	
	/* GETTER AND SETTER */

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

	/**
	 * @return the menuItemCrearCopia
	 */
	public JMenuItem getMenuItemCrearCopia() {
		return menuItemCrearCopia;
	}

	/**
	 * @param menuItemCrearCopia the menuItemCrearCopia to set
	 */
	public void setMenuItemCrearCopia(JMenuItem menuItemCrearCopia) {
		this.menuItemCrearCopia = menuItemCrearCopia;
	}

}
