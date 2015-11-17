package alertas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Clases.Imagen;

public class CambiarBrilloContraste extends JDialog {

	/*
	 * Atributos
	 */
	private JPanel nivelesBrilloContraste;
	protected Scrollbar nivelBrilloScrollbar;
	protected Scrollbar nivelContrasteScrollbar;
	protected JLabel mostrarNivelBrillo;
	protected JLabel mostrarNivelContraste;
	/*
	 * Constructor
	 */
	public CambiarBrilloContraste(Imagen imagen) {
		
		nivelesBrilloContraste = new JPanel();
		nivelesBrilloContraste.setLayout(new BoxLayout(nivelesBrilloContraste, BoxLayout.PAGE_AXIS));
		
		nivelBrilloScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 60, 0, 255);
		nivelBrilloScrollbar.setBackground(Color.WHITE);
		
		mostrarNivelBrillo = new JLabel("Brillo: " + nivelBrilloScrollbar.getValue());
		nivelesBrilloContraste.add(mostrarNivelBrillo);
		
		nivelesBrilloContraste.add(nivelBrilloScrollbar);
		
		nivelContrasteScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 60, 0, 255);
		nivelContrasteScrollbar.setBackground(Color.WHITE);
		
		mostrarNivelContraste = new JLabel("Contraste: " + nivelContrasteScrollbar.getValue());
		nivelesBrilloContraste.add(mostrarNivelContraste);
		
		nivelesBrilloContraste.add(nivelContrasteScrollbar);
		
		Object[] opciones = { "Aceptar", "Cancelar" };
		JOptionPane.showOptionDialog(this, nivelesBrilloContraste, "Brillo y Contraste",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		
		setResizable(false);
	}
	
	public void addCanbiarBrilloListener(AdjustmentListener a){
		nivelBrilloScrollbar.addAdjustmentListener(a);
	}
	public void addCanbiarContrasteListener(AdjustmentListener a){
		nivelContrasteScrollbar.addAdjustmentListener(a);
	}
	/**
	 * @return the nivelesBrilloContraste
	 */
	public JPanel getNivelesBrilloContraste() {
		return nivelesBrilloContraste;
	}
	/**
	 * @param nivelesBrilloContraste the nivelesBrilloContraste to set
	 */
	public void setNivelesBrilloContraste(JPanel nivelesBrilloContraste) {
		this.nivelesBrilloContraste = nivelesBrilloContraste;
	}
	/**
	 * @return the nivelBrilloScrollBar
	 */
	public Scrollbar getNivelBrilloScrollBar() {
		return nivelBrilloScrollbar;
	}
	/**
	 * @param nivelBrilloScrollBar the nivelBrilloScrollBar to set
	 */
	public void setNivelBrilloScrollBar(Scrollbar nivelBrilloScrollBar) {
		this.nivelBrilloScrollbar = nivelBrilloScrollBar;
	}
	/**
	 * @return the nivelContrasteScrollbar
	 */
	public Scrollbar getNivelContrasteScrollbar() {
		return nivelContrasteScrollbar;
	}
	/**
	 * @param nivelContrasteScrollbar the nivelContrasteScrollbar to set
	 */
	public void setNivelContrasteScrollbar(Scrollbar nivelContrasteScrollbar) {
		this.nivelContrasteScrollbar = nivelContrasteScrollbar;
	}

	/**
	 * @return the mostrarNivelContraste
	 */
	public JLabel getMostrarNivelContraste() {
		return mostrarNivelContraste;
	}

	/**
	 * @param mostrarNivelContraste the mostrarNivelContraste to set
	 */
	public void setMostrarNivelContraste(JLabel mostrarNivelContraste) {
		this.mostrarNivelContraste = mostrarNivelContraste;
	}

	/**
	 * @return the mostrarNivelBrillo
	 */
	public JLabel getMostrarNivelBrillo() {
		return mostrarNivelBrillo;
	}

	/**
	 * @param mostrarNivelBrillo the mostrarNivelBrillo to set
	 */
	public void setMostrarNivelBrillo(JLabel mostrarNivelBrillo) {
		this.mostrarNivelBrillo = mostrarNivelBrillo;
	}
}
