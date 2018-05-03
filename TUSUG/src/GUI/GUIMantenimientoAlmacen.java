
package GUI;

import javax.swing.JFrame;
import GUI.Builder;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GUIMantenimientoAlmacen extends JFrame{
    Color gris = new Color(102,102,102);
    Color aguamarina = new Color(7,162,184);
    Color grisAzulado = new Color(91,116,157);
    Color magenta = new Color(62,0,0);
    public GUIMantenimientoAlmacen(){
        Builder.construirFrame(this,"Mantenimiento y Almacen",700,600,300,300,true);
        JLabel t1 = new JLabel("Reportes de mantenimiento y almacen");
        JLabel t2 = new JLabel("Filtrar");
        JLabel t3 = new JLabel("Area:");
        JLabel t4 = new JLabel("Fecha:");
        JLabel t5 = new JLabel("Inicio");
        JLabel t6 = new JLabel("Cerrar Sesion");
        JLabel t7 = new JLabel("Mantenimiento");
        JLabel t8 = new JLabel("Almacen");
        JLabel t9 = new JLabel("Todos");
        JLabel t10 = new JLabel("Todos");
        JLabel t11 = new JLabel("Ultima semana");
        JLabel t12 = new JLabel("Ultimo mes");
        JLabel t13 = new JLabel("Ultimo año");
        JLabel t14 = new JLabel("Inicio");
        JLabel t15 = new JLabel("Cerrar Sesion");
        t1.setForeground(gris);
        t2.setForeground(Color.WHITE);
        t3.setForeground(Color.WHITE);
        t4.setForeground(Color.WHITE);
        t7.setForeground(Color.WHITE);
        t8.setForeground(Color.WHITE);
        t9.setForeground(Color.WHITE);
        t10.setForeground(Color.WHITE);
        t11.setForeground(Color.WHITE);
        t12.setForeground(Color.WHITE);
        t13.setForeground(Color.WHITE);
        t14.setForeground(grisAzulado);
        t15.setForeground(magenta);
        
        
        
        Builder.agregarLabel(this,t1,new Rectangle(309,129,261,21),309,127,261,21);
        Builder.agregarLabel(this,t2,new Rectangle(83,129,37,17),83,127,37,17);
        Builder.agregarLabel(this,t3,new Rectangle(33,185,32,17),33,183,32,17);
        Builder.agregarLabel(this,t4,new Rectangle(33,309,39,17),33,107,39,17);
        Builder.agregarLabel(this,t7,new Rectangle(58,222,95,17),58,216,95,17);
        Builder.agregarLabel(this,t8,new Rectangle(58,248,53,17),58,244,53,17);
        Builder.agregarLabel(this,t9,new Rectangle(58,275,37,17),58,271,37,17);
        Builder.agregarLabel(this,t10,new Rectangle(58,341,37,17),58,337,37,17);
        Builder.agregarLabel(this,t11,new Rectangle(58,371,92,17),58,365,92,17);
        Builder.agregarLabel(this,t12,new Rectangle(58,402,71,17),58,398,71,17);
        Builder.agregarLabel(this,t13,new Rectangle(58,432,69,17),58,428,69,17);
        Builder.agregarLabel(this,t14,new Rectangle(64,75,34,17),64,75,34,17);
        Builder.agregarLabel(this,t15,new Rectangle(568,75,88,17),578,75,88,17);
        Builder.crearCheckbox(this,"",new Rectangle(33,218,20,20),null, true,aguamarina);
        Builder.crearCheckbox(this,"",new Rectangle(33,246,20,20),null, true,aguamarina);
        Builder.crearCheckbox(this,"",new Rectangle(33,273,20,20),null, true,aguamarina);
        Builder.crearCheckbox(this,"",new Rectangle(33,339,20,20),null, true,aguamarina);
        Builder.crearCheckbox(this,"",new Rectangle(33,369,20,20),null, true,aguamarina);
        Builder.crearCheckbox(this,"",new Rectangle(33,400,20,20),null, true,aguamarina);
        Builder.crearCheckbox(this,"",new Rectangle(33,430,20,20),null, true,aguamarina);
        Builder.lblImg(this, "src//Imagenes//fondo ventana con logo.png", 700, 600, 0, 0);
        Builder.crearButtonIcon(this,"",new Rectangle(529,504,136,27),null,"src//Imagenes//abrir en excel.png",Color.WHITE);
        Builder.crearButtonIcon(this,"",new Rectangle(40,487,133,37),null,"src//Imagenes//actualizar lista.png",aguamarina);
        Builder.crearButtonIcon(this,"",new Rectangle(26,69,27,27),null,"src//Imagenes//Home gris azulado (27x27).png",Color.WHITE);
        Builder.crearButtonIcon(this,"",new Rectangle(537,70,23,23),null,"src//Imagenes//cerrar sesion.png",Color.WHITE);
        
        //JTabla t = new JTabla();
        //this.add(t);
        //t.setBounds(222,164,461,364);
        //t.setVisible(true);
        //JButton boton = new JButton("abrir en excel");
        
        
        //ImageIcon icon = new ImageIcon("src//Imagenes//boton aguamarina.png");
       // JButton btn = new JButton(icon);
        //boton.setBackground(aguamarina);
        //boton.setForeground(Color.WHITE);
    }
    
    
    public static void main(String[] args){
        GUIMantenimientoAlmacen vista = new GUIMantenimientoAlmacen();
    }
}
