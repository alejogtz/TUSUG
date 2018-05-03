
import GUI.Builder;
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
        x = Builder.construirFrame("NULL", new Rectangle(0, 0, 700, 600), true);
        p = Builder.crearPanel(x, new Rectangle(0, 0, 700, 600), "src/Imagenes/login.png", false);

        jt = Builder.crearTextField(p, new Rectangle(190, 231, 293, 38), "", null, null, null, true, true, true);

        jt2 = Builder.crearTextField(p, new Rectangle(190, 231, 293, 38), "", null, null, null, true, true, true);

        b = Builder.crearBoton(p, "Ingresar", new Rectangle(257, 380, 185, 39), null, false, false);

    }

    public static void main(String[] args) {
        login l = new login();
    }

}
