package Clases;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Imagen extends Observable implements Cloneable {

	private BufferedImage imagen;
	private HashMap<Integer, Integer> histograma;
	private String extensionImagen;
	private ArrayList<ArrayList<Integer>> matrizPixelesGris;

	/*
	 * Constructor: abre la imagen desde selector de fichero
	 */

	public Imagen() {

		BufferedImage img = null;
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
				img = ImageIO.read(imagenSeleccionada);
				extensionImagen = imagenSeleccionada.getName().substring(
						imagenSeleccionada.getName().lastIndexOf('.'));
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
		matrizPixelesGris = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < imagen.getWidth(); i++) {
			matrizPixelesGris.add(new ArrayList<Integer>());
			for (int j = 0; j < imagen.getHeight(); j++) {
				colorRGB = new Color(imagen.getRGB(i, j));
				// NTSC format
				colorGris = ((int) ((colorRGB.getRed() * 0.299)
						+ (colorRGB.getGreen() * 0.587) + (colorRGB.getBlue() * 0.114)));
				//añadir gris a la matriz
				matrizPixelesGris.get(i).add(colorGris);
				//formar el histograma
				histograma.put(colorGris, histograma.get(colorGris) + 1);
				imagen.setRGB(i, j,
						new Color(colorGris, colorGris, colorGris).getRGB());
			}
		}
	}

	/*
	 * Guardar imagen
	 */

	public void guardarImagen() {
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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	
	public Imagen clone() {
		Imagen imagenClonada = null;
		try {
			imagenClonada = (Imagen) super.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(" no se puede duplicar");
		}
		return imagenClonada;
	}

	public int getNivelGrisPixel(int x, int y){
		return matrizPixelesGris.get(x).get(y);
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

	/**
	 * @return the matrizPixelesGris
	 */
	public ArrayList<ArrayList<Integer>> getMatrizPixelesGris() {
		return matrizPixelesGris;
	}

	/**
	 * @param matrizPixelesGris the matrizPixelesGris to set
	 */
	public void setMatrizPixelesGris(ArrayList<ArrayList<Integer>> matrizPixelesGris) {
		this.matrizPixelesGris = matrizPixelesGris;
	}

}
