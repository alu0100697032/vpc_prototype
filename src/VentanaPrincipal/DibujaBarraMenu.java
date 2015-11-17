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
	
	private JMenu menuVer;
	private JMenuItem menuItemVerHistogramaAbsoluo;
	private JMenuItem menuItemVerHistogramaAcumulado;
	private JMenuItem menuItemVerInformacionImagen;
	
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
		
		//Ver
		
		menuVer = new JMenu("Ver");
		
		menuItemVerHistogramaAbsoluo = new JMenuItem("Histograma Absoluto");
		menuVer.add(menuItemVerHistogramaAbsoluo);
		
		menuItemVerHistogramaAcumulado = new JMenuItem("Histograma Acumulado");
		menuVer.add(menuItemVerHistogramaAcumulado);
		
		menuItemVerInformacionImagen = new JMenuItem("Informacion de la imagen");
		menuVer.add(menuItemVerInformacionImagen);
		
		add(menuVer);
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

	/**
	 * @return the menuVer
	 */
	public JMenu getMenuVer() {
		return menuVer;
	}

	/**
	 * @param menuVer the menuVer to set
	 */
	public void setMenuVer(JMenu menuVer) {
		this.menuVer = menuVer;
	}

	/**
	 * @return the menuVerHistograma
	 */
	public JMenuItem getMenuItemVerHistogramaAbsoluto() {
		return menuItemVerHistogramaAbsoluo;
	}

	/**
	 * @param menuVerHistograma the menuVerHistograma to set
	 */
	public void setMenuVerHistogramaAbsoluto(JMenuItem menuItemVerHistograma) {
		this.menuItemVerHistogramaAbsoluo = menuItemVerHistograma;
	}

	/**
	 * @return the menuItemVerHistogramaAcumulado
	 */
	public JMenuItem getMenuItemVerHistogramaAcumulado() {
		return menuItemVerHistogramaAcumulado;
	}

	/**
	 * @param menuItemVerHistogramaAcumulado the menuItemVerHistogramaAcumulado to set
	 */
	public void setMenuItemVerHistogramaAcumulado(
			JMenuItem menuItemVerHistogramaAcumulado) {
		this.menuItemVerHistogramaAcumulado = menuItemVerHistogramaAcumulado;
	}

	/**
	 * @return the menuItemVerInformacionImagen
	 */
	public JMenuItem getMenuItemVerInformacionImagen() {
		return menuItemVerInformacionImagen;
	}

	/**
	 * @param menuItemVerInformacionImagen the menuItemVerInformacionImagen to set
	 */
	public void setMenuItemVerInformacionImagen(
			JMenuItem menuItemVerInformacionImagen) {
		this.menuItemVerInformacionImagen = menuItemVerInformacionImagen;
	}
}
