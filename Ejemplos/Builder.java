 

//import Impresora.Utils.ButtonIcon;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class Builder {

    public static Frame buildFrame(Frame _new, String title, int w, int h, int x, int y, boolean undecorated) {
        /**
         * Frame sin layout
         */
        Dimension dim = new Dimension(w, h);
        /**
         * Tamanio que no puede cambiar y Layout null
         */
        _new.setMinimumSize(dim);
        //_new.setMaximumSize(dim);
        //_new.setPreferredSize(dim);
        _new.setResizable(false);
        _new.setLocation(x, y);
        _new.setSize(dim);
        _new.setLayout(null);
        /**
         * Terminar programa al cerrar
         */
        //_new.setUndecorated(undecorated);
        _new.setBackground(Color.LIGHT_GRAY);           //cambiar color a conveniencia
        _new.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        return _new;
    }

    public static Frame createFrame(String title, int w, int h, int x, int y, boolean undecorated) {
        return buildFrame(new Frame(), title, w, h, x, y, undecorated);
    }

    /**
     * Metodos para agregar componentes al Frame
     *
     * @param context
     * @param lb
     * @param bounds
     */
    public static void addLabel(Container context, Label lb, Rectangle bounds) {
        lb.setAlignment(Label.RIGHT);
        add(context, lb, bounds);
    }

    public static Label createLabel(Container context, String title, Rectangle bounds) {
        return createLabel(context, title, bounds, Label.RIGHT);
    }

    public static Label createLabel(Container context, String title, Rectangle bounds, int alig) {
        Label lb = new Label(title);
        lb.setAlignment(alig);
        add(context, lb, bounds);
        return lb;
    }
    
    public static Label createLabelL(Container context, String title, Rectangle bounds) {
        return createLabelL(context, title, bounds, Label.LEFT);
    }

    public static Label createLabelL(Container context, String title, Rectangle bounds, int alig) {
        Label lb = new Label(title);
        lb.setAlignment(alig);
        add(context, lb, bounds);
        return lb;
    }

    public static void addChoice(Container context, Choice ch, Rectangle bounds, String[] opts, ItemListener escucha) {
        //recorrer arreglo y añadir items
        for (String s : opts) {
            ch.add(s);
        }
        //item listener
        ch.addItemListener(escucha);
        add(context, ch, bounds);
    }

    public static Choice createChoice(Container context, Rectangle bounds, String[] opts, ItemListener escucha) {
        Choice ch = new Choice();
        addChoice(context, ch, bounds, opts, escucha);
        return ch;
    }

    public static void addButton(Container context, Button btn, String accessName, Rectangle bounds, ActionListener listener) {
        btn.setActionCommand(accessName);
        btn.addActionListener(listener);
        btn.setBounds(bounds);

        add(context, btn, bounds);
    }

    public static Button createButton(Container context, String accessName, Rectangle bounds, ActionListener listener) {
        Button btn = new Button(accessName);
        addButton(context, btn, accessName, bounds, listener);
        return btn;
    }

    public static ButtonIcon createButtonIcon(Container context, String accessName, Rectangle bounds, ActionListener listener, String imagen) {
        ButtonIcon btn = new ButtonIcon(imagen);
        addButton(context, btn, accessName, bounds, listener);
        return btn;
    }

    public static void addCheckBox(Container context, Checkbox chbx, Rectangle bounds, CheckboxGroup group) {
        add(context, chbx, bounds);
        if (group != null) {
            chbx.setCheckboxGroup(group);
        } else {
            //Ops...
        }
    }

    public static Checkbox createCheckbox(Container context, String title, Rectangle bounds, CheckboxGroup group, boolean state) {
        Checkbox chbx = new Checkbox(title);
        addCheckBox(context, chbx, bounds, group);
        chbx.setState(state);
        return chbx;
    }

    /**
     *
     * @param context
     * @param title
     * @param bounds
     * @param group configs[0]
     * @param state configs[1]
     * @param escucha configs[2]
     * @param enabled configs[3]
     * @param visible configs[4]
     * @return
     */
    public static Checkbox createCheckbox(Container context, String title, Rectangle bounds, Object... configs) {
        Checkbox rtn = createCheckbox(context, title, bounds, (CheckboxGroup) configs[0], (Boolean) configs[1]);
        rtn.addItemListener((ItemListener) configs[2]);
        /**
         * Configsextra
         */
        if (configs.length > 3) {
            rtn.setEnabled((Boolean) configs[3]);
        }
        if (configs.length > 4) {
            rtn.setVisible((Boolean) configs[4]);
        }

        return rtn;
    }

    public static void addTextField(Container context, TextField txt, Rectangle bounds) {
        add(context, txt, bounds);

    }

    /**
     *
     * @param context
     * @param bounds
     * @return
     */
    public static TextField createTextField(Container context, Rectangle bounds, String text, String name, KeyListener list, boolean enable, Object... configs) {
        TextField txt = new TextField();
        txt.addKeyListener(list);          
        try{
            txt.addFocusListener((CustomFocusListener) configs[0]);
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

    public static void setPositions(Container context, Rectangle[] bounds, Component[] cmp) {
        if (context != null & bounds != null & cmp != null) {
            int i = 0;
            for (Component x : cmp) {
                Rectangle bound = bounds[i++];
                add(context, x, bound);
            }
        }
    }

    public static Panel createPanel(Container context, Rectangle bounds) {
        Panel panel = new Panel();
        add(context, panel, bounds);
        panel.setLayout(null);
        panel.setBounds(bounds);
        panel.setBackground(Color.LIGHT_GRAY);

        return panel;
    }

}
