package GUI;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUIAutobuses extends JFrame{
    private static ControladorAutobuses controlador;
    
    public GUIAutobuses(){

        this.setVisible(true);
    }
    
    public static void main(String [] args){
        new GUIAutobuses();
    }
    
    public void inits(){
        JFrame frame = Builder.construirFrame("Modulo Autobuses", new Rectangle(200, 50, 700, 600), true);
        JLabel lb_title = Builder.crearLabel(this, "Title", new Rectangle(100,200,50,50), null, null);
        
    }
         
}
