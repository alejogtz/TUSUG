package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Builder {

    public static JFrame construirFrame(String title, Rectangle bounds, boolean undecorated) {
        JFrame r = new JFrame(title);
        r.setBounds(bounds);
        r.setResizable(false);
        r.setLayout(null);
        r.setLocationRelativeTo(null);
        r.setBackground(java.awt.Color.GRAY);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setUndecorated(undecorated);
        r.setVisible(true);
        return r;
    }

    public static JLabel crearLabel(Container ui, String text, Rectangle bounds, Color background, Color foreground) {
        JLabel lb = new JLabel(text);
        ui.add(lb);
        lb.setBounds(bounds);
        if (background != null) {
            lb.setBackground(background);
        }
        if (foreground != null) {
            lb.setForeground(foreground);
        }
        return lb;
    }

    public static JLabel crearLabelImagen(Container context, String url, int w, int h, int x, int y) {
        Icon icon = new ImageIcon(url);
        JLabel rtn = new JLabel(icon);
        context.add(rtn);
        rtn.setBounds(x, y, w, h);
        return rtn;
    }

    public static JButton crearBoton(Container context, String accessName, Rectangle bounds, 
            ActionListener listener, boolean enabled) {
        JButton btn = new JButton(accessName);
        btn.setActionCommand(accessName);
        btn.addActionListener(listener);
        context.add(btn);
        btn.setBounds(bounds);
        return btn;
    }

    public static JCheckBox crearCheckBox(Container ui, Rectangle bounds, String text,
            ItemListener listener,boolean enabled, Color cfondo, Color ctexto) {
        JCheckBox cbox = new JCheckBox(text, enabled);
        ui.add(cbox);
        cbox.setBounds(bounds);
        cbox.setForeground(ctexto);
        cbox.setBackground(cfondo);
        return cbox;
    }

    public static JComboBox<String> crearComboBox(Container ui, Rectangle bounds, String[] options,
            ItemListener listener, Color cfondo, Color ctexto) {
        JComboBox cbox = new JComboBox(options);
        ui.add(cbox);
        cbox.setBounds(bounds);
        cbox.setForeground(ctexto);
        cbox.setBackground(cfondo);
        return cbox;
    }
    public static void main(String[] args) {
    }

}
