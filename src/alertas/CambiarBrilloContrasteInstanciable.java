package alertas;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import Clases.Imagen;

public class CambiarBrilloContrasteInstanciable extends CambiarBrilloContraste{

	public CambiarBrilloContrasteInstanciable(Imagen imagen) {
		super(imagen);
		// TODO Auto-generated constructor stub
		addCanbiarBrilloListener(new CambiarBrilloListener());
		addCanbiarContrasteListener(new CambiarContrasteListener());
	}

	class CambiarBrilloListener implements AdjustmentListener{

		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			// TODO Auto-generated method stub
			mostrarNivelBrillo.setText("Brillo: " + e.getValue());
			System.out.println("dfgd");
		}
	}
	
	class CambiarContrasteListener implements AdjustmentListener{

		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			// TODO Auto-generated method stub
			mostrarNivelContraste.setText("Contraste: " + e.getValue());
			System.out.println("fgdsfgdg");
		}
	}
}
