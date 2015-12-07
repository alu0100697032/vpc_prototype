/**
 * File name:EscaladoMenu.java
 * Package name: menuBar
 * Proyect name: vpc
 */
package menuBar;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class EscaladoMenu extends JMenu{
	/**
	 * Atributos
	 */
	private JMenuItem vecinoMasProximoMenuItem;
	private JMenuItem bilinearMenuItem;
	/**
	 * Constructor: EscaladoMenu
	 */
	public EscaladoMenu() {
		setText("Transformacion de escalado");
		
		setVecinoMasProximoMenuItem(new JMenuItem("VMP"));
		add(getVecinoMasProximoMenuItem());
		
		setBilinearMenuItem(new JMenuItem("Bilinear"));
		add(getBilinearMenuItem());
	}

	/**
	 * @return the vecinoMasProximoMenuItem
	 */
	public JMenuItem getVecinoMasProximoMenuItem() {
		return vecinoMasProximoMenuItem;
	}

	/**
	 * @param vecinoMasProximoMenuItem the vecinoMasProximoMenuItem to set
	 */
	public void setVecinoMasProximoMenuItem(JMenuItem vecinoMasProximoMenuItem) {
		this.vecinoMasProximoMenuItem = vecinoMasProximoMenuItem;
	}

	/**
	 * @return the bilinearMenuItem
	 */
	public JMenuItem getBilinearMenuItem() {
		return bilinearMenuItem;
	}

	/**
	 * @param bilinearMenuItem the bilinearMenuItem to set
	 */
	public void setBilinearMenuItem(JMenuItem bilinearMenuItem) {
		this.bilinearMenuItem = bilinearMenuItem;
	}
}
