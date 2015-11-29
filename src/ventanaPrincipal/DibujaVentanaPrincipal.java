package ventanaPrincipal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import dibujablesImagen.DibujaInternalFrameImagen;
import menuBar.DibujaBarraMenu;
import statusBar.DibujaPanelEstado;

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
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(600, 400));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		imagenesAbiertas = new ArrayList<DibujaInternalFrameImagen>();

		//MenuBar
		
		barraMenu = new DibujaBarraMenu();
		setJMenuBar(barraMenu);
		
		//DesktopPane
		
		grupoInternalFrames = new JDesktopPane();
		add(grupoInternalFrames);
		
		//Panel de estado
		panelEstado = new DibujaPanelEstado(getWidth());
		add(panelEstado, BorderLayout.SOUTH);
		setVisible(true);
	}

	/*
	 * Listeners
	 */
	/*
	 * Archivo
	 */
	public void addAbrirImagenListener (ActionListener a){
		barraMenu.getMenuItemAbrirImagen().addActionListener(a);
	}
	
	public void addGuardarImagenListener(ActionListener a){
		barraMenu.getMenuItemGuardarImagen().addActionListener(a);
	}
	/*
	 * Editar
	 */
	public void addHacerCopiaListener(ActionListener a){
		barraMenu.getMenuItemCrearCopia().addActionListener(a);
	}
	public void addSeleccionarRegionInteresListener(ActionListener a) {
		barraMenu.getMenuItemSeleccionarRegionInteres().addActionListener(a);
	}
	public void addCambiarBrilloContrasteListener(ActionListener a){
		barraMenu.getMenuItemCambiarBrilloContraste().addActionListener(a);
	}
	public void addTransformacionLinealTramosListener(ActionListener a){
		barraMenu.getMenuItemTransformacionLinealTramos().addActionListener(a);
	}
	public void addCorreccionGammaListener(ActionListener a) {
		barraMenu.getMenuItemCorreccionGamma().addActionListener(a);
	}
	/*
	 * Ver
	 */
	public void addVerHistogramaAbsolutoListener(ActionListener a){
		barraMenu.getMenuItemVerHistogramaAbsoluto().addActionListener(a);
	}
	
	public void addVerHistogramaAcumuladoListener(ActionListener a){
		barraMenu.getMenuItemVerHistogramaAcumulado().addActionListener(a);
	}
	
	public void addVerInformacionImagenListener(ActionListener a){
		barraMenu.getMenuItemVerInformacionImagen().addActionListener(a);
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

	/**
	 * @return the barraMenu
	 */
	public DibujaBarraMenu getBarraMenu() {
		return barraMenu;
	}

	/**
	 * @param barraMenu the barraMenu to set
	 */
	public void setBarraMenu(DibujaBarraMenu barraMenu) {
		this.barraMenu = barraMenu;
	}

}
