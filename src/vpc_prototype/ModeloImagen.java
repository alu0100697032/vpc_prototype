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
	private ArrayList<int[][]> coloresRGBImagen;
	private int[][] imagenGris;
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
		almacenarRGBImagen();
		histograma = new HashMap<Integer, Integer>();
		for(int i = 0; i < 256; i++)
			histograma.put(i, 0);
	}

	/*
	 * Separar el RGB de la imagen en matrices
	 */
	public void almacenarRGBImagen() {
		coloresRGBImagen = new ArrayList<int[][]>();
		int[][] matrizAuxiliarPlanoColorAzul = null;
		int[][] matrizAuxiliarPlanoColorVerde = null;
		int[][] matrizAuxiliarPlanoColorRojo = null;

		for (int i = 0; i < imagen.getHeight(); i++) {
			matrizAuxiliarPlanoColorAzul[i] = new int[imagen.getWidth()];
			matrizAuxiliarPlanoColorVerde[i] = new int[imagen.getWidth()];
			matrizAuxiliarPlanoColorRojo[i] = new int[imagen.getWidth()];
			for (int j = 0; j < imagen.getWidth(); j++) {
				matrizAuxiliarPlanoColorAzul[i][j] = imagen.getColorModel()
						.getBlue(imagen.getRGB(i, j));
				matrizAuxiliarPlanoColorVerde[i][j] = imagen.getColorModel()
						.getGreen(imagen.getRGB(i, j));
				matrizAuxiliarPlanoColorRojo[i][j] = imagen.getColorModel()
						.getRed(imagen.getRGB(i, j));
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
		
		imagenGris = null;
		for (int i = 0; i < imagen.getHeight(); i++) {
			imagenGris[i] = new int[imagen.getWidth()];
		}

		for (int i = 0; i < imagenGris.length; i++) {
			for (int j = 0; j < imagenGris[i].length; j++) {
				//NTSC format
				imagenGris[i][j] = (int) ((coloresRGBImagen.get(0)[i][j] * 0.299)
						+ (coloresRGBImagen.get(1)[i][j] * 0.587) + (coloresRGBImagen
						.get(2)[i][j] * 0.114));
				histograma.put(imagenGris[i][j], histograma.get(imagenGris[i][j]+1));
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

	public ArrayList<int[][]> getColoresRGB() {
		return coloresRGBImagen;
	}

	public void setColoresRGB(ArrayList<int[][]> coloresRGB) {
		this.coloresRGBImagen = coloresRGB;
	}

}
