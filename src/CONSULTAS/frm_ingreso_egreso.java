package CONSULTAS;

import Logica.Conexion;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fegresos;
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
public class frm_ingreso_egreso extends javax.swing.JInternalFrame {

    public static String x;

    public frm_ingreso_egreso() {
        initComponents();
        x = "x";
//        btnnuevo.setVisible(false);
        int a = frmprincipal.jDesktopPane2.getWidth() - this.getWidth();
        int b = frmprincipal.jDesktopPane2.getHeight() - this.getHeight();
        setLocation(a / 2, b / 2);
        setVisible(true);

        Calendar mifecha = new GregorianCalendar();
        dcFecha_Inicio.setCalendar(mifecha);
        dcFecha_termino.setCalendar(mifecha);
//        jPanel3.setBackground(new Color(0, 102, 100, 200));
        StyloTabla st = new StyloTabla();
        mortrar(mifecha.toString(),mifecha.toString(),"");
        LOcultarColumna.modjtable(tablaIE);
    }

    void mortrar(String inicio, String fin, String estado) {
        try {
            DefaultTableModel modelo;

            fegresos Funcion = new fegresos();

            modelo = Funcion.mostrarIE(inicio, fin, estado);

//            int total = Funcion.totalregistros;
//            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
            tablaIE.setModel(modelo);

        } catch (Exception e) {
        }

    }
    
    void imprimir(){
       //        abrimos la conexion
        Conexion reporte = new Conexion();
        Connection cn = reporte.conectar();
        String estador = cmbestado.getSelectedItem().toString();
        int fila = tablaIE.getRowCount();
        if (fila == 0) {
            JOptionPane.showMessageDialog(rootPane, "La tabla no puede estar vacia");
        }else{
             
                Map p = new HashMap();
               
                p.put("fecha_inicio", dcFecha_Inicio.getDate());
                p.put("fecha_fin", dcFecha_termino.getDate());
                 p.put("estado", estador);
                p.put("totalventa",lbltotalventa.getText());
            
                JasperReport report;
                JasperPrint print;

                try {
                    report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/Reportes/rptingresos_egresos.jrxml");
                    print = JasperFillManager.fillReport(report, p, cn);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Historial de Ingresos y Egresos");
                    view.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
//                    cerramos la conexion
                    reporte.desconectar();
                }

            
        }
           
        
    }
    
    public static DecimalFormat format = new DecimalFormat("###,###.###");
    public static float sumatoria;
    public static float sumador;
    public static float pulgadas;
    public static float des1;
    public static float des2;
    
    public static void sumarsubtotal() {
        int totalrow = tablaIE.getRowCount();
        totalrow -= 1;
        sumatoria = 0;
        des1 = 0;
        des2 = 0;
        for (int i = 0; i <= (totalrow); i++) {
            sumador = Float.valueOf(tablaIE.getValueAt(i, 2).toString().replaceAll("\\.", ""));
            sumatoria += sumador;
//            des1 = Float.valueOf(jTable1.getValueAt(i, 7).toString().replaceAll("\\.", ""));
            des2 += des1;

        }
        lbltotalventa.setText(String.valueOf(format.format(sumatoria)));
//        txttotal_descuento.setText(String.valueOf(format.format(des2)));
    }
//
//    void mostrarcredito(String inicio, String fin, String estado,String id) {
//        try {
//            DefaultTableModel modelo;
//
//            fventa Funcion = new fventa();
//
//            modelo = Funcion.mostrarcrednombre(inicio, fin, estado,id);
//
////            int total = Funcion.totalregistros;
////            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
//            jTable1.setModel(modelo);
//
//        } catch (Exception e) {
//        }
//
//    }

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
        tablaIE = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cmbestado = new javax.swing.JComboBox<>();
        lbltotalventa1 = new javax.swing.JLabel();
        lbltotalventa = new javax.swing.JLabel();

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
        jLabel10.setText("HISTORIAL DE INGRESOS Y EGRESOS");

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

        tablaIE.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaIE.getTableHeader().setResizingAllowed(false);
        tablaIE.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaIE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INGRESO", "EGRESO" }));
        cmbestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbestadoActionPerformed(evt);
            }
        });

        lbltotalventa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa1.setText("Total:");

        lbltotalventa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 358, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFecha_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFecha_termino, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cmbestado, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lbltotalventa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltotalventa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(284, 284, 284)
                        .addComponent(btnnuevo)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dcFecha_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(dcFecha_termino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnnuevo)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbltotalventa1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbltotalventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
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

         imprimir();


    }//GEN-LAST:event_btnnuevoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        String estado = cmbestado.getSelectedItem().toString();
     
        java.util.Date desde = new java.util.Date();
        SimpleDateFormat sdf_desde = new SimpleDateFormat("yyyy-MM-dd");
        desde = dcFecha_Inicio.getDate();
        String p_fecha_Desde = sdf_desde.format(desde);

        java.util.Date hasta = new java.util.Date();
        SimpleDateFormat sdf_hasta = new SimpleDateFormat("yyyy-MM-dd");
        hasta = dcFecha_termino.getDate();
        String p_fecha_Hasta = sdf_hasta.format(hasta);
        
//        String estado = cmbestado.getSelectedItem().toString();
       
        mortrar(p_fecha_Desde, p_fecha_Hasta, estado);
//        JOptionPane.showConfirmDialog(rootPane, estado);
        sumarsubtotal();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbestadoActionPerformed


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
            java.util.logging.Logger.getLogger(frm_ingreso_egreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_ingreso_egreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_ingreso_egreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_ingreso_egreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frm_ingreso_egreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cmbestado;
    private com.toedter.calendar.JDateChooser dcFecha_Inicio;
    private com.toedter.calendar.JDateChooser dcFecha_termino;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbltotalventa;
    public static javax.swing.JLabel lbltotalventa1;
    public static javax.swing.JTable tablaIE;
    // End of variables declaration//GEN-END:variables

}
