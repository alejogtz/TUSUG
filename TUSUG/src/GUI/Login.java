package GUI;

import javax.swing.*;



public class Login extends JFrame{
	 
	  public Login() {
        PnlFondo pnlFondo = new PnlFondo();
        pnlFondo.setjFramePadre(this);
        this.add(pnlFondo);     
        this.setLocationRelativeTo(null);                        
        this.setResizable(false); 
        //this.setLayout(null);    								// no usamos ningun layout, solo asi podremos dar posiciones a los componentes                              
        this.pack();
        this.setSize(700,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso

    }

    public static void main(String [] args){
    Login f = new Login();
    f.setVisible(true);
    }

}