/**
 * File name:OperacionesGeometricas.java
 * Package name: menuBar
 * Proyect name: vpc
 */
package menuBar;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class OperacionesGeometricasMenu extends JMenu{
	/**
	 * Atributos
	 */
	private JMenuItem espejoHorizontalMenuItem;
	private JMenuItem espejoVerticalMenuItem;
	private JMenuItem traspuestaMenuItem;
	private JMenuItem rotaciones90MenuItem;
	private JMenuItem rotarPintarMenuItem;
	private JMenuItem rotacionesMenuItem;
	private JMenuItem rotacionesBilinealesMenuItem;
	/**
	 * Constructor: OperacionesGeometricas
	 */
	public OperacionesGeometricasMenu() {
		setText("Operaciones geometricas");
		
		setEspejoHorizontalMenuItem(new JMenuItem("Espejo horizontal"));
		add(getEspejoHorizontalMenuItem());
		
		setEspejoVerticalMenuItem(new JMenuItem("Espejo vertical"));
		add(getEspejoVerticalMenuItem());
		
		setTraspuestaMenuItem(new JMenuItem("Traspuesta"));
		add(getTraspuestaMenuItem());
		
		setRotaciones90MenuItem(new JMenuItem("Rotaciones 90 grados"));
		add(getRotaciones90MenuItem());
		
		setRotarPintarMenuItem(new JMenuItem("Rotar y pintar"));
		add(getRotarPintarMenuItem());
		
		setRotacionesMenuItem(new JMenuItem("Rotar VMP"));
		add(getRotacionesMenuItem());
		
		setRotacionesBilinealesMenuItem(new JMenuItem("Rotar Bilineal"));
		add(getRotacionesBilinealesMenuItem());
	}
	/**
	 * @return the espejoHorizontalMenuItem
	 */
	public JMenuItem getEspejoHorizontalMenuItem() {
		return espejoHorizontalMenuItem;
	}
	/**
	 * @param espejoHorizontalMenuItem the espejoHorizontalMenuItem to set
	 */
	public void setEspejoHorizontalMenuItem(JMenuItem espejoHorizontalMenuItem) {
		this.espejoHorizontalMenuItem = espejoHorizontalMenuItem;
	}
	/**
	 * @return the espejoVerticalMenuItem
	 */
	public JMenuItem getEspejoVerticalMenuItem() {
		return espejoVerticalMenuItem;
	}
	/**
	 * @param espejoVerticalMenuItem the espejoVerticalMenuItem to set
	 */
	public void setEspejoVerticalMenuItem(JMenuItem espejoVerticalMenuItem) {
		this.espejoVerticalMenuItem = espejoVerticalMenuItem;
	}
	/**
	 * @return the traspuestaMenuItem
	 */
	public JMenuItem getTraspuestaMenuItem() {
		return traspuestaMenuItem;
	}
	/**
	 * @param traspuestaMenuItem the traspuestaMenuItem to set
	 */
	public void setTraspuestaMenuItem(JMenuItem traspuestaMenuItem) {
		this.traspuestaMenuItem = traspuestaMenuItem;
	}
	/**
	 * @return the rotaciones90MenuItem
	 */
	public JMenuItem getRotaciones90MenuItem() {
		return rotaciones90MenuItem;
	}
	/**
	 * @param rotaciones90MenuItem the rotaciones90MenuItem to set
	 */
	public void setRotaciones90MenuItem(JMenuItem rotaciones90MenuItem) {
		this.rotaciones90MenuItem = rotaciones90MenuItem;
	}
	/**
	 * @return the rotacionesMenuItem
	 */
	public JMenuItem getRotacionesMenuItem() {
		return rotacionesMenuItem;
	}
	/**
	 * @param rotacionesMenuItem the rotacionesMenuItem to set
	 */
	public void setRotacionesMenuItem(JMenuItem rotacionesMenuItem) {
		this.rotacionesMenuItem = rotacionesMenuItem;
	}
	/**
	 * @return the rotarPintarMenuItem
	 */
	public JMenuItem getRotarPintarMenuItem() {
		return rotarPintarMenuItem;
	}
	/**
	 * @param rotarPintarMenuItem the rotarPintarMenuItem to set
	 */
	public void setRotarPintarMenuItem(JMenuItem rotarPintarMenuItem) {
		this.rotarPintarMenuItem = rotarPintarMenuItem;
	}
	/**
	 * @return the rotacionesBilinealesMenuItem
	 */
	public JMenuItem getRotacionesBilinealesMenuItem() {
		return rotacionesBilinealesMenuItem;
	}
	/**
	 * @param rotacionesBilinealesMenuItem the rotacionesBilinealesMenuItem to set
	 */
	public void setRotacionesBilinealesMenuItem(JMenuItem rotacionesBilinealesMenuItem) {
		this.rotacionesBilinealesMenuItem = rotacionesBilinealesMenuItem;
	}
}
