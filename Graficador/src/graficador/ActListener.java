package graficador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Monyert
 */
public class ActListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(programa.boton_dibujar)) {
            programa.panel_grafica.repaint();
        }

    }

}
