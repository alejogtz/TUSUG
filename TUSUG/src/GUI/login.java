import GUI.Builder;
import GUI.PanelImagen;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class login {
    
    public login(){
        JFrame x = Builder.crearFrame("NULL", 700, 600, 100, 50, true);
        PanelImagen p = new PanelImagen("src/Imagenes/login.png");
        p.setOpaque(false);
        Builder.add(x, p, new Rectangle(0,0, 700,600));
        
        
       JTextField jt= Builder.crearJTextField(p,20 ,new Rectangle(190,231, 293,38) );
       Builder.agregarTextField(p, jt, new Rectangle(205,233, 293,38));
       
       JTextField jt2= Builder.crearJTextField(p,20 ,new Rectangle(190,231, 293,38) );
       Builder.agregarTextField(p, jt2, new Rectangle(205,298, 293,38));
       
       JButton b= Builder.crearBoton(p, "Ingresar", new Rectangle(257,380, 185,39), null);
       Builder.agregarBoton(p, b,"Ingresar", new Rectangle(257,383, 185,39), null);

    }
    
     public static void main(String[] args) {
         login l= new login();
    }
    
}
