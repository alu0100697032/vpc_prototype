package vpc_prototype;

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
	private BufferedImage imagenFinal;
	private ArrayList<ArrayList<ArrayList<Integer>>> coloresRGBImagen;
	private ArrayList<ArrayList<Integer>> imagenGris;
	private HashMap<Integer, Integer> histograma;

	public ModeloImagen() {

		BufferedImage img = null;
		BufferedImage imgfinal = null;
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
		imgfinal = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		setImagen(img);
		setImagenFinal(imgfinal);
		almacenarRGBImagen();
		histograma = new HashMap<Integer, Integer>();
		for (int i = 0; i < 256; i++)
			histograma.put(i, 0);
		pasarImagenGris();
	}

	/*
	 * Separar el RGB de la imagen en matrices
	 */
	public void almacenarRGBImagen() {
		coloresRGBImagen = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<Integer>> matrizAuxiliarPlanoColorAzul = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> matrizAuxiliarPlanoColorVerde = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> matrizAuxiliarPlanoColorRojo = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < imagen.getWidth(); i++) {
			matrizAuxiliarPlanoColorRojo.add(new ArrayList<Integer>());
			matrizAuxiliarPlanoColorVerde.add(new ArrayList<Integer>());
			matrizAuxiliarPlanoColorAzul.add(new ArrayList<Integer>());
			for (int j = 0; j < imagen.getHeight(); j++) {
				matrizAuxiliarPlanoColorRojo.get(i).add(imagenFinal.getColorModel()
						.getBlue(imagenFinal.getRGB(i, j)));
				matrizAuxiliarPlanoColorVerde.get(i).add(imagenFinal.getColorModel()
						.getBlue(imagenFinal.getRGB(i, j)));
				matrizAuxiliarPlanoColorAzul.get(i).add(imagenFinal.getColorModel()
						.getBlue(imagenFinal.getRGB(i, j)));
			}
		}
		coloresRGBImagen.add(matrizAuxiliarPlanoColorRojo);
		coloresRGBImagen.add(matrizAuxiliarPlanoColorVerde);
		coloresRGBImagen.add(matrizAuxiliarPlanoColorAzul);
	}

	/*
	 * Pasar a gris la imagen
	 */
	public void pasarImagenGris() {

		imagenGris = new ArrayList<ArrayList<Integer>>();


		for (int i = 0; i < imagen.getWidth(); i++) {
			imagenGris.add(new ArrayList<Integer>());
			for (int j = 0; j < imagen.getHeight(); j++) {
				// NTSC format
				imagenGris.get(i).add((int) ((coloresRGBImagen.get(0).get(i).get(j) * 0.299)
						+ (coloresRGBImagen.get(1).get(i).get(j) * 0.587) + (coloresRGBImagen
						.get(2).get(i).get(j) * 0.114)));
				histograma.put(imagenGris.get(i).get(j),
						histograma.get(imagenGris.get(i).get(j) + 1));
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

	public ArrayList<ArrayList<ArrayList<Integer>>> getColoresRGB() {
		return coloresRGBImagen;
	}

	public void setColoresRGB(ArrayList<ArrayList<ArrayList<Integer>>> coloresRGB) {
		this.coloresRGBImagen = coloresRGB;
	}

	public ArrayList<ArrayList<Integer>> getImagenGris() {
		return imagenGris;
	}

	public void setImagenGris(ArrayList<ArrayList<Integer>> imagenGris) {
		this.imagenGris = imagenGris;
	}

	public HashMap<Integer, Integer> getHistograma() {
		return histograma;
	}

	public void setHistograma(HashMap<Integer, Integer> histograma) {
		this.histograma = histograma;
	}

	public BufferedImage getImagenFinal() {
		return imagenFinal;
	}

	public void setImagenFinal(BufferedImage imagenFinal) {
		this.imagenFinal = imagenFinal;
	}

}
