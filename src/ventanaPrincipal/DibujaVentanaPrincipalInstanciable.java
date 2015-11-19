package ventanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clases.ConjuntoImagenes;
import clases.Imagen;
import dialogs.CambiarBrilloContraste;
import dialogs.InformacionImagen;
import dibujablesHistogramas.DibujaHistogramaAbsoluto;
import dibujablesHistogramas.DibujaHistogramaAcumulado;
import dibujablesHistogramas.DibujaInternalFrameHistogramaAbsoluto;
import dibujablesHistogramas.DibujaInternalFrameHistogramaAcumulado;
import dibujablesImagen.DibujaImagen;
import dibujablesImagen.DibujaInternalFrameImagen;

public class DibujaVentanaPrincipalInstanciable extends DibujaVentanaPrincipal {

	private ConjuntoImagenes conjuntoImagenes;

	public DibujaVentanaPrincipalInstanciable() {
		super();
		addAbrirImagenListener(new AbrirImagenListener());
		addGuardarImagenListener(new GuardarImagenListener());
		addHacerCopiaListener(new HacerCopiaListener());
		addCambiarBrilloContrasteListener(new CambiarBrilloContrasteListener());
		addVerHistogramaAbsolutoListener(new VerHistogramaAbsolutoListener());
		addVerHistogramaAcumuladoListener(new VerHistogramaAcumuladoListener());
		addVerInformacionImagenListener(new VerInformacionImagenListener());
		conjuntoImagenes = new ConjuntoImagenes();
	}

	class AbrirImagenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Imagen imagen = new Imagen();
			getConjuntoImagenes().addImagen(imagen);
			DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(
					new DibujaImagen(imagen, getPanelEstado()));
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
					DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(
							new DibujaImagen(getConjuntoImagenes().hacerCopiaImagen(i), getPanelEstado()));
					getImagenesAbiertas().add(dibujaInternalFrameImagen);
					getGrupoInternalFrames().add(dibujaInternalFrameImagen);
				}
			}
		}

	}

	class CambiarBrilloContrasteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					CambiarBrilloContraste cambiarBrilloContraste = new CambiarBrilloContraste(
							conjuntoImagenes.getImagen(i), getImagenesAbiertas(), getBarraMenu(),
							getGrupoInternalFrames(), getPanelEstado(), getConjuntoImagenes());
				}
			}
		}

	}

	class VerHistogramaAbsolutoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					DibujaInternalFrameHistogramaAbsoluto internalFrameHistograma = new DibujaInternalFrameHistogramaAbsoluto(
							new DibujaHistogramaAbsoluto(getConjuntoImagenes().getHistogramaAbsoluto(i)));
					getGrupoInternalFrames().add(internalFrameHistograma);
				}
			}
		}

	}

	class VerHistogramaAcumuladoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					DibujaInternalFrameHistogramaAcumulado internalFrameHistograma = new DibujaInternalFrameHistogramaAcumulado(
							new DibujaHistogramaAcumulado(getConjuntoImagenes().getHistogramaAcumulado(i)));
					getGrupoInternalFrames().add(internalFrameHistograma);
				}
			}
		}

	}

	class VerInformacionImagenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					InformacionImagen informacion = new InformacionImagen(getConjuntoImagenes().getImagen(i));
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
