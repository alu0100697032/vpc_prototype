package vpc_prototype;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ModeloImagen extends Observable{

	private BufferedImage imagen;
	
	public ModeloImagen(){
		
		BufferedImage img = null;
		JFileChooser selectorFichero = new JFileChooser();
		selectorFichero.setDialogTitle("Seleccione imagen a visualizar:");
		FileNameExtensionFilter extensionPermitida = new FileNameExtensionFilter("JPG & GIF & PNG & BMP", "jpg", "bmp", "png", "gif");
		selectorFichero.setFileFilter(extensionPermitida);
		int flag = selectorFichero.showOpenDialog(null);
		if(flag==JFileChooser.APPROVE_OPTION){
            try {
                File imagenSeleccionada=selectorFichero.getSelectedFile();
                img = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }
                  
        }
		
        setImagen(img);
	}
	

	public BufferedImage getImagen() {
		return imagen;
	}

	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}

}
