package GUI;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
//import GUI.Builder;
//import GUI.PanelImagen;
public class autobuses extends JFrame 
{
    private String [] a;
    public autobuses()
    {

        Builder.buildFrame(this,"Autobus", new Rectangle(200,50,700,600),false);
        inicializarcomp();
        a=new String[10];

    }
    
    public void inicializarcomp()
    {
        JLabel l1 = Builder.crearLabel(this, "Codigo Autobus", new Rectangle(55, 112, 213, 41),null,null);
        l1.setForeground(Color.white);
        JLabel l2 = Builder.crearLabel(this, "________________", new Rectangle(43, 125, 213, 41),null,null);
        l2.setForeground(Color.white);
        JList jl = new JList();
        jl.setBounds(43,165,113,320);
        jl.setOpaque(false);
        this.add(jl);
        
        JTextField j1= Builder.crearTextField(this, new Rectangle(381, 178, 274, 19), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        JTextField j2= Builder.crearTextField(this, new Rectangle(305, 200, 351, 19), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        JTextField j3= Builder.crearTextField(this, new Rectangle(401, 222, 255, 19), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        JTextField j4= Builder.crearTextField(this, new Rectangle(374, 284, 161, 19), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        JTextField j5= Builder.crearTextField(this, new Rectangle(365, 252, 292, 19), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        JTextField j6= Builder.crearTextField(this, new Rectangle(388, 360, 270, 19), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        JLabel l3 = Builder.crearLabel(this, "Codigo autobus:",new Rectangle(254, 176, 271, 19),null,null);
        JLabel l4 = Builder.crearLabel(this, "Marca: ", new Rectangle( 254, 198, 55, 17),null,null);
        JLabel l5 = Builder.crearLabel(this, "Numero Economico:", new Rectangle(254, 220, 351, 17),null,null);
        JLabel l6 = Builder.crearLabel(this, "Matricula Autobus", new Rectangle(254, 252, 118, 17),null,null);
        JLabel l7 = Builder.crearLabel(this, "Conductor Asignado", new Rectangle(254, 284, 128, 17),null,null);
        JLabel l8 = Builder.crearLabel(this, "Fecha de activacion del autobus ", new Rectangle(254, 321, 201, 17),null,null);
        JLabel l9 = Builder.crearLabel(this, "Ultimo Mantenimiento", new Rectangle(254, 359, 145, 17),null,null);
        JLabel l10 = Builder.crearLabel(this, "Fecha proxima de ", new Rectangle(319, 392, 150, 35),null,null);
        JLabel l11 = Builder.crearLabel(this, "mantenimiento:", new Rectangle(319, 410, 150, 35),null,null);
        JLabel l12 = Builder.crearLabel(this, "Dia                 Mes                Año", new Rectangle(450, 306, 250, 17),null,null);
        JLabel l13 = Builder.crearLabel(this, "Dia                 Mes                Año", new Rectangle(450, 391, 250, 20),null,null);
        JButton b1 = Builder.crearBoton(this,"Actualizar Lista",new Rectangle(33, 500, 133, 37) , null,true,true);
        Builder.crearComboBox(this, new Rectangle(450, 320, 52, 20) , a, null,null,null);
        Builder.crearComboBox(this, new Rectangle(518, 320, 52, 20), a, null,null,null);
        Builder.crearComboBox(this, new Rectangle(590, 320, 52, 20), a, null,null,null);
        Builder.crearComboBox(this, new Rectangle(450, 407, 52, 20) , a, null,null,null);
        Builder.crearComboBox(this, new Rectangle(518, 407, 52, 20), a, null,null,null);
        Builder.crearComboBox(this, new Rectangle(590, 407, 52, 20), a, null,null,null);
        b1.setBackground(new Color (7,162,184));
        b1.setForeground(Color.white);
        Builder.crearTextField(this, new Rectangle(305, 112, 224, 33), "", null,null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        Builder.crearComboBox(this,new Rectangle(520, 112, 133, 32), a, null,null,null);
        JButton b2 = Builder.crearBoton(this, "Buscar", new Rectangle(222, 112, 84, 32), null,true,false);
        b2.setBackground(new Color (7,162,184));
        b2.setForeground(Color.white);
        JButton b3 = Builder.crearBoton(this, "Nuevo autobus", new Rectangle(266, 490, 121, 27), null,true,false);
        b3.setBackground(new Color (7,162,184));
        b3.setForeground(Color.white);
        JButton b4 = Builder.crearBoton(this, "Modificar",new Rectangle(414, 490, 97, 27), null,true,false);
        b4.setBackground(new Color (102,102,102));
        b4.setForeground(Color.white);
        JButton b5 = Builder.crearBoton(this, "Eliminar",new Rectangle(550, 490, 80, 27), null,true,false);
        b5.setBackground(new Color (152,0,0));
        b5.setForeground(Color.white);
        JButton b6 = Builder.crearBoton(this, "Detalle chofer", new Rectangle(541, 282, 115, 20), null,true,false);
        b6.setBackground(new Color (102,102,102));
        b6.setForeground(Color.white);
        
        Builder.crearLabelImagen(this,"src/Imagenes/fondo ventana con logo.png" ,new Rectangle(0, 0, 700,600));
        
    }
    
    
    
    public static void main(String []args)
    {
        autobuses a= new autobuses();
    }
}
