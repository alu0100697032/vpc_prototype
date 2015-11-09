package Dibujables;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class DibujaVentanaPrincipal extends JFrame {

	/*
	 * Atributos 
	 */
	private ArrayList<DibujaImagen> imagenesAbiertas;
	private DibujaBarraMenu barraMenu;
	private JDesktopPane grupoInternalFrames;
	
	
	/*
	 * Constructor
	 */
	
	public DibujaVentanaPrincipal() {

		/* 
		 * Propiedades de la ventana
		 */
		
		setTitle("Photoshop prototype");
		setLayout(null);
		setMinimumSize(new Dimension(600, 400));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		imagenesAbiertas = new ArrayList<DibujaImagen>();

		//MenuBar
		
		barraMenu = new DibujaBarraMenu();
		setJMenuBar(barraMenu);
		
		//DesktopPane
		
		grupoInternalFrames = new JDesktopPane();
		setContentPane(grupoInternalFrames);
		
		setVisible(true);
	}

	/*
	 * Listeners
	 */
	
	public void addAbrirImagenListener (ActionListener a){
		barraMenu.getMenuItemAbrirImagen().addActionListener(a);
	}
	
	public void addGuardarImagenListener(ActionListener a){
		barraMenu.getMenuItemGuardarImagen().addActionListener(a);
	}
	
	public void addHacerCopiaListener(ActionListener a){
		barraMenu.getMenuItemCrearCopia().addActionListener(a);
		
	}
	
	/*
	 * GETTER AND SETTER
	 */

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

	/**
	 * @return the grupoInternalFrames
	 */
	public JDesktopPane getGrupoInternalFrames() {
		return grupoInternalFrames;
	}

	/**
	 * @param grupoInternalFrames the grupoInternalFrames to set
	 */
	public void setGrupoInternalFrames(JDesktopPane grupoInternalFrames) {
		this.grupoInternalFrames = grupoInternalFrames;
	}

}
