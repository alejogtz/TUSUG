import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JPanel;
public class Pagina3 extends JFrame
{
	private JLabel texto1,texto2,texto3; 
	private JScrollPane lista, lista2;
        private JCheckBox ch1, ch2, ch3,ch4,ch5,ch6,ch7,ch8,ch9,ch10;
        private JCheckBox ch11,ch12,ch13,ch14,ch15,ch16,ch17,ch18,ch19,ch20;
	private JButton boton1,boton2,boton3,boton4,boton5,boton6;
	private JMenu menu;
        private JPanel panel;
	public Pagina3()
	{
		super();                                        // usamos el contructor de la clase padre JFrame
        configurarVentana();                                    // configuramos la ventana
        inicializarComponentes();                               // inicializamos los atributos o componentes
	}
	private void configurarVentana() {
        //this.setTitle("");                   			// colocamos titulo a la ventana
        this.setSize(655,491);                                  // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);    				// no usamos ningun layout, solo asi podremos dar posiciones a los componentes                              
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }
    private void inicializarComponentes() {
        // creamos los componentes
        texto1 = new JLabel();
        texto2 = new JLabel();
        texto3 = new JLabel();
        menu = new JMenu("Login   limites de la cuenta   Roles administrativos");
        panel = new JPanel();
        lista = new JScrollPane();
        lista2 = new JScrollPane(); 
        boton1 = new JButton("Eliminar");
        boton2 = new JButton("Refrescar");
        boton3 = new JButton("Nueva cuenta");
        boton4 = new JButton("Resetear");
        boton5 = new JButton("Confirmar");
        boton6 = new JButton("Revocar Todos los Privilegios");
        
        //Primer grupo de checks
        ch1 = new JCheckBox("Administrador del sistema");
        ch2 = new JCheckBox("Controlador de Autobuses");
        ch3 = new JCheckBox("<html>Encargado de Recursos Humanos</html>");
        ch4 = new JCheckBox("Encargado de almacen");
        ch5 = new JCheckBox("Jefe");
        ch6 = new JCheckBox("Secretaria");
        ch7 = new JCheckBox("Administrador de autobuses");
        ch8 = new JCheckBox("Checador");
        ch9 = new JCheckBox("Encargado de Mantenimiento");
        //segundo grupo de checks en panel2
        ch10 = new JCheckBox("Alter");
        ch11 = new JCheckBox("Alter routine");
        ch12 = new JCheckBox("Create");
        ch13 = new JCheckBox("Create routine");
        ch14 = new JCheckBox("Create Tablespace");
        ch15 = new JCheckBox("Create temporary\n tables");
        ch16 = new JCheckBox("Create User");
        ch17 = new JCheckBox("Create view");
        ch18 = new JCheckBox("Delete");
        ch19 = new JCheckBox("Drop");
        ch20 = new JCheckBox("Event");

        // configuramos los componentes
        // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        //CheckBox
        ch1.setBounds(220,125,200,25);
        ch2.setBounds(220,152,200, 25);
        ch3.setBounds(220,179,200,25);
        ch4.setBounds(220,206,200,25);
        ch5.setBounds(220,233,200,25);
        ch6.setBounds(220,260,200,25);
        ch7.setBounds(220,287,200,25);
        ch8.setBounds(220,314,200,25);
        ch9.setBounds(220,341,200,25);
        ch10.setBounds(10,10,200,25);
        ch10.setBounds(10,15,200,25);

        
        //Botones ._.
        lista.setBounds(53,87,158,296);
        lista2.setBounds(455,130,158,296);
        boton1.setBounds(46,393,85,22);
        boton2.setBounds(126,393,90,22);
        boton3.setBounds(76,425,107,22);
        boton4.setBounds(432,432,101,22);
        boton5.setBounds(528,432,106,22);
        boton6.setBounds(220,432,210,22);
        //Etiqueta :v
        texto1.setText("Lista de Usuarios");
        texto1.setBounds(80, 50, 400, 25); 
        texto2.setText("Roles Predefinidos");
        texto2.setBounds(255,100,400,25);
        texto3.setText("Privilegios Globales");
        texto3.setBounds(475,100,400,25);
        menu.setBounds(230,60,400,34);
        //agregar componentes al scrollbar lista2
        lista2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(ch10);
        panel.add(ch11);
        panel.add(ch12);
        panel.add(ch13);
        panel.add(ch14);
        panel.add(ch15);
        panel.add(ch16);
        panel.add(ch17);
        panel.add(ch18);
        panel.add(ch19);
        panel.add(ch20);
        lista2.add(panel);
        lista2.setViewportView(panel);

        //agregar componentes a frame
        this.add(menu);
        this.add(texto1);
        this.add(texto2);
        this.add(texto3);
        this.add(boton1);
        this.add(boton2);
        this.add(boton3);
        this.add(boton4);
        this.add(boton5);
        this.add(boton6);
        this.add(lista);
        this.add(lista2);
        //panel.setLayout(borderLayout1);
        
        this.add(ch1);
        
        this.add(ch2);
        
        this.add(ch3);
        this.add(ch4);
        this.add(ch5);
        this.add(ch6);
        this.add(ch7);
        this.add(ch8);
        this.add(ch9);
    }
    public static void main(String[] args) {
        Pagina3 V = new Pagina3();      // creamos una ventana
        V.setVisible(true);             // hacemos visible la ventana creada
        
    }
}
