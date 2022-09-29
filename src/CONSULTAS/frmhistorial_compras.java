package CONSULTAS;

import Logica.Conexion;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fcompra;
import Presentacion.FrmVista2;
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
public class frmhistorial_compras extends javax.swing.JInternalFrame {

    public static int comprobar;
    public static String x;

    public frmhistorial_compras() {
        initComponents();
        txtidproveedor.setVisible(false);
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
        mostrarcontado(String.valueOf(mifecha), String.valueOf(mifecha), "", "");
        LOcultarColumna.modjtable(tablacompras);
    }

    void mostrarcontado(String inicio, String fin, String buscar, String estado) {
        try {
            DefaultTableModel modelo;

            fcompra Funcion = new fcompra();

            modelo = Funcion.mostrarcompras(inicio, fin, buscar, estado);

//            int total = Funcion.totalregistros;
//            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
            tablacompras.setModel(modelo);

        } catch (Exception e) {
        }

    }

    public static DecimalFormat format = new DecimalFormat("###,###.###");
    public static float sumatoria;
    public static float sumatoria2;
    public static float sumador;
    public static float sumador2;
    public static float pulgadas;
    public static float des1;
    public static float des2;
     public static String estado;
    public static void sumarsubtotal() {
        int totalrow = tablacompras.getRowCount();
        totalrow -= 1;
        sumatoria = 0;
        des1 = 0;
        des2 = 0;
        for (int i = 0; i <= (totalrow); i++) {
            estado = String.valueOf(tablacompras.getValueAt(i, 8).toString());
            if (estado.equals("CONTADO")) {
                sumador = Float.valueOf(tablacompras.getValueAt(i, 5).toString().replaceAll("\\.", ""));
                sumatoria += sumador;
//            des1 = Float.valueOf(jTable1.getValueAt(i, 7).toString().replaceAll("\\.", ""));
//                des2 += des1;
            } else if (estado.equals("CREDITO")) {
                sumador2 = Float.valueOf(tablacompras.getValueAt(i, 5).toString().replaceAll("\\.", ""));
                sumatoria2 += sumador2;
//            des1 = Float.valueOf(jTable1.getValueAt(i, 7).toString().replaceAll("\\.", ""));
//                des3 += des4;
            }

        }
        lbltotalCredito.setText(String.valueOf(format.format(sumatoria2)));
        lbltotalventa.setText(String.valueOf(format.format(sumatoria)));
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
        jLabel12 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacompras = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cmbestado = new javax.swing.JComboBox<>();
        txtproveedor = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtidproveedor = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbltotalventa1 = new javax.swing.JLabel();
        lbltotalventa = new javax.swing.JLabel();
        lbltotalventa2 = new javax.swing.JLabel();
        lbltotalCredito = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(false);
        setMaximumSize(null);
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

        dcFecha_Inicio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(dcFecha_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 150, 30));

        dcFecha_termino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(dcFecha_termino, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 150, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setText("HISTORIAL DE COMPRAS");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 320, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Estado:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, -1, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("Proveedor:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, 30));

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/imprimir1.png"))); // NOI18N
        btnnuevo.setText("Imprimir");
        btnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, 150, -1));

        tablacompras.setModel(new javax.swing.table.DefaultTableModel(
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
        tablacompras.getTableHeader().setResizingAllowed(false);
        tablacompras.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablacompras);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1184, 380));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, 113, 30));

        cmbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO", "TODOS" }));
        jPanel3.add(cmbestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 150, 30));

        txtproveedor.setEnabled(false);
        txtproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproveedorActionPerformed(evt);
            }
        });
        jPanel3.add(txtproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 220, 31));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 36, 35));
        jPanel3.add(txtidproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 25, 31));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setText("Fecha de inicio:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setText("Fecha fin:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, 30));

        lbltotalventa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa1.setText("Total Contado:");
        jPanel3.add(lbltotalventa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 110, 30));

        lbltotalventa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa.setText("0");
        jPanel3.add(lbltotalventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, 110, 30));

        lbltotalventa2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa2.setText("Total Credito:");
        jPanel3.add(lbltotalventa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 90, 30));

        lbltotalCredito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalCredito.setText("0");
        jPanel3.add(lbltotalCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
//        abrimos la conexion
        Conexion reporte = new Conexion();
        Connection cn = reporte.conectar();
//        if (txtidproveedor.getText().length() == 0) {
//            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EL PROVEEDOR");
//            txtidproveedor.requestFocus();
//            return;
//        }
        String idcliente = txtidproveedor.getText();
        String estador = cmbestado.getSelectedItem().toString();
        int fila = tablacompras.getRowCount();
        if (fila == 0) {
            JOptionPane.showMessageDialog(rootPane, "La tabla no puede estar vacia");
        } else {
            if (estador.equals("TODOS")) {
                estador = "";
                Map p = new HashMap();
                p.put("fecha_inicio", dcFecha_Inicio.getDate());
                p.put("fecha_fin", dcFecha_termino.getDate());
                p.put("idproveedor", txtidproveedor.getText());
                p.put("totalcompraContado", lbltotalventa.getText());
                p.put("totalcompraCredito", lbltotalCredito.getText());
                p.put("estado", estador);
                JasperReport report;
                JasperPrint print;

                try {
                    report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/Reportes/rptcompra_historial.jrxml");
                    print = JasperFillManager.fillReport(report, p, cn);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Historial compras");
                    view.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
//                    cerramos la conexion
                    reporte.desconectar();
                }
            } else {
                estador = cmbestado.getSelectedItem().toString();
                Map p = new HashMap();
                p.put("fecha_inicio", dcFecha_Inicio.getDate());
                p.put("fecha_fin", dcFecha_termino.getDate());
                p.put("idproveedor", txtidproveedor.getText());
                p.put("totalcompraContado", lbltotalventa.getText());
                p.put("totalcompraCredito", lbltotalCredito.getText());
                p.put("estado", estador);
                JasperReport report;
                JasperPrint print;

                try {
                    report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/Reportes/rptcompra_historial.jrxml");
                    print = JasperFillManager.fillReport(report, p, cn);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Historial compras");
                    view.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
//                    cerramos la conexion
                    reporte.desconectar();
                }

            }
        }


    }//GEN-LAST:event_btnnuevoActionPerformed
    void buscarCompras() {
        String estado = cmbestado.getSelectedItem().toString();
        String id = txtidproveedor.getText();

        java.util.Date desde = new java.util.Date();
        SimpleDateFormat sdf_desde = new SimpleDateFormat("yyyy-MM-dd");
        desde = dcFecha_Inicio.getDate();
        String p_fecha_Desde = sdf_desde.format(desde);

        java.util.Date hasta = new java.util.Date();
        SimpleDateFormat sdf_hasta = new SimpleDateFormat("yyyy-MM-dd");
        hasta = dcFecha_termino.getDate();
        String p_fecha_Hasta = sdf_hasta.format(hasta);
        String proveedor = txtidproveedor.getText();

        if (estado.equals("CONTADO")) {
            estado = "FINALIZADO";
            mostrarcontado(p_fecha_Desde, p_fecha_Hasta, proveedor, estado);
//            LOcultarColumna.ocultar_esta_columna2(tablahistorial, 0, 1, 2);
            sumarsubtotal();
        } else if (estado.equals("CREDITO")) {
            estado = "PENDIENTE";
            mostrarcontado(p_fecha_Desde, p_fecha_Hasta, proveedor, estado);
//            mostrarcredito(p_fecha_Desde, p_fecha_Hasta, estado);
//            LOcultarColumna.ocultar_esta_columna2(tablahistorial, 0, 1, 2);
            sumarsubtotal();
//            LOcultarColumna.ocultar_esta_columna2(tablahistorial, 0, 1, 2);
        } else {
            estado = "";
            mostrarcontado(p_fecha_Desde, p_fecha_Hasta, proveedor, estado);
//            mostrarcredito(p_fecha_Desde, p_fecha_Hasta, estado);
//            LOcultarColumna.ocultar_esta_columna2(tablahistorial, 0, 1, 2);
            sumarsubtotal();
//            LOcultarColumna.ocultar_esta_columna2(tablahistorial, 0, 1, 2);
        }
        sumarsubtotal();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarCompras();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FrmVista2 form = new FrmVista2();
        form.jComboBox1.setVisible(false);
        form.setVisible(true);
        form.toFront();
        form.dondebuscar = 9;
        form.lbltitulovista.setText("Historial Compras");
        form.buscador();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproveedorActionPerformed

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
            java.util.logging.Logger.getLogger(frmhistorial_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmhistorial_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmhistorial_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmhistorial_compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new frmhistorial_compras().setVisible(true);
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbltotalCredito;
    public static javax.swing.JLabel lbltotalventa;
    public static javax.swing.JLabel lbltotalventa1;
    public static javax.swing.JLabel lbltotalventa2;
    public static javax.swing.JTable tablacompras;
    public static javax.swing.JTextField txtidproveedor;
    public static javax.swing.JTextField txtproveedor;
    // End of variables declaration//GEN-END:variables

}
