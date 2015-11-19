package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class ConjuntoImagenes {

	private ArrayList<Imagen> listaImagenes;

	/*
	 * Constructor
	 */
	
	public ConjuntoImagenes(){
		setListaImagenes(new ArrayList<Imagen>());
	}
	
	public void addImagen(Imagen imagen){
		getListaImagenes().add(imagen);
	}
	
	public void removeImagen(int index){
		getListaImagenes().remove(index);
	}
	
	public Imagen hacerCopiaImagen(int index){
		getListaImagenes().add(getListaImagenes().get(index).clone());
		return getListaImagenes().get(getListaImagenes().size()-1);
	}
	
	public Imagen getImagen(int index){
		return getListaImagenes().get(index);
	}
	
	public HashMap<Integer, Integer> getHistogramaAbsoluto(int index){
		return getListaImagenes().get(index).getHistogramaAbsoluto();
	}
	
	public HashMap<Integer, Integer> getHistogramaAcumulado(int index){
		return getListaImagenes().get(index).getHistogramaAcumulado();
	}
	
	public int getRangoMaximo(int index){
		return getListaImagenes().get(index).getRangoMaximo();
	}
	
	public int getRangoMinimo(int index){
		return getListaImagenes().get(index).getRangoMinimo();
	}
	
	public int getBrillo(int index){
		return getListaImagenes().get(index).getBrillo();
	}
	
	public double getContraste(int index){
		return getListaImagenes().get(index).getContraste();
	}
	/**
	 * @return the listaImagenes
	 */
	public ArrayList<Imagen> getListaImagenes() {
		return listaImagenes;
	}

	/**
	 * @param listaImagenes the listaImagenes to set
	 */
	public void setListaImagenes(ArrayList<Imagen> listaImagenes) {
		this.listaImagenes = listaImagenes;
	}
}
