package graficador;

/**
 * @author Monyert
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import jdk.nashorn.internal.ir.BreakNode;



public class programa extends JFrame {

    public static JButton boton_dibujar = new JButton("Dibujar");
    public static graficador panel_grafica = new graficador();
    public static JLabel valor_a = new JLabel("a:");
    public static JLabel valor_b = new JLabel("b:");
    public static JLabel valor_c = new JLabel("c:");
    public static JTextField text_a = new JTextField(5);
    public static JTextField text_b = new JTextField(5);
    public static JTextField text_c = new JTextField(5);
    
 
    public programa() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(906, 689);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        

        //Bordes del Panel Superior
        JPanel panel_superior = new JPanel();
        panel_superior.setBackground(Color.decode("#DCDCDC"));
        Border border = BorderFactory.createLineBorder(Color.decode("#BEBEBE"));
        Border borde_ec = BorderFactory.createTitledBorder(border, " Ecuacion: ", 0, 0, Font.decode("BOLD"));
        panel_superior.setBorder(borde_ec);

        //Borde de la Grafica
        panel_grafica.setBorder(border);
        
        //Panel Superior
        panel_superior.add(valor_a);
        panel_superior.add(text_a);
        
        panel_superior.add(valor_b);
        panel_superior.add(text_b);
        
        panel_superior.add(valor_c);
        panel_superior.add(text_c);
        
        panel_superior.add(boton_dibujar);
        boton_dibujar.addActionListener(new ActListener());
        //Contenedor
        Container contentpane = this.getContentPane();
        contentpane.add(panel_grafica, BorderLayout.CENTER);
        contentpane.add(panel_superior, BorderLayout.NORTH);

        this.setVisible(true);
    }

    public static void MensajeError() {
        JOptionPane.showMessageDialog(panel_grafica, "Sintaxis Incorrecta", "Error de Evaluacion", JOptionPane.CLOSED_OPTION);
        
    }

    public static void main(String[] args) {
        programa prog = new programa();
    }
}
