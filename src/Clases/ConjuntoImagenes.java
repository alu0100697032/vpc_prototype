package Clases;

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
	
	public HashMap<Integer, Integer> getHistograma(int index){
		return getListaImagenes().get(index).getHistograma();
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
