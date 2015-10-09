package vpc_prototype;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ModeloImagen extends Observable {

	private BufferedImage imagen;
	private HashMap<Integer, Integer> histograma;

	public ModeloImagen() {

		BufferedImage img = null;
		JFileChooser selectorFichero = new JFileChooser();
		selectorFichero.setDialogTitle("Seleccione imagen a visualizar:");
		FileNameExtensionFilter extensionPermitida = new FileNameExtensionFilter(
				"JPG & GIF & PNG & BMP & JPEG", "jpg", "bmp", "png", "gif",
				"jpeg");
		selectorFichero.setFileFilter(extensionPermitida);
		int flag = selectorFichero.showOpenDialog(null);
		if (flag == JFileChooser.APPROVE_OPTION) {
			try {
				File imagenSeleccionada = selectorFichero.getSelectedFile();
				img = ImageIO.read(imagenSeleccionada);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		setImagen(img);
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
				colorGris = ((int) ((colorRGB.getRed()* 0.299)
						+ (colorRGB.getGreen() * 0.587) + (colorRGB.getBlue() * 0.114)));
				histograma.put(colorGris,
						histograma.get(colorGris)+1);
				imagen.setRGB(i, j, colorGris);
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

}
