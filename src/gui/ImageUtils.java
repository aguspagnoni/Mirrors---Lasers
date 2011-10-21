package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * Clase con métodos útiles para el manejo de imágenes.
 */
public class ImageUtils {

	/**
	 * Carga una imagen y retorna una instancia de la misma. Si hay algun problema
	 * al leer el archivo lanza una excepcion.
	 */
	public static Image loadImage(String fileName) throws IOException {
	    InputStream stream = ClassLoader.getSystemResourceAsStream(fileName);
        if (stream == null) {
                return ImageIO.read(new File(fileName));
        } else {
                return ImageIO.read(stream);
        }
	}
	
	/**
	 * Dada una imagen, la rota 90 grados a la derecha tantas veces como se indique en el 
	 * parametro times. Retorna una nueva imagen con la rotación, la imagen original queda intacta.
	 */
	public static Image rotateImage(Image image, int times) {
		BufferedImage aux = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		aux.getGraphics().drawImage(image, 0, 0, null);
		
		AffineTransform at = new AffineTransform();
		at.rotate(times * 90.0 * Math.PI / 180.0, image.getWidth(null) / 2.0, image.getHeight(null) / 2.0);

		BufferedImageOp bio = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		return bio.filter(aux, null);
	}
	
	/**
	 * Dada una imagen, reemplaza todos los pixeles de color source por el color target. Retorna una 
	 * nueva instancia con el resultado, la imagen original queda intacta.
	 */
	public static Image replaceColor(Image image, Color source, Color target) {
		BufferedImage result = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		result.getGraphics().drawImage(image, 0, 0, null);
		
		for (int x = 0; x < image.getWidth(null); x++) {
			for (int y = 0; y < image.getHeight(null); y++) {
				Color c = new Color(result.getRGB(x, y));
				if (c.equals(source)) {
					result.setRGB(x, y, target.getRGB());
				}
			}
		}
		return result;
	}
	
	/**
	 * Mezcla dos colores y retorna una nueva instancia con el resultado.
	 */
	public static Color mix(Color c1, Color c2) {
		return new Color(Math.min(c1.getRed() + c2.getRed(), 255), 
				Math.min(c1.getGreen() + c2.getGreen(), 255),
				Math.min(c1.getBlue() + c2.getBlue(), 255));
	}
	
	/**
	 * Dado un color y el color de un filtro retorna el color filtrado. 
	 */
	public static Color filter(Color c, Color filter) {
		return new Color(Math.max(0, c.getRed() - filter.getRed()),
				Math.max(0, c.getGreen() - filter.getGreen()),
				Math.max(0, c.getBlue() - filter.getBlue()));
	}
}
