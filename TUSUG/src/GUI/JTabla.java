
package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;

public class JTabla extends JTable{
    Object[][] data = {
    {"Dato1","Dato2","Dato3","Dato4"},
    {"Dato5","Dato6","Dato7","Dato8"}
    };
    
    Object[] titulos = {"Fecha","Matricula","Orden de trabajo","Costos"};

    public JTabla(){
        super();
        this.setModel(new DefaultTableModel(data,titulos));
        this.setBackground(Color.RED);


}
}
