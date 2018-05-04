/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alekhius
 */
public class GUIMenu {

    // Declaracion de variables
    String RUTA_FONDO = "src/Imagenes/home.png";
    private CustomActionListener escucha;
    JFrame ui;
    JPanel panel;
    JButton btn_trabajador;
    JButton btn_autobus;
    JButton btn_ruta;
    JButton btn_listTrabajadores;
    JButton btn_listAutobuses;
    JButton btn_listActivos;
    JButton btn_listInactivos;
    JButton btn_verRutas;
    JButton btn_verFacturas;
    JButton btn_checarManten;
    JButton btn_addRuta;

    public GUIMenu() {
        escucha = new CustomActionListener();
        initComponentes();
    }

    public void initComponentes() {
        ui = Builder.construirFrame("GUI Menu Principal - Bienvenido", new Rectangle(100, 50, 700, 494), false);
        panel = Builder.crearPanel(ui, new Rectangle(0, 0, ui.getWidth(), ui.getHeight()), RUTA_FONDO, true);
        btn_trabajador = Builder.crearButtonIcon(panel, "Trabajador", "src/Imagenes/boton trabajadores.png", new Rectangle(13, 205, 117, 27), escucha, true, false);
        btn_autobus = Builder.crearButtonIcon(panel, "Autobus", "src/Imagenes/boton autobuses.png", new Rectangle(13, 291, 117, 27), escucha, true, false);
        btn_ruta = Builder.crearButtonIcon(panel, "Ruta", "src/Imagenes/boton rutas.png", new Rectangle(13, 370, 117, 27), escucha, true, false);
        btn_listTrabajadores = Builder.crearButtonIcon(panel, "Listar Trabajadores", "src/Imagenes/boton listar todos.png", new Rectangle(290, 211, 105, 27), escucha, true, false);
        btn_listAutobuses = Builder.crearButtonIcon(panel, "Listar Autobuses", "src/Imagenes/boton autobuses.png", new Rectangle(290, 292, 105, 27), escucha, true, false);
        btn_verRutas = Builder.crearButtonIcon(panel, "Ver Rutas", "src/Imagenes/boton visualizar rutas.png", new Rectangle(290, 371, 105, 27), escucha, true, false);
        btn_listActivos = Builder.crearButtonIcon(panel, "Listar Activos", "src/Imagenes/boton listar activos.png", new Rectangle(416, 211, 125, 27), escucha, true, false);
        btn_checarManten = Builder.crearButtonIcon(panel, "Checar Mantenimiento", "src/Imagenes/boton checar mantenimiento.png", new Rectangle(406, 289, 145, 34), escucha, true, false);
        btn_addRuta = Builder.crearButtonIcon(panel, "Agregar Ruta", "src/Imagenes/boton agregar nueva ruta.png", new Rectangle(416, 371, 125, 27), escucha, true, false);
        btn_listInactivos = Builder.crearButtonIcon(panel, "Listar Inactivos", "src/Imagenes/boton listar inactivos.png", new Rectangle(561, 211, 125, 27), escucha, true, false);
        btn_verFacturas = Builder.crearButtonIcon(panel, "Ver Facturas", "src/Imagenes/boton ver facturas.png", new Rectangle(561, 292, 115, 27), escucha, true, false);
    }

    class CustomActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            switch (comando) {
                case "Trabajador":
                    // Code Here:
                    //System.out.println(comando);
                    break;
                case "Autobus":
                    // Code Here:
                    //System.out.println(comando);
                    break;
                case "Ruta":
                    // Code Here:
                    //System.out.println(comando);
                    break;
                case "Listar Trabajadores":
                    // Code Here:
                    //System.out.println(comando);
                    break;
                case "Listar Autobuses":
                    // Code Here:
                    //System.out.println(comando);
                    break;
                case "Ver Rutas":
                    // Code Here:
                    //System.out.println(comando);
                    break;
                case "Listar Activos":
                    // Code Here:
                    //System.out.println(comando);
                    break;
                case "Checar Mantenimiento":
                    // Code Here:
                    //System.out.println(comando);
                    break;
                case "Agregar Ruta":
                    // Code Here:
                    //System.out.println(comando);
                    break;
                case "Listar Inactivos":
                    // Code Here:
                    //System.out.println(comando);
                    break;
                case "Ver Facturas":
                    // Code Here:
                    //System.out.println(comando);
                    break;
            }
        }

    }
}
