package Dibujables;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Clases.Imagen;

public class DibujaVentanaPrincipal extends JFrame {

	/*
	 * Atributos 
	 */
	private ArrayList<DibujaImagen> imagenesAbiertas;
	private JMenuBar barraMenu;
	
	private JMenu menuArchivo;
	private JMenuItem menuItemAbrirImagen;
	private JMenuItem menuItemGuardarImagen;
	
	private JMenu menuEditar;
	private JMenuItem menuItemCrearCopia;
	
	/*
	 * Constructor
	 */
	
	public DibujaVentanaPrincipal() {

		/* Propiedades de la ventana */
		setTitle("Photoshop prototype");
		setLayout(null);
		setMinimumSize(new Dimension(600, 400));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		imagenesAbiertas = new ArrayList<DibujaImagen>();

		//MenuBar
		
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);

		/*
		 * Pesta�as del menu
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
	 * Listeners
	 */
	
	public void addAbrirImagenListener (ActionListener a){
		getMenuItemAbrirImagen().addActionListener(a);
	}
	
	public void addGuardarImagenListener(ActionListener a){
		getMenuItemGuardarImagen().addActionListener(a);
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

	/**
	 * @return the imagenesAbiertas
	 */
	public ArrayList<DibujaImagen> getImagenesAbiertas() {
		return imagenesAbiertas;
	}

	/**
	 * @param imagenesAbiertas the imagenesAbiertas to set
	 */
	public void setImagenesAbiertas(ArrayList<DibujaImagen> imagenesAbiertas) {
		this.imagenesAbiertas = imagenesAbiertas;
	}

}
