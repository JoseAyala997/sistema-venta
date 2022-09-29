/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vfactura;
import Logica.Conexion;
import Logica.ffactura;
import static Presentacion.frmcompras.insertarCompra;
import static Presentacion.frmventas.txtnrofactura;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import static Presentacion.frmventas.insertarVenta;
import java.awt.event.KeyEvent;
import java.sql.Connection;

/**
 *
 * @author JOSE AYALA
 */
public class FrmFactura extends javax.swing.JFrame {

    public static Conexion mysql = new Conexion();

    /**
     * Creates new form FrmFactura
     */
    public FrmFactura() {
        initComponents();
        txtFactura.setEnabled(false);
        txtMonto.setEnabled(false);
        txtVuelto.setEnabled(false);
        txtpresupuesto.setVisible(false);
        txtEfectivo.setText("0");
        setLocationRelativeTo(null);

        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                btnAceptarActionPerformed(null);
            }
        });
    }

    void insertarfactura() {
        vfactura datos = new vfactura();
        ffactura funcion = new ffactura();
        datos.setNrofactura(Integer.parseInt(txtnrofactura.getText()));
        datos.setMonto(Long.parseLong(txtMonto.getText().replaceAll("\\.", "")));
        datos.setEfectivo(Long.parseLong(txtEfectivo.getText().replaceAll("\\.", "")));
        datos.setVuelto(Long.parseLong(txtVuelto.getText().replaceAll("\\.", "")));
//        datos.setIdventa(Integer.parseInt(txtnrofactura.getText()));

        funcion.insertarF(datos);

    }
//     void insertarfacturaPresupuesto() {
//        vfactura datos = new vfactura();
//        ffactura funcion = new ffactura();
//        datos.setNrofactura(Integer.parseInt(txtnrofactura.getText()));
//        datos.setMonto(Long.parseLong(txtMonto.getText().replaceAll("\\.", "")));
//        datos.setEfectivo(Long.parseLong(txtEfectivo.getText().replaceAll("\\.", "")));
//        datos.setVuelto(Long.parseLong(txtVuelto.getText().replaceAll("\\.", "")));
////        datos.setIdventa(Integer.parseInt(txtnrofactura.getText()));
//
//        funcion.insertarF(datos);
//
//    }

    void factura() {
        int monto = Integer.parseInt(txtMonto.getText().replaceAll("\\.", ""));
        int efe = Integer.parseInt(txtEfectivo.getText().replaceAll("\\.", ""));
        String presu = txtpresupuesto.getText();

//               if (txtEfectivo.getText().length()==0) {
        if (efe < monto) {

            JOptionPane.showMessageDialog(rootPane, "El efectivo no puede estar vacio, ni ser menor al monto");
            txtEfectivo.requestFocus();
        } else {
            if (presu.equals("PRESUPUESTO")) {
                frmventas.insertarpresupuesto();
                frmventas.NroFctura();
                dispose();
                vaciartabla(frmventas.tablaventas);
//                insertarfacturaP resupuesto();
                frmventas.sumarsubtotal();
////           frmventas.cliente();
//                frmventas.txtpulgadas.requestFocus();
                frmventas.cbotipo.setSelectedItem("CONTADO");

                imprimirPresupuesto();

            } else {
                insertarVenta();
                insertarfactura();
                frmventas.NroFctura();

//            frmventas.insertarVenta();
                dispose();

                vaciartabla(frmventas.tablaventas);
                frmventas.sumarsubtotal();
//           frmventas.cliente();
//                frmventas.txtpulgadas.requestFocus();
                frmventas.cbotipo.setSelectedItem("CONTADO");
                imprimir();
            }
        }
    }
    void facturaCompra() {
        int monto = Integer.parseInt(txtMonto.getText().replaceAll("\\.", ""));
        int efe = Integer.parseInt(txtEfectivo.getText().replaceAll("\\.", ""));
        String presu = txtpresupuesto.getText();

//               if (txtEfectivo.getText().length()==0) {
        if (efe < monto) {

            JOptionPane.showMessageDialog(rootPane, "El efectivo no puede estar vacio, ni ser menor al monto");
            txtEfectivo.requestFocus();
        } else {
            
               insertarCompra();
            frmcompras.NroFactura();
//            frmventas.insertarVenta();
            dispose();

            frmcompras.cbotipo.setSelectedItem("CONTADO");
              
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        txtVuelto = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        txtpresupuesto = new javax.swing.JTextField();
        txttipo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FACTURA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MONTO:");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("EFECTIVO:");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("VUELTO:");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEfectivoActionPerformed(evt);
            }
        });
        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyReleased(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(153, 153, 153));
        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("FACTURA");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DESCUENTO:");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtdescuento.setEnabled(false);
        txtdescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescuentoActionPerformed(evt);
            }
        });

        txtpresupuesto.setEnabled(false);
        txtpresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpresupuestoActionPerformed(evt);
            }
        });

        txttipo.setEnabled(false);
        txttipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpresupuesto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttipo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    DecimalFormat format = new DecimalFormat("###,###.##");
    private void txtEfectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyReleased
        // TODO add your handling code here:
        txtEfectivo.setText(txtEfectivo.getText().replaceAll("\\.", ""));
        int c = Integer.parseInt(txtEfectivo.getText());
        txtEfectivo.setText(format.format(c) + "");
        int monto = Integer.parseInt(txtMonto.getText().replaceAll("\\.", ""));
        int calculo = c - monto;
        txtVuelto.setText("" + format.format(calculo));

        if (txtEfectivo.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES INGRESAR EFECTIVO DEL CLIENTE");
        }


    }//GEN-LAST:event_txtEfectivoKeyReleased

    public void vaciartabla(JTable tabla) {
        try {
            int fila = tabla.getRowCount();
            for (int i = 0; fila > i; i++) {
                frmventas.modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (txttipo.getText().equals("venta")) {
            factura();
        } else {
            facturaCompra();
        }


    }//GEN-LAST:event_btnAceptarActionPerformed

    public static void imprimir() {

        try {
            Connection cn = mysql.conectar();
            System.out.println("imprimiendo");
            Map p = new HashMap();
            p.put("importe", txtEfectivo.getText());
            p.put("VUELTO", txtVuelto.getText());
            p.put("descuento", txtdescuento.getText());

            JasperReport jr;
            JasperPrint jp;

            jr = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/rptventasclinica.jrxml");//Jasper para tener vista en exel y demas editores de texto

            jp = JasperFillManager.fillReport(jr, p, cn);
//            JasperPrintManager.printReport(jp, true);

            JasperViewer view = new JasperViewer(jp, false);
            view.setTitle("Comprobante Venta");
            view.setVisible(true);
//            System.out.println("imprimiendo2");

        } catch (Exception e) {
        }
    }

    public static void imprimirPresupuesto() {

        try {
            Connection cn = mysql.conectar();
            System.out.println("imprimiendo");
            Map p = new HashMap();
//            p.put("IMPORTE", txtEfectivo.getText());
//            p.put("VUELTO", "0");
////            p.put("descuento", txtdescuento.getText());
            p.put("cliente", frmventas.txtcliente.getText());

            JasperReport jr;
            JasperPrint jp;

            jr = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/rptPresupuesto.jrxml");//Jasper para tener vista en exel y demas editores de texto

            jp = JasperFillManager.fillReport(jr, p, cn);
//            JasperPrintManager.printReport(jp, true);

            JasperViewer view = new JasperViewer(jp, false);
            view.setTitle("Presupuesto");
            view.setVisible(true);
//            System.out.println("imprimiendo2");

        } catch (Exception e) {
        }
    }

    private void txtEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEfectivoActionPerformed
        // TODO add your handling code here:
//        btnAceptar.requestFocus();
    }//GEN-LAST:event_txtEfectivoActionPerformed

    private void txtdescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescuentoActionPerformed

    private void txtpresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpresupuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpresupuestoActionPerformed

    private void txtEfectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txttipo.getText().equals("venta")) {
                factura();
            } else {
                facturaCompra();
            }

        }


    }//GEN-LAST:event_txtEfectivoKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        frmventas.NroFctura();
    }//GEN-LAST:event_formWindowClosing

    private void txttipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttipoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txtEfectivo;
    public static javax.swing.JTextField txtFactura;
    public static javax.swing.JTextField txtMonto;
    public static javax.swing.JTextField txtVuelto;
    public static javax.swing.JTextField txtdescuento;
    public static javax.swing.JTextField txtpresupuesto;
    public static javax.swing.JTextField txttipo;
    // End of variables declaration//GEN-END:variables
}
