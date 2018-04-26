package GUI;

import java.awt.Component;
import javax.swing.*;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.event.KeyListener;
import java.awt.Rectangle;
import java.awt.event.FocusListener;
public class Builder
{
    public static JFrame construirFrame(JFrame frame,String title, int w, int h, int x, int y, boolean undecorated)
    {
        frame.setSize(w,h);
        frame.setResizable(false);
        frame.setLocation(x,y);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setBackground(java.awt.Color.GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }
    public static JFrame crearFrame(String title, int w, int h, int x, int y, boolean undecorated) 
    {
        return construirFrame(new JFrame(), title, w, h, x, y, undecorated);
    }
    public static void agregarLabel(Container context, JLabel lb,Rectangle bounds,int x,int y,int ancho,int altura)
    {
        lb.setBounds(x,y,ancho,altura);
        add(context, lb, bounds);
    }
    public static JLabel crearLabel(Container context, String title,Rectangle bounds,int x,int y,int ancho,int altura) 
    {
        return crearLabel1(context, title, bounds,x,y,ancho,altura);
    }
    public static JLabel crearLabel1(Container context, String title, Rectangle bounds, int x,int y,int ancho,int altura) 
    {
        JLabel lb = new JLabel(title);
        lb.setBounds(x,y,ancho,altura);
        add(context, lb, bounds);
        return lb;
    }
    public static void agregarComboBox(Container context, JComboBox ch,Rectangle bounds, String[] opts, ItemListener escucha) 
    {
        //recorrer arreglo y añadir items
        if(opts != null)
        for (String s : opts) {
            ch.addItem(s);
        }
        //item listener
        ch.addItemListener(escucha);
        add(context, ch, bounds);
    }

    public static JComboBox crearComboBox(Container context, Rectangle bounds, String[] opts, ItemListener escucha) 
    {
        JComboBox ch = new JComboBox();
        agregarComboBox(context, ch, bounds, opts, escucha);
        return ch;
    }
    public static void agregarBoton(Container context, JButton btn, String accessName, Rectangle bounds, ActionListener listener) 
    {
        btn.setActionCommand(accessName);
        btn.addActionListener(listener);
        btn.setBounds(bounds);
        add(context, btn, bounds);
    }

    public static JButton crearBoton(Container context, String accessName, Rectangle bounds, ActionListener listener) 
    {
        JButton btn = new JButton(accessName);
        agregarBoton(context, btn, accessName, bounds, listener);
        return btn;
    }
    public static JButton crearButtonIcon(Container context, String accessName, Rectangle bounds, ActionListener listener, String imagen) 
    {
        ImageIcon icon = new ImageIcon(imagen);
        JButton btn = new JButton(icon);
        agregarBoton(context, btn, accessName, bounds, listener);
        return btn;
    }
    public static void agregarCheckBox(Container context, JCheckBox chbx, Rectangle bounds, ButtonGroup group) 
    {
        add(context, chbx, bounds);
        if (group != null) {
            //chbx.setCheckboxGroup(group);
            group.add(chbx);
        } else {
            //Ops...
        }
    }
    public static JCheckBox crearCheckbox(Container context, String title, Rectangle bounds, ButtonGroup group, boolean state) 
    {
        JCheckBox chbx = new JCheckBox(title);
        agregarCheckBox(context, chbx, bounds, group);
        chbx.setSelected(state);
        return chbx;
    }
    public static JCheckBox crearCheckbox(Container context, String title, Rectangle bounds, Object... configs) 
    {
        JCheckBox rtn = crearCheckbox(context, title, bounds, (ButtonGroup) configs[0], (Boolean) configs[1]);
        rtn.addItemListener((ItemListener) configs[2]);
        
        if (configs.length > 3) {
            rtn.setEnabled((Boolean) configs[3]);
        }
        if (configs.length > 4) {
            rtn.setVisible((Boolean) configs[4]);
        }
        return rtn;
    }
    public static void agregarTextField(Container context, JTextField txt, Rectangle bounds) 
    {
        add(context, txt, bounds);
    }
    public static JTextField crearTextField(Container context, Rectangle bounds, String text, String name, KeyListener list, boolean enable, Object... configs) 
    {
        JTextField txt = new JTextField();
        txt.addKeyListener(list);          
        try{
            txt.addFocusListener((FocusListener) configs[0]);
        }catch(Exception ex){}
        
        txt.setName(name);
        txt.setText(text);
        add(context, txt, bounds);
        txt.setEnabled(enable);
        return txt;
    }
    public static void add(Container context, Component cmp, Rectangle bounds) {
        context.add(cmp);
        if (bounds != null) {
            cmp.setBounds(bounds);
        }
        cmp.setVisible(true);
    }
    public static void setPositions(Container context, Rectangle[] bounds, Component[] cmp) 
    {
        if (context != null & bounds != null & cmp != null) {
            int i = 0;
            for (Component x : cmp) {
                Rectangle bound = bounds[i++];
                add(context, x, bound);
            }
        }
    }
    public static JPanel crearPanel(Container context, Rectangle bounds) 
    {
        JPanel panel = new JPanel();
        add(context, panel, bounds);
        panel.setLayout(null);
        panel.setBounds(bounds);
        panel.setBackground(java.awt.Color.LIGHT_GRAY);
        return panel;
    }
    
    public static JLabel lblImg(Container context, String url, int w, int h, int x, int y){
        Icon icon = new ImageIcon(url);
        JLabel rtn = new JLabel(icon);
        context.add(rtn);
        rtn.setBounds(x, y, w, h);
        return rtn;//tusug logo 116x42
    }
}