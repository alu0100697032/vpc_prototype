package Dibujables;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Clases.ConjuntoImagenes;
import Clases.Imagen;

public class DibujaVentanaPrincipalInstanciable extends DibujaVentanaPrincipal{

	private ConjuntoImagenes conjuntoImagenes;

	public DibujaVentanaPrincipalInstanciable() {
		super();
		addAbrirImagenListener(new AbrirImagenListener());
		addGuardarImagenListener(new GuardarImagenListener());
		addHacerCopiaListener(new HacerCopiaListener());
		conjuntoImagenes = new ConjuntoImagenes();
	}

	class AbrirImagenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Imagen imagen = new Imagen();
			getConjuntoImagenes().addImagen(imagen);
			DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(new DibujaImagen(imagen.getImagen(), getPanelEstado()));
			getImagenesAbiertas().add(dibujaInternalFrameImagen);
			getGrupoInternalFrames().add(dibujaInternalFrameImagen);
		}

	}

	class GuardarImagenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					getConjuntoImagenes().getImagen(i).guardarImagen();
				}
			}
		}

	}

	class HacerCopiaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(new DibujaImagen(
							getConjuntoImagenes().hacerCopiaImagen(i)
									.getImagen(), getPanelEstado()));
					getImagenesAbiertas().add(dibujaInternalFrameImagen);
					getGrupoInternalFrames().add(dibujaInternalFrameImagen);
				}
			}
		}

	}

	/**
	 * @return the conjuntoImagenes
	 */
	public ConjuntoImagenes getConjuntoImagenes() {
		return conjuntoImagenes;
	}

	/**
	 * @param conjuntoImagenes
	 *            the conjuntoImagenes to set
	 */
	public void setConjuntoImagenes(ConjuntoImagenes conjuntoImagenes) {
		this.conjuntoImagenes = conjuntoImagenes;
	}	
}
