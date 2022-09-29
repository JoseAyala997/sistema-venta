package CONSULTAS;

import Logica.Conexion;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fventa;
import Presentacion.frmprincipal;
import java.io.File;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jose Ayala
 */
public class frmventas_diarias extends javax.swing.JInternalFrame {

//    public static int comprobar;
    public static String x;

    public static DecimalFormat format = new DecimalFormat("###,###.###");
    float sumatoria;
    float sumador;
    float sumatoria2;
    float sumador2;
    String estado;

    public frmventas_diarias() {
        initComponents();
        x = "x";
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);

        Calendar mifecha = new GregorianCalendar();
        dcFecha_Inicio.setCalendar(mifecha);
        dcFecha_termino.setCalendar(mifecha);

//        jPanel3.setBackground(new Color(0, 102, 100, 200));
        StyloTabla st = new StyloTabla();

        buscar();

        LOcultarColumna.modjtable(tablareporte);
    }

    void buscar() {
        java.util.Date desde = new java.util.Date();
        SimpleDateFormat sdf_desde = new SimpleDateFormat("yyyy-MM-dd");
        desde = dcFecha_Inicio.getDate();
        String p_fecha_Desde = sdf_desde.format(desde);

        java.util.Date hasta = new java.util.Date();
        SimpleDateFormat sdf_hasta = new SimpleDateFormat("yyyy-MM-dd");
        hasta = dcFecha_termino.getDate();
        String p_fecha_Hasta = sdf_hasta.format(hasta);

        String estado = cmbestado.getSelectedItem().toString();
        if (estado.equals("CONTADO")) {
            estado = "FINALIZADO";
            mostrarcontado(p_fecha_Desde, p_fecha_Hasta, estado);
            sumarsubtotal();
            LOcultarColumna.ocultar_esta_columna2(tablareporte, 0, 1, 2);

        } else if (estado.equals("CREDITO")) {
            estado = "PENDIENTE";
            mostrarcontado(p_fecha_Desde, p_fecha_Hasta, estado);
//            mostrarcredito(p_fecha_Desde, p_fecha_Hasta, estado);
//            LOcultarColumna.ocultar_esta_columna2(tablahistorial, 0, 1, 2);
            sumarsubtotal();
            LOcultarColumna.ocultar_esta_columna2(tablareporte, 0, 1, 2);
        } else {
            estado = "";
            mostrarcontado(p_fecha_Desde, p_fecha_Hasta, estado);
//            mostrarcredito(p_fecha_Desde, p_fecha_Hasta, estado);
//            LOcultarColumna.ocultar_esta_columna2(tablahistorial, 0, 1, 2);
            sumarsubtotal();
            LOcultarColumna.ocultar_esta_columna2(tablareporte, 0, 1, 2);
        }
//        LOcultarColumna.ocultar_esta_columna2(tablareporte,0,1,2);
    }

    void mostrarcontado(String inicio, String fin, String estado) {
        try {
            DefaultTableModel modelo;

            fventa Funcion = new fventa();

            modelo = Funcion.mostrarhventatotal(inicio, fin, estado);

//            int total = Funcion.totalregistros;
//            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
            tablareporte.setModel(modelo);

        } catch (Exception e) {
        }

    }

    void imprimir() {
        Conexion reporte = new Conexion();
        Connection cn = reporte.conectar();
        String estador = cmbestado.getSelectedItem().toString();
        int fila = tablareporte.getRowCount();
        if (fila == 0) {
            JOptionPane.showMessageDialog(rootPane, "La tabla no puede estar vacia");
        } else {
            if (estador.equals("CONTADO")) {
                estador = "FINALIZADO";
                Map p = new HashMap();
                p.put("fecha_inicio", dcFecha_Inicio.getDate());
                p.put("fecha_fin", dcFecha_termino.getDate());
                p.put("estado", estador);
                p.put("contado", lblcontado.getText());
                p.put("credito", lblcredito.getText());
                p.put("id", "");
                p.put("ganancia", lblganancia.getText());
                JasperReport report;
                JasperPrint print;

                try {
                    report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/Reportes/rptventa_historial_total.jrxml");
                    print = JasperFillManager.fillReport(report, p, cn);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Historial ventas");

                    view.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
//                cerramos la conexion
                    reporte.desconectar();
                }
            } else if (estador.equals("CREDITO")) {
                estador = "PENDIENTE";
                Map p = new HashMap();
                estador = "PENDIENTE";
                p.put("fecha_inicio", dcFecha_Inicio.getDate());
                p.put("fecha_fin", dcFecha_termino.getDate());
                p.put("estado", estador);
                p.put("contado", lblcontado.getText());
                p.put("credito", lblcredito.getText());
                p.put("id", "");
                p.put("ganancia", lblganancia.getText());
                JasperReport report;
                JasperPrint print;

                try {
                    report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/Reportes/rptventa_historial_total.jrxml");
//                            + "/src/Reportes/rptventa_historialcred_total.jrxml");
                    print = JasperFillManager.fillReport(report, p, cn);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Historial ventas");
                    view.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
//                cerramos la conexion
                    reporte.desconectar();
                }

            } else {
                estador = "";
                Map p = new HashMap();
                p.put("fecha_inicio", dcFecha_Inicio.getDate());
                p.put("fecha_fin", dcFecha_termino.getDate());
                p.put("estado", estador);
                p.put("contado", lblcontado.getText());
                p.put("credito", lblcredito.getText());
                p.put("id", "");
                p.put("ganancia", lblganancia.getText());
                JasperReport report;
                JasperPrint print;

                try {
                    report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/Reportes/rptventa_historial_total.jrxml");
//                            + "/src/Reportes/rptventa_historialcred_total.jrxml");
                    print = JasperFillManager.fillReport(report, p, cn);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Historial de ventas diarias");
                    view.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
//                cerramos la conexion
                    reporte.desconectar();
                }
            }
        }
    }

    void sumarsubtotal() {
        int totalrow = tablareporte.getRowCount();
        totalrow -= 1;
        sumatoria = 0;
        sumatoria2 = 0;
//        des1 = 0;
//        des2 = 0;
        for (int i = 0; i <= (totalrow); i++) {
            estado = String.valueOf(tablareporte.getValueAt(i, 9).toString());
            if (estado.equals("CONTADO")) {
                sumador = Float.valueOf(tablareporte.getValueAt(i, 7).toString().replaceAll("\\.", ""));
                sumatoria += sumador;
//            des1 = Float.valueOf(jTable1.getValueAt(i, 7).toString().replaceAll("\\.", ""));
//                des2 += des1;
            } else if (estado.equals("CREDITO")) {
                sumador2 = Float.valueOf(tablareporte.getValueAt(i, 7).toString().replaceAll("\\.", ""));
                sumatoria2 += sumador2;
//            des1 = Float.valueOf(jTable1.getValueAt(i, 7).toString().replaceAll("\\.", ""));
//                des3 += des4;
            }

        }
        lblcredito.setText(String.valueOf(format.format(sumatoria2)));
        lblcontado.setText(String.valueOf(format.format(sumatoria)));

//        txttotal_descuento.setText(String.valueOf(format.format(des2)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        dcFecha_Inicio = new com.toedter.calendar.JDateChooser();
        dcFecha_termino = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnimprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablareporte = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        cmbestado = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        lblcontado = new javax.swing.JLabel();
        lbltotalventa1 = new javax.swing.JLabel();
        lblcredito = new javax.swing.JLabel();
        lbltotalventa3 = new javax.swing.JLabel();
        lbltotalventa2 = new javax.swing.JLabel();
        lblganancia = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(false);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dcFecha_Inicio.setEnabled(false);
        dcFecha_Inicio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(dcFecha_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 150, 30));

        dcFecha_termino.setEnabled(false);
        dcFecha_termino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(dcFecha_termino, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 150, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setText("Ventas del día");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 188, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Fecha fin:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, 20));

        btnimprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/imprimir1.png"))); // NOI18N
        btnimprimir.setText("Imprimir");
        btnimprimir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });
        jPanel3.add(btnimprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, -1, -1));

        tablareporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablareporte.getTableHeader().setResizingAllowed(false);
        tablareporte.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablareporte);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1184, 420));

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel3.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, -1, 35));

        cmbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO", "TODOS" }));
        jPanel3.add(cmbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 121, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setText("Fecha de inicio:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, 20));

        lblcontado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontado.setText("0");
        jPanel3.add(lblcontado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 110, 30));

        lbltotalventa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa1.setText("Total Venta Contado:");
        jPanel3.add(lbltotalventa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 140, 30));

        lblcredito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcredito.setText("0");
        jPanel3.add(lblcredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 590, 110, 30));

        lbltotalventa3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa3.setText("Total Venta Credito:");
        jPanel3.add(lbltotalventa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 130, 30));

        lbltotalventa2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa2.setText("Total ganancia:");
        jPanel3.add(lbltotalventa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 100, 30));

        lblganancia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblganancia.setText("0");
        jPanel3.add(lblganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed

        imprimir();


    }//GEN-LAST:event_btnimprimirActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        buscar();

    }//GEN-LAST:event_btnbuscarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmventas_diarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmventas_diarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmventas_diarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmventas_diarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmventas_diarias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JComboBox<String> cmbestado;
    private com.toedter.calendar.JDateChooser dcFecha_Inicio;
    private com.toedter.calendar.JDateChooser dcFecha_termino;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblcontado;
    public static javax.swing.JLabel lblcredito;
    public static javax.swing.JLabel lblganancia;
    public static javax.swing.JLabel lbltotalventa1;
    public static javax.swing.JLabel lbltotalventa2;
    public static javax.swing.JLabel lbltotalventa3;
    public static javax.swing.JTable tablareporte;
    // End of variables declaration//GEN-END:variables

}
