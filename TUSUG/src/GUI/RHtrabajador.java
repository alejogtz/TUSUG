package GUI;

import GUI.Builder;
import GUI.PanelImagen;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RHtrabajador  {
    
    public RHtrabajador(){
        JFrame x = Builder.crearFrame("NULL", 700, 600, 100, 50, true);
        PanelImagen p = new PanelImagen("src/Imagenes/fondo ventana con logo.png");
        Builder.add(x, p, new Rectangle(0,0, 700,600));
        p.setOpaque(false);
        
        
        JLabel l1= Builder.crearLabel1(p, "RFC: ", new Rectangle(237,128,80, 17),237,128,80, 17);
        //Builder.agregarLabel(p, l1,new Rectangle(237,128,27, 17),237,128,27, 17);
        
        JLabel l2= Builder.crearLabel1(p, "Apellido Paterno: ", new Rectangle(237,157,150, 17),237,157,150, 17);
        //Builder.agregarLabel(p, l2,new Rectangle(237,157,108, 17),237,157,108, 17);
        
        JLabel l3= Builder.crearLabel1(p, "Apellido Materno: ", new Rectangle(237,185,150, 17),237,185,100, 17);
        //Builder.agregarLabel(p, l3,new Rectangle(237,185,70, 17),237,185,70, 17);
        
        JLabel l4= Builder.crearLabel1(p, "Nombre(s): ", new Rectangle(237,213,100, 17),237,213,100, 17);
        //Builder.agregarLabel(p, l4,new Rectangle(237,213,70, 17),237,213,70, 17);
        
        JLabel l5= Builder.crearLabel1(p, "Genero: ", new Rectangle(237,236,80, 17),237,236,80, 17);
        //Builder.agregarLabel(p, l5,new Rectangle(237,236,48, 17),237,236,48, 17);
        
        
        
        
        
        
        
        
        
    }
    
         public static void main(String[] args) {
         RHtrabajador t= new RHtrabajador();
    }
}
