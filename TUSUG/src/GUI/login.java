
import GUI.Builder;
import GUI.PanelImagen;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login {

    JFrame x;
    JPanel p;
    JTextField jt;
    JTextField jt2;
    JButton b;

    public login() {
        x = Builder.construirFrame("NULL", new Rectangle(0, 0, 700, 600), false);
        p = Builder.crearPanel(x, new Rectangle(0, 0, 700, 600), "src/Imagenes/login.png", true);

        jt = Builder.crearTextField(p, new Rectangle(205,233, 293,38), "", null, null, null, true, true, true);

        jt2 = Builder.crearTextField(p, new Rectangle(205,298, 293,38), "", null, null, null, true, true, true);

        b = Builder.crearBoton(p, "Ingresar", new Rectangle(257,383, 185,39), null, false, false);

    }

    public static void main(String[] args) {
        login l = new login();
    }

}
