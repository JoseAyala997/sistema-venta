package CONSULTAS;

import Logica.Conexion;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fegresos;
import Presentacion.frmprincipal;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
public class frm_ingreso_egreso_final extends javax.swing.JInternalFrame {

    private JTable table;
  
    public static String x;
    

    public frm_ingreso_egreso_final() {
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
        mortrar(mifecha.toString(),mifecha.toString());
        LOcultarColumna.modjtable(tablaresumen);
    }

 
    void mortrar(String inicio, String fin) {
        try {
            DefaultTableModel modelo;

            fegresos Funcion = new fegresos();

            modelo = Funcion.mostrarIE_Resumen(inicio, fin);

//            int total = Funcion.totalregistros;
//            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
            tablaresumen.setModel(modelo);
            Funcion.ingresos(inicio, fin);
            Funcion.egresos(inicio, fin);

        } catch (Exception e) {
        }

    }
    void imprimir(){
        //        abrimos la conexion
        Conexion reporte = new Conexion();
        Connection cn = reporte.conectar();
//        String estador = cmbestado.getSelectedItem().toString();
        int fila = tablaresumen.getRowCount();
        if (fila == 0) {
            JOptionPane.showMessageDialog(rootPane, "La tabla no puede estar vacia");
        }else{
             
                Map p = new HashMap();
               
                p.put("inicio", dcFecha_Inicio.getDate());
                p.put("fin", dcFecha_termino.getDate());
                 p.put("ingreso", lbltotalingreso.getText());
                p.put("egreso",lbltotalegreso.getText());
            
                JasperReport report;
                JasperPrint print;

                try {
                    report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/Reportes/rptresumenIE.jrxml");
                    print = JasperFillManager.fillReport(report, p, cn);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Resumen de Ingresos y Egresos");
                    view.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    reporte.desconectar();
                }

            
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaresumen = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        lbltotalventa1 = new javax.swing.JLabel();
        lbltotalingreso = new javax.swing.JLabel();
        lbltotalventa2 = new javax.swing.JLabel();
        lbltotalegreso = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        dcFecha_Inicio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(dcFecha_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 150, 30));

        dcFecha_termino.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel3.add(dcFecha_termino, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 150, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setText("RESUMEN DE INGRESOS Y EGRESOS");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 11, 483, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Fecha fin:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("Fecha de inicio:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, 31));

        tablaresumen.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaresumen.getTableHeader().setResizingAllowed(false);
        tablaresumen.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaresumen);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1185, 390));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar32.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, -1, 30));

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/imprimir1.png"))); // NOI18N
        btnguardar.setText("Imprimir");
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnguardar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 560, -1, -1));

        lbltotalventa1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa1.setText("Total Ingresos:");
        jPanel3.add(lbltotalventa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 100, 30));

        lbltotalingreso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalingreso.setText("0");
        jPanel3.add(lbltotalingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 110, 30));

        lbltotalventa2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalventa2.setText("Total Egresos:");
        jPanel3.add(lbltotalventa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 100, 30));

        lbltotalegreso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalegreso.setText("0");
        jPanel3.add(lbltotalegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 110, 30));

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

        setBounds(0, 0, 1201, 651);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        x = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
     
        java.util.Date desde = new java.util.Date();
        SimpleDateFormat sdf_desde = new SimpleDateFormat("yyyy-MM-dd");
        desde = dcFecha_Inicio.getDate();
        String p_fecha_Desde = sdf_desde.format(desde);

        java.util.Date hasta = new java.util.Date();
        SimpleDateFormat sdf_hasta = new SimpleDateFormat("yyyy-MM-dd");
        hasta = dcFecha_termino.getDate();
        String p_fecha_Hasta = sdf_hasta.format(hasta);
        
//        String estado = cmbestado.getSelectedItem().toString();
       
        mortrar(p_fecha_Desde, p_fecha_Hasta);
        
//        JOptionPane.showConfirmDialog(rootPane, estado);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        imprimir();
        
    }//GEN-LAST:event_btnguardarActionPerformed

    

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
            java.util.logging.Logger.getLogger(frm_ingreso_egreso_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_ingreso_egreso_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_ingreso_egreso_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_ingreso_egreso_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frm_ingreso_egreso_final().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnguardar;
    public static com.toedter.calendar.JDateChooser dcFecha_Inicio;
    public static com.toedter.calendar.JDateChooser dcFecha_termino;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbltotalegreso;
    public static javax.swing.JLabel lbltotalingreso;
    public static javax.swing.JLabel lbltotalventa1;
    public static javax.swing.JLabel lbltotalventa2;
    public static javax.swing.JTable tablaresumen;
    // End of variables declaration//GEN-END:variables

}
