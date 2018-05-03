import GUI.Builder;
import GUI.PanelImagen;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class login {
    
    public login(){  
        JFrame x = Builder.construirFrame("NULL", new Rectangle(0,0, 700,600), true);
        PanelImagen p = new PanelImagen("src/Imagenes/login.png");
        p.setOpaque(false);
        
        
       JTextField jt= Builder.crearTextField(p, new Rectangle(190,231, 293,38),"", null, null, null,true, false , true);
       
       JTextField jt2= Builder.crearTextField(p,new Rectangle(190,231, 293,38), "", null, null, null,true, false, true);
       
       JButton b= Builder.crearBoton(p, "Ingresar", new Rectangle(257,380, 185,39),null, false,false);

    }
    
     public static void main(String[] args) {
         login l= new login();
    }
    
}
