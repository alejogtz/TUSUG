package GUI;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIAutobuses extends JFrame{
    private static ControladorAutobuses controlador;
    public JTextField txtnombre;
    
    public GUIAutobuses(){

        inits();
    }
    
    public static void main(String [] args){
        new GUIAutobuses();
        controlador.ingresar();
    }
    
    public void inits(){
        Builder.buildFrame(this, "Modulo Autobuses", new Rectangle(200, 50, 700, 600), false);
        JLabel lb_title = Builder.crearLabel(this, "Title", new Rectangle(100,200,50,50), null, null);
        
    }
         
}
