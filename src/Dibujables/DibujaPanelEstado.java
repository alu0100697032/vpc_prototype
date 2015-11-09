package Dibujables;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class DibujaPanelEstado extends JPanel{

	/*
	 * Atributos
	 */
	private JLabel coordenadasColor;
	/*
	 * Constructor
	 */
	public DibujaPanelEstado(int ancho){
		//Especificaciones del panel
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setSize(new Dimension(ancho, 20));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		//Texto a mostrar
		coordenadasColor = new JLabel("");
		coordenadasColor.setHorizontalAlignment(SwingConstants.LEFT);
		add(coordenadasColor);
	}
	/**
	 * @return the coordenadasColor
	 */
	public JLabel getCoordenadasColor() {
		return coordenadasColor;
	}
	/**
	 * @param coordenadasColor the coordenadasColor to set
	 */
	public void setCoordenadasColor(JLabel coordenadasColor) {
		this.coordenadasColor = coordenadasColor;
	}
}
