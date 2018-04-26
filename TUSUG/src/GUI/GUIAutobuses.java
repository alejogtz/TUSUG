package GUI;
import javax.swing.JFrame;

public class GUIAutobuses extends JFrame{
    private static ControladorAutobuses controlador;
    
    public GUIAutobuses(){
        
//<<<<<<< HEAD
        Builder.construirFrame(this, "Modulo Autobuses", 700, 600, 200, 50, false);
        Builder.lblImg(this, "src/Imagenes/logo_tusug.png", 293, 100, 232,99);
//=======
        Builder.construirFrame(this, "Modulo Autobuses", 700, 600, 200, 50, true);
        Builder.lblImg(this, "src/Imagenes/logo_tusug.png", 293, 100, 232,99);
//>>>>>>> 4eec161c049d33fb96abad2270e2b47f105626d9
        this.setVisible(true);
    }
    
    public static void main(String [] args){
        new GUIAutobuses();
    }
         
}
