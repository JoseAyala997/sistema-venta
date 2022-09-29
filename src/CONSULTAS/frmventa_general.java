package CONSULTAS;

import Logica.Conexion;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fventa;
import Presentacion.FrmVista2;
import Presentacion.frmprincipal;
import java.awt.Color;
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
public class frmventa_general extends javax.swing.JInternalFrame {

    public static String x;

    public static DecimalFormat format = new DecimalFormat("###,###.###");
    float sumatoria;
    float sumador;
    float sumatoria2;
    float sumador2;
    String estado;

    public frmventa_general() {
        initComponents();
        txtidcliente.setVisible(false);
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

        LOcultarColumna.modjtable(tablaventageneral);
    }
//funcion para mostrar ventas al contado y credito con nombre del cliente

    void mostrarcontado(String inicio, String fin, String estado, String id) {
        try {
            DefaultTableModel modelo;

            fventa Funcion = new fventa();

            modelo = Funcion.mostrarcontnombre(inicio, fin, estado, id);

//            int total = Funcion.totalregistros;
//            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
            tablaventageneral.setModel(modelo);

        } catch (Exception e) {
        }

    }

//    funcion para sumar el total de todas las ventas
    void sumarsubtotal() {
        int totalrow = tablaventageneral.getRowCount();
        totalrow -= 1;
        sumatoria = 0;
        sumatoria2 = 0;
//        des1 = 0;
//        des2 = 0;
        for (int i = 0; i <= (totalrow); i++) {
            estado = String.valueOf(tablaventageneral.getValueAt(i, 10).toString());
            if (estado.equals("CONTADO")) {
                sumador = Float.valueOf(tablaventageneral.getValueAt(i, 8).toString().replaceAll("\\.", ""));
                sumatoria += sumador;
//            des1 = Float.valueOf(jTable1.getValueAt(i, 7).toString().replaceAll("\\.", ""));
//                des2 += des1;
            } else if (estado.equals("CREDITO")) {
                sumador2 = Float.valueOf(tablaventageneral.getValueAt(i, 8).toString().replaceAll("\\.", ""));
                sumatoria2 += sumador2;
//            des1 = Float.valueOf(jTable1.getValueAt(i, 7).toString().replaceAll("\\.", ""));
//                des3 += des4;
            }

        }
        lblcredito.setText(String.valueOf(format.format(sumatoria2)));
        lblcontado.setText(String.valueOf(format.format(sumatoria)));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        dcFecha_Inicio = new com.toedter.calendar.JDateChooser();
        dcFecha_termino = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventageneral = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cmbestado = new javax.swing.JComboBox<>();
        txtidcliente = new javax.swing.JTextField();
        txtcliente = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        lblcontado = new javax.swing.JLabel();
        lblcredito = new javax.swing.JLabel();
        lbltotalventa3 = new javax.swing.JLabel();
        lbltotalventa1 = new javax.swing.JLabel();

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

        dcFecha_Inicio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        dcFecha_termino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setText("HISTORIAL DE VENTAS POR CLIENTE");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Fecha fin:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("Fecha de inicio:");

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/imprimir1.png"))); // NOI18N
        btnnuevo.setText("Imprimir");
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        tablaventageneral.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaventageneral.getTableHeader().setResizingAllowed(false);
        tablaventageneral.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaventageneral);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO", "TODOS" }));

        txtcliente.setEnabled(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblcontado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontado.setText("0");

        lblcredito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcredito.setText("0");

        lbltotalventa3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa3.setText("Total Venta Credito:");

        lbltotalventa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa1.setText("Total Venta Contado:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcFecha_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcFecha_termino, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbestado, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbltotalventa1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblcontado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbltotalventa3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblcredito, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnnuevo)
                .addGap(511, 511, 511))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(11, 11, 11)
                .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnnuevo)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltotalventa1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblcontado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltotalventa3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblcredito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(dcFecha_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)
                                .addComponent(dcFecha_termino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
//        + "/src/Reportes/rptventa_historialcred.jrxml");
        Conexion reporte = new Conexion();
        Connection cn = reporte.conectar();
        String idcliente = txtidcliente.getText();
        String estador = cmbestado.getSelectedItem().toString();
        int fila = tablaventageneral.getRowCount();

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
                p.put("id", txtidcliente.getText());
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
                }finally{
//                    cerramos la conexion
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
                p.put("id", txtidcliente.getText());
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
                }finally{
//                    cerramos la conexion
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
                p.put("id", txtidcliente.getText());
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
                }finally{
//                    cerramos la conexion
                    reporte.desconectar();
                }
            }
        }


    }//GEN-LAST:event_btnnuevoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String id = txtidcliente.getText();
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
            mostrarcontado(p_fecha_Desde, p_fecha_Hasta, estado, id);
            sumarsubtotal();
            LOcultarColumna.ocultar_esta_columna2(tablaventageneral, 0, 1, 2);

        } else if (estado.equals("CREDITO")) {
            estado = "PENDIENTE";
            mostrarcontado(p_fecha_Desde, p_fecha_Hasta, estado, id);
//            mostrarcredito(p_fecha_Desde, p_fecha_Hasta, estado);
//            LOcultarColumna.ocultar_esta_columna2(tablahistorial, 0, 1, 2);
            sumarsubtotal();
            LOcultarColumna.ocultar_esta_columna2(tablaventageneral, 0, 1, 2);
        } else {
            estado = "";
            mostrarcontado(p_fecha_Desde, p_fecha_Hasta, estado, id);
//            mostrarcredito(p_fecha_Desde, p_fecha_Hasta, estado);
//            LOcultarColumna.ocultar_esta_columna2(tablahistorial, 0, 1, 2);
            sumarsubtotal();
            LOcultarColumna.ocultar_esta_columna2(tablaventageneral, 0, 1, 2);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FrmVista2 form = new FrmVista2();
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 8;
        form.lbltitulovista.setText("Historial ventas");
        form.buscador();
    }//GEN-LAST:event_jButton2ActionPerformed


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
            java.util.logging.Logger.getLogger(frmventa_general.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmventa_general.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmventa_general.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmventa_general.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmventa_general().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cmbestado;
    private com.toedter.calendar.JDateChooser dcFecha_Inicio;
    private com.toedter.calendar.JDateChooser dcFecha_termino;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblcontado;
    public static javax.swing.JLabel lblcredito;
    public static javax.swing.JLabel lbltotalventa1;
    public static javax.swing.JLabel lbltotalventa3;
    public static javax.swing.JTable tablaventageneral;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtidcliente;
    // End of variables declaration//GEN-END:variables

}
