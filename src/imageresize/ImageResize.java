/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageresize;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author andres
 */
public class ImageResize {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClassLoader classLoader = ImageResize.class.getClassLoader();
        File pngOriginal = new File(classLoader.getResource("resources/imagencita-tarjetas.jpg").getPath());
        String newFileAddress = classLoader.getResource("resources").getPath() + "/nueva.jpg";
        File pngResized = new File(newFileAddress);
        resizeImage(pngOriginal, pngResized, 200, 200, "jpg");
    }
    
    private static void resizeImage(File originalImage, File resizedImage, int width, int height, String format)
    {
        try {
            BufferedImage original = ImageIO.read(originalImage);
            BufferedImage resized = new BufferedImage(width, height, original.getType());
            Graphics2D g2 = resized.createGraphics();
            g2.drawImage(original, 0, 0, width, height, null);
            g2.dispose();
            ImageIO.write(resized, format, resizedImage);            
            
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }
    
}
