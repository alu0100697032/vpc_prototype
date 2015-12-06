package clases;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Map.Entry;

public class Imagen extends Observable implements Cloneable {
	/**
	 * Atributos
	 */
	private BufferedImage imagen;
	private ArrayList<ArrayList<Integer>> matrizPixelesGris;
	private HashMap<Integer, Integer> histogramaAbsoluto;
	private HashMap<Integer, Integer> histogramaAcumulado;
	private String extensionImagen;
	private String nombreImagen;
	private int rangoMinimo;
	private int rangoMaximo;
	private int brillo;
	private int contraste;
	private float entropia;

	/**
	 * Constructor: Imagen
	 */
	public Imagen(BufferedImage img, String nombre, String extension) {
		setImagen(img);
		setExtensionImagen(extension);
		setNombreImagen(nombre);
		// inicializa los histogramas
		histogramaAcumulado = new HashMap<Integer, Integer>();
		histogramaAbsoluto = new HashMap<Integer, Integer>();
		for (int i = 0; i < 256; i++)
			histogramaAbsoluto.put(i, 0);
		// pasar la imagen a gris
		pasarImagenGris();
	}

	/**
	 * pasarImagenGris
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
				colorGris = ((int) ((colorRGB.getRed() * 0.299) + (colorRGB.getGreen() * 0.587)
						+ (colorRGB.getBlue() * 0.114)));
				// añadir gris a la matriz
				matrizPixelesGris.get(i).add(colorGris);
				// formar el histograma
				histogramaAbsoluto.put(colorGris, histogramaAbsoluto.get(colorGris) + 1);
				imagen.setRGB(i, j, new Color(colorGris, colorGris, colorGris).getRGB());
			}
		}
		// una vez pasada a gris se calculan una serie de propiedades
		obtenerHisogramaAcumulado();
		obtenerRango();
		obtenerBrillo();
		obtenerContraste();
		obtenerEntropia();
	}

	/**
	 * obtenerHisogramaAcumulado
	 */
	private void obtenerHisogramaAcumulado() {
		histogramaAcumulado.clear();
		int pixelesAcumulados = 0;
		for (Entry<Integer, Integer> entry : histogramaAbsoluto.entrySet()) {
			pixelesAcumulados += entry.getValue();
			histogramaAcumulado.put(entry.getKey(), pixelesAcumulados);
			// System.out.println(entry.getKey()+ ": " +
			// histogramaAcumulado.get(entry.getKey()));
		}
	}

	/**
	 * obtenerRango
	 */
	private void obtenerRango() {
		setRangoMaximo(0);
		setRangoMinimo(255);
		for (Entry<Integer, Integer> entry : histogramaAbsoluto.entrySet()) {
			if (entry.getValue() != 0 && entry.getKey() > rangoMaximo)
				rangoMaximo = entry.getKey();
			if (entry.getValue() != 0 && entry.getKey() < rangoMinimo)
				rangoMinimo = entry.getKey();
		}
	}

	/**
	 * obtenerBrillo
	 */
	private void obtenerBrillo() {
		int sumatorioValores = 0;
		int numeroPixleles = histogramaAcumulado.get(255);
		for (Entry<Integer, Integer> entry : histogramaAbsoluto.entrySet()) {
			sumatorioValores += entry.getKey() * entry.getValue();
		}
		brillo = sumatorioValores / numeroPixleles;
	}

	/**
	 * obtenerContraste
	 */

	private void obtenerContraste() {
		int sumatorioValores = 0;
		int numeroPixleles = histogramaAcumulado.get(255);
		for (Entry<Integer, Integer> entry : histogramaAbsoluto.entrySet()) {
			sumatorioValores += entry.getValue() * (Math.pow((entry.getKey() - brillo), 2));
		}
		contraste = (int) Math.sqrt((sumatorioValores / numeroPixleles));
	}

	/**
	 * obtenerEntropia
	 */
	private void obtenerEntropia() {
		entropia = 0;
		int numeroPixleles = histogramaAcumulado.get(255);
		for (Entry<Integer, Integer> entry : histogramaAbsoluto.entrySet()) {
			float probabilidad = (float) entry.getValue() / (float) numeroPixleles;
			if (probabilidad > 0.0)
				entropia -= (probabilidad * (Math.log(probabilidad) / Math.log(2)));
		}
	}

	/**
	 * ajusteLinealTramos
	 */
	// bien
	public void ajusteLinealTramos(ArrayList<Integer> coordenadasTramos) {
		int xAnterior = coordenadasTramos.get(0);
		int yAnterior = coordenadasTramos.get(1);
		int x = 2;
		int y = 3;
		int xSiguiente = coordenadasTramos.get(x);
		int ySiguiente = coordenadasTramos.get(y);
		int colorCambiado;
		HashMap<Integer, Integer> relacionVinVout = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> VOut = new HashMap<Integer, Integer>();
		for (int i = 0; i < 256; i++)
			VOut.put(i, 0);
		// recorremos el histograma y cambiamos los valores de vin por vout
		Iterator it = histogramaAbsoluto.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			if ((int) pairs.getKey() >= xAnterior && (int) pairs.getKey() <= xSiguiente) {
				if ((int) pairs.getKey() < coordenadasTramos.get(coordenadasTramos.size() - 2)
						&& (int) pairs.getKey() == xSiguiente) {
					x += 2;
					y += 2;
					xAnterior = xSiguiente;
					yAnterior = ySiguiente;
					xSiguiente = coordenadasTramos.get(x);
					ySiguiente = coordenadasTramos.get(y);
				}
				double A = ((ySiguiente - yAnterior) / (double) (xSiguiente - xAnterior));
				double B = yAnterior - A * xAnterior;

				colorCambiado = (int) ((A * (int) pairs.getKey()) + B);

				VOut.put(colorCambiado, VOut.get(colorCambiado) + (int) (pairs.getValue()));
				relacionVinVout.put((int) (pairs.getKey()), colorCambiado);
			} else {
				VOut.put((int) pairs.getKey(), VOut.get((int) pairs.getKey()) + (int) (pairs.getValue()));
				relacionVinVout.put((int) (pairs.getKey()), (int) (pairs.getKey()));
			}
		}
		actualizarValoresVinVout(relacionVinVout, VOut);
	}

	/**
	 * ajustarBrilloContraste
	 */
	public void ajustarBrilloContraste(int brilloPrima, int contrastePrima) {
		double A = contrastePrima / (double)contraste;
		double B = brilloPrima - ((double)A * brillo);
		int colorCambiado;
		HashMap<Integer, Integer> relacionVinVout = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> VOut = new HashMap<Integer, Integer>();
		for (int i = 0; i < 256; i++)
			VOut.put(i, 0);
		// recorremos el histograma y cambiamos los valores de vin por vout
		Iterator it = histogramaAbsoluto.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			colorCambiado = (int) ((A * (int)pairs.getKey()) + B);
			if (colorCambiado > 255)
				colorCambiado = 255;
			if (colorCambiado < 0)
				colorCambiado = 0;
			VOut.put(colorCambiado, VOut.get(colorCambiado) + (int)pairs.getValue());
			relacionVinVout.put((int)pairs.getKey(), colorCambiado);
		}
		actualizarValoresVinVout(relacionVinVout, VOut);
	}

	/**
	 * ecualizar
	 */
	//bien
	public void ecualizar() {
		int colorCambiado;
		HashMap<Integer, Integer> relacionVinVout = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> VOut = new HashMap<Integer, Integer>();
		for (int i = 0; i < 256; i++)
			VOut.put(i, 0);
		// recorremos el histograma y cambiamos los valores de vin por vout
		Iterator it = histogramaAbsoluto.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			// esto va a dar 0000000 seguro
			colorCambiado = Math.round((((float)256 / histogramaAcumulado.get(255)) * (int) histogramaAcumulado.get((int)pairs.getKey())) - 1);
			if(colorCambiado < 0)
				colorCambiado = 0;
			if(colorCambiado > 255)
				colorCambiado = 255;
			VOut.put(colorCambiado, VOut.get(colorCambiado) + (int) (pairs.getValue()));
			relacionVinVout.put((int) (pairs.getKey()), colorCambiado);
		}
		actualizarValoresVinVout(relacionVinVout, VOut);
	}

	/**
	 * correccionGamma
	 */
	// bien
	public void correccionGamma(double y) {
		int colorCambiado;
		HashMap<Integer, Integer> relacionVinVout = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> VOut = new HashMap<Integer, Integer>();
		for (int i = 0; i < 256; i++)
			VOut.put(i, 0);
		// recorremos el histograma y cambiamos los valores de vin por vout
		Iterator it = histogramaAbsoluto.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			double a = (int) pairs.getKey() / (double) 255;
			double b = Math.pow(a, y);
			colorCambiado = (int) (b * 255);
			VOut.put(colorCambiado, VOut.get(colorCambiado) + (int) (pairs.getValue()));
			relacionVinVout.put((int) (pairs.getKey()), colorCambiado);
		}
		actualizarValoresVinVout(relacionVinVout, VOut);
	}

	/**
	 * repintarCambiosMatrizPixeles
	 */
	public void repintarCambiosMatrizPixeles(ArrayList<ArrayList<Integer>> matrizDiferencia, int umbral) {
		for (int i = 0; i < matrizDiferencia.size(); i++) {
			for (int j = 0; j < matrizDiferencia.get(i).size(); j++) {
				if (matrizDiferencia.get(i).get(j) > umbral) {
					imagen.setRGB(i, j, new Color(255, 0, 0).getRGB());
				}
			}
		}
	}

	/**
	 * diferenciaImagenes
	 */
	public BufferedImage diferenciaImagenes(Imagen imagenResta) {
		BufferedImage imagenDiferencia = new BufferedImage(imagen.getWidth(), imagen.getHeight(), imagen.getType());
		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {
				int colorCambiado = Math
						.abs(matrizPixelesGris.get(i).get(j) - imagenResta.getMatrizPixelesGris().get(i).get(j));
				imagenDiferencia.setRGB(i, j, new Color(colorCambiado, colorCambiado, colorCambiado).getRGB());
			}
		}
		return imagenDiferencia;
	}

	/**
	 * generarHistogramaMatriz
	 */
	public HashMap<Integer, Integer> generarHistogramaMatriz(ArrayList<ArrayList<Integer>> matriz) {
		HashMap<Integer, Integer> histograma = new HashMap<Integer, Integer>();
		for (int i = 0; i < 256; i++)
			histograma.put(i, 0);
		for (int i = 0; i < matriz.size(); i++) {
			for (int j = 0; j < matriz.get(i).size(); j++) {
				histograma.put(matriz.get(i).get(j), histograma.get(matriz.get(i).get(j)) + 1);
			}
		}
		return histograma;
	}

	/**
	 * actualizarValores
	 */
	public void actualizarValoresVinVout(HashMap<Integer, Integer> relacionVinVout, HashMap<Integer, Integer> VOut) {
		// cambiamos la matriz de pixeles y cambiamos la bufferedimage
		for (int i = 0; i < matrizPixelesGris.size(); i++) {
			for (int j = 0; j < matrizPixelesGris.get(i).size(); j++) {
				int colorCambiado = relacionVinVout.get(matrizPixelesGris.get(i).get(j));
				matrizPixelesGris.get(i).set(j, colorCambiado);
				imagen.setRGB(i, j, new Color(colorCambiado, colorCambiado, colorCambiado).getRGB());
			}
		}
		// actualizamos la imformacion de la imagen
		setHistogramaAbsoluto(VOut);
		obtenerHisogramaAcumulado();
		obtenerRango();
		obtenerBrillo();
		obtenerContraste();
	}

	/**
	 * actualizarValoresMedienteBufferedImage
	 */
	public void actualizarValoresMedienteBufferedImage() {
		histogramaAbsoluto.clear();
		for (int i = 0; i < 256; i++)
			histogramaAbsoluto.put(i, 0);
		for (int i = 0; i < matrizPixelesGris.size(); i++) {
			for (int j = 0; j < matrizPixelesGris.get(i).size(); j++) {
				int colorCambiado = new Color(imagen.getRGB(i, j)).getRed();
				matrizPixelesGris.get(i).set(j, colorCambiado);
				histogramaAbsoluto.put(colorCambiado, histogramaAbsoluto.get(colorCambiado) + 1);
			}
		}
		// actualizamos la imformacion de la imagen
		obtenerHisogramaAcumulado();
		obtenerRango();
		obtenerBrillo();
		obtenerContraste();
	}

	/**
	 * subImagen
	 */
	public BufferedImage subImagen(Point inicio, Point fin) {
		int k = 0;
		int l = 0;
		BufferedImage subImagen = new BufferedImage((int) (fin.getX() - inicio.getX()),
				(int) (fin.getY() - inicio.getY()), imagen.getType());
		for (int i = (int) inicio.getX(); i < fin.getX(); i++) {
			for (int j = (int) inicio.getY(); j < fin.getY(); j++) {
				subImagen.setRGB(k, l, new Color(matrizPixelesGris.get(i).get(j), matrizPixelesGris.get(i).get(j),
						matrizPixelesGris.get(i).get(j)).getRGB());
				l++;
			}
			l = 0;
			k++;
		}
		return subImagen;
	}

	/**
	 * informacionImagen
	 */
	public String informacionImagen() {
		String informacion = "Tipo: ." + extensionImagen + "\nSize: " + imagen.getWidth() + "x" + imagen.getHeight()
				+ "\nRango: " + rangoMinimo + " - " + rangoMaximo + "\nBrillo: " + brillo + "\nContraste: " + contraste
				+ "\nEntropia: " + entropia;
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
			// clonar las primitivas
			imagenClonada = (Imagen) super.clone();
			// clonar los arrays
			imagenClonada
					.setHistogramaAbsoluto((HashMap<Integer, Integer>) imagenClonada.getHistogramaAbsoluto().clone());
			imagenClonada
					.setHistogramaAcumulado((HashMap<Integer, Integer>) imagenClonada.getHistogramaAcumulado().clone());
			imagenClonada
					.setMatrizPixelesGris((ArrayList<ArrayList<Integer>>) imagenClonada.getMatrizPixelesGris().clone());
			// clonar la bufferedImage
			ColorModel colorModel = imagenClonada.getImagen().getColorModel();
			boolean isAlphaPremultiplied = colorModel.isAlphaPremultiplied();
			WritableRaster raster = imagenClonada.getImagen().copyData(null);
			imagenClonada.setImagen(new BufferedImage(colorModel, raster, isAlphaPremultiplied, null));
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
	public void setMatrizPixelesGris(ArrayList<ArrayList<Integer>> matrizPixelesGris) {
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
	public void setHistogramaAcumulado(HashMap<Integer, Integer> histogramaAcumulado) {
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
	public float getEntropia() {
		return entropia;
	}

	/**
	 * @param entropia
	 *            the entropia to set
	 */
	public void setEntropia(float entropia) {
		this.entropia = entropia;
	}

	/**
	 * @return the nombreImagen
	 */
	public String getNombreImagen() {
		return nombreImagen;
	}

	/**
	 * @param nombreImagen
	 *            the nombreImagen to set
	 */
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

}
