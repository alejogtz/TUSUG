package GUI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alekhius
 */
public class PanelImagen extends JPanel {

    BufferedImage imagen;

    public PanelImagen(String resource) {
        super();
        try {
            imagen = ImageIO.read(new File(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), null);
    }
<<<<<<< HEAD
=======

    public static void main(String[] args) {
        System.out.println("SSS");
        JFrame x = new JFrame("Hi");
        PanelImagen p = new PanelImagen("src/Imagenes/fondo ventana con logo.png");
        Builder.construirFrame(x,"Hi", 100, 200, 100, 50, true);
        Builder.add(x, p, new Rectangle(0,0, 100,100));
    }
>>>>>>> 0fc6db618079dbf168322b3f44d2883acfa17538
}
