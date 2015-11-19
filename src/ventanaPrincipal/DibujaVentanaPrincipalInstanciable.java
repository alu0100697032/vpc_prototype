package ventanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.SliderUI;

import clases.ConjuntoImagenes;
import clases.Imagen;
import dialogs.CambiarBrilloContraste;
import dialogs.InformacionImagen;
import dialogs.SelectorFichero;
import dibujablesHistogramas.DibujaHistogramaAbsoluto;
import dibujablesHistogramas.DibujaHistogramaAcumulado;
import dibujablesHistogramas.DibujaInternalFrameHistogramaAbsoluto;
import dibujablesHistogramas.DibujaInternalFrameHistogramaAcumulado;
import dibujablesImagen.DibujaImagen;
import dibujablesImagen.DibujaImagenInstanciable;
import dibujablesImagen.DibujaInternalFrameImagen;

public class DibujaVentanaPrincipalInstanciable extends DibujaVentanaPrincipal {

	private ConjuntoImagenes conjuntoImagenes;

	public DibujaVentanaPrincipalInstanciable() {
		super();
		addAbrirImagenListener(new AbrirImagenListener());
		addGuardarImagenListener(new GuardarImagenListener());
		
		addHacerCopiaListener(new HacerCopiaListener());
		addCambiarBrilloContrasteListener(new CambiarBrilloContrasteListener());
		addSeleccionarRegionInteresListener(new SeleccionarRegionInteresListener());
		
		addVerHistogramaAbsolutoListener(new VerHistogramaAbsolutoListener());
		addVerHistogramaAcumuladoListener(new VerHistogramaAcumuladoListener());
		addVerInformacionImagenListener(new VerInformacionImagenListener());
		conjuntoImagenes = new ConjuntoImagenes();
	}

	class AbrirImagenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SelectorFichero selectorFichero = new SelectorFichero();
			Imagen imagen = new Imagen(selectorFichero.getImagenCargada(), selectorFichero.getNombreImagen(),
					selectorFichero.getExtensionImagen());
			getConjuntoImagenes().addImagen(imagen);
			DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(
					new DibujaImagenInstanciable(imagen, getImagenesAbiertas(), getBarraMenu(), getGrupoInternalFrames(),
							getPanelEstado(), conjuntoImagenes));
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
							new DibujaImagenInstanciable(getConjuntoImagenes().hacerCopiaImagen(i), getImagenesAbiertas(),
									getBarraMenu(), getGrupoInternalFrames(), getPanelEstado(), getConjuntoImagenes()));
					getImagenesAbiertas().add(dibujaInternalFrameImagen);
					getGrupoInternalFrames().add(dibujaInternalFrameImagen);
				}
			}
		}

	}

	class CambiarBrilloContrasteListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
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

	class SeleccionarRegionInteresListener implements ActionListener{

		private boolean seleccionActiva = false;
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(seleccionActiva == false) {
				seleccionActiva = true;
				getBarraMenu().getMenuItemSeleccionarRegionInteres().setText("Seleccionar ROI(activado)");
				for(int i = 0; i < getImagenesAbiertas().size(); i++) {
					getImagenesAbiertas().get(i).getDibujaImagenInstanciable().habilitarSeleccionRegionInteres();
				}
			}else {
				seleccionActiva = false;
				getBarraMenu().getMenuItemSeleccionarRegionInteres().setText("Seleccionar ROI(desactivado)");
				for(int i = 0; i < getImagenesAbiertas().size(); i++) {
					getImagenesAbiertas().get(i).getDibujaImagenInstanciable().deshabilitarSeleccionRegionInteres();
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
