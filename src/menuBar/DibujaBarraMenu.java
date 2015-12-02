package menuBar;

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
	private JMenuItem menuItemCambiarBrilloContraste;
	private JMenuItem menuItemSeleccionarRegionInteres;
	private JMenuItem menuItemTransformacionLinealTramos;
	private JMenuItem menuItemCorreccionGamma;
	private JMenuItem menuItemDiferenciaImagenes;
	private JMenuItem menuItemEcualizacion;
	
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
		menuItemGuardarImagen = new JMenuItem("Guardar Imagen");
		menuArchivo.add(menuItemAbrirImagen);
		menuArchivo.add(menuItemGuardarImagen);
		
		add(menuArchivo);

		//Editar
		
		menuEditar = new JMenu("Editar");
		
		menuItemCrearCopia = new JMenuItem("Crear Copia");
		menuEditar.add(menuItemCrearCopia);
		
		menuItemSeleccionarRegionInteres = new JMenuItem("Seleccionar ROI(desactivado)");
		menuEditar.add(menuItemSeleccionarRegionInteres);
		
		menuItemCambiarBrilloContraste = new JMenuItem("Brillo y Contraste");
		menuEditar.add(menuItemCambiarBrilloContraste);
		
		menuItemTransformacionLinealTramos = new JMenuItem("Transformacion lineal por tramos");
		menuEditar.add(menuItemTransformacionLinealTramos);
		
		menuItemCorreccionGamma = new JMenuItem("Correcci�n Gamma");
		menuEditar.add(menuItemCorreccionGamma);
		
		menuItemDiferenciaImagenes = new JMenuItem("Diferencia");
		menuEditar.add(menuItemDiferenciaImagenes);
		
		menuItemEcualizacion = new JMenuItem("Ecualizacion");
		menuEditar.add(menuItemEcualizacion);
		
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

	/**
	 * @return the menuItemCambiarBrilloContraste
	 */
	public JMenuItem getMenuItemCambiarBrilloContraste() {
		return menuItemCambiarBrilloContraste;
	}

	/**
	 * @param menuItemCambiarBrilloContraste the menuItemCambiarBrilloContraste to set
	 */
	public void setMenuItemCambiarBrilloContraste(JMenuItem menuItemCambiarBrilloContraste) {
		this.menuItemCambiarBrilloContraste = menuItemCambiarBrilloContraste;
	}

	/**
	 * @return the menuItemSeleccionarRegionInteres
	 */
	public JMenuItem getMenuItemSeleccionarRegionInteres() {
		return menuItemSeleccionarRegionInteres;
	}

	/**
	 * @param menuItemSeleccionarRegionInteres the menuItemSeleccionarRegionInteres to set
	 */
	public void setMenuItemSeleccionarRegionInteres(JMenuItem menuItemSeleccionarRegionInteres) {
		this.menuItemSeleccionarRegionInteres = menuItemSeleccionarRegionInteres;
	}

	/**
	 * @return the menuItemTransformacionLinealTramos
	 */
	public JMenuItem getMenuItemTransformacionLinealTramos() {
		return menuItemTransformacionLinealTramos;
	}

	/**
	 * @param menuItemTransformacionLinealTramos the menuItemTransformacionLinealTramos to set
	 */
	public void setMenuItemTransformacionLinealTramos(
			JMenuItem menuItemTransformacionLinealTramos) {
		this.menuItemTransformacionLinealTramos = menuItemTransformacionLinealTramos;
	}

	/**
	 * @return the menuItemCorreccionGamma
	 */
	public JMenuItem getMenuItemCorreccionGamma() {
		return menuItemCorreccionGamma;
	}

	/**
	 * @param menuItemCorreccionGamma the menuItemCorreccionGamma to set
	 */
	public void setMenuItemCorreccionGamma(JMenuItem menuItemCorreccionGamma) {
		this.menuItemCorreccionGamma = menuItemCorreccionGamma;
	}

	/**
	 * @return the menuItemDiferenciaImagenes
	 */
	public JMenuItem getMenuItemDiferenciaImagenes() {
		return menuItemDiferenciaImagenes;
	}

	/**
	 * @param menuItemDiferenciaImagenes the menuItemDiferenciaImagenes to set
	 */
	public void setMenuItemDiferenciaImagenes(JMenuItem menuItemDiferenciaImagenes) {
		this.menuItemDiferenciaImagenes = menuItemDiferenciaImagenes;
	}

	/**
	 * @return the menuItemEcualizacion
	 */
	public JMenuItem getMenuItemEcualizacion() {
		return menuItemEcualizacion;
	}

	/**
	 * @param menuItemEcualizacion the menuItemEcualizacion to set
	 */
	public void setMenuItemEcualizacion(JMenuItem menuItemEcualizacion) {
		this.menuItemEcualizacion = menuItemEcualizacion;
	}
}
