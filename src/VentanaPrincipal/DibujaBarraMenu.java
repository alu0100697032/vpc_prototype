package VentanaPrincipal;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DibujaBarraMenu extends JMenuBar{

	/*
	 * Atributos
	 */
	
	private JMenu menuArchivo;
	private JMenuItem menuItemAbrirImagen;
	private JMenuItem menuItemGuardarImagen;
	
	private JMenu menuEditar;
	private JMenuItem menuItemCrearCopia;
	
	/*
	 * Constructor
	 */
	
	public DibujaBarraMenu(){

		//Archivo
		
		menuArchivo = new JMenu("Archivo");
		
		menuItemAbrirImagen = new JMenuItem("Abrir Imagen");
		menuItemGuardarImagen = new JMenuItem("Guardar Como...");
		menuArchivo.add(menuItemAbrirImagen);
		menuArchivo.add(menuItemGuardarImagen);
		
		add(menuArchivo);

		//Editar
		
		menuEditar = new JMenu("Editar");
		
		menuItemCrearCopia = new JMenuItem("Crear Copia");
		menuEditar.add(menuItemCrearCopia);
		
		add(menuEditar);
	}
	
	/*
	 * 
	 */
	
	/**
	 * @return the menuItemGuardarImagen
	 */
	public JMenuItem getMenuItemGuardarImagen() {
		return menuItemGuardarImagen;
	}
	/**
	 * @param menuItemGuardarImagen the menuItemGuardarImagen to set
	 */
	public void setMenuItemGuardarImagen(JMenuItem menuItemGuardarImagen) {
		this.menuItemGuardarImagen = menuItemGuardarImagen;
	}
	/**
	 * @return the menuItemAbrirImagen
	 */
	public JMenuItem getMenuItemAbrirImagen() {
		return menuItemAbrirImagen;
	}
	/**
	 * @param menuItemAbrirImagen the menuItemAbrirImagen to set
	 */
	public void setMenuItemAbrirImagen(JMenuItem menuItemAbrirImagen) {
		this.menuItemAbrirImagen = menuItemAbrirImagen;
	}
	/**
	 * @return the menuArchivo
	 */
	public JMenu getMenuArchivo() {
		return menuArchivo;
	}
	/**
	 * @param menuArchivo the menuArchivo to set
	 */
	public void setMenuArchivo(JMenu menuArchivo) {
		this.menuArchivo = menuArchivo;
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
	/**
	 * @return the menuEditar
	 */
	public JMenu getMenuEditar() {
		return menuEditar;
	}
	/**
	 * @param menuEditar the menuEditar to set
	 */
	public void setMenuEditar(JMenu menuEditar) {
		this.menuEditar = menuEditar;
	}
}
