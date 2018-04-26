package GUI;
import GUI.Builder;
import javax.swing.JFrame;

public class GUIAutobuses extends JFrame{
    //String logo_
    public GUIAutobuses(){
        
        Builder.construirFrame(this, "Modulo Autobuses", 700, 600, 200, 50, false);
        Builder.lblImg(this, "C:\\Lab\\Git\\TUSUG\\Recursos\\Ventanas mejoradas\\Imagen de iconos\\tusug logo 116x42.png", 293, 100, 232,99);
        this.setVisible(true);
    }
    
    public static void main(String [] args){
        new GUIAutobuses();
    }
         
}
