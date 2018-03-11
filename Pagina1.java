import javax.swing.*;
public class Pagina1 extends JFrame
{
	private JLabel texto1,texto2, texto3, texto4, texto5, texto6; 
	private JScrollPane lista;
	private JButton boton1,boton2,boton3,boton4,boton5;
	private JTextField area1,area2,area3,area4, area5;
	private JMenu menu;
	private JPanel paneles;//___________________________
	public Pagina1()
	{
		super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
	}
	private void configurarVentana() {

        //this.setTitle("");                   					// colocamos titulo a la ventana
        this.setSize(655,491);                                  // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);    								// no usamos ningun layout, solo asi podremos dar posiciones a los componentes                              
        this.setResizable(false);                               //
        //paneles.setBackground(Color.white);     // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
        
    }
    private void inicializarComponentes() {
        // creamos los componentes
        texto1 = new JLabel();
        texto2 = new JLabel();
        texto3 = new JLabel();
        texto4 = new JLabel();
        texto5 = new JLabel();
        texto6 = new JLabel();
        area1=new JTextField(20);
        area2=new JTextField(20);
        area3=new JTextField(20);
        area4=new JPasswordField(20);
        area5=new JPasswordField(20);
        menu= new JMenu("Login   limites de la cuenta   Roles administrativos");

        lista = new JScrollPane();
        boton1 = new JButton("Eliminar");
        boton2 = new JButton("Refrescar");
        boton3 = new JButton("Nueva cuenta");
        boton4 = new JButton("Resetear");
        boton5 = new JButton("Confirmar");

        // configuramos los componentes
        //Botones ._.
        lista.setBounds(53,87,158,296);
        boton1.setBounds(46,393,85,22);
        boton2.setBounds(126,393,90,22);
        boton3.setBounds(76,425,107,22);
        boton4.setBounds(432,432,101,22);
        boton5.setBounds(528,432,106,22);
        //Etiqueta :v
        texto1.setText("Lista de Usuarios");
        texto2.setText("Nombre de Usuarios");
        texto3.setText("Tipo de autenticacion");
        texto4.setText("<html>Limite para la coinciencia del host</html>");
        texto5.setText("Contraseña");
        texto6.setText("Confirmar contraseña");
        texto1.setBounds(60, 50, 400, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        texto2.setBounds(230, 150, 200, 25); 
        texto3.setBounds(230, 200, 200, 25); 
        texto4.setBounds(230, 250, 200, 25); 
        texto5.setBounds(230, 300, 200, 25); 
        texto6.setBounds(230, 350, 200, 25);
        //menu xD
        menu.setBounds(230,60,400,34);
        //Areas de texto
        area1.setBounds(440,150,200,25);
        area2.setBounds(440,200,200,25);
        area3.setBounds(440,250,200,25);
        area4.setBounds(440,300,200,25);
        area5.setBounds(440,350,200,25);


        this.add(menu);
        this.add(texto1);
        this.add(texto2);
        this.add(texto3);
        this.add(texto4);
        this.add(texto5);
        this.add(texto6);
        this.add(boton1);
        this.add(boton2);
        this.add(boton3);
        this.add(boton4);
        this.add(boton5);
        this.add(area1);
        this.add(area2);
        this.add(area3);
        this.add(area4);
        this.add(area5);
        this.add(lista);
    }
    public static void main(String[] args) {
        Pagina1 V = new Pagina1();      // creamos una ventana
        V.setVisible(true);             // hacemos visible la ventana creada
    }
}