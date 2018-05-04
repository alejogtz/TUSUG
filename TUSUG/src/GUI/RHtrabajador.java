package GUI;

import GUI.Builder;
import GUI.PanelImagen;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class RHtrabajador  {
    String dia[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String mes[]={"1","2","3","4","5","6","7", "8","9", "10", "11", "12"};
    String anio[]={"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"};
    String Categoria[]= {"1","2","3","4","5"};
    String st[]={"activo", "inactivo"};
    String turn[]={"matutino", "vespertino"};
    
    public RHtrabajador(){
        JFrame x = Builder.construirFrame("NULL", new Rectangle(0,0, 700, 600), false);
        JPanel p = Builder.crearPanel(x, new Rectangle(0, 0, 700, 600),"src/Imagenes/fondo ventana con logo.png", true);
     
        JLabel l1= Builder.crearLabel(p, "RFC: ", new Rectangle(237,128,80, 17),null,null);
        JLabel l2= Builder.crearLabel(p, "Apellido Paterno: ", new Rectangle(237,157,150, 17),null, null);
        JLabel l3= Builder.crearLabel(p, "Apellido Materno: ", new Rectangle(237,173,150, 17),null, null);
        JLabel l4= Builder.crearLabel(p, "Nombre(s): ", new Rectangle(237,213,100, 17),null, null);
        JLabel l5= Builder.crearLabel(p, "Genero: ", new Rectangle(237,236,80, 17),null, null);
        JLabel l6= Builder.crearLabel(p, "Edad: ", new Rectangle(409, 236,50, 17), null,null);
        JLabel l7= Builder.crearLabel(p, "Fecha nac. :", new Rectangle(237, 268,131, 17), null,null);
        JLabel l8= Builder.crearLabel(p, "Fecha-ingreso :", new Rectangle(240, 305,131, 17), null,null);
        JLabel l9= Builder.crearLabel(p, "Dia :", new Rectangle(349, 311,100, 17), null,null);
        JLabel l10= Builder.crearLabel(p, "Mes :", new Rectangle(406, 311,100, 17), null,null);
        JLabel l11= Builder.crearLabel(p, "Año :", new Rectangle(468, 311,100, 17),null,null);
        JLabel l12= Builder.crearLabel(p, "Contacto :", new Rectangle(279, 349,140, 21), null,null);
        JLabel l13= Builder.crearLabel(p, "Empleo :", new Rectangle(510, 349,140, 21), null,null);
        JLabel l14= Builder.crearLabel(p, "Tel. Casa :", new Rectangle(237, 369,140, 17), null,null);
        JLabel l15= Builder.crearLabel(p, "Tel. Celular :", new Rectangle(239, 397,104, 17), null,null);
        JLabel l16= Builder.crearLabel(p, "Email :", new Rectangle(237, 423,90, 17),null,null);
        JLabel l17= Builder.crearLabel(p, "Direccion :", new Rectangle(237, 466,62, 17),null,null);
        JLabel l18= Builder.crearLabel(p, "Cargo :", new Rectangle(495, 380,40, 17), null,null);
        JLabel l19= Builder.crearLabel(p, "Categoria :", new Rectangle(495, 408,80, 17),null,null);
        JLabel l20= Builder.crearLabel(p, "Status :", new Rectangle(494, 443,50, 17), null,null);
        JLabel l21= Builder.crearLabel(p, "Turno :", new Rectangle(495,478,50, 17), null,null);
        
        JButton btn1= Builder.crearBoton(p, "Incorporar Empleado", new Rectangle(249, 547, 161, 27), null, true, false);
        JButton btn2= Builder.crearBoton(p, "Modificar", new Rectangle(484, 547, 100, 27), null, true, false);
        JButton btn3= Builder.crearBoton(p, "Eliminar", new Rectangle(584, 547, 100, 27), null, true, false);
        JButton btn4= Builder.crearBoton(p, "Cambiar Foto", new Rectangle(556, 133, 100, 100), null, true, false);
        
        JTextField tf1= Builder.crearTextField(p, new Rectangle(277, 146, 265, 17), null, null,null, null, true, true, true);
        JTextField tf2= Builder.crearTextField(p, new Rectangle(357, 157, 185, 17), null,null,null, null, true, true, true);
        JTextField tf3= Builder.crearTextField(p, new Rectangle(357, 173, 265, 17), null, null,null, null, true, true, true);
        JTextField tf4= Builder.crearTextField(p, new Rectangle(323, 226, 219, 17), null, null,null, null, true, true, true);
        JTextField tf5= Builder.crearTextField(p, new Rectangle(300, 252, 98, 17), null, null,null, null, true, true, true);
        JTextField tf6= Builder.crearTextField(p, new Rectangle(409, 236, 100, 17), null, null,null, null, true, true, true);
        JTextField tf7= Builder.crearTextField(p, new Rectangle(377, 165, 265, 17), null, null,null, null, true, true, true);
        JTextField tf8= Builder.crearTextField(p, new Rectangle(357, 387, 110, 17), null, null,null, null, true, true, true);
        JTextField tf9= Builder.crearTextField(p, new Rectangle(355, 413, 112, 17), null, null,null, null, true, true, true);
        JTextField tf10= Builder.crearTextField(p, new Rectangle(240, 457, 226, 17), null, null,null, null, true, true, true);
        JTextField tf11= Builder.crearTextField(p, new Rectangle(237, 482, 233, 56), null, null,null, null, true, true, true);
        JTextField tf12= Builder.crearTextField(p, new Rectangle(563, 424, 105, 17), null, null,null, null, true, true, true);

        
        JComboBox cb1= Builder.crearComboBox(p, new Rectangle(349,311,52,17),dia , null, null,null);
        JComboBox cb2= Builder.crearComboBox(p, new Rectangle(406,311,56,17),mes , null, null,null);
        JComboBox cb3= Builder.crearComboBox(p, new Rectangle(468,311,72,17),anio , null, null,null);
        JComboBox cb4= Builder.crearComboBox(p, new Rectangle(349,311,52,17),dia , null, null,null);
        JComboBox cb5= Builder.crearComboBox(p, new Rectangle(543,379,125,17),Categoria, null, null,null);
        JComboBox cb6= Builder.crearComboBox(p, new Rectangle(543,442,125,17),st , null, null,null);
        JComboBox cb7= Builder.crearComboBox(p, new Rectangle(496,478,40,17),turn , null, null,null);
    
    }
    
         public static void main(String[] args) {
         RHtrabajador t= new RHtrabajador();
    }
}
