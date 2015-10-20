package vpc_prototype;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ModeloImagen extends Observable {

	private BufferedImage imagen;
	private HashMap<Integer, Integer> histograma;
	private String extensionImagen;

	/*
	 * Constructor: abre la imagen desde selector de fichero
	 */
	public ModeloImagen() {

		BufferedImage img = null;
		JFileChooser selectorFichero = new JFileChooser();
		selectorFichero.setDialogTitle("Seleccione una imagen para abrir:");
		FileNameExtensionFilter extensionPermitida = new FileNameExtensionFilter(
				"Archivos de imagen: *.jpg, *.gif, *.png, *.bmp, *.jpeg", "jpg", "bmp", "png", "gif", "jpeg");
		selectorFichero.setFileFilter(extensionPermitida);
		int flag = selectorFichero.showOpenDialog(null);
		if (flag == JFileChooser.APPROVE_OPTION) {
			try {
				File imagenSeleccionada = selectorFichero.getSelectedFile();
				img = ImageIO.read(imagenSeleccionada);
				extensionImagen = imagenSeleccionada.getName().substring(imagenSeleccionada.getName().lastIndexOf('.'));
				extensionImagen = extensionImagen.substring(1);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		setImagen(img);
		// inicializa el histograma
		histograma = new HashMap<Integer, Integer>();
		for (int i = 0; i < 256; i++)
			histograma.put(i, 0);
		pasarImagenGris();
	}

	/*
	 * Pasar a gris la imagen
	 */

	public void pasarImagenGris() {
		Color colorRGB;
		int colorGris;

		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {
				colorRGB = new Color(imagen.getRGB(i, j));
				// NTSC format
				colorGris = ((int) ((colorRGB.getRed() * 0.299) + (colorRGB.getGreen() * 0.587)
						+ (colorRGB.getBlue() * 0.114)));
				histograma.put(colorGris, histograma.get(colorGris) + 1);
				imagen.setRGB(i, j, new Color(colorGris, colorGris, colorGris).getRGB());
			}
		}
	}

	/*
	 * GETTER Y SETTER
	 */

	public BufferedImage getImagen() {
		return imagen;
	}

	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}

	public HashMap<Integer, Integer> getHistograma() {
		return histograma;
	}

	public void setHistograma(HashMap<Integer, Integer> histograma) {
		this.histograma = histograma;
	}

	public String getExtensionImagen() {
		return extensionImagen;
	}

	public void setExtensionImagen(String extensionIMagen) {
		this.extensionImagen = extensionIMagen;
	}

}
