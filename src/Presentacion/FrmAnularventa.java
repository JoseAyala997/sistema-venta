/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vproductos;
import Datos.vventas;
import Logica.LOcultarColumna;
import Logica.StyloTabla;
import Logica.fpacientes;
import Logica.fproductos;
import Logica.fventa;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Ayala
 */
public class FrmAnularventa extends javax.swing.JFrame {

    /**
     * Creates new form FrmServicios
     */
    public FrmAnularventa() {
        initComponents();

//        mostrar("");
//        jPanel1.setBackground(new Color(0, 102, 100, 200));
//        jPanel2.setBackground(new Color(0, 102, 100, 200));
        StyloTabla st = new StyloTabla();

        setTitle("ANULAR");
//        LOcultarColumna.modjtable(tablalistado);
//        LOcultarColumna.ocultar_esta_columna3(tablalistado, 0, 1, 8, 11);

    }

//    void mostrar(String buscar) {
//        try {
//            DefaultTableModel modelo;
//
//            fproductos Funcion = new fproductos();
//
//            modelo = Funcion.mostrar(buscar);
//
//            int total = Funcion.TotalRegistros;
//
//            lbltotalregistros.setText("Total Registros : " + String.valueOf(total));
//
//            tablalistado.setModel(modelo);
//            LOcultarColumna.ocultar_esta_columna3(tablalistado, 0, 1, 8, 11);
//        } catch (Exception e) {
//        }
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtidventa = new javax.swing.JTextField();
        btncancelar = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        txtcliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 660));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        tablalistado.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablalistado.getTableHeader().setResizingAllowed(false);
        tablalistado.getTableHeader().setReorderingAllowed(false);
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablalistadoMousePressed(evt);
            }
        });
        tablalistado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablalistadoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("ANULAR");

        txtidventa.setEnabled(false);
        txtidventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidventaActionPerformed(evt);
            }
        });
        txtidventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidventaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidventaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidventaKeyTyped(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar1.png"))); // NOI18N
        btncancelar.setText("Anular");
        btncancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txttotal.setEnabled(false);
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        txttotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttotalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttotalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttotalKeyTyped(evt);
            }
        });

        txtcliente.setEnabled(false);
        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });
        txtcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtclienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtclienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtclienteKeyTyped(evt);
            }
        });

        jLabel1.setText("ID VENTA");

        jLabel2.setText("TOTAL");

        jLabel3.setText("CLIENTE");

        tablalistado1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        tablalistado1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablalistado1.getTableHeader().setResizingAllowed(false);
        tablalistado1.getTableHeader().setReorderingAllowed(false);
        tablalistado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistado1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablalistado1MousePressed(evt);
            }
        });
        tablalistado1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablalistado1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablalistado1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(469, 469, 469))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btncancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1139, 601));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked

    }//GEN-LAST:event_tablalistadoMouseClicked

    private void tablalistadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMousePressed
        int fila2 = tablalistado.rowAtPoint(evt.getPoint());
        if (evt.getClickCount() == 2) {
//            int fila2 = tablalistado.getSelectedRow();
            txtidventa.setText(tablalistado.getValueAt(fila2, 0).toString());
            txtcliente.setText(tablalistado.getValueAt(fila2, 8).toString());
            txttotal.setText(tablalistado.getValueAt(fila2, 6).toString());
            
           fventa funci = new fventa();
            modelo = funci.mostrarcancelacionProductos(txtidventa.getText());
            tablalistado1.setModel(modelo);
        }
    }

//    void seleccionar_esta_fila(int fila) {
//        if (dondebuscar == 1) {
//
//          
//           
//
//        }
//
//      
//
//    }
    public static DefaultTableModel modelo;
    public static int dondebuscar = 0;

    public static void buscador() {
        if (dondebuscar == 4) {
//              java.util.Date desde = new java.util.Date();
//        SimpleDateFormat sdf_desde = new SimpleDateFormat("yyyy-MM-dd");
            String desde = frmprincipal.lblfechahoy.getText().replaceAll("\\/", "-");
//        String p_fecha_Desde = sdf_desde.format(desde);
            fventa func = new fventa();
            modelo = func.mostrarcancelacion(frmprincipal.lblidmovimiento2.getText());
            tablalistado.setModel(modelo);
            LOcultarColumna.ocultar_esta_columna5(tablalistado, 1, 2, 7, 8, 9);
            LOcultarColumna.modjtable(tablalistado);
//            LOcultarColumna ocultar = new LOcultarColumna();
//            ocultar.ocultar_esta_columna(tablalistado, 0);
        }


    }//GEN-LAST:event_tablalistadoMousePressed

    private void tablalistadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablalistadoKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            int fila = tablalistado.getSelectedRow();
//            txtidventa.setText(tablalistado.getValueAt(fila, 0).toString());
//            txtidventa.setText(tablalistado.getValueAt(fila, 0).toString());
//
//        }

//        int fila = tablalistado.rowAtPoint(evt.getPoint());
//        if (evt.getClickCount() == 2) {
//            seleccionar_esta_fila(fila);
//        }
    }//GEN-LAST:event_tablalistadoKeyPressed

    private void txtidventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidventaActionPerformed

    private void txtidventaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidventaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidventaKeyPressed

    private void txtidventaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidventaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidventaKeyReleased

    private void txtidventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidventaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidventaKeyTyped

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        if (txtidventa.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBES SELECCIONAR UNA VENTA DE LA TABLA");
            txtidventa.requestFocus();
            return;
        }

        vventas dts = new vventas();
        fventa func = new fventa();
        dts.setIdventa(Integer.parseInt(txtidventa.getText()));
//                dts.setIdmovimiento(Integer.parseInt(txtidmovimiento.getText()));
        func.anularVenta(dts);

        JOptionPane.showMessageDialog(this, " VENTA ANULADA CORRECTAMENTE");
        modelo = func.mostrarcancelacion(frmprincipal.lblidmovimiento2.getText());
        tablalistado.setModel(modelo);
        modelo = func.mostrarcancelacionProductos("");
        tablalistado1.setModel(modelo);
        LOcultarColumna.ocultar_esta_columna5(tablalistado, 1, 2, 7, 8, 9);//ocultamos algunas columnas de la tabla
        LOcultarColumna.modjtable(tablalistado);//bloqueamos el jtable para que no se edite
        LOcultarColumna.modjtable(tablalistado1);//bloqueamos el jtable para que no se edite
        
        //borramos los valores de los jtextfield
        txtcliente.setText("");
        txtidventa.setText("");
        txttotal.setText("");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");//creamos un formato para la fecha
        frmprincipal.mostrarhoy(dtf.format(LocalDateTime.now()));//llamamos a la funcion para actualizar los reportes del frmprincipal
        
        
      


    }//GEN-LAST:event_btncancelarActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txttotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalKeyPressed

    private void txttotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalKeyReleased

    private void txttotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalKeyTyped

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteActionPerformed

    private void txtclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteKeyPressed

    private void txtclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteKeyReleased

    private void txtclienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteKeyTyped

    private void tablalistado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistado1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistado1MouseClicked

    private void tablalistado1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistado1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistado1MousePressed

    private void tablalistado1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablalistado1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistado1KeyPressed

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
            java.util.logging.Logger.getLogger(FrmAnularventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAnularventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAnularventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAnularventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAnularventa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tablalistado;
    public static javax.swing.JTable tablalistado1;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtidventa;
    public static javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
