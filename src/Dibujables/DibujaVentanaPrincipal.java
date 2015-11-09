package Dibujables;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class DibujaVentanaPrincipal extends JFrame {

	/*
	 * Atributos 
	 */
	private ArrayList<DibujaInternalFrameImagen> imagenesAbiertas;
	private DibujaBarraMenu barraMenu;
	private JDesktopPane grupoInternalFrames;
	private DibujaPanelEstado panelEstado;
	
	
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

		imagenesAbiertas = new ArrayList<DibujaInternalFrameImagen>();

		//MenuBar
		
		barraMenu = new DibujaBarraMenu();
		setJMenuBar(barraMenu);
		
		//DesktopPane
		
		grupoInternalFrames = new JDesktopPane();
		setContentPane(grupoInternalFrames);
		
		//Panel de estado
		panelEstado = new DibujaPanelEstado(getWidth());
		add(panelEstado);
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
	public ArrayList<DibujaInternalFrameImagen> getImagenesAbiertas() {
		return imagenesAbiertas;
	}

	/**
	 * @param imagenesAbiertas the imagenesAbiertas to set
	 */
	public void setImagenesAbiertas(ArrayList<DibujaInternalFrameImagen> imagenesAbiertas) {
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

	/**
	 * @return the panelEstado
	 */
	public DibujaPanelEstado getPanelEstado() {
		return panelEstado;
	}

	/**
	 * @param panelEstado the panelEstado to set
	 */
	public void setPanelEstado(DibujaPanelEstado panelEstado) {
		this.panelEstado = panelEstado;
	}

}
