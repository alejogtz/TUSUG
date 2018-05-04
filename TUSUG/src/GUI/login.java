package GUI;

import Datos.Conexion;
import GUI.Builder;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login {

    JFrame x;
    JPanel p;
    JTextField txt_rfc;
    JTextField txt_password;
    JButton b;

    public login() {
        CustomActionListener escucha = new CustomActionListener();
        x = Builder.construirFrame("NULL", new Rectangle(0, 0, 700, 600), false);
        p = Builder.crearPanel(x, new Rectangle(0, 0, 700, 600), "src/Imagenes/login.png", true);
        txt_rfc = Builder.crearTextField(p, new Rectangle(205, 233, 293, 38), "", null, null, null, true, true, true);
        txt_password = Builder.crearPasswordField(p, new Rectangle(205, 298, 293, 38), "", null, null, null, true, true);
        b = Builder.crearBoton(p, "Ingresar", new Rectangle(257, 383, 185, 39), escucha, false, false);
    }

    //Logica del Login
    public boolean validarUsuario(String rfc, String pass) {
        boolean valid = false;
        try {
            String md5user = Utiles.Encript.md5(pass);
            Datos.usuarios user = new Datos.usuarios(new Datos.Conexion());
            if (user.getPassword(rfc).equals(md5user)) {
                valid = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valid;
    }

    public static void main(String[] args) {
        login l = new login();
    }

    class CustomActionListener implements ActionListener {

        String comando = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            comando = e.getActionCommand();
            switch (comando) {
                case "Ingresar":
                    // usuario root
                    if (txt_rfc.getText().trim().equals("root") && txt_password.getText().trim().equals("root")) {
                        new GUIMenu();
                        x.dispose();
                    }else if (validarUsuario(txt_rfc.getText(), txt_password.getText())) {
                        //Code para mostrar la siguiente ventana de acuerdo al rol
                    } else {
                        //System.err.println("Error de contraseña o de usuario");
                        //En base al requerimiento notificar al usuario de un error de usuario
                        //o de contraseña
                    }
                    break;
            }
        }

    }
}
