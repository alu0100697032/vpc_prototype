package ventanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import clases.ConjuntoImagenes;
import clases.Imagen;
import dialogs.CambiarBrilloContrasteDialog;
import dialogs.CorreccionGammaDialog;
import dialogs.EspecificarNumeroTramosDialog;
import dialogs.GuardarImagenDialog;
import dialogs.InformacionImagenDialog;
import dialogs.SeleccionarUmbralDialog;
import dialogs.AbrirImagenDialog;
import dibujablesHistogramas.DibujaHistogramaAbsoluto;
import dibujablesHistogramas.DibujaHistogramaAcumulado;
import dibujablesHistogramas.DibujaInternalFrameHistogramaAbsoluto;
import dibujablesHistogramas.DibujaInternalFrameHistogramaAcumulado;
import dibujablesImagen.DibujaImagenInstanciable;
import dibujablesImagen.DibujaInternalFrameImagen;

public class DibujaVentanaPrincipalInstanciable extends DibujaVentanaPrincipal {

	/**
	 * Atributos
	 */
	private ConjuntoImagenes conjuntoImagenes;

	/**
	 * Constructor: DibujaVentanaPrincipalInstanciable
	 */
	public DibujaVentanaPrincipalInstanciable() {
		super();
		addAbrirImagenListener(new AbrirImagenListener());
		addGuardarImagenListener(new GuardarImagenListener());

		addHacerCopiaListener(new HacerCopiaListener());
		addSeleccionarRegionInteresListener(new SeleccionarRegionInteresListener());
		addCambiarBrilloContrasteListener(new CambiarBrilloContrasteListener());
		addTransformacionLinealTramosListener(new TransformacionLinealTramosListener());
		addCorreccionGammaListener(new CorreccionGammaListener());
		addDiferenciaImagenesListener(new DiferenciaImagenesListener());
		addEcualizacionListener(new EcualizacionListener());

		addVerHistogramaAbsolutoListener(new VerHistogramaAbsolutoListener());
		addVerHistogramaAcumuladoListener(new VerHistogramaAcumuladoListener());
		addVerInformacionImagenListener(new VerInformacionImagenListener());
		conjuntoImagenes = new ConjuntoImagenes();
	}

	class AbrirImagenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AbrirImagenDialog selectorFichero = new AbrirImagenDialog();
			Imagen imagen = new Imagen(selectorFichero.getImagenCargada(), selectorFichero.getNombreImagen(),
					selectorFichero.getExtensionImagen());
			getConjuntoImagenes().addImagen(imagen);
			DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(
					new DibujaImagenInstanciable(imagen, getImagenesAbiertas(), getBarraMenu(),
							getGrupoInternalFrames(), getPanelEstado(), conjuntoImagenes));
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
					GuardarImagenDialog guardarImagen = new GuardarImagenDialog(
							getConjuntoImagenes().getImagen(i).getImagen(),
							getConjuntoImagenes().getImagen(i).getExtensionImagen());

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
							new DibujaImagenInstanciable(getConjuntoImagenes().hacerCopiaImagen(i),
									getImagenesAbiertas(), getBarraMenu(), getGrupoInternalFrames(), getPanelEstado(),
									getConjuntoImagenes()));
					getImagenesAbiertas().add(dibujaInternalFrameImagen);
					getGrupoInternalFrames().add(dibujaInternalFrameImagen);
				}
			}
		}

	}

	class SeleccionarRegionInteresListener implements ActionListener {
		private boolean seleccionActiva = false;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (seleccionActiva == false) {
				seleccionActiva = true;
				getBarraMenu().getMenuItemSeleccionarRegionInteres().setText("Seleccionar ROI(activado)");
				for (int i = 0; i < getImagenesAbiertas().size(); i++) {
					getImagenesAbiertas().get(i).getDibujaImagenInstanciable().habilitarSeleccionRegionInteres();
				}
			} else {
				seleccionActiva = false;
				getBarraMenu().getMenuItemSeleccionarRegionInteres().setText("Seleccionar ROI(desactivado)");
				for (int i = 0; i < getImagenesAbiertas().size(); i++) {
					getImagenesAbiertas().get(i).getDibujaImagenInstanciable().deshabilitarSeleccionRegionInteres();
				}
			}
		}
	}

	class CambiarBrilloContrasteListener implements ActionListener {
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					CambiarBrilloContrasteDialog cambiarBrilloContraste = new CambiarBrilloContrasteDialog(
							conjuntoImagenes.getImagen(i), getImagenesAbiertas(), getBarraMenu(),
							getGrupoInternalFrames(), getPanelEstado(), getConjuntoImagenes());
				}
			}
		}
	}

	class TransformacionLinealTramosListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					EspecificarNumeroTramosDialog especificarNumeroTramosDialog = new EspecificarNumeroTramosDialog(
							conjuntoImagenes.getImagen(i), getImagenesAbiertas(), getBarraMenu(),
							getGrupoInternalFrames(), getPanelEstado(), getConjuntoImagenes());
				}
			}
		}
	}

	class CorreccionGammaListener implements ActionListener {
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					CorreccionGammaDialog correccionGammaDialog = new CorreccionGammaDialog(
							conjuntoImagenes.getImagen(i), getImagenesAbiertas(), getBarraMenu(),
							getGrupoInternalFrames(), getPanelEstado(), getConjuntoImagenes());
				}
			}
		}
	}
	
	class EcualizacionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					Imagen imagen = new Imagen(conjuntoImagenes.hacerCopiaImagen(index));
					getConjuntoImagenes().addImagen(imagen);
					DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(
							new DibujaImagenInstanciable(imagen, getImagenesAbiertas(), getBarraMenu(),
									getGrupoInternalFrames(), getPanelEstado(), conjuntoImagenes));
					getImagenesAbiertas().add(dibujaInternalFrameImagen);
					getGrupoInternalFrames().add(dibujaInternalFrameImagen);
				}
			}*/
		}
		
	}

	class DiferenciaImagenesListener implements ActionListener {
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					//Abre imagen y la visualiza
					AbrirImagenDialog abrirImagenDiferencia = new AbrirImagenDialog();
					Imagen imagen = new Imagen(abrirImagenDiferencia.getImagenCargada(),
							abrirImagenDiferencia.getNombreImagen(), abrirImagenDiferencia.getExtensionImagen());
					getConjuntoImagenes().addImagen(imagen);
					DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(
							new DibujaImagenInstanciable(imagen, getImagenesAbiertas(), getBarraMenu(),
									getGrupoInternalFrames(), getPanelEstado(), conjuntoImagenes));
					getImagenesAbiertas().add(dibujaInternalFrameImagen);
					getGrupoInternalFrames().add(dibujaInternalFrameImagen);
					//genera la imagen diferencia
					Imagen imagenDiferencia = new Imagen(conjuntoImagenes.getImagen(i).diferenciaImagenes(imagen),
							"imagenDiferencia", abrirImagenDiferencia.getExtensionImagen());
					imagenDiferencia.actualizarValoresMedienteBufferedImage();
					getConjuntoImagenes().addImagen(imagenDiferencia);
					DibujaInternalFrameImagen dibujaInternalFrameImagenDiferencia = new DibujaInternalFrameImagen(
							new DibujaImagenInstanciable(imagenDiferencia, getImagenesAbiertas(), getBarraMenu(),
									getGrupoInternalFrames(), getPanelEstado(), conjuntoImagenes));
					getImagenesAbiertas().add(dibujaInternalFrameImagenDiferencia);
					getGrupoInternalFrames().add(dibujaInternalFrameImagenDiferencia);
					/*DibujaHistogramaAbsoluto dibujaHistogramaAbsolutoDiferencia = new DibujaHistogramaAbsoluto(
							conjuntoImagenes.getImagen(i)
									.generarHistogramaMatriz(matrizDiferencia));
					DibujaInternalFrameHistogramaAbsoluto dibujaInternalFrameImagenDiferencia = new DibujaInternalFrameHistogramaAbsoluto(
							dibujaHistogramaAbsolutoDiferencia);
					getGrupoInternalFrames().add(dibujaInternalFrameImagenDiferencia);
					//Pregunta por el umbral
					SeleccionarUmbralDialog seleccionarUmbralDialog =  new SeleccionarUmbralDialog(imagen, matrizDiferencia);*/
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
					InformacionImagenDialog informacion = new InformacionImagenDialog(
							getConjuntoImagenes().getImagen(i));
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
