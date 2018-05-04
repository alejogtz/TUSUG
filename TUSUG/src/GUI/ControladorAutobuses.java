package GUI;


public class ControladorAutobuses {
    GUIAutobuses interfaz;
    public ControladorAutobuses(GUIAutobuses f){
        interfaz = f;
    }
    public void ingresar(){
        String nombre = interfaz.txtnombre.getText();
        
        Datos.autobus auto = new Datos.autobus();
        auto.insert(0, nombre, 0, nombre);
    }
}

