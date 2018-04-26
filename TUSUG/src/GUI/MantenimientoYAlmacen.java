package GUI;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MantenimientoYAlmacen extends JFrame
{
    public MantenimientoYAlmacen()
    {
        Builder.construirFrame(this, "Modulo Autobuses", 700, 600, 200, 50, false);
        iniciarComponentes();
    }
    public void iniciarComponentes()
    {
        JButton home = Builder.crearButtonIcon(this, null, new Rectangle(26,69,30,30), null, "src/Imagenes/Home gris azulado (27x27).png");
        Builder.crearLabel(this, "Reportes de mantenimiento y el almacen", null, 309,127,300,25);
        JLabel inicio = Builder.crearLabel(this, "Inicio", null, 60,69,45,30);
        JLabel area = Builder.crearLabel(this, "Area", null, 33,183,45,45);
        JLabel filtrar = Builder.crearLabel(this, "Filtrar", null, 83,127,45,45);
        ButtonGroup group=new ButtonGroup();
        ButtonGroup group1=new ButtonGroup();
        
        JCheckBox mant = Builder.crearCheckbox(this, "Mantenimiento", new Rectangle(33,218,150,17), group, false);
        JCheckBox alma = Builder.crearCheckbox(this, "Almacen", new Rectangle(33,246,100,17), group, false);
        JCheckBox todos = Builder.crearCheckbox(this, "Todos", new Rectangle(33,273,80,17), group, false);
        JLabel fecha = Builder.crearLabel(this, "Fecha", null, 33,307,100,17);
        JCheckBox todo = Builder.crearCheckbox(this, "Todos", new Rectangle(33,339,80,17), group1, false);
        JCheckBox semana = Builder.crearCheckbox(this, "Ultima semana", new Rectangle(33,369,150,17), group1, false);
        JCheckBox mes = Builder.crearCheckbox(this, "Ultimo mes", new Rectangle(33,400,130,17), group1, false);
        JCheckBox año = Builder.crearCheckbox(this, "Ultimo año", new Rectangle(33,430,130,17), group1, false);
        JButton act = Builder.crearBoton(this, "Actualizar lista", new Rectangle(33, 527,140,35), null);
        Builder.lblImg(this, "src/Imagenes/fondo ventana con logo.png", 700, 600, 0, 0);
        
        area.setForeground(Color.WHITE);
        filtrar.setForeground(Color.WHITE);
        fecha.setForeground(Color.WHITE);
        mant.setForeground(Color.WHITE);
        alma.setForeground(Color.WHITE);
        todos.setForeground(Color.WHITE);
        todo.setForeground(Color.WHITE);
        semana.setForeground(Color.WHITE);
        mes.setForeground(Color.WHITE);
        año.setForeground(Color.WHITE);
        act.setForeground(Color.WHITE);
        inicio.setForeground(new Color(7,162,184));
        
        mant.setBackground(new Color(7,162,184));
        alma.setBackground(new Color(7,162,184));
        todos.setBackground(new Color(7,162,184));
        todo.setBackground(new Color(7,162,184));
        semana.setBackground(new Color(7,162,184));
        mes.setBackground(new Color(7,162,184));
        año.setBackground(new Color(7,162,184));
        act.setBackground(new Color(7,162,184));
        home.setBackground(Color.WHITE);
        home.setBorder(BorderFactory.createLineBorder(Color.white));
        act.setBorder(BorderFactory.createLineBorder(Color.white));
        
        
        
    }
    public static void main(String []args)
    {
        new MantenimientoYAlmacen();
    }
}
