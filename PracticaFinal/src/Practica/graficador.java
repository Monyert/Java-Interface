package Practica;

/**
 * @author ema
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import jdk.nashorn.internal.runtime.JSType;

public class graficador extends JPanel {

    public boolean f = true;
    private int ANCHO, LARGO;
    private int y1, y2;
    private double x1, x2, y;
    double resultado;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setVisible(true);
        ANCHO = getWidth();
        LARGO = getHeight();
        Color c1 = new Color(59, 131, 189); //Blau
        Color c2 = new Color(254, 000, 000); //Roig
        Color c3 = new Color(184, 183, 153); //Verd
        Color c4 = new Color(184, 183, 153); //Taronja
        Color c5 = new Color(010, 010, 010); //Negre

        g.setColor(c1);
        g.drawLine(0, LARGO / 2, ANCHO, LARGO / 2); //Eix x
        g.drawLine(ANCHO / 2, 0, ANCHO / 2, ANCHO); //Eix y

        g.setColor(c5);
        //Punts de separacio eix X

        for (int i = 0; i <= ANCHO / 100; i++) {
            g.drawLine(ANCHO / 2 - 50 * i, LARGO / 2 - 5, ANCHO / 2 - 50 * i, LARGO / 2 + 5);
            g.drawLine(ANCHO / 2 + 50 * i, LARGO / 2 - 5, ANCHO / 2 + 50 * i, LARGO / 2 + 5);
        }

        //Punts de separacio eix Y 
        for (int i = 0; i <= LARGO / 100; i++) {
            g.drawLine(ANCHO / 2 - 5, LARGO / 2 + 50 * i, ANCHO / 2 + 5, LARGO / 2 + 50 * i);
            g.drawLine(ANCHO / 2 - 5, LARGO / 2 - 50 * i, ANCHO / 2 + 5, LARGO / 2 - 50 * i);
        }

        g.setColor(Color.RED);
        int a = 1;
        int b = 50;
        int c = 50;
        if (Aplicacio.numero_a.getText().length() == 0 || Aplicacio.numero_b.getText().length() == 0 || Aplicacio.numero_c.getText().length() == 0) {

            //Vacio
        } else {
            try{
            a = Integer.parseInt(Aplicacio.numero_a.getText());
            b = Integer.parseInt(Aplicacio.numero_b.getText());
            c = Integer.parseInt(Aplicacio.numero_c.getText());
            }catch(Exception e){
                Aplicacio.MensajeError();
            }
           
            if (JSType.isNumber(a) && JSType.isNumber(b) && JSType.isNumber(c)) {
                     g.setColor(Color.BLUE);
                double formula;

                for (double i = -300; i < 300; i++) {
                    formula = a * Math.pow(i / 50, 2) + b * (i / 50) + c;

                    if (formula == 0) {
                        continue;
                    }

                    g.drawOval((int) (i + ANCHO / 2), (int) (LARGO / 2 - 50 * formula), 1, 5);
                }
            } else {
               
                 System.out.println("Error");   
                
            }
        }

    }
}
