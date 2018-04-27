package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
}
