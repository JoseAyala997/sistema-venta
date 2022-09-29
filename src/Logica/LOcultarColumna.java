/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Jose Ayala
 */
public class LOcultarColumna {

    public static void modjtable(javax.swing.JTable tabla) {
        for (int c = 0; c < tabla.getColumnCount(); c++) {

            Class<?> col_class = tabla.getColumnClass(c);

            tabla.setDefaultEditor(col_class, null); // remove editor

        }
    }

    public static void ocultar_esta_columna(javax.swing.JTable nombretabla, int nrocolumna) {
        nombretabla.getColumnModel().getColumn(nrocolumna).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna).setPreferredWidth(0);
    }

    public static void ocultar_esta_columna1(javax.swing.JTable nombretabla, int nrocolumna1, int nrocolumna2, int nrocolumna3) {
        nombretabla.getColumnModel().getColumn(nrocolumna1).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna1).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna1).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna2).setMaxWidth(260);
        nombretabla.getColumnModel().getColumn(nrocolumna2).setMinWidth(260);
        nombretabla.getColumnModel().getColumn(nrocolumna2).setPreferredWidth(260);

        nombretabla.getColumnModel().getColumn(nrocolumna3).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna3).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna3).setPreferredWidth(0);
    }

    public static void ocultar_esta_columna2(javax.swing.JTable nombretabla, int nrocolumna1, int nrocolumna2, int nrocolumna3) {
        nombretabla.getColumnModel().getColumn(nrocolumna1).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna1).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna1).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna2).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna2).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna2).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna3).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna3).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna3).setPreferredWidth(0);
    }

    public static void ocultar_esta_columna3(javax.swing.JTable nombretabla, int nrocolumna1, int nrocolumna2, int nrocolumna3, int nrocolumna4) {
        nombretabla.getColumnModel().getColumn(nrocolumna1).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna1).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna1).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna2).setMaxWidth(250);
        nombretabla.getColumnModel().getColumn(nrocolumna2).setMinWidth(250);
        nombretabla.getColumnModel().getColumn(nrocolumna2).setPreferredWidth(250);

        nombretabla.getColumnModel().getColumn(nrocolumna3).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna3).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna3).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna4).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna4).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna4).setPreferredWidth(0);
    }

    public static void ocultar_esta_columna5(javax.swing.JTable nombretabla, int nrocolumna1, int nrocolumna2, int nrocolumna3, int nrocolumna4, int nrocolumna5) {
        nombretabla.getColumnModel().getColumn(nrocolumna1).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna1).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna1).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna2).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna2).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna2).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna3).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna3).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna3).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna4).setMaxWidth(150);
        nombretabla.getColumnModel().getColumn(nrocolumna4).setMinWidth(150);
        nombretabla.getColumnModel().getColumn(nrocolumna4).setPreferredWidth(150);

        nombretabla.getColumnModel().getColumn(nrocolumna5).setMaxWidth(150);
        nombretabla.getColumnModel().getColumn(nrocolumna5).setMinWidth(150);
        nombretabla.getColumnModel().getColumn(nrocolumna5).setPreferredWidth(150);
    }

    public static void ocultar_esta_columnaPVenta(javax.swing.JTable nombretabla, int nrocolumna1, int nrocolumna2, int nrocolumna3, int nrocolumna4, int nrocolumna5, int nrocolumna6, int nrocolumna7, int nrocolumna8, int nrocolumna9) {
        nombretabla.getColumnModel().getColumn(nrocolumna1).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna1).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna1).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna2).setMaxWidth(250);
        nombretabla.getColumnModel().getColumn(nrocolumna2).setMinWidth(250);
        nombretabla.getColumnModel().getColumn(nrocolumna2).setPreferredWidth(250);

        nombretabla.getColumnModel().getColumn(nrocolumna3).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna3).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna3).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna4).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna4).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna4).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna5).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna5).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna5).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna6).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna6).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna6).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna7).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna7).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna7).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna8).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna8).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna8).setPreferredWidth(0);

        nombretabla.getColumnModel().getColumn(nrocolumna9).setMaxWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna9).setMinWidth(0);
        nombretabla.getColumnModel().getColumn(nrocolumna9).setPreferredWidth(0);
    }

}
