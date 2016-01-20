package ventanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import clases.ConjuntoImagenes;
import clases.Imagen;
import dialogs.CambiarBrilloContrasteDialog;
import dialogs.CorreccionGammaDialog;
import dialogs.EspecificarNumeroTramosDialog;
import dialogs.GuardarImagenDialog;
import dialogs.InformacionImagenDialog;
import dialogs.RotacionBilinealDialog;
import dialogs.RotacionDialog;
import dialogs.RotarPintarDialog;
import dialogs.SeleccionarUmbralDialog;
import dialogs.AbrirImagenDialog;
import dibujablesHistogramas.DibujaHistogramaAbsoluto;
import dibujablesHistogramas.DibujaHistogramaAcumulado;
import dibujablesHistogramas.DibujaInternalFrameHistogramaAbsoluto;
import dibujablesHistogramas.DibujaInternalFrameHistogramaAcumulado;
import dibujablesImagen.DibujaImagenInstanciable;
import dibujablesImagen.DibujaInternalFrameImagen;
import escaladoDialogs.NuevaEscalaDialog;

@SuppressWarnings("serial")
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
		addMapaCambiosListener(new MapaCambiosListener());
		addEcualizacionListener(new EcualizacionListener());

		addVerHistogramaAbsolutoListener(new VerHistogramaAbsolutoListener());
		addVerHistogramaAcumuladoListener(new VerHistogramaAcumuladoListener());
		addVerInformacionImagenListener(new VerInformacionImagenListener());

		addVMPListener(new VecinoMasProximoListener());
		addBilinearistener(new BilinearListener());

		addEspejoHorizontalListener(new EspejoHorizontalListener());
		addEspejoVerticalListener(new EspejoVerticalListener());
		addTraspuestaListener(new TraspuestaListener());
		addRotaciones90Listener(new Rotaciones90Listener());
		addRotarPintarListener(new RotarPintarListener());
		addRotacionesListener(new RotacionesListener());
		addRotacionesBilinealesListener(new RotacionesBilinealesListener());
		
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

	class EcualizacionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < getImagenesAbiertas().size(); i++) {
				if (getImagenesAbiertas().get(i).isSelected()) {
					Imagen imagen = getConjuntoImagenes().hacerCopiaImagen(i);
					imagen.ecualizar();
					getConjuntoImagenes().addImagen(imagen);
					DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(
							new DibujaImagenInstanciable(imagen, getImagenesAbiertas(), getBarraMenu(),
									getGrupoInternalFrames(), getPanelEstado(), conjuntoImagenes));
					getImagenesAbiertas().add(dibujaInternalFrameImagen);
					getGrupoInternalFrames().add(dibujaInternalFrameImagen);
				}
			}
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
					// Abre imagen y la visualiza
					AbrirImagenDialog abrirImagenResta = new AbrirImagenDialog();
					Imagen imagenResta = new Imagen(abrirImagenResta.getImagenCargada(),
							abrirImagenResta.getNombreImagen(), abrirImagenResta.getExtensionImagen());
					getConjuntoImagenes().addImagen(imagenResta);
					DibujaInternalFrameImagen dibujaInternalFrameImagen = new DibujaInternalFrameImagen(
							new DibujaImagenInstanciable(imagenResta, getImagenesAbiertas(), getBarraMenu(),
									getGrupoInternalFrames(), getPanelEstado(), conjuntoImagenes));
					getImagenesAbiertas().add(dibujaInternalFrameImagen);
					getGrupoInternalFrames().add(dibujaInternalFrameImagen);
					// genera la imagen diferencia
					Imagen imagenDiferencia = new Imagen(conjuntoImagenes.getImagen(i).diferenciaImagenes(imagenResta));
					getConjuntoImagenes().addImagen(imagenDiferencia);
					DibujaInternalFrameImagen dibujaInternalFrameImagenDiferencia = new DibujaInternalFrameImagen(
							new DibujaImagenInstanciable(imagenDiferencia, getImagenesAbiertas(), getBarraMenu(),
									getGrupoInternalFrames(), getPanelEstado(), conjuntoImagenes));
					getImagenesAbiertas().add(dibujaInternalFrameImagenDiferencia);
					getGrupoInternalFrames().add(dibujaInternalFrameImagenDiferencia);
				}
			}
		}

	}

	class MapaCambiosListener implements ActionListener {

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
					SeleccionarUmbralDialog umbralDialog = new SeleccionarUmbralDialog(conjuntoImagenes.getImagen(i));
					getImagenesAbiertas().get(i).repaint();
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

	class VecinoMasProximoListener implements ActionListener {

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
					NuevaEscalaDialog nuevaEscalaDialog = new NuevaEscalaDialog(conjuntoImagenes.getImagen(i),
							getImagenesAbiertas(), getBarraMenu(), getGrupoInternalFrames(), getPanelEstado(),
							getConjuntoImagenes(), 0);
				}
			}

		}

	}

	class BilinearListener implements ActionListener {

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
					NuevaEscalaDialog nuevaEscalaDialog = new NuevaEscalaDialog(conjuntoImagenes.getImagen(i),
							getImagenesAbiertas(), getBarraMenu(), getGrupoInternalFrames(), getPanelEstado(),
							getConjuntoImagenes(), 1);
				}
			}
		}

	}

	class EspejoHorizontalListener implements ActionListener {

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
					Imagen imagen = new Imagen(conjuntoImagenes.getImagen(i).espejoHorizontal());
					getConjuntoImagenes().addImagen(imagen);
					DibujaInternalFrameImagen dibujaInternalFrameImagenDiferencia = new DibujaInternalFrameImagen(
							new DibujaImagenInstanciable(imagen, getImagenesAbiertas(), getBarraMenu(),
									getGrupoInternalFrames(), getPanelEstado(), conjuntoImagenes));
					getImagenesAbiertas().add(dibujaInternalFrameImagenDiferencia);
					getGrupoInternalFrames().add(dibujaInternalFrameImagenDiferencia);
				}
			}
		}

	}

	class EspejoVerticalListener implements ActionListener {

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
					Imagen imagen = new Imagen(conjuntoImagenes.getImagen(i).espejoVertical());
					getConjuntoImagenes().addImagen(imagen);
					DibujaInternalFrameImagen dibujaInternalFrameImagenDiferencia = new DibujaInternalFrameImagen(
							new DibujaImagenInstanciable(imagen, getImagenesAbiertas(), getBarraMenu(),
									getGrupoInternalFrames(), getPanelEstado(), conjuntoImagenes));
					getImagenesAbiertas().add(dibujaInternalFrameImagenDiferencia);
					getGrupoInternalFrames().add(dibujaInternalFrameImagenDiferencia);
				}
			}
		}

	}

	class TraspuestaListener implements ActionListener {

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
					Imagen imagen = new Imagen(conjuntoImagenes.getImagen(i).traspuesta());
					getConjuntoImagenes().addImagen(imagen);
					DibujaInternalFrameImagen dibujaInternalFrameImagenDiferencia = new DibujaInternalFrameImagen(
							new DibujaImagenInstanciable(imagen, getImagenesAbiertas(), getBarraMenu(),
									getGrupoInternalFrames(), getPanelEstado(), conjuntoImagenes));
					getImagenesAbiertas().add(dibujaInternalFrameImagenDiferencia);
					getGrupoInternalFrames().add(dibujaInternalFrameImagenDiferencia);
				}
			}
		}

	}

	class Rotaciones90Listener implements ActionListener {

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
					Imagen imagen = new Imagen(conjuntoImagenes.getImagen(i).rotacion90());
					getConjuntoImagenes().addImagen(imagen);
					DibujaInternalFrameImagen dibujaInternalFrameImagenDiferencia = new DibujaInternalFrameImagen(
							new DibujaImagenInstanciable(imagen, getImagenesAbiertas(), getBarraMenu(),
									getGrupoInternalFrames(), getPanelEstado(), conjuntoImagenes));
					getImagenesAbiertas().add(dibujaInternalFrameImagenDiferencia);
					getGrupoInternalFrames().add(dibujaInternalFrameImagenDiferencia);
				}
			}
		}

	}
	class RotarPintarListener implements ActionListener {

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
					RotarPintarDialog rotacionDialog = new RotarPintarDialog(conjuntoImagenes.getImagen(i),
							getImagenesAbiertas(), getBarraMenu(), getGrupoInternalFrames(), getPanelEstado(),
							getConjuntoImagenes());
				}
			}
		}

	}
	class RotacionesListener implements ActionListener {

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
					RotacionDialog rotacionDialog = new RotacionDialog(conjuntoImagenes.getImagen(i),
							getImagenesAbiertas(), getBarraMenu(), getGrupoInternalFrames(), getPanelEstado(),
							getConjuntoImagenes());
				}
			}
		}

	}
	class RotacionesBilinealesListener implements ActionListener {

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
					RotacionBilinealDialog rotacionBilinealDialog = new RotacionBilinealDialog(conjuntoImagenes.getImagen(i),
							getImagenesAbiertas(), getBarraMenu(), getGrupoInternalFrames(), getPanelEstado(),
							getConjuntoImagenes());
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
