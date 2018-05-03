package GUI;
import javax.swing.JFrame;

public class GUIAutobuses extends JFrame{
    private static ControladorAutobuses controlador;
    
    public GUIAutobuses(){
        Builder.construirFrame(this, "Modulo Autobuses", 700, 600, 200, 50, false);
        Builder.lblImg(this, "src/Imagenes/logo_tusug.png", 293, 100, 232,99);

        this.setVisible(true);
    }
    
    public static void main(String [] args){
        new GUIAutobuses();
    }
         
}
