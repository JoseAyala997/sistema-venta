/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author José Ayala
 */
public class StyloTabla {

    public static void stylotabla(javax.swing.JTable nombretabla) {
        nombretabla.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                l.setBorder(new LineBorder(Color.black, 1));
                l.setBackground(new java.awt.Color(153, 153, 153));

                l.setForeground(new java.awt.Color(255, 255, 255));
                l.setFont(new java.awt.Font("Arial", 1, 14));
                return l;
            }
        });
    }
}
