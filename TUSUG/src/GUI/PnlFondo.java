package GUI;


import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class PnlFondo extends javax.swing.JPanel {
    private JFrame jFramePadre;
    private JTextField us;
    private JPasswordField ps;
    private JButton aceptar ,cancelar;

    
    public PnlFondo() {
        initComponents();
         this.setLayout(null);    								// no usamos ningun layout, solo asi podremos dar posiciones a los componentes                              

    }
    
    @Override
    public void paintComponent(Graphics g){
        System.out.println("paintComponent");
        Dimension tamanio = getSize();        
        ImageIcon imagenFondo = new ImageIcon(getClass().
                getResource("login.png"));
        g.drawImage(imagenFondo.getImage(), 0, 0, 
                tamanio.width, tamanio.height, null);
        setOpaque(false);
        
        super.paintComponent(g);
    }

    public void initComponents(){
        us   = new JTextField(20);
        ps   = new JPasswordField(20);
        aceptar= new JButton("Ingresar");
         
         aceptar.setContentAreaFilled(false);
        us.setBounds(205,223,293,38);
        ps.setBounds(205,289,293,38);
        aceptar.setBounds(257,368,185,39);


        this.add(us);
        this.add(ps);
        this.add(aceptar);

     }

       public JFrame getjFramePadre() {
        return jFramePadre;
    }
       public void setjFramePadre(JFrame jFramePadre) {
        this.jFramePadre = jFramePadre;
    }


    }

