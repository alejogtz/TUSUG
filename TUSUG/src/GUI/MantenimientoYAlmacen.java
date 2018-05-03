package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MantenimientoYAlmacen extends JFrame
{
    public MantenimientoYAlmacen()
    {
        JFrame f = new JFrame();
        Builder.buildFrame(this, "Modulo Autobuses", new Rectangle(200, 50, 700, 600), false);
        iniciarComponentes();
    }
    public void iniciarComponentes()
    {
        //Builder.crearLabelImagen(this, "src/Imagenes/fondo ventana con logo.png", new Rectangle(700,600,0,0));
        JButton home = Builder.crearButtonIcon(this, "Home","src/Imagenes/Home gris azulado (27x27).png",new Rectangle(26,69,30,30),null,true,true);
        JButton exce = Builder.crearButtonIcon(this, "Abrir en excel","src/Imagenes/abrir en excel.png", new Rectangle(539,527,140,30), null, true,true);
        Builder.crearLabel(this, "Reportes de mantenimiento y el almacen", new Rectangle(309,127,300,25),null,null);
        Builder.crearLabel(this, "Inicio", new Rectangle(60,69,45,30),null,new Color(7,162,184));
        Builder.crearLabel(this, "Area", new Rectangle(33,183,45,45),null,Color.WHITE);
        Builder.crearLabel(this, "Filtrar", new Rectangle(83,127,45,45),null,Color.WHITE);
        ButtonGroup group=new ButtonGroup();
        ButtonGroup group1=new ButtonGroup();
        
        Builder.crearCheckBox(this, new Rectangle(33,218,150,17),"Mantenimiento", null,false,new Color(7,162,184),Color.WHITE);
        Builder.crearCheckBox(this, new Rectangle(33,246,100,17),"Almacen", null, false,new Color(7,162,184),Color.WHITE);
        Builder.crearCheckBox(this,new Rectangle(33,273,80,17),"Todos", null, false,new Color(7,162,184),Color.WHITE);
        Builder.crearLabel(this, "Fecha",new Rectangle(33,307,100,17),null, Color.WHITE);
        Builder.crearCheckBox(this,new Rectangle(33,339,80,17),"Todos",null,false,new Color(7,162,184),Color.WHITE);
        Builder.crearCheckBox(this, new Rectangle(33,369,150,17),"Ultima semana", null, false,new Color(7,162,184),Color.WHITE);
        Builder.crearCheckBox(this, new Rectangle(33,400,130,17),"Ultimo mes", null, false,new Color(7,162,184),Color.WHITE);
        Builder.crearCheckBox(this, new Rectangle(33,430,130,17),"Ultimo año", null, false,new Color(7,162,184),Color.WHITE);
        JButton act=Builder.crearButtonIcon(this, "Actualizar lista", "src/Imagenes/actualizar lista.png",new Rectangle(33,520,140,40), null,false,false);
        Builder.crearLabelImagen(this, "src/Imagenes/fondo ventana con logo.png", new Rectangle(0,0,700,600));
        //Builder.crearPanel(this, new Rectangle(700,600,0,0), "src/Imagenes/fondo ventana con logo.png", true);
        
        exce.setBackground(Color.WHITE);
        home.setBackground(Color.WHITE);
        home.setBorder(BorderFactory.createLineBorder(Color.white));
        act.setBorder(BorderFactory.createLineBorder(new Color(7,162,184)));
        act.setBackground(new Color(7,162,184));
        exce.setBorder(BorderFactory.createLineBorder(Color.white));
        ////////////////////Ignorar eso///////////////////
        //Object [][]d={{"Hola","Soy","Un","Pan"},{"Yo","Tambien","xD","Holi"}};
        //String[]cN={"Hola","Soy","Un","Pan"};
        //agregaTabla(d,cN);
    }
    public void agregaTabla(Object [][]d, String[] cN)//Ignorar este método
    {
        DefaultTableModel dtm= new DefaultTableModel(d,cN);
        JTable table = new JTable(dtm)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
    public static void main(String []args)
    {
        //JFrame f = new JFrame();
        //Builder.buildFrame(f, "Modulo Autobuses", new Rectangle(700, 600, 200, 50), false);
        new MantenimientoYAlmacen();
    }
}
