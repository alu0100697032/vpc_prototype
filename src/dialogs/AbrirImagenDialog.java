/**
 * File name:SelectorFichero.java
 * Package name: clases
 * Proyect name: vpc
 */
package dialogs;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AbrirImagenDialog {
	/**
	 * Atributos
	 */
	private BufferedImage imagenCargada;
	private String nombreImagen;
	private String extensionImagen;
	/**
	 * Constructor: SelectorFichero
	 */
	public AbrirImagenDialog() {
		imagenCargada = null;
		JFileChooser selectorFichero = new JFileChooser();
		selectorFichero.setDialogTitle("Seleccione una imagen para abrir:");
		FileNameExtensionFilter extensionPermitida = new FileNameExtensionFilter(
				"Archivos de imagen: *.jpg, *.gif, *.png, *.bmp, *.jpeg",
				"jpg", "bmp", "png", "gif", "jpeg");
		selectorFichero.setFileFilter(extensionPermitida);
		int flag = selectorFichero.showOpenDialog(null);
		if (flag == JFileChooser.APPROVE_OPTION) {
			try {
				File imagenSeleccionada = selectorFichero.getSelectedFile();
				imagenCargada = ImageIO.read(imagenSeleccionada);
				nombreImagen = imagenSeleccionada.getName();
				extensionImagen = nombreImagen.substring(
						imagenSeleccionada.getName().lastIndexOf('.'));
				extensionImagen = extensionImagen.substring(1);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	/**
	 * @return the imagenCargada
	 */
	public BufferedImage getImagenCargada() {
		return imagenCargada;
	}
	/**
	 * @param imagenCargada the imagenCargada to set
	 */
	public void setImagenCargada(BufferedImage imagenCargada) {
		this.imagenCargada = imagenCargada;
	}
	/**
	 * @return the extensionFichero
	 */
	public String getExtensionImagen() {
		return extensionImagen;
	}
	/**
	 * @param extensionFichero the extensionFichero to set
	 */
	public void setExtensionImagen(String extensionFichero) {
		this.extensionImagen = extensionFichero;
	}
	/**
	 * @return the nombreImagen
	 */
	public String getNombreImagen() {
		return nombreImagen;
	}
	/**
	 * @param nombreImagen the nombreImagen to set
	 */
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}
}
