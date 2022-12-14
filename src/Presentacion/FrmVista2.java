/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import CONSULTAS.frmhistorial_compras;
import CONSULTAS.frmventa_general;
import Logica.LOcultarColumna;
import Logica.fcategoria;
import Logica.fmovimiento_caja;
import Logica.fpacientes;
import Logica.fproveedor;
import Logica.fusuarios;
import java.sql.Date;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
public class FrmVista2 extends javax.swing.JFrame {

    /**
     * Creates new form FrmVista1
     */
    public FrmVista2() {
        initComponents();
        LOcultarColumna.modjtable(tablalistado);

    }

    public static void ocultar_columnas() {
//        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
//        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
//        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(3).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(3).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(3).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(4).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(4).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(4).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(5).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(5).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(5).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(6).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(6).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(6).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(7).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(7).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(7).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(9).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(9).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(9).setPreferredWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtbuscar = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lbltotalregistros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new JTable(){    public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        jPanel2 = new javax.swing.JPanel();
        lbltitulovista = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblbandera = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 230, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDIENTE", "FINALIZADO", "ANULADO" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 110, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BUSCAR");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 30));

        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(0, 204, 0));
        lbltotalregistros.setText("jLabel2");
        getContentPane().add(lbltotalregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 190, 20));

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.getTableHeader().setResizingAllowed(false);
        tablalistado.getTableHeader().setReorderingAllowed(false);
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        tablalistado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablalistadoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 750, 220));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        lbltitulovista.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbltitulovista.setForeground(new java.awt.Color(255, 255, 255));
        lbltitulovista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitulovista.setText("jLabel2");
        jPanel2.add(lbltitulovista);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(574, Short.MAX_VALUE)
                .addComponent(lblbandera, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblbandera, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 770, 320));

        jMenu1.setText("ATAJOS");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DOWN, 0));
        jMenuItem1.setText("Ir a Tabla");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        buscador();        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        buscador();     // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        tablalistado.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        int fila = tablalistado.rowAtPoint(evt.getPoint());
        if (evt.getClickCount() == 2) {
            seleccionar_esta_fila(fila);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoMouseClicked
    public static void cambiarcombo() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("ACTIVO");
        modelo.addElement("INACTIVO");
        jComboBox1.setModel(modelo);
    }

    public static void cambiarcombo2() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("HABILITADO");
        modelo.addElement("INHABILITADO");
        jComboBox1.setModel(modelo);
    }
    private void tablalistadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablalistadoKeyReleased
        int key = evt.getKeyCode();
        if (key == 10) {
            int fila = tablalistado.getSelectedRow() - 1;
            if (fila > -1) {
                seleccionar_esta_fila(fila);
            }
            if (fila == 1) {
                seleccionar_esta_fila(tablalistado.getRowCount() - 1);
            }
        }
        if (key < 37 || key > 40) {
            txtbuscar.requestFocus();
            txtbuscar.selectAll();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoKeyReleased
    public static int dondebuscar = 0;

    public static void buscador() {
        DefaultTableModel modelo = null;

        if (dondebuscar == 1) {
            jComboBox1.setVisible(false);
            fusuarios func = new fusuarios();
            modelo = func.mostrar(txtbuscar.getText());
            tablalistado.setModel(modelo);
            lbltotalregistros.setText("TOTAL USUARIO " + Integer.toString(func.totalregistros));
        }

        if (dondebuscar == 2) {
            jComboBox1.setVisible(true);
            fmovimiento_caja func = new fmovimiento_caja();

            func.mostrarMonto(txtbuscar.getText().toString());
            Integer id = fmovimiento_caja.ultimoMonto;
            Integer idmo = fmovimiento_caja.idm;
            // System.out.println("no es igual: " + id + " : " + idmo);
            if (!id.equals(0)) {
                modelo = func.mostrarcaja(txtbuscar.getText(), jComboBox1.getSelectedItem().toString(), frmprincipal.lblidmovimiento2.getText());

                tablalistado.setModel(modelo);
                ocultar_columnas();
//                System.out.println("igual: " + id + " : " + idmo);
            } else {
//                if (id.equals(0)) {
                modelo = func.mostrar(txtbuscar.getText(), jComboBox1.getSelectedItem().toString(), frmprincipal.lblidmovimiento2.getText());
                tablalistado.setModel(modelo);
                ocultar_columnas();
//                System.out.println("no es igual: " + id + " : " + idmo);
//                }

            }

//            lbltotalregistros.setText("TOTAL PEDIDOS" + Integer.toString(func.totalregistros));
        }
        if (dondebuscar == 3) {

            fcategoria func = new fcategoria();
            modelo = func.mostrar(txtbuscar.getText());
            tablalistado.setModel(modelo);
            //lbltotalregistros.setText("TOTAL PEDIDOS" + Integer.toString(func.totalregistros));

        }
        if (dondebuscar == 4) {

            fproveedor func = new fproveedor();
            modelo = func.mostrar(txtbuscar.getText());
            tablalistado.setModel(modelo);
            //lbltotalregistros.setText("TOTAL PEDIDOS" + Integer.toString(func.totalregistros));

        }
        if (dondebuscar == 5) {

            fpacientes func = new fpacientes();
            modelo = func.mostrar(txtbuscar.getText());
            tablalistado.setModel(modelo);
            //lbltotalregistros.setText("TOTAL PEDIDOS" + Integer.toString(func.totalregistros));

        }
//        if (dondebuscar == 6) {
//
//            fpacientes func = new fpacientes();
//            modelo = func.mostrar(txtbuscar.getText());
//            tablalistado.setModel(modelo);
//            //lbltotalregistros.setText("TOTAL PEDIDOS" + Integer.toString(func.totalregistros));
//
//        }
        if (dondebuscar == 7) {
            jComboBox1.setVisible(true);
            fmovimiento_caja func = new fmovimiento_caja();

            modelo = func.mostrar(txtbuscar.getText(), jComboBox1.getSelectedItem().toString(), frmprincipal.lblidmovimiento2.getText());
            tablalistado.setModel(modelo);
        }
        if (dondebuscar == 8) {

            fpacientes func = new fpacientes();
            modelo = func.mostrar(txtbuscar.getText());
            tablalistado.setModel(modelo);
            //lbltotalregistros.setText("TOTAL PEDIDOS" + Integer.toString(func.totalregistros));

        }
        if (dondebuscar == 9) {

            fproveedor func = new fproveedor();
            modelo = func.mostrar(txtbuscar.getText());
            tablalistado.setModel(modelo);

        }
    }
    public static DefaultTableModel modelo = new DefaultTableModel();

    DecimalFormat format = new DecimalFormat("###,###.##");

    void seleccionar_esta_fila(int fila) {

        if (dondebuscar == 1) {
            FrmApertura_Caja.txtID.setText(tablalistado.getValueAt(fila, 0).toString());
            FrmApertura_Caja.txtDocumento.setText(tablalistado.getValueAt(fila, 1).toString());
            FrmApertura_Caja.txtnombreapellido.setText(tablalistado.getValueAt(fila, 2).toString());

            this.dispose();
        }

        if (dondebuscar == 2) {
////               
            FrmCerrarCaja.habilitar(true);
            FrmCerrarCaja.txtID.setText(tablalistado.getValueAt(fila, 7).toString());
            FrmCerrarCaja.txtIDCaja.setText(tablalistado.getValueAt(fila, 0).toString());
            FrmCerrarCaja.txtNroCaja.setText(tablalistado.getValueAt(fila, 1).toString());
//            FrmCerrarCaja.txtDocumento.setText(tablalistado.getValueAt(fila, 9).toString());s
            FrmCerrarCaja.txtnombreapellido.setText(tablalistado.getValueAt(fila, 8).toString());
            FrmCerrarCaja.txtMontoApertura.setText(tablalistado.getValueAt(fila, 2).toString());
//            FrmCerrarCaja.txtmontocierre.setText(tablalistado.getValueAt(fila, 3).toString());

            fmovimiento_caja func = new fmovimiento_caja();

            func.mostrarMonto(txtbuscar.getText().toString());
            Integer id = fmovimiento_caja.ultimoMonto;
            Integer idmo = fmovimiento_caja.idm;

            double otros = Double.parseDouble(frmprincipal.txtingresos1.getText().replace(".", ""));

            if (!id.equals(0)) {
                double apertura = Double.parseDouble(tablalistado.getValueAt(fila, 2).toString().replace(".", ""));
                double egreso = Double.parseDouble(tablalistado.getValueAt(fila, 10).toString().replace(".", ""));
                double compras = Integer.parseInt(frmprincipal.TXTCOMPRAS1.getText().replace(".", ""));
//                        Double.parseDouble(tablalistado.getValueAt(fila, 11).toString().replace(".", ""));

                double ingreso = func.mostrarTotalAcumuladoPagosVentas(tablalistado.getValueAt(fila, 0).toString());
                double cobrado = func.mostrarcobrado(tablalistado.getValueAt(fila, 0).toString());
                double credito = func.mostrarcredito(tablalistado.getValueAt(fila, 0).toString());

//            egreso = func.mostrarTotalegreso(tablalistado.getValueAt(fila, 0).toString());
                double acumulado = ingreso + apertura+cobrado;
                double caja = ingreso;
                double capital = ((acumulado+otros)-(egreso+compras));
//                        ((acumulado - egreso) + otros) - compras;
//            FrmCerrarCaja.txtmontoacumulado.setText(String.valueOf((format.format((int) acumulado))));
                FrmCerrarCaja.txtmontoventa.setText(String.valueOf((format.format((int) caja))));
                FrmCerrarCaja.txtmontoegreso.setText(String.valueOf((format.format((int) egreso))));
                FrmCerrarCaja.txtcapitalcaja.setText(String.valueOf((format.format((int) capital))));
                FrmCerrarCaja.txtmontocierre.setText(String.valueOf((format.format((int) capital))));
                FrmCerrarCaja.txtcobrado.setText(String.valueOf((format.format((int) cobrado))));
                FrmCerrarCaja.txtcredito.setText(String.valueOf((format.format((int) credito))));
                FrmCerrarCaja.txtcontado.setText(String.valueOf((format.format((int) ingreso))));
                FrmCerrarCaja.txtcompras.setText(String.valueOf((format.format((int) compras))));
//                        setText(String.valueOf((format.format((int) compras))));
//                FrmCerrarCaja.txtmontocierre.setText(String.valueOf((format.format((int) capital))));
                func.ingresohoycierre(frmprincipal.lblidmovimiento2.getText());
                frmprincipal.mostrarhoy(frmprincipal.lblfechahoy.getText());
                FrmCerrarCaja.txtmontocierre.requestFocus();
            } else {
//              frmprincipal.mostrarhoy(frmprincipal.lblfechahoy.getText());
                double cobrado2 = func.mostrarcobrado(tablalistado.getValueAt(fila, 0).toString());
                double credito = func.mostrarcredito(tablalistado.getValueAt(fila, 0).toString());
                double apertura = Double.parseDouble(tablalistado.getValueAt(fila, 2).toString().replace(".", ""));
                double egreso = 0;
                double compras = Integer.parseInt(frmprincipal.TXTCOMPRAS1.getText().replace(".", ""));
//                        Double.parseDouble(tablalistado.getValueAt(fila, 10).toString().replace(".", ""));

                double ingreso = func.mostrarTotalAcumuladoPagosVentas(tablalistado.getValueAt(fila, 0).toString());
                double acumulado = ingreso + apertura+cobrado2;
                double caja = ingreso;
                double capital = ((acumulado+otros)-(egreso+compras));
//                        ((acumulado - egreso) + otros) - compras;
                FrmCerrarCaja.txtmontoventa.setText(String.valueOf((format.format((int) caja))));
                FrmCerrarCaja.txtmontoegreso.setText(String.valueOf((format.format((int) egreso))));
                FrmCerrarCaja.txtcapitalcaja.setText(String.valueOf((format.format((int) capital))));
                FrmCerrarCaja.txtmontocierre.setText(String.valueOf((format.format((int) capital))));
                FrmCerrarCaja.txtcontado.setText(String.valueOf((format.format((int) ingreso))));
                FrmCerrarCaja.txtcredito.setText(String.valueOf((format.format((int) credito))));
                FrmCerrarCaja.txtcobrado.setText(String.valueOf((format.format((int) cobrado2))));
                FrmCerrarCaja.txtcompras.setText(String.valueOf((format.format((int) compras))));
                func.ingresohoycierre(frmprincipal.lblidmovimiento2.getText());
                frmprincipal.mostrarhoy(frmprincipal.lblfechahoy.getText());
                FrmCerrarCaja.txtmontocierre.requestFocus();
            }

            this.dispose();
        }

        if (dondebuscar == 3) {

            frmproducto2.txtidcategoria.setText(tablalistado.getValueAt(fila, 0).toString());
            frmproducto2.txtcategoria.setText(tablalistado.getValueAt(fila, 1).toString());

            this.dispose();
        }
        if (dondebuscar == 4) {

            frmproducto2.txtidproveedor.setText(tablalistado.getValueAt(fila, 0).toString());
            frmproducto2.txtproveedor.setText(tablalistado.getValueAt(fila, 1).toString());

            this.dispose();
        }
        if (dondebuscar == 5) {
//            frmhistorial_ventas.txtidcliente.setText(tablalistado.getValueAt(fila, 0).toString());
//            frmhistorial_ventas.txtcliente.setText(tablalistado.getValueAt(fila, 1).toString());
//            FrmApertura_Caja.txtnombreapellido.setText(tablalistado.getValueAt(fila, 2).toString());

            this.dispose();
        }
//        if (dondebuscar == 6) {
//            frmventas_diarias.txtidcliente.setText(tablalistado.getValueAt(fila, 0).toString());
//            frmventas_diarias.txtcliente.setText(tablalistado.getValueAt(fila, 1).toString());
////            FrmApertura_Caja.txtnombreapellido.setText(tablalistado.getValueAt(fila, 2).toString());
//
//            this.dispose();
//        }
        if (dondebuscar == 7) {
         

            FrmApertura_Caja.habilitar(true);
            FrmApertura_Caja.txtIDCaja.setText(tablalistado.getValueAt(fila, 0).toString());
            FrmApertura_Caja.txtNroCaja.setText(tablalistado.getValueAt(fila, 1).toString());
            FrmApertura_Caja.txtMontoApertura.setText(tablalistado.getValueAt(fila, 2).toString());
            FrmApertura_Caja.txtmontocierre.setText(tablalistado.getValueAt(fila, 3).toString());
            FrmApertura_Caja.txtID.setText(tablalistado.getValueAt(fila, 7).toString());
            FrmApertura_Caja.jFechaApertura.setDate(Date.valueOf(tablalistado.getValueAt(fila, 4).toString()));
            FrmApertura_Caja.txtDocumento.setText(tablalistado.getValueAt(fila, 9).toString());
            FrmApertura_Caja.txtnombreapellido.setText(tablalistado.getValueAt(fila, 8).toString());
            FrmApertura_Caja.opciones = "editar";
//            FrmApertura_Caja.as.setText("EDITAR");
            this.dispose();
        }
        if (dondebuscar == 8) {
            frmventa_general.txtidcliente.setText(tablalistado.getValueAt(fila, 0).toString());
            frmventa_general.txtcliente.setText(tablalistado.getValueAt(fila, 1).toString());
//            FrmApertura_Caja.txtnombreapellido.setText(tablalistado.getValueAt(fila, 2).toString());

            this.dispose();
        }
        if (dondebuscar == 9) {
            frmhistorial_compras.txtidproveedor.setText(tablalistado.getValueAt(fila, 0).toString());
            frmhistorial_compras.txtproveedor.setText(tablalistado.getValueAt(fila, 1).toString());

            this.dispose();
        }
    }

    DecimalFormat formato = new DecimalFormat("###,###.##");

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
            java.util.logging.Logger.getLogger(FrmVista2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVista2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVista2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVista2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmVista2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbandera;
    public static javax.swing.JLabel lbltitulovista;
    public static javax.swing.JLabel lbltotalregistros;
    public static javax.swing.JTable tablalistado;
    public static javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
