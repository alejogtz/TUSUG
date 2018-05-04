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
    String Cargo[]={"secretaria", "chofer", "mantenimiento", "recursos humanos"};
    String Categoria[]= {"1","2","3","4","5"};
    String st[]={"activo", "inactivo"};
    String turn[]={"matutino", "vespertino"};
    
    public RHtrabajador(){
        JFrame x = Builder.construirFrame("NULL", new Rectangle(0,0, 700, 600), false);
        JPanel p = Builder.crearPanel(x, new Rectangle(0, 0, 700, 600),"src/Imagenes/fondo ventana con logo.png", true);
        JLabel jlrfc= Builder.crearLabel(p, "RFC: ", new Rectangle(237,128,80, 17),null,null);
        JLabel jlapp= Builder.crearLabel(p, "Apellido Paterno: ", new Rectangle(237,157,150, 17),null, null);
        JLabel jlapm= Builder.crearLabel(p, "Apellido Materno: ", new Rectangle(237,173,150, 17),null, null);
        JLabel jlnom= Builder.crearLabel(p, "Nombre(s): ", new Rectangle(237,213,100, 17),null, null);
        JLabel jlgen= Builder.crearLabel(p, "Genero: ", new Rectangle(237,236,80, 17),null, null);
        JLabel jleda= Builder.crearLabel(p, "Edad: ", new Rectangle(409, 236,50, 17), null,null);
        JLabel jlfna= Builder.crearLabel(p, "Fecha nac. :", new Rectangle(237, 268,131, 17), null,null);
        JLabel jlfin= Builder.crearLabel(p, "Fecha-ingreso :", new Rectangle(237, 290,131, 17), null,null);
        JLabel jldia= Builder.crearLabel(p, "Dia :", new Rectangle(349, 311,100, 17), null,null);
        JLabel jlmes= Builder.crearLabel(p, "Mes :", new Rectangle(406, 311,100, 17), null,null);
        JLabel jlanio= Builder.crearLabel(p, "Año :", new Rectangle(468, 311,100, 17),null,null);
        JLabel jlcon= Builder.crearLabel(p, "Contacto", new Rectangle(330, 349,140, 21), null,null);
        JLabel jlemp= Builder.crearLabel(p, "Empleo ", new Rectangle(550, 349,140, 21), null,null);
        JLabel jltca= Builder.crearLabel(p, "Tel. Casa :", new Rectangle(237, 369,140, 17), null,null);
        JLabel jltce= Builder.crearLabel(p, "Tel. Celular :", new Rectangle(239, 397,104, 17), null,null);
        JLabel jlema= Builder.crearLabel(p, "Email :", new Rectangle(237, 423,90, 17),null,null);
        JLabel jldir= Builder.crearLabel(p, "Direccion :", new Rectangle(237, 466,100, 17),null,null);
        JLabel jlcar= Builder.crearLabel(p, "Cargo :", new Rectangle(495, 380,60, 17), null,null);
        JLabel jlcat= Builder.crearLabel(p, "Categoria :", new Rectangle(495, 408,80, 17),null,null);
        JLabel jlsta= Builder.crearLabel(p, "Status :", new Rectangle(494, 443,50, 17), null,null);
        JLabel jltur= Builder.crearLabel(p, "Turno :", new Rectangle(495,478,50, 17), null,null);
        
        JButton btn1= Builder.crearBoton(p, "Incorporar Empleado", new Rectangle(249, 547, 161, 27), null, true, true);
        JButton btn2= Builder.crearBoton(p, "Modificar", new Rectangle(484, 547, 100, 27), null, true, true);
        JButton btn3= Builder.crearBoton(p, "Eliminar", new Rectangle(584, 547, 100, 27), null, true, true);
        JButton btn4= Builder.crearBoton(p, "Cambiar Foto", new Rectangle(556, 133, 100, 100), null, true, true);
        
        JTextField tfrfc= Builder.crearTextField(p, new Rectangle(277, 128, 265, 17), null, null,null, null, true, true, true);
        JTextField tfapp= Builder.crearTextField(p, new Rectangle(357, 157, 185, 17), null,null,null, null, true, true, true);
        JTextField tfapm= Builder.crearTextField(p, new Rectangle(357, 173, 185, 17), null, null,null, null, true, true, true);
        JTextField tfnom= Builder.crearTextField(p, new Rectangle(323, 213, 219, 17), null, null,null, null, true, true, true);
        JTextField tfgen= Builder.crearTextField(p, new Rectangle(300, 236, 98, 17), null, null,null, null, true, true, true);
        JTextField tfeda= Builder.crearTextField(p, new Rectangle(449, 236, 100, 17), null, null,null, null, true, true, true);
        JTextField tffna= Builder.crearTextField(p, new Rectangle(323, 268, 265, 17), null, null,null, null, true, true, true);
        JTextField tftca= Builder.crearTextField(p, new Rectangle(330, 369, 110, 17), null, null,null, null, true, true, true);
        JTextField tfdir= Builder.crearTextField(p, new Rectangle(330, 466, 110, 17), null, null,null, null, true, true, true);
        JTextField tffin= Builder.crearTextField(p, new Rectangle(335, 290, 110, 17), null, null,null, null, true, true, true);
        JTextField tftce= Builder.crearTextField(p, new Rectangle(330, 397, 110, 17), null, null,null, null, true, true, true);
        JTextField tfema= Builder.crearTextField(p, new Rectangle(330, 423,110, 17), null, null,null, null, true, true, true);
       
        JComboBox cb1= Builder.crearComboBox(p, new Rectangle(349,311,52,17),dia , null, null,null);
        JComboBox cb2= Builder.crearComboBox(p, new Rectangle(406,311,56,17),mes , null, null,null);
        JComboBox cb3= Builder.crearComboBox(p, new Rectangle(468,311,72,17),anio , null, null,null);

        JComboBox cb4= Builder.crearComboBox(p, new Rectangle(543,380,125,17),Cargo, null, null,null);
        JComboBox cb5= Builder.crearComboBox(p, new Rectangle(543,408,125,17),Categoria, null, null,null);
        JComboBox cb6= Builder.crearComboBox(p, new Rectangle(543,443,125,17),st , null, null,null);
        JComboBox cb7= Builder.crearComboBox(p, new Rectangle(543,478,40,17),turn , null, null,null);
    }
    
         public static void main(String[] args) {
         RHtrabajador t= new RHtrabajador();
    }
}
