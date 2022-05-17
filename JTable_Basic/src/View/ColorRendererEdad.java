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
public class ColorRendererEdad extends JLabel implements TableCellRenderer {

    /**
     * Creates a new instance of ColorRenderer
     */
    public ColorRendererEdad() {
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
        if (value.toString().equals(value)) {
            this.setForeground(Color.RED);
        }
        System.out.println(column);
        
        this.setText(value.toString());
        this.setToolTipText("El valor d’aquesta cel·la es: " + value);
        this.setOpaque(true);
        return this;
    }
}
