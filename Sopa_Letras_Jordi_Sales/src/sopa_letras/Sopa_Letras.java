package sopa_letras;

/**
 *
 * @Monyert
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Sopa_Letras extends JFrame {

    SopaBLL datos = new SopaBLL();

    JPanel panelSopa;//Panel de la Sopa (Amarilla)
    char[][] VectorSopaDeLetras = new char[6][6];
    String sopaLetras = "";

    String sopaLetras_Ventana1 = "";
    String sopaLetras_Ventana2 = "";

    JPanel panel_boton_sopa;
    JPanel panel_boton_resolver;
    JButton botonResolver;

    JPanel panel_Ventana1;
    JTextArea Diccionario;

    JPanel panel_Ventana2;
    JTextArea Ventana2_solucion;

    public Sopa_Letras() {
        super("Sopa de Letras ");
        setLayout(new BorderLayout());
        
        VectorSopaDeLetras = datos.getDAO().getSopa();
        sopaLetras = datos.getDAO().getLetras();
        sopaLetras_Ventana1 = datos.getDAO().getVentana1();
        
        sopa();
        setVisible(true);
        setSize(700, 300);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    public void sopa() {
        //Layout de la sopa
        setLayout(new FlowLayout());
        JTextArea sopa = new JTextArea(10, 15);
        sopa.setBackground(Color.yellow);
        panel_boton_sopa = new JPanel();
        panel_boton_sopa.setBackground(Color.yellow);
        panel_boton_sopa.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        
        sopa.setText(sopaLetras);
        sopa.setEditable(false);
        
        panel_boton_sopa.setLayout(new BorderLayout());
        panelSopa = new JPanel();
        panelSopa.add(sopa);
        panelSopa.setBackground(Color.YELLOW);
        panel_boton_sopa.add(panelSopa, BorderLayout.CENTER);
        panel_boton_resolver = new JPanel();
        panel_boton_resolver.setBackground(Color.YELLOW);
        panel_boton_resolver.add(botonResolver = new JButton("Resolver"), BorderLayout.CENTER);
        botonResolver.addActionListener(new ListenerBoton());
        panel_boton_sopa.add(panel_boton_resolver, BorderLayout.SOUTH);
        add(panel_boton_sopa);

        //Layout Ventana1
        panel_Ventana1 = new JPanel();
        JTextArea ventana1 = new JTextArea(10, 15);
        JScrollPane ventana1_scroll = new JScrollPane(ventana1);
        
        ventana1.setText(sopaLetras_Ventana1.replace(" ", "\n"));
        ventana1.setEditable(false);
        add(ventana1_scroll);

        //Layout Ventana2
        panel_Ventana2 = new JPanel();
        Ventana2_solucion = new JTextArea(10, 15);
        Ventana2_solucion.setEditable(false);
        Ventana2_solucion.setText(sopaLetras_Ventana2.replace(" ", "\n"));
       
        JScrollPane ventana2_scroll = new JScrollPane();
        ventana2_scroll.setViewportView(Ventana2_solucion);
        add(ventana2_scroll);

    }

    class ListenerBoton implements ActionListener {

        public ListenerBoton() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            sopaLetras_Ventana2 = datos.getSolucion();
            sopaLetras_Ventana2 = sopaLetras_Ventana2.replace(" ", "\n");
            Ventana2_solucion.setText(sopaLetras_Ventana2);
            repaint();
        }
    }

    public static void main(String[] args) {
        Sopa_Letras run = new Sopa_Letras();
    }

}
