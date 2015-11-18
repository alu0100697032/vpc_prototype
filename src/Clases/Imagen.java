package Clases;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Imagen extends Observable implements Cloneable {

	private BufferedImage imagen;
	private ArrayList<ArrayList<Integer>> matrizPixelesGris;

	private HashMap<Integer, Integer> histogramaAbsoluto;
	private HashMap<Integer, Integer> histogramaAcumulado;
	private String extensionImagen;
	private int rangoMinimo;
	private int rangoMaximo;
	private int brillo;
	private int contraste;
	private int entropia;

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
		histogramaAcumulado = new HashMap<Integer, Integer>();
		histogramaAbsoluto = new HashMap<Integer, Integer>();
		for (int i = 0; i < 256; i++)
			histogramaAbsoluto.put(i, 0);
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
				// añadir gris a la matriz
				matrizPixelesGris.get(i).add(colorGris);
				// formar el histograma
				histogramaAbsoluto.put(colorGris,
						histogramaAbsoluto.get(colorGris) + 1);
				imagen.setRGB(i, j,
						new Color(colorGris, colorGris, colorGris).getRGB());
			}
		}
		obtenerHisogramaAcumulado();
		obtenerRango();
		obtenerBrillo();
		obtenerContraste();
	}

	/*
	 * Obtener histograma acumulado
	 */
	private void obtenerHisogramaAcumulado() {
		int pixelesAcumulados = 0;
		histogramaAcumulado.clear();
		for (Entry<Integer, Integer> entry : histogramaAbsoluto.entrySet()) {
			pixelesAcumulados = pixelesAcumulados + entry.getValue();
			histogramaAcumulado.put(entry.getKey(), pixelesAcumulados);
		}
	}

	/*
	 * Obtener rango
	 */
	private void obtenerRango() {
		setRangoMaximo(0);
		setRangoMinimo(255);
		for (Entry<Integer, Integer> entry : histogramaAbsoluto.entrySet()) {
			if (entry.getKey() > rangoMaximo)
				rangoMaximo = entry.getKey();
			if (entry.getKey() < rangoMinimo)
				rangoMinimo = entry.getKey();
		}
	}

	/*
	 * Obtener brillo
	 */
	private void obtenerBrillo() {
		int sumatorioValores = 0;
		int numeroPixleles = 0;
		for (Entry<Integer, Integer> entry : histogramaAbsoluto.entrySet()) {
			numeroPixleles = numeroPixleles + entry.getValue();
			sumatorioValores = sumatorioValores + entry.getKey()
					* entry.getValue();
		}
		brillo = sumatorioValores / numeroPixleles;
	}

	/*
	 * Obtener contraste
	 */
	private void obtenerContraste() {
		int sumatorioValores = 0;
		int numeroPixleles = 0;
		for (Entry<Integer, Integer> entry : histogramaAbsoluto.entrySet()) {
			numeroPixleles = numeroPixleles + entry.getValue();
			for (int j = 0; j < entry.getValue(); j++) {
				sumatorioValores = sumatorioValores
						+ (int) Math.pow((entry.getKey() - brillo), 2);
			}
		}
		contraste = (int) Math.sqrt(((sumatorioValores / numeroPixleles)));
	}

	/*
	 * Cambiar brillo y contraste
	 */
	public void ajustarBrilloContraste(int brilloPrima, int contrastePrima) {
		int A = contrastePrima / contraste;
		int B = brilloPrima - (A * brillo);
		int colorCambiado;
		HashMap<Integer, Integer> relacionVinVout = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> histogramaCambiado = new HashMap<Integer, Integer>();
		for (int i = 0; i < histogramaAbsoluto.size(); i++)
			histogramaCambiado.put(i, 0);
		for (int i = 0; i < histogramaAbsoluto.size(); i++) {
			colorCambiado = (A * histogramaAbsoluto.get(i)) + B;
			histogramaCambiado.put(colorCambiado, histogramaAbsoluto.get(i));
			relacionVinVout.put(i, colorCambiado);
		}
		for (int i = 0; i < matrizPixelesGris.size(); i++) {
			for (int j = 0; j < matrizPixelesGris.get(i).size(); j++) {
				colorCambiado = histogramaCambiado.get(matrizPixelesGris.get(i)
						.get(j));
				matrizPixelesGris.get(i).set(j, colorCambiado);
				imagen.setRGB(i, j, new Color(colorCambiado, colorCambiado,
						colorCambiado).getRGB());
			}
		}
		setHistogramaAcumulado(histogramaCambiado);
		obtenerHisogramaAcumulado();
		obtenerRango();
		obtenerBrillo();
		obtenerContraste();
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
	 * Informacion de la imagen
	 */
	public String informacionImagen() {
		String informacion = "Tipo: ." + extensionImagen + "\nSize: "
				+ imagen.getWidth() + "x" + imagen.getHeight() + "\nRango: "
				+ rangoMinimo + " - " + rangoMaximo + "\nBrillo: " + brillo
				+ "\nContraste: " + contraste + "\nEntropia: ";
		return informacion;
	}

	/*
	 * (non-Javadoc)
	 * 
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

	public int getNivelGrisPixel(int x, int y) {
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

	public HashMap<Integer, Integer> getHistogramaAbsoluto() {
		return histogramaAbsoluto;
	}

	public void setHistogramaAbsoluto(HashMap<Integer, Integer> histograma) {
		this.histogramaAbsoluto = histograma;
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
	 * @param matrizPixelesGris
	 *            the matrizPixelesGris to set
	 */
	public void setMatrizPixelesGris(
			ArrayList<ArrayList<Integer>> matrizPixelesGris) {
		this.matrizPixelesGris = matrizPixelesGris;
	}

	/**
	 * @return the histogramaAcumulado
	 */
	public HashMap<Integer, Integer> getHistogramaAcumulado() {
		return histogramaAcumulado;
	}

	/**
	 * @param histogramaAcumulado
	 *            the histogramaAcumulado to set
	 */
	public void setHistogramaAcumulado(
			HashMap<Integer, Integer> histogramaAcumulado) {
		this.histogramaAcumulado = histogramaAcumulado;
	}

	/**
	 * @return the rangoMinimo
	 */
	public int getRangoMinimo() {
		return rangoMinimo;
	}

	/**
	 * @param rangoMinimo
	 *            the rangoMinimo to set
	 */
	public void setRangoMinimo(int rangoMinimo) {
		this.rangoMinimo = rangoMinimo;
	}

	/**
	 * @return the rangoMaximo
	 */
	public int getRangoMaximo() {
		return rangoMaximo;
	}

	/**
	 * @param rangoMaximo
	 *            the rangoMaximo to set
	 */
	public void setRangoMaximo(int rangoMaximo) {
		this.rangoMaximo = rangoMaximo;
	}

	/**
	 * @return the brilloImagen
	 */
	public int getBrillo() {
		return brillo;
	}

	/**
	 * @param brilloImagen
	 *            the brilloImagen to set
	 */
	public void setBrillo(int brilloImagen) {
		this.brillo = brilloImagen;
	}

	/**
	 * @return the constraste
	 */
	public int getContraste() {
		return contraste;
	}

	/**
	 * @param constraste
	 *            the constraste to set
	 */
	public void setConstraste(int contraste) {
		this.contraste = contraste;
	}

	/**
	 * @return the entropia
	 */
	public int getEntropia() {
		return entropia;
	}

	/**
	 * @param entropia
	 *            the entropia to set
	 */
	public void setEntropia(int entropia) {
		this.entropia = entropia;
	}

}
