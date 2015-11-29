/**
 * File name:guardarImagen.java
 * Package name: dialogs
 * Proyect name: vpc
 */
package dialogs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class GuardarImagenDialog {
	/**
	 * Atributos
	 */
	public GuardarImagenDialog(BufferedImage imagen, String extensionImagen) {
		File saveFile = new File("imagen." + extensionImagen);
		JFileChooser chooser = new JFileChooser();
		chooser.setSelectedFile(saveFile);
		int rval = chooser.showSaveDialog(null);
		if (rval == JFileChooser.APPROVE_OPTION) {
			saveFile = chooser.getSelectedFile();
			try {
				ImageIO.write(imagen, extensionImagen, saveFile);
			} catch (IOException ex) {
			}
		}
	}
}
