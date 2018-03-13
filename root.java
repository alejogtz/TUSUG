package PROYECTOINTEGRADOR;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class root extends JFrame{
    private JLabel etiqueta1, etiqueta2,etiqueta3,etiqueta4,etiqueta5,etiqueta6,etiqueta7;
    private JTextField text1, text2;
    private JButton boton;
    private JPanel panel1,panel2;
    public root(){
        super();  
        this.setLayout(new GridLayout(1,2));// usamos el contructor de la clase padre JFrame
        configurarVentana();                                    // configuramos la ventana
        inicializarComponentes();                               // inicializamos los atributos o componentes
        
    }
    	private void configurarVentana() {

        this.setSize( 662 , 230);                                  // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla    				// no usamos ningun layout, solo asi podremos dar posiciones a los componentes                              
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        private void inicializarComponentes(){
            etiqueta1 = new JLabel("Nombre de usuario o correo electronico:");
            etiqueta2 = new JLabel("Contraseña(minimo x caracteres):           ");
            etiqueta3 = new JLabel("¿Primera vez en el sistema?");
            etiqueta4 = new JLabel("¿Olvido su contraseña?                              ");
            etiqueta5 = new JLabel("                                                                                    ");
            etiqueta6 = new JLabel("Registrate.");
            text1 = new JTextField(20);
            text2 = new JTextField(20);
            boton = new JButton("Ingresar");
            boton.setForeground(Color.white);
            boton.setBackground(new Color (60,169,113));
            etiqueta4.setForeground(Color.blue);
            etiqueta6.setForeground(Color.blue);
            panel1 = new JPanel();
            panel2 = new JPanel();
            panel1.setLayout(new FlowLayout());
            panel2.setLayout(new FlowLayout());
            Icon CORAGE = new ImageIcon(getClass().getResource("CORAGE.jpg"));//COLOCAR LA IMAGEN DEL TRABAJADOR
            etiqueta7 = new JLabel("", CORAGE, SwingConstants.RIGHT);
            etiqueta7.setToolTipText("CORAGE");
            panel1.add(etiqueta1);
            panel1.add(text1);
            panel1.add(etiqueta2);
            panel1.add(text2);
            panel1.add(etiqueta5);
            panel1.add(boton);
            panel2.add(etiqueta3);
            panel2.add(etiqueta6);
            panel2.add(etiqueta4);
            panel2.add(etiqueta7);
            add(panel1);
            add(panel2);
        } 

    /**
     *
     * @param g
     */
    @Override
        public void paint( Graphics g )
            {
                super.paint( g );  // llamar al método paint de la superclase
 
                g.setColor( Color.black );
                g.drawLine( 320, 0, 320, 230 );
            }
            public static void main(String[] args) {
        root r = new root();      // creamos una ventana
        r.setVisible(true);             // hacemos visible la ventana creada
        
    }
}
