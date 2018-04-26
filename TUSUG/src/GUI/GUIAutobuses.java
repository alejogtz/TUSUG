package GUI;
import GUI.Builder;
import javax.swing.JFrame;

public class GUIAutobuses extends JFrame{
    //String logo_
    public GUIAutobuses(){
        
        Builder.construirFrame(this, "Modulo Autobuses", 700, 600, 200, 50, false);
        Builder.lblImg(this, "/home/gallardo/SistemaTusug/TUSUG/TUSUG/src/Imagenes/logo_tusug.png", 293, 100, 232,99);
        this.setVisible(true);
    }
    
    public static void main(String [] args){
        new GUIAutobuses();
    }
         
}
