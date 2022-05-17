/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author chova
 */
public class ColorRenderer extends JLabel implements TableCellRenderer {

    /**
     * Creates a new instance of ColorRenderer
     */
    public ColorRenderer() {
    }

    /**
     * Retorna un component per personalitzar la cel·la
     *
     * @param table Component JTable pare
     * @param value Valor de la cel·la
     * @param isSelected True si la cel·la està seleccionada
     * @param hasFocus Si te el foco
     * @param row Index de la fila
     * @param column Index de la columna
     * @return Component per a ser visualitzat
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (!isSelected) {
            this.setBackground(Color.YELLOW);
            this.setForeground(Color.PINK);
        } else {
            this.setBackground(Color.LIGHT_GRAY);
            this.setForeground(Color.RED);
        }
        System.out.println(column);
        
        this.setText((String) value);
        this.setToolTipText("El valor d’aquesta cel·la es: " + value);
        this.setOpaque(true);
        return this;
    }
}
